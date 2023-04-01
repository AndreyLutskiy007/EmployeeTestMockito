package pro.sky.demoEmployeeTestMockito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.sky.demoEmployeeTestMockito.employee.Employee;
import pro.sky.demoEmployeeTestMockito.exception.EmployeeAlreadyAddedException;
import pro.sky.demoEmployeeTestMockito.exception.EmployeeNotFoundException;
import pro.sky.demoEmployeeTestMockito.exception.EmployeeStorageIsFullException;
import pro.sky.demoEmployeeTestMockito.service.EmployeeService;
import pro.sky.demoEmployeeTestMockito.service.EmployeeServiceImpl;

import java.util.List;


@RestController
    @RequestMapping("/employee")
    public class EmployeeController {

        private final EmployeeService employeeService;

        @Autowired
        public EmployeeController(EmployeeServiceImpl employeeService) {
            this.employeeService = employeeService;
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(EmployeeStorageIsFullException.class)
        public String handleException(EmployeeStorageIsFullException e) {
            return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(EmployeeAlreadyAddedException.class)
        public String handleException(EmployeeAlreadyAddedException e) {
            return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }

        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(EmployeeNotFoundException.class)
        public String handleException(EmployeeNotFoundException e) {
            return String.format("%s EmployeeNotFoundException %s", HttpStatus.NOT_FOUND.value(), e.getMessage());
        }

        @GetMapping(path = "/add")
        public Employee addEmployee(
                @RequestParam String firstName,
                @RequestParam String lastName,
                @RequestParam float salary,
                @RequestParam int departmentId) {
            return employeeService.add(firstName, lastName, salary, departmentId);
        }

        @GetMapping(path = "/find")
        public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
            return employeeService.find(firstName, lastName);
        }

        @GetMapping(path = "/remove")
        public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
            return employeeService.remove(firstName, lastName);
        }

        @GetMapping(path = "/findAll")
        public List<Employee> getEmployees() {
            return employeeService.getAll();
        }
}
