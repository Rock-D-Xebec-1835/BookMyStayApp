package com.bookmystayapp.service;
import com.bookmystayapp.model.*;
import com.bookmystayapp.repository.*;

import java.util.List;
import java.util.Map;

public class ServiceManagementService {
    private ServiceRepository serviceRepository;

    public ServiceManagementService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public void addServiceToReservation(String reservationId, Service service) {
        serviceRepository.addService(reservationId, service);
    }

    public double calculateServiceCost(String reservationId) {
        List<Service> services = serviceRepository.getServices(reservationId);
        double total = 0;
        for(Service s : services) {
            total += s.getPrice();
        }
        return total;
    }
    
    public List<Service> getServicesForReservation(String reservationId) {
        return serviceRepository.getServices(reservationId);
    }
}