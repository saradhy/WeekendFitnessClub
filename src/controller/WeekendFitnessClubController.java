package controller;

import java.util.InputMismatchException;
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
			System.out.println("____________________________________________" + "\n");

			System.out.println("* WEEKEND FITNESS CLUB MANAGEMENT SYSTEM *");
			System.out.println("____________________________________________" + "\n");

			// System.out.println("1. BOOK LESSON");
			System.out.printf("| %1s * %-8s                          |%n", "1", "BOOK LESSON");

			System.out.printf("| %1s * %-8s                       |%n", "2", "CANCEL BOOKING");
			System.out.printf("| %1s * %-8s                       |%n", "3", "CHANGE BOOKING");
			System.out.printf("| %1s * %-8s                        |%n", "4", "ATTEND LESSON");
			System.out.printf("| %1s * %-8s                |%n", "5", "MONTHLY LESSON REPORT");
			System.out.printf("| %1s * %-8s |%n", "6", "MONTHLY CHAMPION FITNESS TYPE REPORT");
			System.out.printf("| %1s * %-8s                       |%n", "7", "VIEW TIMETABLE");
			System.out.printf("| %1s * %-8s                            |%n", "0", "EXIT MENU");
			System.out.println("____________________________________________");
			System.out.println("Enter your choice: ");
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid input: please enter an integer");
                scanner.nextLine(); // clear input buffer
                continue;
			}
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
