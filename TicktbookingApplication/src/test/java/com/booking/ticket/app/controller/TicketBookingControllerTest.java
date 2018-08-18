package com.booking.ticket.app.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.booking.ticket.app.dao.TicketBookingDao;
import com.booking.ticket.app.enities.Ticket;
import com.booking.ticket.app.service.TicketBookingServers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TicketBookingController.class, secure = false)
public class TicketBookingControllerTest {

	@Autowired
	MockMvc mockMvc;
	@MockBean
	private TicketBookingServers ticketBookingServers;

	@MockBean
	private TicketBookingDao ticketBookingDao;

	@MockBean
	DataSource dataSource;

	Ticket ticket = new Ticket();
	Ticket ticket1 = new Ticket();

	String postURl = "/api/tickets/create";
	String getByID="/api/tickets/ticket/1";
	String getAllTickets="/api/tickets/alltickets";
	String inputJson;
	ObjectMapper obj=new ObjectMapper();

	@Before
	public void setUp() throws JsonProcessingException {

		ticket.setPassgerName("Sankar");
		ticket.setDest_station("ATP");
		ticket.setSource_station("Chennai");
		ticket.setEmail("sankar.scb@gmail.com");
		ticket.setTicketId(1);
		ticket.setBookingDate((new Date()));
		//

		ticket1.setPassgerName("Sankar");
		ticket1.setDest_station("ATP");
		ticket1.setSource_station("Chennai");
		ticket1.setEmail("sankar.scb@gmail.com");
		ticket1.setTicketId(2);
		ticket1.setBookingDate((new Date()));
		inputJson=obj.writeValueAsString(ticket);	
	}

	@Test
	public void createTicketTest() throws Exception {
		

		System.out.println(inputJson);
		when(ticketBookingServers.createTicket(Mockito.any(Ticket.class)))
				.thenReturn(ticket);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(this.postURl).accept(MediaType.APPLICATION_JSON)
				.content(inputJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		String outputJson=response.getContentAsString();
		System.out.println(outputJson);
		assertEquals(outputJson, inputJson);
		assertEquals(HttpStatus.OK.value(),response.getStatus());

	}
	
	@Test
	public void getTicketByIdTest() throws Exception{

		when(ticketBookingServers.getTicketById(Mockito.anyInt())).thenReturn(ticket);
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get(this.getByID).accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response=result.getResponse();
		
		String outputJson=response.getContentAsString();
		System.out.println(outputJson);
		assertEquals(outputJson, inputJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
	}

	@Test
	public void getAllBookingTicketsTest() throws Exception{
		List<Ticket> list_ticket=new ArrayList<Ticket>();
		list_ticket.add(ticket);
		list_ticket.add(ticket1);
		inputJson=obj.writeValueAsString(list_ticket);	
		when(ticketBookingServers.getAllBookingTickets()).thenReturn(list_ticket);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get(this.getAllTickets).contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response=result.getResponse();
		String outputJson=response.getContentAsString();
		System.out.println(outputJson);
		assertEquals(outputJson, inputJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void updateTicketTest() throws Exception{
		
		when(ticketBookingServers.updateTicket(Mockito.anyInt(), Mockito.anyString())).thenReturn(ticket);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.put("").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response=result.getResponse();
		String outputJson=response.getContentAsString();
		System.out.println(outputJson);
		assertEquals(outputJson, inputJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		
	}

}
