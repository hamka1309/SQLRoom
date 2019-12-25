package com.ct.sqlroom;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bt_click_show)
    TextView btClickShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Student student = new Student();
        student.setClassRoom("ct1c");
        student.setName("ja");
        student.setScore(10);
        AppDatabase.getInstance(this).getStudentDao().insert(student);


    }

    @OnClick(R.id.bt_click_show)
    public void onViewClicked() {
        List<Student> students = AppDatabase.getInstance(this).getStudentDao().getAll();
        for (Student student : students) {
            Log.e("ha", "onViewClicked: "+student.getName() );
        }

    }
}
