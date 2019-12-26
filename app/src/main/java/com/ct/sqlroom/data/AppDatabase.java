package com.ct.sqlroom.data;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class, Employee.class, Pet.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance = null;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context,
                    AppDatabase.class, "student_manager")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract StudentDao getStudentDao();
}
