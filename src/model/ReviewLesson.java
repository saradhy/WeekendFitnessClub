package model;

public class ReviewLesson {
    private String lesson;
    private int rating;

    public ReviewLesson(String lesson, int rating) {
        this.lesson = lesson;
        this.rating = rating;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

