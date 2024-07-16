package com.javaimplant.synchronizedstatic;

public class BookSeats2 implements Runnable {
	
	BookTheaterApp b;
	int seats;
	
	public BookSeats2(BookTheaterApp b,int seats) {
		this.b=b;
		this.seats=seats;
	}

	@Override
	public void run() {
		b.bookSeat(seats);
	}

}
