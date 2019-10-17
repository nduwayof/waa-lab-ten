package edu.mum.lab.ten.service;

import edu.mum.lab.ten.domain.Employee;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * The interface Employee service.
 *
 * @author nduwayofabrice
 * @version 1.0
 */
public interface IEmployeeService {

    /**
     * Save.
     *
     * @param employee the employee
     *
     * @return the employee
     */
    Employee save(@NotNull final Employee employee);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(@NotNull final Long id);

    /**
     * Find by id employee.
     *
     * @param id the id
     *
     * @return the employee
     */
    Employee findById(@NotNull final Long id);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Employee>  findAll();

}
