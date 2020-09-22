package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.paypal.bfs.test.employeeserv.DAO.EmployeeDAO;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.paypal.bfs.test.employeeserv.exception.ResourceNotFoundException;
import java.net.URI;
/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

   @Autowired EmployeeDAO employeeDao;

    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {

        Integer longId= new Integer(id);
        Employee employee = employeeDao.findById(longId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

   @Override
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
    {
        int id = (int)employeeDao.count() + 1;
        employee.setId(id);

        employeeDao.save(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
