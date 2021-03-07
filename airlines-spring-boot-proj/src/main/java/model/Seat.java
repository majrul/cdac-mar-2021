package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Seat database table.
 * 
 */
@Entity
@NamedQuery(name="Seat.findAll", query="SELECT s FROM Seat s")
public class Seat implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SeatPK id;

	@Column(name="class")
	private String class_;

	public Seat() {
	}

	public SeatPK getId() {
		return this.id;
	}

	public void setId(SeatPK id) {
		this.id = id;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

}