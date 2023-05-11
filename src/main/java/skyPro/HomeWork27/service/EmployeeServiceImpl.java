package skyPro.HomeWork27.service;

import org.springframework.stereotype.Service;
import skyPro.HomeWork27.exception.EmployeeAlreadyAddedException;
import skyPro.HomeWork27.exception.EmployeeNotFoundException;
import skyPro.HomeWork27.exception.EmployeeStorageIsFullException;
import skyPro.HomeWork27.model.Employee;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private static final int EMPLOYEES_MAX_COUNT = 5;
    private final Set<Employee> employees;

    public EmployeeServiceImpl(Set<Employee> employees) {
        this.employees = new HashSet<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee))
            throw new EmployeeAlreadyAddedException(employee);
        if (employees.size() == EMPLOYEES_MAX_COUNT)
            throw new EmployeeStorageIsFullException();
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee))
            throw new EmployeeNotFoundException(employee);
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException(employee);}
        return employee;
    }

    @Override
    public Collection<Employee>findAll() {
        return employees;
    }
}
