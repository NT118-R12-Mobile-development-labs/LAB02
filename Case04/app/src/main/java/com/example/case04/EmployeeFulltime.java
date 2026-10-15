package com.example.case04;

public class EmployeeFulltime extends Employee {

    public EmployeeFulltime() {
    }

    public EmployeeFulltime(String id, String name) {
        super(id, name);
    }

    @Override
    public double tinhLuong() {
        return 500;
    }

    @Override
    public String toString() {
        return super.toString() + "--> Fulltime = 500";
    }
}
