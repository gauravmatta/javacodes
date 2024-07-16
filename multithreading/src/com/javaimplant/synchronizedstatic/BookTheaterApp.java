package com.javaimplant.synchronizedstatic;

public class BookTheaterApp {
	int total_seats=10;
	synchronized void bookSeat(int seats) {
		if(total_seats>=seats) {
			System.out.println("Seats Booked Succesfully");
			total_seats=total_seats-seats;
			System.out.println("seats left:"+total_seats);
		}else {
			System.out.println("Seats cannot be booked");
			System.out.println("seats left:"+total_seats);
		}
	}

}
