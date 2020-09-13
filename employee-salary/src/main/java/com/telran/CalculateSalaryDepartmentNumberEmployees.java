package com.telran;


import java.util.List;

public class CalculateSalaryDepartmentNumberEmployees {
    public static long count(
            List<Department> departments, long limit, final String prefix) {
        return departments.stream()
                .filter(department -> department.getCode().startsWith(prefix))
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= limit)
                .count();
    }

}
