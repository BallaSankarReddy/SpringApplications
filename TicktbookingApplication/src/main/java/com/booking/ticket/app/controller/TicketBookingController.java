package com.booking.ticket.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.ticket.app.dao.TicketBookingDao;
import com.booking.ticket.app.enities.Ticket;
import com.booking.ticket.app.service.TicketBookingServers;

@RestController
@RequestMapping(value = "/api/tickets")
public class TicketBookingController {
 
	@Autowired
	private TicketBookingServers ticketBookingServers;
	@Autowired
	private TicketBookingDao ticketBookingDao;
	@Value("${welcome.message}")
	private String welcomeMessage;

	
	
	Ticket ticket=new Ticket();

	public String helloWorld() {

		return "Hello...";
	}

	@GetMapping("/welcome")
	public String retrieveWelcomeMessage() {
		// Complex Method
		return welcomeMessage;
	}

	@PostMapping(value = "/create")
	// /api/tickets/create
	public Ticket createTicket(@RequestBody Ticket ticket) {
		this.ticket.setBookingDate(new Date());
		this.ticket.setPassgerName("AP_Passbger");
		this.ticket.setDest_station("ATP");
		this.ticket.setSource_station("Chennai");
		this.ticket.setEmail("sankar.scb@gmail.com");
		return ticketBookingServers.createTicket(ticket);
	}

	@GetMapping(value = "/ticket/{ticketId}")
	public Ticket getTicketById(@PathVariable("ticketId") Integer ticketId) {
		return ticketBookingServers.getTicketById(ticketId);
	}

	@GetMapping(value = "/alltickets")
	public Iterable<Ticket> getAllBookingTickets() {

		return ticketBookingServers.getAllBookingTickets();
	}

	@DeleteMapping(value = "/ticket/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		ticketBookingServers.deleteTicket(ticketId);
	}

	@PutMapping(value = "/ticket/{ticketId}/{newEmail:.+}")
	public Ticket updateTicket(@PathVariable("ticketId") Integer ticketId,
			@PathVariable("newEmail") String newEmail) {

		return ticketBookingServers.updateTicket(ticketId, newEmail);

	}

}
