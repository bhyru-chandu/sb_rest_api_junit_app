package in.ashokit.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashokit.model.Customer;
import in.ashokit.service.CustomerService;

@WebMvcTest(value = CustomerRestController.class)
public class CustomerRestControllerTest {

	@MockBean
	private CustomerService customerService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testSaveCustomer1() throws Exception {

		Customer c = new Customer();
		c.setId(101);
		c.setName("Ashok");
		c.setEmail("ashok.b@gmail.com");

		when(customerService.saveCutomer(any(Customer.class))).thenReturn(true);

		ObjectMapper mapper = new ObjectMapper();
		String customerJson = mapper.writeValueAsString(c);
		
		
		MockHttpServletRequestBuilder req = 
				MockMvcRequestBuilders.post("/customer")
									  .contentType("application/json")
									  .content(customerJson);
		
		MvcResult result = mockMvc.perform(req).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		String contentAsString = response.getContentAsString();
		
		assertEquals("Customer Saved", contentAsString);

	}
	
	@Test
	public void testSaveCustomer2() throws Exception {

		Customer c = new Customer();
		c.setId(101);
		c.setName("Ashok");
		c.setEmail("ashok.b@gmail.com");

		when(customerService.saveCutomer(any(Customer.class))).thenReturn(false);

		ObjectMapper mapper = new ObjectMapper();
		String customerJson = mapper.writeValueAsString(c);
		
		
		MockHttpServletRequestBuilder req = 
				MockMvcRequestBuilders.post("/customer")
									  .contentType("application/json")
									  .content(customerJson);
		
		MvcResult result = mockMvc.perform(req).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		String contentAsString = response.getContentAsString();
		
		assertEquals("Customer Not Saved", contentAsString);

	}

}
