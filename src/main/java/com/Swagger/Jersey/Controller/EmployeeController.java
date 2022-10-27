package com.Swagger.Jersey.Controller;

//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.Swagger.Jersey.Entity.EmployeeEntity;
import com.Swagger.Jersey.Service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//if the endpoints are implemented using Spring MVC instead of a JAX-RS implementation.
@Component
@XmlAccessorType(XmlAccessType.FIELD)
@Api(value = "EmployeeController")
//search and access  at that particular location
@Path("Emp")
//response that Consumed will be converted into JSON format.
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//response that produced will be converted into JSON format.
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	// Save the resource
	@POST
	@Path("/Save")
	// the response that will be Consumes will be converted into JSON format.
	@ApiOperation(produces = "application/json, application/xml", value = "Save employee details", httpMethod = "POST", notes = "<br>This service delete Employee details", response = EmployeeEntity.class)

	public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
		return employeeService.createEmployee(employeeEntity);
	}

	// Updates the resource
	@PUT
	@Path("/update")
	@ApiOperation(produces = "application/json, application/xml", value = "Update employee details", httpMethod = "PUT", notes = "<br>This service delete Employee details", response = EmployeeEntity.class)

	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
		return employeeService.updateEmployee(employeeEntity);
	}

	// Retrive the resource
	@GET
	// @Produces("Application/Json")
	@Path("/{id}")
	@ApiOperation(produces = "application/json, application/xml", value = "Get employee details", httpMethod = "GET", notes = "<br>This service delete Employee details", response = EmployeeEntity.class)

	public EmployeeEntity fetchEmployee(@PathParam("id") Long id) {
		return employeeService.fetchEmployee(id);

	}

	// Delete the resource
	@DELETE
	@Path("/{id}")
	@ApiOperation(produces = "application/json, application/xml", value = "Delete employee details", httpMethod = "DELETE", notes = "<br>This service delete Employee details", response = EmployeeEntity.class)
	public Boolean deleteById(@PathParam("id") Long id) {
		return employeeService.deleteEmployee(id);
	}

	@GET
	@Path("/getEmployees")
	@ApiOperation(produces = "application/json, application/xml", value = "Get employee details", httpMethod = "GET", notes = "<br>This service delete Employee details", response = EmployeeEntity.class)
	public List<EmployeeEntity> fetchAll() {
		return employeeService.fetchAllEmployees();
	}
}