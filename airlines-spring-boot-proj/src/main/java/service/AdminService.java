package service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.GenericDao;
import dto.FlightData;
import model.Flight;
import model.Schedule;
import model.Seat;
import model.SeatPK;

//@Component
@Service
@Transactional
public class AdminService {

	@Autowired
	private GenericDao genericDao;
	
	public void addFlight(FlightData flightData) {		
		Flight flight = new Flight();
		flight.setCarrier(flightData.getCarrier());
		flight.setSource(flightData.getSource());
		flight.setDestination(flightData.getDestination());
		
		//int days = Period.between(flightData.getStartDate(), flightData.getEndDate()).getDays();
		long days = ChronoUnit.DAYS.between(flightData.getStartDate(), flightData.getEndDate());
		//System.out.println(days);
		
		List<Schedule> schedules = new ArrayList<Schedule>();
		LocalDate date = flightData.getStartDate();
		for(int i=0; i<=days; i++) {
			Schedule schedule = new Schedule();
			schedule.setScheduleDate(date);
			schedule.setDepartureTime(flightData.getDepartureTime());
			schedule.setArrivalTime(flightData.getArrivalTime());
			schedule.setAvailableSeats(flightData.getAvailableSeats());
			schedule.setStatus("Active");
			
			List<Seat> seats = new ArrayList<Seat>();
			for(int j=1; j<=flightData.getAvailableSeats(); j++) {
				Seat seat = new Seat();
				SeatPK pk = new SeatPK();
				pk.setSeatNo(j);
				pk.setSchedule(schedule);
				seat.setId(pk);
				seat.setClass_("EC");
				seats.add(seat);
			}

			schedule.setFlight(flight);
			schedule.setSeats(seats);
			schedules.add(schedule);
	
			date = date.plusDays(1);
		}
		flight.setSchedules(schedules);
		
		genericDao.save(flight);
	}
}
