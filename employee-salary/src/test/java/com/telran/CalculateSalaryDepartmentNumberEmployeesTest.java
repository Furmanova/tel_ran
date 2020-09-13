package com.telran;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class CalculateSalaryDepartmentNumberEmployeesTest {
    @Test
    public  void testCalculateSalaryDepartmentNumberEmployees(){
        List<Employee>employeeList = Arrays.asList(
                new Employee("Peter", 1000),
                new Employee("Ivan", 200000),
                new Employee("Helga", 10000),
                new Employee("Frank", 50000));
        List<Department> departmentList = Arrays.asList(
                new Department("Amazon", "00101",employeeList),
                new Department("Amaretto", "001002",employeeList),
                new Department("Amadeus", "00753",employeeList),
                new Department("Intel", "05784",employeeList));
        Long res = CalculateSalaryDepartmentNumberEmployees.count(
                departmentList,30000,"001");
        System.out.println(res);
        Assert.assertEquals(Long.valueOf(4), res);
    }
}