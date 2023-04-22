package controller;


import java.util.Scanner;

import dao.FitnessLessonReportDao;
import dao.LessonReportDao;
import dao.WeekendFitnessClubDao;


public class WeekendFitnessClubController {
private static Scanner scanner = new Scanner(System.in);
public WeekendFitnessClubController() {
	WeekendFitnessClubDao clubDao = new WeekendFitnessClubDao();

	// WeekendFitnessClubDao clubDao = new WeekendFitnessClubDao();

	int choice = -1;
	while (choice != 0) {
		System.out.println("* Weekend Fitness Club Management System *");
		System.out.println("1. Book a group fitness lesson");
		System.out.println("2. Cancel a booking");
		System.out.println("3. Change a booking");
		System.out.println("4. Attend a lesson");
		System.out.println("5. Monthly lesson report");
		System.out.println("6. Monthly champion fitness type report");
		System.out.println("7. Display Timetable based on CustomerId , day and Weekend");
		System.out.println("0. Exit");
		System.out.println("Enter your choice: ");
		choice = scanner.nextInt();
		switch (choice) {
		case 1:
			clubDao.bookLesson();
			break;
		case 2:
			clubDao.CancelBooking();
			// CancelBooking method;
			break;
		case 3:
			clubDao.ChangeBooking();
			// // changeBooking method ;
			break;
		case 4:
			// Attend lesson method need to write;
			clubDao.AttendReview();
			break;
		case 5:
			// monthlyLessonReport method need to write;
			LessonReportDao lRdao = new LessonReportDao();
			lRdao.lessonReport();
			break;
		case 6:
			// monthlyChampionFitnessTypeReport method need to write;
			FitnessLessonReportDao fLRDao = new FitnessLessonReportDao();
			fLRDao.fitnessLessonReport();
			break;
		case 7:
			// monthlyChampionFitnessTypeReport method need to write;
			Scanner scDisplay = new Scanner(System.in);
			System.out.print("Enter the day (Saturday or Sunday): ");
			String day = scDisplay.nextLine();
			System.out.print("Enter the weekend for booking ");
			String weekend = scDisplay.nextLine();
			System.out.print("Enter your customer ID: ");
			int customerId = scDisplay.nextInt();
			clubDao.displayTimetable(weekend, day, customerId);

			break;
		case 0:
			System.out.println("Exiting program...");
			break;
		default:
			System.out.println("Invalid choice. Please try again.");
		}
		// Display the updated timetable
		// club.displayTimetable();
		// club.displayTimetable(display.get("weekend"),display.get("day"));
	}


}
}
