package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.Lesson;

public class WeekendFitnessClubDao {

	private Map<String, ArrayList<Integer>> saturdayLessons1 = new HashMap<>();
	private Map<String, ArrayList<Integer>> sundayLessons1 = new HashMap<>();
	private Map<String, ArrayList<Integer>> saturdayLessons2 = new HashMap<>();
	private Map<String, ArrayList<Integer>> sundayLessons2 = new HashMap<>();
	private Map<String, ArrayList<Integer>> saturdayLessons3 = new HashMap<>();
	private Map<String, ArrayList<Integer>> sundayLessons3 = new HashMap<>();
	private Map<String, ArrayList<Integer>> saturdayLessons4 = new HashMap<>();
	private Map<String, ArrayList<Integer>> sundayLessons4 = new HashMap<>();

	public void displayTimetable(String weekend, String day, int custId) {

		{
			System.out.println(
					"######################################### Timetable ##############################################");
			if (day.equalsIgnoreCase("saturday")) {
				if (weekend.equalsIgnoreCase("1")) {
					System.out.println("SATURDAY FIRST WEEK: ");
					System.out.printf("| %-10s | %-8s | %-8s | %4s |%n", "LESSON", "SLOT BOOKED", "FEES", "MAX SLOTS");
					patternMatchWithCountdisplay(day, Lesson.FITNESS_LESSONS, saturdayLessons1);
				} else if (weekend.equalsIgnoreCase("2")) {
					System.out.println("SATURDAY SECOND WEEK: ");
					System.out.printf("| %-10s | %-8s | %4s |%n", "LESSON", "SLOT BOOKED", "MAX SLOTS");
					patternMatchWithCountdisplay(day, Lesson.FITNESS_LESSONS, saturdayLessons2);

				} else if (weekend.equalsIgnoreCase("3")) {
					System.out.println("SATURDAY THIRD WEEK: ");
					System.out.printf("| %-10s | %-8s | %4s |%n", "LESSON", "SLOT BOOKED", "MAX SLOTS");
					patternMatchWithCountdisplay(day, Lesson.FITNESS_LESSONS, saturdayLessons3);
				} else {

					System.out.println("SATURDAY FORTH WEEK: ");
					System.out.printf("| %-10s | %-8s | %4s |%n", "LESSON", "SLOT BOOKED", "MAX SLOTS");
					patternMatchWithCountdisplay(day, Lesson.FITNESS_LESSONS, saturdayLessons4);

				}
			}

		}

		if (day.equalsIgnoreCase("sunday")) {
			if (weekend.equalsIgnoreCase("1")) {
				System.out.println("SUNDAY FIRST WEEK: ");
				System.out.printf("| %-10s | %-8s | %4s |%n", "LESSON", "SLOT BOOKED", "MAX SLOTS");
				patternMatchWithCountdisplay(day, Lesson.FITNESS_LESSONS, sundayLessons1);
			} else if (weekend.equalsIgnoreCase("2")) {
				System.out.println("SUNDAY SECOND WEEK: ");
				System.out.printf("| %-10s | %-8s | %4s |%n", "LESSON", "SLOT BOOKED", "MAX SLOTS");
				patternMatchWithCountdisplay(day, Lesson.FITNESS_LESSONS, sundayLessons2);

			} else if (weekend.equalsIgnoreCase("3")) {
				System.out.println("SUNDAY THIRD WEEK: ");
				System.out.printf("| %-10s | %-8s | %4s |%n", "LESSON", "SLOT BOOKED", "MAX SLOTS");
				patternMatchWithCountdisplay(day, Lesson.FITNESS_LESSONS, sundayLessons3);
			} else {

				System.out.println("SUNDAY FORTH WEEK: ");
				System.out.printf("| %-10s | %-8s | %4s |%n", "LESSON", "SLOT BOOKED", "MAX SLOTS");
				patternMatchWithCountdisplay(day, Lesson.FITNESS_LESSONS, sundayLessons4);

			}
		}

		System.out.println(
				"#########################################...........##############################################");
		System.out.println();
	}

