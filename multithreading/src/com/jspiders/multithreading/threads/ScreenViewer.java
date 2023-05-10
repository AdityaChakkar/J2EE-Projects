package com.jspiders.multithreading.threads;

import com.jspiders.multithreading.resource.MovieTicket;

public class ScreenViewer extends Thread{
		MovieTicket movieticket;
		
		public ScreenViewer(MovieTicket movieticket){
			this.movieticket=movieticket;
		}
		
		public void run(){
			movieticket.purchaseTickets(10);
		}
	}
