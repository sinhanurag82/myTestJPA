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

import javax.annotation.Resource;

import static com.sinha.jpademo.entity.Employee.EmployeeBuilder.anEmployee;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(
            classes = { EmployeeJpaConfig.class },
            loader = AnnotationConfigContextLoader.class)
@EnableAutoConfiguration(exclude = JpaRepositoriesAutoConfiguration.class)
@Transactional
public class EmployeeRepositoryTest {


        @Resource
        private EmployeeRepository employeeRepository;

        @Test
        public void givenEmployee_whenSave_thenGetOk() {
            Employee savedEmployeeOne = anEmployee()
                    .withEmployeeName("John")
                    .build();
            employeeRepository.save(savedEmployeeOne);
            System.out.println("ID : " + savedEmployeeOne.getId() + " Employee Name :" + savedEmployeeOne.getEmployeeName());
            assertEquals("John",savedEmployeeOne.getEmployeeName());
        }

}
