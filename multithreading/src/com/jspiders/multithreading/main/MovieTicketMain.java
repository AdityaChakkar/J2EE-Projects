package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.MovieTicket;
import com.jspiders.multithreading.threads.ScreenViewer;
import com.jspiders.multithreading.threads.TicketSeller;

public class MovieTicketMain {

		public static void main(String[] args) {
			MovieTicket movieticket = new MovieTicket(5);
			ScreenViewer screenViewer = new ScreenViewer(movieticket);
			TicketSeller ticketSeller = new TicketSeller(movieticket);
			
			screenViewer.start();
			ticketSeller.start();
		}
	}



