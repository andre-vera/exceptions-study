package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class MainProgram {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check in date: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check out date: ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation. Checkout date must be after Checkin date.");
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			System.out.println();
			
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check in date: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check out date: ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error em reservation. The updated dates must be future dates.");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation. Check Out date must be after Check In date.");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println(reservation);
			}
		}
		
		
	}

}