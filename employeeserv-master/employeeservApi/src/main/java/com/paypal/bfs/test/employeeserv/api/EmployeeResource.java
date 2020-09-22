package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Interface for employee resource operations.
 */
@RequestMapping("/v1/bfs")
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    @GetMapping("/employees/{id}")
    ResponseEntity<Employee> employeeGetById(@PathVariable("id") String id);

    @PostMapping(path= "/employees/", consumes = "application/json", produces = "application/json")
    ResponseEntity<Employee> addEmployee(@RequestBody Employee employee);

}
