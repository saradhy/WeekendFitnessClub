package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.FitnessReportModel;
import model.Lesson;

public class FitnessLessonReportDao {
	public void fitnessLessonReport() {

		// Create a list of FitnessLesson objects
		List<FitnessReportModel> lessons = new ArrayList<>();
		lessons.add(new FitnessReportModel("Spin", 10, 50));
		lessons.add(new FitnessReportModel("Yoga", 20, 75));
		lessons.add(new FitnessReportModel("Bodysculpt", 30, 100));
		lessons.add(new FitnessReportModel("Zumba", 15, 60));
		lessons.add(new FitnessReportModel("Aquacise", 25, 90));
		lessons.add(new FitnessReportModel("Box Fit", 35, 120));

		// Calculate the total income for each type of lesson
		Map<String, Integer> incomeByLesson = new HashMap<>();
		for (FitnessReportModel lesson : lessons) {
			String lessonType = lesson.getType();
			int lessonIncome = lesson.getPrice() * lesson.getAttendees();
			if (incomeByLesson.containsKey(lessonType)) {
				int totalIncome = incomeByLesson.get(lessonType) + lessonIncome;
				incomeByLesson.put(lessonType, totalIncome);
			} else {
				incomeByLesson.put(lessonType, lessonIncome);
			}
		}

		// Determine the lesson type with the highest income
		String highestIncomeLessonType = "";
		int highestIncome = 0;
		for (String lessonType : incomeByLesson.keySet()) {
			int totalIncome = incomeByLesson.get(lessonType);
			if (totalIncome > highestIncome) {
				highestIncomeLessonType = lessonType;
				highestIncome = totalIncome;
			}
		}

		// Print the report
		System.out.println("Report: Type of fitness lesson with highest income");
		System.out.println("Lesson type\tIncome");
		System.out.printf("| %-10s | %-8s |%n", "LESSON", "TOTAL INCOME");
		for (String lessonType : incomeByLesson.keySet()) {
			int totalIncome = incomeByLesson.get(lessonType);

			System.out.printf("| %-10s | %-8s |%n", lessonType, totalIncome);
		}
		System.out.println("\nLesson type with highest income: " + highestIncomeLessonType);
	}
}
