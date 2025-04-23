package com.example.employeesystem.Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDatabaseTest {

    @Test
    void addEmployee() throws Exception {
        Employee<UUID> employee = new Employee<>("Alice", "HR", 3500.0, 4.2, 5);
        EmployeeDatabase<UUID> dataBase = new EmployeeDatabase<>();
        dataBase.addEmployee(employee);
        Assertions.assertFalse(dataBase.getAllEmployees().isEmpty());
    }

    @Test
    void removeEmployee() throws Exception {
        Employee<UUID> employee = new Employee<>("Alice", "HR", 3500.0, 4.2, 5);
        EmployeeDatabase<UUID> dataBase = new EmployeeDatabase<>();
        UUID employeeID = employee.getEmployeeID();
        dataBase.removeEmployee(employeeID);

    }

    @Test
    void search() {
    }
}