package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number:");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy):");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out: ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Reservation dates for update must be future dates" + 
					"");
		}
		else {
			Reservation reservation = new Reservation(roomNumber,checkIn,checkOut);
			System.out.println();
			System.out.println(reservation);
			System.out.println("Enter data to update the reservation");
			System.out.print("Check in date:");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check out date:");
			checkOut = sdf.parse(sc.next());
			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Reservation error:"+ error);
			}
			
			else {
				System.out.println(reservation);
			}
		}
		sc.close();
	}
}	