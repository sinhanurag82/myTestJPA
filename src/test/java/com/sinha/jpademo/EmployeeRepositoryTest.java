package com.sinha.jpademo;


import com.sinha.jpademo.entity.Employee;
import com.sinha.jpademo.entity.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.sinha.jpademo.entity.Employee.EmployeeBuilder.anEmployee;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(
            classes = { EmployeeJpaConfig.class },
            loader = AnnotationConfigContextLoader.class)
@EnableAutoConfiguration(exclude = JpaRepositoriesAutoConfiguration.class)
@Transactional
public class EmployeeRepositoryTest {


        @Autowired
        private EmployeeRepository employeeRepository;

        @Test
        public void givenEmployee_whenSave_thenGetOk() {
            Employee savedEmployeeOne = anEmployee()
                    .withEmployeeName("John")
                    .build();
            Employee savedEmployeeTwo = anEmployee()
                    .withEmployeeName("Jack")
                    .build();
            employeeRepository.save(savedEmployeeOne);
            employeeRepository.save(savedEmployeeTwo);
            System.out.println("ID : " + savedEmployeeOne.getId() + " Employee Name :" + savedEmployeeOne.getEmployeeName());
            System.out.println("ID : " + savedEmployeeTwo.getId() + " Employee Name :" + savedEmployeeTwo.getEmployeeName());
            List<Employee> fetchedEmployee =  employeeRepository.findById(savedEmployeeOne.getId());
            assertEquals("John",savedEmployeeOne.getEmployeeName());
            assertThat(fetchedEmployee.contains(savedEmployeeTwo));
        }

}
