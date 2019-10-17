package edu.mum.lab.ten.repository;

import edu.mum.lab.ten.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

/**
 * The interface Employee repository.
 *
 * @author nduwayofabrice
 * @version 1.0
 */
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Find employee by phone number employee.
     *
     * @param phoneNumber the phone number
     *
     * @return the employee
     */
    @Query("select e from Employee e where e.phoneNumber =:phoneNumber")
    Employee findEmployeeByPhoneNumber(@NotNull final String phoneNumber);

    /**
     * Find employee by email address employee.
     *
     * @param email the email
     *
     * @return the employee
     */
    @Query("select e from Employee e where e.email =:email")
    Employee findEmployeeByEmailAddress(@NotNull final String email);

}
