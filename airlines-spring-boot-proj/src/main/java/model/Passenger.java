package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name="Passenger.findAll", query="SELECT p FROM Passenger p")
public class Passenger {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="passenger_no")
	private int passengerNo;
	
	@ManyToOne
	@JoinColumn(name = "pnr_no")
	private Booking booking;
	
	@OneToOne
	@JoinColumns({@JoinColumn(name = "seat_no"), @JoinColumn(name = "schedule_no")})
	private Seat seat;

	private String name;
	private String gender;
	public int getPassengerNo() {
		return passengerNo;
	}
	public void setPassengerNo(int passengerNo) {
		this.passengerNo = passengerNo;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
