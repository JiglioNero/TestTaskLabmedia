package com.example.testtasklabmedia.View.Activitys;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.testtasklabmedia.Entitys.Answer;
import com.example.testtasklabmedia.Entitys.Question;
import com.example.testtasklabmedia.R;
import com.example.testtasklabmedia.View.Fragments.AnswerCardFragment;
import com.example.testtasklabmedia.db.QuestionDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestActivity extends AppCompatActivity implements AnswerCardFragment.OnFragmentInteractionListener {
    private LinearLayout answersList;
    private TextView questionText;

    private Question question;
    private List<Answer> answers;

    private ArrayList<AnswerCardFragment> answerCardFragmentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answersList = findViewById(R.id.list_answers);
        questionText = findViewById(R.id.question);

        question = (Question) getIntent().getSerializableExtra("question");
        answers = QuestionDB.getInstance(this).getAnswerDAO().getByQuestionId(question.get_id());

        questionText.setText(question.getQuestion());
        answerCardFragmentArrayList = new ArrayList<>();

        ProgressBar player = findViewById(R.id.player_health);
        ProgressBar enemy = findViewById(R.id.enemy_health);

        player.setProgress(40);
        enemy.setProgress(60);

        Random random = new Random();
        random.setSeed(answers.size() * question.getAnswer().length() * random.nextInt());
        int rice = random.nextInt(answers.size());
        boolean flag = false;
        for (int i = 0; i < answers.size(); i++) {
            if (i != rice) {
                AnswerCardFragment f = AnswerCardFragment.newInstance(false, answers.get(i).getAnswer());
                answerCardFragmentArrayList.add(f);
            } else {
                AnswerCardFragment f = AnswerCardFragment.newInstance(true, question.getAnswer());
                answerCardFragmentArrayList.add(f);
                AnswerCardFragment f1 = AnswerCardFragment.newInstance(false, answers.get(i).getAnswer());
                answerCardFragmentArrayList.add(f1);
                flag = true;
            }
        }
        if (!flag) {
            AnswerCardFragment f = AnswerCardFragment.newInstance(true, question.getAnswer());
            answerCardFragmentArrayList.add(f);
            flag = true;
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (AnswerCardFragment f : answerCardFragmentArrayList) {
            transaction.add(R.id.list_answers, f, f.getTag());
        }
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Bundle bundle) {
        boolean isTrue = bundle.getBoolean(AnswerCardFragment.IS_ANSWER);
        for (AnswerCardFragment f : answerCardFragmentArrayList) {
            f.endOfSelect();
        }
    }
}
