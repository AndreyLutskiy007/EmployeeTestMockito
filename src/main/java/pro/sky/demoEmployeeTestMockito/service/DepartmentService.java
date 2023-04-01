package pro.sky.demoEmployeeTestMockito.service;

import pro.sky.demoEmployeeTestMockito.employee.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeWithMinSalary(int departmentId);

    Employee getEmployeeWithMaxSalary(int departmentId);

    Map<String, List<Employee>> getAll(Integer departmentId);



}
