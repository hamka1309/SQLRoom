package com.ct.sqlroom;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ct.sqlroom.data.AppDatabase;
import com.ct.sqlroom.data.Employee;
import com.ct.sqlroom.data.Pet;
import com.ct.sqlroom.data.Student;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    @BindView(R.id.bt_click_save)
    TextView btClickSave;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.tv_score)
    TextView tvScore;
    @BindView(R.id.et_score)
    EditText etScore;
    @BindView(R.id.tv_class_room)
    TextView tvClassRoom;
    @BindView(R.id.et_class_room)
    EditText etClassRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Employee employee = new Employee();
        employee.setName("ha");
        employee.setDesc("hadhs");
        Pet pet = new Pet();
        pet.setEmployeId(1);
        pet.setNamePet("Dog");
       // AppDatabase.getInstance(this).getStudentDao().insertPet(pet);
        employee.setPlace(pet);
        AppDatabase.getInstance(this).getStudentDao().insertEmployee(employee);
        List<Employee> employees = AppDatabase.getInstance(this).getStudentDao().getAllEmployee();
        List<Pet> pets = AppDatabase.getInstance(this).getStudentDao().getAllPet();
        for (Employee employee1 : employees) {
            Log.e(TAG, "onCreate: employee" + employee1.toString());
        }
        for (Pet pet1 : pets) {
            Log.e(TAG, "onCreate: pet"+pet1.toString() );
        }
    }

    @OnClick(R.id.bt_click_save)
    public void onViewClicked() {
        String classRoom = etClassRoom.getText().toString();
        String score = etScore.getText().toString();
        String name = etName.getText().toString();
        if (!TextUtils.isEmpty(classRoom.trim()) || !TextUtils.isEmpty(etScore.getText().toString().trim()) || !TextUtils.isEmpty(name.trim())) {
            Student student = new Student();
            student.setClassRoom(classRoom);
            student.setName(name);
            student.setScore(Float.parseFloat(score));
            AppDatabase.getInstance(this).getStudentDao().insert(student);
        } else {
            Toast.makeText(this, "text is empty", Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick(R.id.bt_click_show)
    public void onViewClickedShow() {
        startActivity(new Intent(MainActivity.this, ShowActivity.class));

    }
}
