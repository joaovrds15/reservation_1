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
		
		System.out.println("Room number:");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy):");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out: ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkOut)) {
			System.out.println("Error in reservation: Reservation dates for update must be future dates\r\n" + 
					"");
		}
		else {
			Reservation reservation = new Reservation(roomNumber,checkIn,checkOut);
		}
		
	}
}
