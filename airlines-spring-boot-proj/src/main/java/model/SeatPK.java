package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The primary key class for the Seat database table.
 * 
 */
@Embeddable
public class SeatPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="seat_no")
	private int seatNo;

	@ManyToOne
	@JoinColumn(name="schedule_no")
	private Schedule schedule;

	public SeatPK() {
	}
	public int getSeatNo() {
		return this.seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

}