package com.javaimplant.synchronizedstatic;

public class BookSeatMain {

	public static void main(String[] args) {
		BookTheaterApp b1 = new BookTheaterApp();
		BookSeats t1 = new BookSeats(b1,7);
		new Thread(t1).start();
		BookSeats2 t2 = new BookSeats2(b1,6);
		new Thread(t2).start();
	}
}
