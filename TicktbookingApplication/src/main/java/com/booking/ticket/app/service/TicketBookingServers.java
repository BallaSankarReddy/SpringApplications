package com.booking.ticket.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.ticket.app.dao.TicketBookingDao;
import com.booking.ticket.app.enities.Ticket;

@Service
public class TicketBookingServers {
	
	@Autowired
	private TicketBookingDao ticketBookingDao;
	
	
public void setTicketBookingDao(TicketBookingDao ticketBookingDao) {
		this.ticketBookingDao = ticketBookingDao;
	}


	//	
//	@PersistenceContext
//	private EntityManager entityManager;
//	
	public Ticket createTicket(Ticket ticket) {

		return ticketBookingDao.save(ticket);
	}


	public Ticket getTicketById(Integer ticketId) {
		// TODO Auto-generated method stub
		return ticketBookingDao.findOne(ticketId);
	}


	public Iterable<Ticket> getAllBookingTickets() {
		
		return ticketBookingDao.findAll();
		
	}


	public void deleteTicket(Integer ticketId) {

		ticketBookingDao.delete(ticketId);
	}


	public Ticket updateTicket(Integer ticketId, String newEmail) {

		Ticket ticketFromDB=ticketBookingDao.findOne(ticketId);
		ticketFromDB.setEmail(newEmail);
		//ticketFromDB.setTicketId(ticketId);
	Ticket updatedTicket=ticketBookingDao.save(ticketFromDB);
		return updatedTicket;
	}

	
}
