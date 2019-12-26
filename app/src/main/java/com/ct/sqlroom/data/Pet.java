package com.ct.sqlroom.data;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Employee.class, parentColumns = "id", childColumns = "employee_id"))
public class Pet {

    @PrimaryKey(autoGenerate = true)
    private int idPet;

    @ColumnInfo(name = "employee_id")
    private int employeId;

    @ColumnInfo
    private String namePet;

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public int getEmployeId() {
        return employeId;
    }

    public void setEmployeId(int employeId) {
        this.employeId = employeId;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "idPet=" + idPet +
                ", employeId=" + employeId +
                ", namePet='" + namePet + '\'' +
                '}';
    }
}
