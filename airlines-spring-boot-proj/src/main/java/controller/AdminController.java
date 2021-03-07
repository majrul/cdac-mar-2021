package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.FlightData;
import dto.Status;
import dto.Status.StatusType;
import service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/addFlight")
	public Status addFlight(@RequestBody FlightData flightData) {
		adminService.addFlight(flightData);
		
		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Flight added successfully!");
		return status;
	}
	
}
