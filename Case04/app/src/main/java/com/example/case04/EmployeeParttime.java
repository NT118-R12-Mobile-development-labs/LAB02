package com.example.case04;

public class EmployeeParttime extends Employee {
    public EmployeeParttime() {
    }

    public EmployeeParttime(String id, String name) {
        super(id, name);
    }

    @Override
    public double tinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString() + "--> Parttime = 150";
    }
}
