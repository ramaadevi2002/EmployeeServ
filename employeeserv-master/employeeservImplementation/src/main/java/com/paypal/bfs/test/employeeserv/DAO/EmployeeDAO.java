package com.paypal.bfs.test.employeeserv.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

@Repository
public interface EmployeeDAO extends CrudRepository<Employee,Integer>{

}