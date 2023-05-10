package com.jspiders.multithreading.threads;

import com.jspiders.multithreading.resource.MovieTicket;

	public class TicketSeller extends Thread {
		MovieTicket movieticket;
		public TicketSeller(MovieTicket movieticket)
		{
			this.movieticket=movieticket;
			
		}
		public void run()
		{
			movieticket.addTickets(20);
		}

	}


