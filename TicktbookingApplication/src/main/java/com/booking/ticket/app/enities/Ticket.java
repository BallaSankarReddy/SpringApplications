package com.booking.ticket.app.enities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;

	@Column(name = "passger_name", nullable = false)
	private String passgerName;

	@Column(name = "booking_date")
	private Date bookingDate;
	
	@Column(name="souce_station")
	private String source_station;
	
	@Column(name="dest_station")
	private String dest_station;
	
	@Column(name="email")
	private String email;
	
	
	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(Integer ticketId, String passgerName, Date bookingDate,
			String source_station, String dest_station, String email) {
		super();
		this.ticketId = ticketId;
		this.passgerName = passgerName;
		this.bookingDate = bookingDate;
		this.source_station = source_station;
		this.dest_station = dest_station;
		this.email = email;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassgerName() {
		return passgerName;
	}

	public void setPassgerName(String passgerName) {
		this.passgerName = passgerName;
	}

	
	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	
	public String getSource_station() {
		return source_station;
	}

	public void setSource_station(String source_station) {
		this.source_station = source_station;
	}

	public String getDest_station() {
		return dest_station;
	}

	public void setDest_station(String dest_station) {
		this.dest_station = dest_station;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passgerName=" + passgerName
				+ ", bookingDate=" + bookingDate + ", source_station="
				+ source_station + ", dest_station=" + dest_station
				+ ", email=" + email + "]";
	}

	
	
	
}
