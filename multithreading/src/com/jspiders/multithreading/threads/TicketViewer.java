package com.jspiders.multithreading.threads;

import com.jspiders.multithreading.resource.FlightTicket;

public class TicketViewer extends Thread{
    FlightTicket flightTicket;

    public TicketViewer(FlightTicket flightTicket){
        this.flightTicket=flightTicket;
    }

        @Override
        public void run(){
        flightTicket.purchaseTickets(10);
    }
}
