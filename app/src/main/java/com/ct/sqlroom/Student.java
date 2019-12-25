package com.ct.sqlroom;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String name;

    @ColumnInfo(name = "class_room")
    private String classRoom;

    @ColumnInfo
    private float score;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public float getScore() {
        return score;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
