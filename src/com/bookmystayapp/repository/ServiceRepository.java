package com.bookmystayapp.repository;
import com.bookmystayapp.model.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class ServiceRepository {
	private Map<String, List<Service>> reservationServices;
	
	public ServiceRepository() {
		this.reservationServices = new HashMap<>();
	}
	
	public void addService(String reservationId, Service service) {
	    reservationServices
	        .computeIfAbsent(reservationId, k -> new ArrayList<>())
	        .add(service);
	}
	
	public List<Service> getServices(String reservationId) {
	    return reservationServices.getOrDefault(reservationId, new ArrayList<>());
	}
}
