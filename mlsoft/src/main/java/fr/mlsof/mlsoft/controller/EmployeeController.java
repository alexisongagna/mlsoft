package fr.mlsof.mlsoft.controller;

import javax.annotation.Resource;
import fr.mlsof.mlsoft.model.Employee;
import fr.mlsof.mlsoft.repository.EmployeeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api( description="API pour les opérations CRUD sur les employés")
@RequestMapping(value="/api")
public class EmployeeController {

    @Resource
    private EmployeeRepository employeeRepository;

    @ApiOperation(value = "Récupère un employé grâce à son ID")
    @RequestMapping(value="/employee/{empNo}", method=RequestMethod.GET)
    public Employee getEmployee(@PathVariable String empNo){
        return employeeRepository.findByEmpNo(empNo) ;
    }

    @ApiOperation(value = "Renvoie de la liste de tous les employés")
    @RequestMapping(value="/employees", method=RequestMethod.GET)
    public Iterable<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
}
