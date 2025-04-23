package com.example.employeesystem.Model;

import com.example.employeesystem.Exception.EmployeeNotFoundException;
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
        dataBase.addEmployee(employee);
        dataBase.removeEmployee(employeeID);
        Assertions.assertTrue(dataBase.getAllEmployees().isEmpty());
    }

    @Test
    void search_employeeByDepartmentFound() throws Exception {
        Employee<UUID> emp1 = new Employee<>("Alice", "HR", 3500.0, 4.2, 5);
        Employee<UUID> emp2 = new Employee<>( "Bob", "Engineering", 5000.0, 3.8, 7);
        Employee<UUID> emp3 = new Employee<>( "Charlie", "Sales", 4200.0, 4.5, 3);
        Employee<UUID> emp4 = new Employee<>( "Diana", "Marketing", 3900.0, 4.1, 4);
        Employee<UUID> emp5 = new Employee<>( "Ethan", "Engineering", 6000.0, 4.8, 10);
        EmployeeDatabase<UUID> dataBase = new EmployeeDatabase<>();
        dataBase.addEmployee(emp1);
        dataBase.addEmployee(emp2);
        dataBase.addEmployee(emp3);
        dataBase.addEmployee(emp4);
        dataBase.addEmployee(emp5);

        Assertions.assertFalse(dataBase.search("Engineering").isEmpty());
    }

    @Test
    void search_employeeByDepartmentNotFound() throws Exception {
        Employee<UUID> emp1 = new Employee<>("Alice", "HR", 3500.0, 4.2, 5);
        Employee<UUID> emp2 = new Employee<>( "Bob", "Engineering", 5000.0, 3.8, 7);
        Employee<UUID> emp3 = new Employee<>( "Charlie", "Sales", 4200.0, 4.5, 3);
        Employee<UUID> emp4 = new Employee<>( "Diana", "Marketing", 3900.0, 4.1, 4);
        Employee<UUID> emp5 = new Employee<>( "Ethan", "Engineering", 6000.0, 4.8, 10);

        EmployeeDatabase<UUID> dataBase = new EmployeeDatabase<>();
        dataBase.addEmployee(emp1);
        dataBase.addEmployee(emp2);
        dataBase.addEmployee(emp3);
        dataBase.addEmployee(emp4);
        dataBase.addEmployee(emp5);

        Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
            dataBase.search("devops");
        });
    }
}