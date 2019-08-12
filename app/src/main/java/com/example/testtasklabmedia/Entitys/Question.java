package com.example.testtasklabmedia.Entitys;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

/**
 * Room Table Builder
 */
@Entity(tableName = "Question")
public class Question implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Integer _id;
    @ColumnInfo(name = "answer")
    private String answer;
    @ColumnInfo(name = "question")
    private String question;

    public Question() {
    }

    @Ignore
    public Question(Integer _id, String answer, String question) {
        this._id = _id;
        this.answer = answer;
        this.question = question;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }
}