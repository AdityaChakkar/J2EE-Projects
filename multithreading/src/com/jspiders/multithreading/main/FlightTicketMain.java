package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.FlightTicket;
import com.jspiders.multithreading.threads.FlightTicketSeller;
import com.jspiders.multithreading.threads.TicketViewer;

public class FlightTicketMain {
    public static void main(String[] args) {
        FlightTicket flightTicket = new FlightTicket(5);
        TicketViewer ticketViewer = new TicketViewer(flightTicket);
        FlightTicketSeller ticketSeller = new FlightTicketSeller(flightTicket);

        ticketViewer.start();
        ticketSeller.start();
    }
}