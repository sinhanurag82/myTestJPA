package com.sinha.jpademo.entity;

import javax.persistence.*;

@Entity
@Table (name = "employee")
public class Employee {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
    @SequenceGenerator(name = "ID_SEQUENCE",sequenceName = "SEQ_EMP_ID", allocationSize = 1)
    @Id
    @Column(name ="ID", updatable = false , nullable = false)
    private long id;

    @Column(name = "employee_name")
    private String employeeName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public static final class EmployeeBuilder {
        private long id;
        private String employeeName;

        private EmployeeBuilder() {
        }

        public static EmployeeBuilder anEmployee() {
            return new EmployeeBuilder();
        }

        public EmployeeBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder withEmployeeName(String employeeName) {
            this.employeeName = employeeName;
            return this;
        }

        public Employee build() {
            Employee employee = new Employee();
            employee.setId(id);
            employee.setEmployeeName(employeeName);
            return employee;
        }
    }
}
