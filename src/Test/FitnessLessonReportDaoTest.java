package Test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import controller.WeekendFitnessClubController;
import dao.FitnessLessonReportDao;

public class FitnessLessonReportDaoTest {
	private ByteArrayOutputStream output;
	FitnessLessonReportDao dao = new FitnessLessonReportDao();
	@Before
	public void setUp() {
		new WeekendFitnessClubController();
		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));	
	}

	@Test
	public void testFitnessLessonReport() {

		String input = "7\n1\n0\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		new WeekendFitnessClubController();

		String expectedOutput = "Report: Type of fitness lesson with highest incomeLesson type	Income| LESSON     | TOTAL INCOME || Box Fit    | 4200     || Spin       | 500      || Bodysculpt | 3000     || Yoga       | 1500     || Zumba      | 900      || Aquacise   | 2250     |Lesson type with highest income: Box Fit";
		assertEquals(expectedOutput, output.toString());
	
	}
}
