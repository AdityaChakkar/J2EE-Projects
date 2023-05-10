package com.jspiders.multithreading.threads;

import com.jspiders.multithreading.resource.FlightTicket;

public class FlightTicketSeller extends Thread{

    FlightTicket flightTicket;
    
    public FlightTicketSeller(FlightTicket flightTicket) {
        this.flightTicket=flightTicket;
    }

       @Override
       public void run() {
        flightTicket.addTickets(20);
    }
}
