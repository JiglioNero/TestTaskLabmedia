package com.example.testtasklabmedia.Entitys;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Room Table Builder
 */
@Entity(tableName = "Answer")
public class Answer {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Integer _id;
    @ColumnInfo(name = "answer")
    private String answer;
    @ColumnInfo(name = "questionId")
    @ForeignKey(entity = Question.class, parentColumns = "id", childColumns = "questionId")
    private Integer questionId;

    public Answer() {
    }

    @Ignore
    public Answer(Integer _id, String answer, Integer questionId) {
        this._id = _id;
        this.answer = answer;
        this.questionId = questionId;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }
}