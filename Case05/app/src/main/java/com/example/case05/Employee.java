package com.example.case05;

public class Employee {
    private String id;
    private String name;
    private boolean isManager;

    public Employee() {}

    public Employee(String id, String name, boolean isManager) {
        this.id = id;
        this.name = name;
        this.isManager = isManager;
    }

    public String getFullName() {
        return name;
    }

    public boolean isManager() {
        return  isManager;
    }
}
