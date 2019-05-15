package fr.mlsof.mlsoft;

import javax.annotation.Resource;
import fr.mlsof.mlsoft.ApplicationConfig;
import fr.mlsof.mlsoft.model.Employee;
import fr.mlsof.mlsoft.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ApplicationConfig.class})
public class EmployeeTest {

    @Resource
    private EmployeeRepository employeeRepository;

    @Test
    public void getEmployee(){
        String n = "E1";
        Employee employees = employeeRepository.findByEmpNo(n);
        Assert.assertNotNull(employees);
        Assert.assertThat(n, is(employees.getEmpNo()));
    }

    @Test
    public void readAll(){
        Iterable<Employee> employees = employeeRepository.findAll();
        Assert.assertNotNull(employees);
        //Assert.assertTrue(employees. > 0);
    }
}