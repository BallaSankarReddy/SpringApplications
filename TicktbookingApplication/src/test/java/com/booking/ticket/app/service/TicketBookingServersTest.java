package com.booking.ticket.app.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.booking.ticket.app.dao.TicketBookingDao;
import com.booking.ticket.app.enities.Ticket;

public class TicketBookingServersTest {

	@Autowired
	TicketBookingServers ticketBookingServers;

	@MockBean
	TicketBookingDao ticketBookingDao;

	Ticket ticket;

	@Before
	public void setUp() {
		ticketBookingServers = new TicketBookingServers();
		ticketBookingDao = Mockito.mock(TicketBookingDao.class);
		// mock(TicketBookingDao.class);
		ticketBookingServers.setTicketBookingDao(ticketBookingDao);
		ticket = new Ticket();
		ticket.setBookingDate(new Date());
		ticket.setPassgerName("AP_Passbger");
		ticket.setDest_station("ATP");
		ticket.setTicketId(1);
		ticket.setSource_station("Chennai");
		ticket.setEmail("sankar.scb@gmail.com");

	}

	@Test
	public void createTicketTest() {

		when(ticketBookingDao.save(ticket)).thenReturn(ticket);
		// when(ticketBookingServers.createTicket(ticket)).thenReturn(ticket);
		// assertEquals(ticketBookingServers.createTicket(ticket), ticket);
		//assertNotEquals(ticketBookingServers.createTicket(ticket), ticket);
		ticketBookingServers.createTicket(ticket);
	}

	@Test
	public void getTicketByIdTest() {

		Mockito.when(ticketBookingDao.findOne(ticket.getTicketId()))
				.thenReturn(ticket);
		//assertEquals(ticketBookingServers.getTicketById(ticket.getTicketId()),ticket);
		ticketBookingServers.getTicketById(ticket.getTicketId());
		/*
		 * when(ticketBookingServers.getTicketById(ticket.getTicketId()))
		 * .thenReturn(ticket);
		 */

	}

	@Test
	public void updateTicketTest() { 

		when(ticketBookingDao.findOne(ticket.getTicketId())).thenReturn(ticket);
		ticketBookingServers.updateTicket(ticket.getTicketId(), ticket.getEmail());
		//assertEquals(ticketBookingServers.updateTicket(ticket.getTicketId(), ticket.getEmail()), ticket);
		/*when(
				ticketBookingServers.updateTicket(ticket.getTicketId(),
						ticket.getEmail())).thenReturn(ticket);*/
	}

	@Test
	public void getAllBookingTicketsTest() {
		Iterable<Ticket> itr = null;
		when(ticketBookingDao.findAll()).thenReturn(itr);
		ticketBookingServers.getAllBookingTickets();
	}

	/*
	 * @Test public void getTicketByIdTest(){
	 * 
	 * 
	 * when(ticketBookingServers.getTicketById(ticket.getTicketId())).thenReturn(
	 * ticket);
	 * when(ticketBookingDao.findOne(ticket.getTicketId())).thenReturn(ticket);
	 * }
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Test public void getAllBookingTicketsTest(){ //Iterator<Ticket>
	 * mockIterator = mock(Iterator.class); Collection<Ticket> fruits = null;
	 * when(mockIterator.hasNext()).thenReturn(true);
	 * when(mockIterator.next()).thenReturn(ticket); int iterations =0;
	 * for(Ticket t:fruits){ iterations++; } Iterable<Ticket> itr = null;
	 * when(ticketBookingDao.findAll()).thenReturn(itr);
	 * ticketBookingServers.getAllBookingTickets();
	 * 
	 * }
	 */

}
