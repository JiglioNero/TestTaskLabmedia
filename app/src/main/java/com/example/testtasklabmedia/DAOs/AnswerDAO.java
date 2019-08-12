package com.example.testtasklabmedia.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.testtasklabmedia.Entitys.Answer;

import java.util.List;

@Dao
public interface AnswerDAO {
    @Query("SELECT * FROM Answer")
    List<Answer> getAll();

    @Query("SELECT * FROM Answer WHERE _id = :id")
    Answer getById(int id);

    @Query("SELECT * FROM Answer WHERE questionId = :id")
    List<Answer> getByQuestionId(int id);

    @Insert
    void insert(Answer answer);

    @Delete
    void delete(Answer answer);

}
