package com.example.testtasklabmedia.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.testtasklabmedia.DAOs.AnswerDAO;
import com.example.testtasklabmedia.DAOs.QuestionDAO;
import com.example.testtasklabmedia.Entitys.Answer;
import com.example.testtasklabmedia.Entitys.Question;
import com.example.testtasklabmedia.View.Activitys.QuestionListActivity;

import java.util.List;

@Database(entities = {Question.class, Answer.class}, version = 1)
public abstract class QuestionDB extends RoomDatabase {
    public abstract QuestionDAO getQuestionDAO();

    public abstract AnswerDAO getAnswerDAO();

    private static QuestionDB INSTANCE;
    private static String DB_NAME = "testDB.db";
    private static boolean isPrepopulated = true;

    public static QuestionDB getInstance(final Context context) {
        synchronized (context) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, QuestionDB.class, DB_NAME)
                        .allowMainThreadQueries()
                        .addCallback(new Callback() {
                            @Override
                            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                super.onCreate(db);
                                QuestionDB.prePopulate(INSTANCE, DBInfoProvider.initQuestionsList(), DBInfoProvider.initAnswersList(), (QuestionListActivity) context);
                            }
                        })
                        .build();
            }
            return INSTANCE;
        }
    }

    public static boolean isIsPrepopulated() {
        return isPrepopulated;
    }

    private static void prePopulate(final QuestionDB db, List<Question> questions, List<Answer> answers, QuestionListActivity listActivity) {
        AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPreExecute() {
                listActivity.loadStart();
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                listActivity.adapterListReload();
                listActivity.loadEnd();
            }

            @Override
            protected Void doInBackground(Void... voids) {

                for (final Question q : questions) {
                    db.getQuestionDAO().insert(q);
                }
                for (final Answer a : answers) {
                    db.getAnswerDAO().insert(a);
                }
                return null;
            }
        };
        asyncTask.execute();
    }
}
