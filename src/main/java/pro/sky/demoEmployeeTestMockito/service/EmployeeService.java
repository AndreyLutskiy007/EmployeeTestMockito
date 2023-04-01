package pro.sky.demoEmployeeTestMockito.service;

import pro.sky.demoEmployeeTestMockito.employee.Employee;

import java.util.List;

public interface EmployeeService {

        Employee add(String firstName, String lastName, float salary, int departmentId);

        Employee find(String firstName, String lastName);

        Employee remove(String firstName, String lastName);

        List<Employee> getAll();
}