	public void AttendReview() {

		HashMap<String, ArrayList<String>> reviewsByCustomer = new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<Integer>> ratingsByCustomer = new HashMap<String, ArrayList<Integer>>();
		HashMap<String, ArrayList<String>> reviewLessonCustomer = new HashMap<String, ArrayList<String>>();

		// Prompt user for reviews and ratings
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter a customer ID (or 'q' to quit): ");
			String customerID = sc.nextLine();
			if (customerID.equals("q")) {
				break;
			}
			System.out.print("Enter a Lesson to Review: ");
			String reviewLesson = sc.nextLine();
			System.out.print("Enter a review: ");
			String review = sc.nextLine();
			System.out.print("Enter a rating (1-5): ");
			int rating = sc.nextInt();
			sc.nextLine(); // Consume newline character

			// Add review and rating to customer's arrays
			if (!reviewsByCustomer.containsKey(customerID)) {
				reviewsByCustomer.put(customerID, new ArrayList<String>());
			}
			reviewsByCustomer.get(customerID).add(review);
			if (!ratingsByCustomer.containsKey(customerID)) {
				ratingsByCustomer.put(customerID, new ArrayList<Integer>());
			}
			ratingsByCustomer.get(customerID).add(rating);
			if (!reviewLessonCustomer.containsKey(customerID)) {
				reviewLessonCustomer.put(customerID, new ArrayList<String>());
			}
			reviewLessonCustomer.get(customerID).add(reviewLesson);

		}

