package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.WeekendFitnessClubController;

public class WeekendFitnessClubControllerTest {

	private WeekendFitnessClubController controller;
	private ByteArrayOutputStream output;

	@Before
	public void setUp() {
		controller = new WeekendFitnessClubController();
		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
	}

	@Test
	public void testMenu() {
		String input = "1\n0\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		controller = new WeekendFitnessClubController();

		String expectedOutput = "* Weekend Fitness Club Management System *\r\n" + "1. Book a group fitness lesson\r\n"
				+ "2. Cancel a booking\r\n" + "3. Change a booking\r\n" + "4. Attend a lesson\r\n"
				+ "5. Monthly lesson report\r\n" + "6. Monthly champion fitness type report\r\n"
				+ "7. Display Timetable based on CustomerId , day and Weekend\r\n" + "0. Exit\r\n"
				+ "Enter your choice: \r\n" + "Exiting program...\r\n";

		assertEquals(expectedOutput, output.toString());
	}

	@Test
	public void testBookLesson() {
		String input = "1\n1\n0\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		controller = new WeekendFitnessClubController();

		String expectedOutput = "Enter your customer ID: \r\n" + "Enter the weekend for booking " + "Enter the type of lesson to book (Yoga, Zumba, or Pilates): \r\n"
				+ "Enter the number of people booking the lesson (max 5): \r\n" + "Booking successful.\r\n"
				+ "Enter your choice: \r\n" + "Exiting program...\r\n";

		assertEquals(expectedOutput, output.toString());
	}

	@Test
	public void testCancelBooking() {
		String input = "2\n1\n0\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		controller = new WeekendFitnessClubController();

		String expectedOutput = "Enter your customer ID: \r\n" + "Enter the weekend for booking: \r\n"
				+ "Enter the day (Saturday or Sunday): \r\n" + "Enter the type of lesson to cancel: \r\n"
				+ "Enter the number of people booked: \r\n" + "Booking cancelled.\r\n" + "Enter your choice: \r\n"
				+ "Exiting program...\r\n";

		assertEquals(expectedOutput, output.toString());
	}

	@Test
	public void testChangeBooking() {
		String input = "3\n1\n0\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		controller = new WeekendFitnessClubController();

		String expectedOutput = "Enter your customer ID: \r\n" + "Enter the weekend for booking: \r\n"
				+ "Enter the day (Saturday or Sunday): \r\n" + "Enter the type of lesson to change: \r\n"
				+ "Enter the number of people booked: \r\n" + "Booking changed.\r\n" + "Enter your choice: \r\n"
				+ "Exiting program...\r\n";

		assertEquals(expectedOutput, output.toString());
	}

}