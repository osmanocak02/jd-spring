package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByEmail(String email);

    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    List<Employee> findByFirstNameIs(String firstName);

    List<Employee> findByLastNameStartsWith(String firstName);

    List<Employee> findBySalaryGreaterThan(Integer salary);

    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    List<Employee> findByEmailIsNull();


}
