package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.example.controller.EmployeeController;
import com.example.entity.Employee;
import com.example.exception.RecordNotFoundException;
import com.example.service.EmployeeService;

@RunWith(SpringRunner.class)

// @WebMvcTest(EmployeeController.class)
// @ContextConfiguration(classes=EmployeeCrudOperationsApplication.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;

	@Test
	public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception {

		List<Employee> allEmployees = Arrays.asList(new Employee(1, "sai", 48000.22, "sai.shinde@yash.com"),
				new Employee(2, "sai1", 48070.22, "sai1.shinde@yash.com"));

		Mockito.when(employeeService.getAllEmployees()).thenReturn(allEmployees);

		mockMvc.perform(MockMvcRequestBuilders.get("/employees").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$[0].empName", is(allEmployees.get(0).getEmpName())));

	}

	/*@Test
	public void givenEmployeeId_wwhenGetEmployeebyId_ThenReturnJsonObject() throws Exception {
		Employee employee = new Employee(1, "sai", 48000.22, "sai.shinde@yash.com");

		Employee e = employeeService.getEmployeeById(1).get();
		System.out.println("frm test====" + e);
		Mockito.when(employeeService.getEmployeeById(1)).thenReturn(Optional.of(employee));

		mockMvc.perform(MockMvcRequestBuilders.get("/employee/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.empId", is(1)));
	}*/

	/*
	 * @Test public void
	 * givenInvalidEmployeeId_WhenGetEmployeebyId_ThenReturnNotFound() throws
	 * Exception { Employee employee = new Employee(1, "sai", 48000.22,
	 * "sai.shinde@yash.com");
	 * 
	 * Employee e = employeeService.getEmployeeById(122).get();
	 * System.out.println("frm test====" + e);
	 * Mockito.when(e).thenThrow(RecordNotFoundException.class);
	 * 
	 * mockMvc.perform(MockMvcRequestBuilders.get("/employee/122").contentType(
	 * MediaType.APPLICATION_JSON)) .andExpect(status().isNotFound()); }
	 */
	@Test
	public void testSaveEmployee() throws Exception {

		String exampleCourseJson = "{\"empName\":\"sai3\",\"salary\":\"48000.22\",\"email\":\"sai3.shinde@yash.com\"}";
		Employee employee = new Employee(3, "sai3", 49000.22, "sai3.shinde@yash.com");

		Mockito.when(employeeService.saveEmployee(employee)).thenReturn(employee);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employee").accept(MediaType.APPLICATION_JSON)
				.content(exampleCourseJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

}
