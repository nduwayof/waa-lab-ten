package edu.mum.lab.ten.repository;

import edu.mum.lab.ten.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeByPhoneNumber(@NotNull final String phoneNumber);

    @Query("select e from employee e where e.email =:email")
    Employee findEmployeeByEmailAddress(@NotNull final String email);

}
