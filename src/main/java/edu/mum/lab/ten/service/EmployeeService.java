package edu.mum.lab.ten.service;

import edu.mum.lab.ten.domain.Employee;
import edu.mum.lab.ten.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * The type Employee service.
 * @author nduwayofabrice
 * @version 1.0
 */
@Service
public class EmployeeService implements IEmployeeService{

    private IEmployeeRepository employeeRepository;

    /**
     * Instantiates a new Employee service.
     *
     * @param employeeRepository the employee repository
     */
    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(@NotNull final Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public void delete(@NotNull final Long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(@NotNull Long id) {
        return this.employeeRepository.getOne(id);
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }
}
