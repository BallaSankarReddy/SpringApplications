package com.booking.ticket.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booking.ticket.app.enities.Ticket;

@Repository
public interface TicketBookingDao extends CrudRepository<Ticket, Integer>{

}
