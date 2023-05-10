package com.jspiders.multithreading.resource;

public class FlightTicket {

    int availableTickets;

    public FlightTicket(int availableTickets)
    {
        this.availableTickets= availableTickets;
    }
    public synchronized void purchaseTickets(int noofTickets)
    {
        System.out.println("Trying to purchase "+noofTickets+" tickets.");
        if(noofTickets>=availableTickets)
        {
            System.out.println(noofTickets+" tickets are not available.");
            System.out.println(
            		availableTickets+" tickets available currently now on counter.");
            System.out.println("Please Wait...!!");
            try
            {
                this.wait();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            availableTickets -= noofTickets;
            System.out.println(noofTickets+" tickets purchased.");
            System.out.println("Now available tickets "+ availableTickets +".");

        }
    }
    public synchronized void  addTickets(int noofTickets)
    {
        System.out.println("Adding "+noofTickets+" tickets.");
        availableTickets  += noofTickets;
        System.out.println("Now available tickets are "+availableTickets +".");
        System.out.println("Now you can purchase your tickets.");
        System.out.println("now you are ready to Fly...!");
        this.notify();
    }
}
