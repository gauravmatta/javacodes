package com.javaimplant.synchronizedstatic;

public class BookSeats implements Runnable {
	
	BookTheaterApp b;
	int seats;
	
	public BookSeats(BookTheaterApp b,int seats) {
		this.b=b;
		this.seats=seats;
	}

	@Override
	public void run() {
		b.bookSeat(seats);
	}

}
