package com.example.employeesystem.Model;

import com.example.employeesystem.Exception.InvalidDepartmentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
class EmployeeDatabaseTest {
    private EmployeeDatabase database;
    @BeforeEach
    void createDatabase() {
        database = new EmployeeDatabase();
    }

    @Test
    void addEmployee() throws Exception {
        Employee<UUID> emp1 = new Employee("Alice", "Engineering", 60000, 4, 101);
        database.addEmployee(emp1);
        Assertions.assertFalse(database.getAllEmployees().isEmpty());
    }

    @Test
    void removeEmployee() throws Exception {
        Employee<UUID> emp1 = new Employee<>("Alice", "Engineering", 60000, 4, 101);
        Employee<UUID> emp2 = new Employee<>("Bob", "Human Resource", 75000, 5, 102);
        database.addEmployee(emp1);
        database.addEmployee(emp2);
        database.removeEmployee(emp1.getEmployeeID());
        Assertions.assertEquals(1, database.getAllEmployees().size(), 1);
    }

    @Test
    void filterByDepartment() throws Exception{
        Employee<UUID> emp1 = new Employee("Alice", "Engineering", 60000, 4, 101);
        Employee<UUID> emp2 = new Employee<>("Bob", "Human Resource", 75000, 5, 102);
        database.addEmployee(emp1);
        database.addEmployee(emp2);
        Assertions.assertThrows(InvalidDepartmentException.class, () -> {
            database.filterByDepartment("hover");
        });

    }
}