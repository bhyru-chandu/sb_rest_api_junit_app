package in.ashokit.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import in.ashokit.service.MsgService;

@WebMvcTest(controllers = MsgRestController.class)
public class MsgRestControllerTest {

	@MockBean
	private MsgService msgService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testWelcome() throws Exception {

		when(msgService.getWelcomeMsg()).thenReturn("Dummy Text");

		// prepare GET request to /welcome url
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/welcome");

		// send GET request using MockMVC bean
		MvcResult result = mockMvc.perform(req).andReturn();

		// get response from result and validate it
		MockHttpServletResponse response = result.getResponse();

		int status = response.getStatus();

		assertEquals(200, status);
	}
	
	@Test
	public void testGreet() throws Exception {

		when(msgService.getGreetMsg()).thenReturn("Dummy Greet Msg....");

		// prepare GET request to /greet url
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/greet");

		// send GET request using MockMVC bean
		MvcResult result = mockMvc.perform(req).andReturn();

		// get response from result and validate it
		MockHttpServletResponse response = result.getResponse();

		int status = response.getStatus();

		assertEquals(200, status);
	}


}
