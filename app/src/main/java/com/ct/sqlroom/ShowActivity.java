package com.ct.sqlroom;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ct.sqlroom.data.AppDatabase;
import com.ct.sqlroom.data.Student;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity {

    private final String TAG = "ShowActivity";
    @BindView(R.id.lv_student)
    RecyclerView lvStudent;
    ShowAdapter showAdapter;
    private List<Student> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
        showAdapter = new ShowAdapter(this);
        lvStudent.setAdapter(showAdapter);
        data = AppDatabase.getInstance(this).getStudentDao().getAll();
        showAdapter.setData(data);
        showAdapter.setListener(id -> {
            Log.e(TAG, "clickItem: ");
            Student student = data.get(id);
            student.setClassRoom("ct1c");
            student.setName("Thu Ha");
            student.setScore(9);
            AppDatabase.getInstance(ShowActivity.this).getStudentDao().update(student);
            showAdapter.notifyDataSetChanged();
        });

        showAdapter.setDeleteItemListener(id -> {
            Log.e(TAG, "onCreate: ");
            Student student = data.get(id);
            AppDatabase.getInstance(ShowActivity.this).getStudentDao().delete(student);
            remove(id);
        });
    }

    private void remove(int position) {
        data.remove(position);
        showAdapter.notifyDataSetChanged();
    }
}
