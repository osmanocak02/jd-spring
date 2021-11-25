package com.cybertek.repository;

import com.cybertek.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    List<Department> findAllByDepartment(String department);

    List<Department> findAllByDivision(String division);

    List<Department> findByDivisionEndsWith(String division);

    List<Department> findDistinctTop3ByDivisionContains(String division);
}
