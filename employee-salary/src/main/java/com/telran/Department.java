package com.telran;

import java.util.List;
import java.util.Objects;

public class Department {
    private String name;
    private String code;
    List<Employee> employees;

    public Department(String name, String code, List<Employee> employees) {
        this.name = name;
        this.code = code;
        this.employees = employees;
    }

    public String getCode() {
        return code;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

       @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", employees=" + employees +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return name.equals(that.name) &&
                code.equals(that.code) &&
                employees.equals(that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, employees);
    }
}
