package com.example.testtasklabmedia.View.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testtasklabmedia.Entitys.Question;
import com.example.testtasklabmedia.R;
import com.example.testtasklabmedia.View.Activitys.TestActivity;

import java.util.ArrayList;
import java.util.Collection;

public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.QuestionHolder> {

    private ArrayList<Question> questions = new ArrayList<>();
    private Context context;

    public QuestionListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public QuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_holder, parent, false);
        return new QuestionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionHolder holder, int position) {
        holder.bind(questions.get(position));
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public void setItems(Collection<Question> questions) {
        this.questions.addAll(questions);
        notifyDataSetChanged();
    }

    public void clearItems() {
        questions.clear();
        notifyDataSetChanged();
    }


    public class QuestionHolder extends RecyclerView.ViewHolder {

        private TextView questionText;

        public QuestionHolder(View itemView) {
            super(itemView);
            questionText = itemView.findViewById(R.id.qestionTextInList);
        }

        public void bind(final Question question) {
            questionText.setText(question.getQuestion());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, TestActivity.class);
                    intent.putExtra("question", question);
                    context.startActivity(intent);
                }
            });
        }
    }
}