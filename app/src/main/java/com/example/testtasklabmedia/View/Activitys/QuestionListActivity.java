package com.example.testtasklabmedia.View.Activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testtasklabmedia.R;
import com.example.testtasklabmedia.View.Adapters.QuestionListAdapter;
import com.example.testtasklabmedia.db.QuestionDB;

public class QuestionListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private QuestionListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        recyclerView = findViewById(R.id.questionLoadList);
        adapter = new QuestionListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapterListReload();
    }

    public void loadStart() {
        ProgressBar progressBar = findViewById(R.id.list_load_bar);
        progressBar.setVisibility(View.VISIBLE);
    }

    public void adapterListReload() {
        adapter.clearItems();
        adapter.setItems(QuestionDB.getInstance(this).getQuestionDAO().getAll());
    }

    public void loadEnd() {
        ProgressBar progressBar = findViewById(R.id.list_load_bar);
        progressBar.setVisibility(View.INVISIBLE);
    }
}
