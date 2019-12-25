package com.ct.sqlroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM Student")
    List<Student> getAll();
    @Query("SELECT * FROM Student WHERE score >= :score")
    List<Student> getByScore(int score);
    @Insert
    void insert(Student... students);
    @Update
    void update(Student... students);
    @Delete
    void delete(Student... students);

}
