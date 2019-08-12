package com.example.testtasklabmedia.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.testtasklabmedia.Entitys.Question;

import java.util.List;

@Dao
public interface QuestionDAO {
    @Query("SELECT * FROM Question")
    List<Question> getAll();

    @Query("SELECT * FROM Question WHERE _id = :id")
    Question getById(int id);

    @Insert
    void insert(Question question);

    @Delete
    void delete(Question question);

}
