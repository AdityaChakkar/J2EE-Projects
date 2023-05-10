package com.jspiders.multithreading.resource;

public class MovieTicket {

	int availableTickets;

		public MovieTicket(int availableTickets)
		{
			this.availableTickets= availableTickets;
		}
		 public synchronized void purchaseTickets(int noofTickets)
		 {
			 System.out.println("Trying to purchase "+noofTickets+" tickets");
			 if(noofTickets>=availableTickets)
			 {
				 System.out.println(noofTickets+" tickets not available");
				 System.out.println(availableTickets+" tickets available currently now on counter");
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
			 System.out.println(noofTickets+" tickets purchased");
			 System.out.println("Now available tickets "+ availableTickets);
			 
			 }
		 } 
		 public synchronized void  addTickets(int noofTickets)
		 {
			 System.out.println("Adding "+noofTickets+" tickets");
			 availableTickets  += noofTickets;
			 System.out.println("Now available tickets "+availableTickets);
			 System.out.println("Now you can purchase");
			 this.notify();
		 }

	}  


