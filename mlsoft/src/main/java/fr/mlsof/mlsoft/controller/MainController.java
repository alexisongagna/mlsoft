package fr.mlsof.mlsoft.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import fr.mlsof.mlsoft.model.Employee;
import fr.mlsof.mlsoft.repository.EmployeeRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@Api( description="API pour les opérations CRUD sur les employés")
public class MainController {

    @Autowired
    @Resource
    private EmployeeRepository employeeRepository;

    private static final String[] NAMES = new String[] { "Tom", "Jerry", "Donald" };

    @ResponseBody
    @RequestMapping("/")
    public String home() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/api/testInsert'>Test Insert</a></li>";
        html += " <li><a href='/api/showAllEmployee'>Show All Employee</a></li>";
        html += " <li><a href='/api/showFullNameLikeTom'>Show All 'Tom'</a></li>";
        html += " <li><a href='/api/deleteAllEmployee'>Delete All Employee</a></li>";
        html += " <li><a href='/api/employees'>All Employee</a></li>";
        html += "</ul>";
        return html;
    }

    @ResponseBody
    @RequestMapping("/api/testInsert")
    public String testInsert() {

        Long empIdMax = this.employeeRepository.getMaxId();

        Employee employee = new Employee();

        int random = new Random().nextInt(3);

        long id = empIdMax + 1;
        String fullName = NAMES[random] + " " + id;

        employee.setId(id);
        employee.setEmpNo("E" + id);
        employee.setFullName(fullName);
        employee.setHireDate(new Date());
        this.employeeRepository.save(employee);

        return "Inserted: " + employee;
    }

    @ResponseBody
    @RequestMapping("/api/showAllEmployee")
    public String showAllEmployee() {

        Iterable<Employee> employees = this.employeeRepository.findAll();

        String html = "";
        for (Employee emp : employees) {
            html += emp + "<br>";
        }

        return html;
    }

    @ResponseBody
    @RequestMapping("/api/showFullNameLikeTom")
    public String showFullNameLikeTom() {

        List<Employee> employees = this.employeeRepository.findByFullNameLike("Tom");

        String html = "";
        for (Employee emp : employees) {
            html += emp + "<br>";
        }

        return html;
    }

    @ResponseBody
    @RequestMapping("/api/deleteAllEmployee")
    public String deleteAllEmployee() {

        this.employeeRepository.deleteAll();
        return "Deleted!";
    }



}
