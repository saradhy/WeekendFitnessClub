package model;

public class Customer {
    private String name;
    private String lessonName;
    private String day;
    private String week;

    public Customer(String name, String lessonName, String day, String week) {
        this.name = name;
        this.lessonName = lessonName;
        this.day = day;
        this.setWeek(week);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}
}
