package com.cybertek;

import com.cybertek.entity.Employee;
import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;

import javax.annotation.PostConstruct;
import javax.xml.bind.SchemaOutputResolver;

@SpringBootApplication
public class DerivedQueryApplication {

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DerivedQueryApplication.class, args);
    }

    @PostConstruct
    public void testRegions(){

        System.out.println("----------Region start------------");

        System.out.println("regionRepository.findByCountry(\"Canada\") = " + regionRepository.findByCountry("Canada"));

        System.out.println("regionRepository.findDistinctByCountry(\"Canda\") = " + regionRepository.findDistinctByCountry("Canada"));

        System.out.println("regionRepository.findAllByCountryContaining(\"United\") = " + regionRepository.findAllByCountryContaining("United"));

        System.out.println("regionRepository.findAllByCountryContainingOrderByCountry(\"United\") = " + regionRepository.findAllByCountryContainingOrderByCountry("Asia"));

        System.out.println("regionRepository.findTop2ByCountry(\"Canada\") = " + regionRepository.findTop2ByCountry("Canada"));

    }

    @PostConstruct
    public void testDepartments(){

        System.out.println("----------Departments start------------");

        System.out.println("departmentRepository.findAllByDepartment= " + departmentRepository.findAllByDepartment("Furniture"));

        System.out.println("departmentRepository.findAllByDivision= " + departmentRepository.findAllByDivision("Health"));

        System.out.println("departmentRepository.findByDivisionEndsWith= " + departmentRepository.findByDivisionEndsWith("ics"));

        System.out.println("departmentRepository.findDistinctTop3ByDivisionContains(\"Hea\")= " + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));

    }

    @PostConstruct
    public void testEmployees(){

        System.out.println("----------Employees start------------");

        System.out.println(employeeRepository.findByEmail("ssymonds2@hhs.gov"));

        //System.out.println(employeeRepository.findByFirstNameAndLastNameOrEmail("Bethena", "Throw", ""));

        System.out.println(employeeRepository.findByFirstNameIs("Berrie"));

        System.out.println(employeeRepository.findByLastNameStartsWith("Mc"));

        System.out.println(employeeRepository.findBySalaryGreaterThan(150000));

        //System.out.println(employeeRepository.findByHireDateBetween(2016-11-09:44:44.797, 2016-11-09T11:44:44.797));

        System.out.println(employeeRepository.findBySalaryGreaterThanEqualOrderBySalaryDesc(150000));

        System.out.println(employeeRepository.findDistinctTop3BySalaryLessThan(150000));

        System.out.println(employeeRepository.findByEmailIsNull());

    }

    @PostConstruct
    public void testJpql() {

        System.out.println("----------JPQL start------------");

        System.out.println(employeeRepository.getEmployeeDetail());

        System.out.println(employeeRepository.getEmployeeSalary());

        System.out.println(employeeRepository.getEmployeeByEmail("npointona@vistaprint.com"));

        System.out.println(employeeRepository.getEmployeeByEmailAndSalary("npointona@vistaprint.com", 150000));

        //System.out.println(employeeRepository.getEmployeeBySalaryNotEqual(150000));

    }

}