		// Display reviews and ratings by customer
		for (String customerID : reviewsByCustomer.keySet()) {
			System.out.println("-----------------------------");
			System.out.println("Customer ID: " + customerID);
			ArrayList<String> reviews = reviewsByCustomer.get(customerID);
			ArrayList<Integer> ratings = ratingsByCustomer.get(customerID);
			ArrayList<String> lessons = reviewLessonCustomer.get(customerID);
			for (int i = 0; i < reviews.size(); i++) {
				System.out.println("- LessonType: " + lessons.get(i));
				System.out.println("- Review: " + reviews.get(i));

				int rating = ratings.get(i);
				switch (rating) {
				case 1:
					System.out.println("  Rating: 1 (We're sorry to hear that. Thank you for your feedback.)");
					break;
				case 2:
					System.out.println(
							"  Rating: 2 (We appreciate your feedback and will use it to improve our service.)");
					break;
				case 3:
					System.out.println(
							"  Rating: 3 (Thank you for your feedback. We're glad to hear you had an average experience.)");
					break;
				case 4:
					System.out.println(
							"  Rating: 4 (Thank you for your feedback. We're glad to hear you had a good experience.)");
					break;
				case 5:
					System.out.println(
							"  Rating: 5 (Thank you for your feedback. We're thrilled to hear you had an excellent experience!)");
					break;
				default:
					System.out.println("  Rating: Invalid rating");
					break;
				}

				System.out.println("-----------------------------");
			}
		}

	}

	@SuppressWarnings("resource")
	public boolean bookLesson() {
		// Book a lesson
		// WeekendFitnessClub club = new WeekendFitnessClub();
		Scanner bookScanner = new Scanner(System.in);
		System.out.print("Enter the day (Saturday or Sunday): ");
		String day = bookScanner.nextLine();
		System.out.print("Enter the weekend for booking ");
		String weekend = bookScanner.nextLine();
		displayTimetable(weekend, day, 0);
		System.out.print("Enter the lesson type: ");
		String lessonType = bookScanner.nextLine();
		System.out.print("Enter your customer ID: ");
		int customerId = bookScanner.nextInt();

		Map<String, ArrayList<Integer>> lessons = null;
		
		if (day.equals("Saturday")) {
			if (weekend.equals("1"))
				lessons = saturdayLessons1;
			else if (weekend.equals("2"))
				lessons = saturdayLessons2;
			else if (weekend.equals("3"))
				lessons = saturdayLessons3;
			else if (weekend.equals("4"))
				lessons = saturdayLessons4;

		} else if (day.equals("Sunday")) {

			if (weekend.equals("1"))
				lessons = sundayLessons1;
			else if (weekend.equals("2"))
				lessons = sundayLessons2;
			else if (weekend.equals("3"))
				lessons = sundayLessons3;
			else if (weekend.equals("4"))
				lessons = sundayLessons4;

		} else {
			System.out.println("Sorry, invalid day. try again");

			return false;
		}

		int lessonIndex = Arrays.asList(Lesson.FITNESS_LESSONS).indexOf(lessonType);
		if (lessonIndex == -1) {
			System.out.println("Sorry, invalid lesson. try again");
			return false;
		}

		ArrayList<Integer> customers = lessons.getOrDefault(lessonType + day + customerId, new ArrayList<>());

		if (customers.size() >= Lesson.MAX_CAPACITY_PER_COURSE) {
			System.out.println("Sorry, this lesson is full.");
			return false;
		} else if (customers.contains(customerId)) {
			System.out.println("You have already booked this lesson.");
			return false;
		} else {
			customers.add(customerId);
			lessons.put(lessonType + day + customerId, customers);
			System.out.println("Booking successful.");
			displayTimetable(weekend, day, customerId);

			return true;
		}

	}

	@SuppressWarnings("resource")
	public boolean CancelBooking() {
		// Book a lesson
		Scanner bookScanner = new Scanner(System.in);
		System.out.print("Enter the day (Saturday or Sunday): ");
		String day = bookScanner.nextLine();
		System.out.print("Enter the weekend for cadddncel booking (1 to 4) ");
		String weekend = bookScanner.nextLine();
		System.out.print("Enter the lesson type: ");
		String lessonType = bookScanner.nextLine();
		System.out.print("Enter your customer ID: ");
		int customerId = bookScanner.nextInt();

		Map<String, ArrayList<Integer>> lessons = null;
		if (day.equals("Saturday")) {
			if (weekend.equals("1"))
				lessons = saturdayLessons1;
			if (weekend.equals("2"))
				lessons = saturdayLessons2;
			if (weekend.equals("3"))
				lessons = saturdayLessons3;
			if (weekend.equals("4"))
				lessons = saturdayLessons4;

		} else if (day.equals("Sunday")) {
			if (weekend.equals("1"))
				lessons = sundayLessons1;
			if (weekend.equals("2"))
				lessons = sundayLessons2;
			if (weekend.equals("3"))
				lessons = sundayLessons3;
			if (weekend.equals("4"))
				lessons = sundayLessons4;

		} else {
			System.out.println("Sorry, invalid day. try again");
			return false;
		}

		int lessonIndex = Arrays.asList(Lesson.FITNESS_LESSONS).indexOf(lessonType);
		if (lessonIndex == -1) {
			System.out.println("Sorry, invalid lesson. try again");
			return false;
		}

		ArrayList<Integer> customers = lessons.getOrDefault(lessonType + day + customerId, new ArrayList<>());
		if (customers.contains(customerId)) {
			lessons.remove(lessonType + day + customerId, customers);
			System.out.println("Booking Cancel successful.");
			return true;
		} else {
			System.out.println("Invalid Booking Try again.");
			return false;
		}

	}

	@SuppressWarnings("resource")
	public boolean ChangeBooking() {
		// Book a lesson
		Scanner bookScanner = new Scanner(System.in);
		System.out.print("Enter the day (Saturday or Sunday): ");
		String day = bookScanner.nextLine();
		System.out.print("Enter the weekend for change lesson (1to 4) ");
		String weekend = bookScanner.nextLine();
		System.out.print("Enter the lesson type: ");
		String lessonType = bookScanner.nextLine();
		System.out.print("Enter your customer ID: ");
		int customerId = bookScanner.nextInt();

		Map<String, ArrayList<Integer>> lessons = null;
		if (day.equals("Saturday")) {
			if (weekend.equals("1"))
				lessons = saturdayLessons1;
			if (weekend.equals("2"))
				lessons = saturdayLessons2;
			if (weekend.equals("3"))
				lessons = saturdayLessons3;
			if (weekend.equals("4"))
				lessons = saturdayLessons4;

		} else if (day.equals("Sunday")) {
			if (weekend.equals("1"))
				lessons = sundayLessons1;
			if (weekend.equals("2"))
				lessons = sundayLessons2;
			if (weekend.equals("3"))
				lessons = sundayLessons3;
			if (weekend.equals("4"))
				lessons = sundayLessons4;

		} else {
			System.out.println("Sorry, invalid day. try again");
			return false;
		}

		int lessonIndex = Arrays.asList(Lesson.FITNESS_LESSONS).indexOf(lessonType);
		if (lessonIndex == -1) {
			System.out.println("Sorry, invalid lesson. try again");
			return false;
		}

		ArrayList<Integer> customers = lessons.getOrDefault(lessonType + day + customerId, new ArrayList<>());
		if (customers.contains(customerId)) {
			Scanner changeBookScanner = new Scanner(System.in);
			System.out.print("Enter the new day (Saturday or Sunday): ");
			String newDay = changeBookScanner.nextLine();
			System.out.print("Enter the new lesson type: ");
			String newLessonType = changeBookScanner.nextLine();

			Map<String, ArrayList<Integer>> newLessons = null;
			if (newDay.equals("Saturday")) {
				newLessons = saturdayLessons1;
			} else if (newDay.equals("Sunday")) {
				newLessons = sundayLessons1;
			} else {
				System.out.println("Sorry, invalid day. try again");
				return false;
			}
			if (newDay.equalsIgnoreCase(day) && newLessonType.equalsIgnoreCase(lessonType)) {
				System.out.println("Sorry, Asking same request to edit");
				return false;
			}
			int newLessonIndex = Arrays.asList(Lesson.FITNESS_LESSONS).indexOf(newLessonType);
			if (newLessonIndex == -1) {
				System.out.println("Sorry, invalid lesson. try again");
				return false;
			}

			ArrayList<Integer> newCustomers = newLessons.getOrDefault(newLessonType + newDay, new ArrayList<>());
			if (newCustomers.size() >= Lesson.MAX_CAPACITY_PER_COURSE) {
				System.out.println("Sorry, this lesson is full.");
				return false;
			} else if (newCustomers.contains(customerId)) {
				System.out.println("You have already booked this lesson.");
				return false;
			} else {
				newCustomers.add(customerId);
				newLessons.put(newLessonType + newDay, newCustomers);
				lessons.remove(lessonType + day + customerId, customers);
				System.out.println("Booking Updated successfully.");
				return true;
			}
		} else {
			System.out.println("Invalid Booking");
			return false;
		}

	}

	private void patternMatchWithCountdisplay(String daySelect, String[] fitnessLessons,
			Map<String, ArrayList<Integer>> lessonMap) {

		String pattern = "";
		for (int i = 0; i < fitnessLessons.length; i++) {

			int count = 0;
			pattern = fitnessLessons[i] + daySelect;
			for (String key : lessonMap.keySet()) {

				if (key.startsWith(pattern)) {
					count++;

				}

			}
			if (count > 0) {
				System.out.printf("| %-10s | %-8s    | %-8s    | %-8s  |%n", fitnessLessons[i], count,
						Lesson.FITNESS_LESSONS_FEES[i], Lesson.MAX_CAPACITY_PER_COURSE);
			} else {
				System.out.printf("| %-10s | %-8s    | %-8s    | %-8s  |%n", fitnessLessons[i], 0,
						Lesson.FITNESS_LESSONS_FEES[i], Lesson.MAX_CAPACITY_PER_COURSE);
			}

		}

	}

}
