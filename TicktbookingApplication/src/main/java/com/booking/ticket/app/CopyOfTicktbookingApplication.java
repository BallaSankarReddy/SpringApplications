/*package com.booking.ticket.app;

import java.util.Date;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.booking.ticket.app.dao.TicketBookingDao;
import com.booking.ticket.app.enities.Ticket;
import com.booking.ticket.app.service.TicketBookingServers;

@SpringBootApplication
//@SpringBootConfiguration()
public class CopyOfTicktbookingApplication implements CommandLineRunner {

	@Autowired
	private TicketBookingServers ticketBookingServers;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private TicketBookingDao ticketBookingDao;
    final static private Logger LOGGER = Logger.getLogger("TicktbookingApplication");
	
	public static void main(String[] args) {
		
		//TicketBookingServers ticketBookingServers
		ConfigurableApplicationContext applicationContext=SpringApplication.run(TicktbookingApplication.class, args);
		
		TicketBookingServers ticketBookingServers=	applicationContext.getBean("ticketBookingServers", TicketBookingServers.class);
		
		SpringApplication.run(CopyOfTicktbookingApplication.class, args);
		LOGGER.info(args);
	}

	
	@Override
	public void run(String... arg0) throws Exception {

		Ticket ticket=new Ticket();
		ticket.setBookingDate(new Date());
		ticket.setPassgerName("AP_Passbger");
		ticket.setDest_station("ATP");
		ticket.setSource_station("Chennai");
		ticket.setEmail("sankar.scb@gmail.com");
		ticketBookingServers.createTicket(ticket);
		
	System.out.println("DataSource :"+dataSource);	
		}
	
	
}
*/