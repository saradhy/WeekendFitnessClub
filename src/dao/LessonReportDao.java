package dao;

import java.util.*;

import model.Customer;

public class LessonReportDao {
    public void lessonReport() {
        // Define the lessons and their ratings
        Map<String, Integer> lessonRatings = new HashMap<>();
        lessonRatings.put("Spin", 4);
        lessonRatings.put("Yoga", 3);
        lessonRatings.put("Bodysculpt", 5);
        lessonRatings.put("Zumba", 2);
        lessonRatings.put("Aquacise", 2);
        lessonRatings.put("Zumba", 2);
        
        
        // Define the customers and their lessons and days
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Leo", "Spin", "Saturday","week 1"));
        customers.add(new Customer("Aimee", "Spin", "Saturday","week 1"));
        customers.add(new Customer("Ricky", "Aquacise", "Saturday","week 1"));
        customers.add(new Customer("Chris", "Zumba", "Saturday","week 1"));
        customers.add(new Customer("Nolljean", "Yoga", "Saturday","week 1"));
        customers.add(new Customer("sam", "Spin", "Saturday","week 1"));
        customers.add(new Customer("Linto", "Spin", "Saturday","week 1"));
        customers.add(new Customer("iliies", "Bodysculpt", "Saturday","week 1"));
       
        customers.add(new Customer("Leo", "Aquacise", "Sunday","week 1"));
        customers.add(new Customer("Aimee", "Zumba", "Sunday","week 1"));
        customers.add(new Customer("Ricky", "Spin", "Sunday","week 1"));
        customers.add(new Customer("Chris", "Yoga", "Sunday","week 1"));
        customers.add(new Customer("Nolljean", "Zumba", "Sunday","week 1"));
        customers.add(new Customer("sam", "Yoga", "Sunday","week 1"));
        customers.add(new Customer("Linto", "Bodysculpt", "Sunday","week 1"));
        customers.add(new Customer("iliies", "Yoga", "Sunday","week 1"));
        
        customers.add(new Customer("ben", "Spin", "Saturday","week 2"));
        customers.add(new Customer("dane", "Spin", "Saturday","week 2"));
        customers.add(new Customer("stuart", "Aquacise", "Saturday","week 2"));
        customers.add(new Customer("pony", "Zumba", "Saturday","week 2"));
        customers.add(new Customer("analie", "Yoga", "Saturday","week 2"));
        customers.add(new Customer("tylor", "Spin", "Saturday","week 2"));
        customers.add(new Customer("gemma", "Spin", "Saturday","week 2"));
        customers.add(new Customer("james", "Bodysculpt", "Saturday","week 2"));
        
        customers.add(new Customer("ben", "Aquacise", "Sunday","week 2"));
        customers.add(new Customer("dane", "Aquacise", "Sunday","week 2"));
        customers.add(new Customer("stuart", "Spin", "Sunday","week 2"));
        customers.add(new Customer("pony", "Yoga", "Sunday","week 2"));
        customers.add(new Customer("analie", "Zumba", "Sunday","week 2"));
        customers.add(new Customer("tylor", "Zumba", "Sunday","week 2"));
        customers.add(new Customer("gemma", "Bodysculpt", "Sunday","week 2"));
        customers.add(new Customer("james", "Spin", "Sunday","week 2"));
        
        customers.add(new Customer("Leo", "Spin", "Saturday","week 3"));
        customers.add(new Customer("Aimee", "Spin", "Saturday","week 3"));
        customers.add(new Customer("Ricky", "Aquacise", "Saturday","week 3"));
        customers.add(new Customer("Chris", "Zumba", "Saturday","week 3"));
        customers.add(new Customer("Nolljean", "Yoga", "Saturday","week 3"));
        customers.add(new Customer("sam", "Spin", "Saturday","week 3"));
        customers.add(new Customer("Linto", "Spin", "Saturday","week 3"));
        customers.add(new Customer("iliies", "Bodysculpt", "Saturday","week 3"));
        
        customers.add(new Customer("Leo", "Spin", "Sunday","week 3"));
        customers.add(new Customer("dane", "Spin", "Sunday","week 3"));
        customers.add(new Customer("Ricky", "Aquacise", "Sunday","week 3"));
        customers.add(new Customer("stuart", "Zumba", "Sunday","week 3"));
        customers.add(new Customer("Nolljean", "Yoga", "Sunday","week 3"));
        customers.add(new Customer("pony", "Spin", "Sunday","week 3"));
        customers.add(new Customer("Linto", "Spin", "Sunday","week 3"));
        customers.add(new Customer("analie", "Bodysculpt", "Sunday","week 3"));
        
        
        customers.add(new Customer("Leo", "Spin", "Saturday","week 4"));
        customers.add(new Customer("Aimee", "Spin", "Saturday","week 4"));
        customers.add(new Customer("Ricky", "Aquacise", "Saturday","week 4"));
        customers.add(new Customer("Chris", "Zumba", "Saturday","week 4"));
        customers.add(new Customer("Nolljean", "Yoga", "Saturday","week 4"));
        customers.add(new Customer("sam", "Spin", "Saturday","week 4"));
        customers.add(new Customer("Linto", "Spin", "Saturday","week 4"));
        customers.add(new Customer("iliies", "Bodysculpt", "Saturday","week 4"));
        
        customers.add(new Customer("Leo", "Spin", "Sunday","week 4"));
        customers.add(new Customer("dane", "Spin", "Sunday","week 4"));
        customers.add(new Customer("Ricky", "Aquacise", "Sunday","week 4"));
        customers.add(new Customer("stuart", "Zumba", "Sunday","week 4"));
        customers.add(new Customer("Nolljean", "Yoga", "Sunday","week 4"));
        customers.add(new Customer("pony", "Spin", "Sunday","week 4"));
        customers.add(new Customer("Linto", "Spin", "Sunday","week 4"));
        customers.add(new Customer("analie", "Bodysculpt", "Sunday","week 4"));
        
        
        // Initialize a map that will store the number of customers per lesson on each day
        Map<String, Map<String, Integer>> customerCountByLessonByDay = new HashMap<>();
        // Initialize a map that will store the sum of ratings per lesson
        Map<String, Integer> ratingSumByLesson = new HashMap<>();
        // Initialize a map that will store the number of ratings per lesson
        Map<String, Integer> ratingCountByLesson = new HashMap<>();
        
        // Loop through all customers and update the customerCountByLessonByDay map
        for (Customer customer : customers) {
            String lessonName = customer.getLessonName();
            String day = customer.getDay();
            Map<String, Integer> customerCountByLesson = customerCountByLessonByDay.computeIfAbsent(day, k -> new HashMap<>());
            customerCountByLesson.put(lessonName, customerCountByLesson.getOrDefault(lessonName, 0) + 1);
        }
        
        // Loop through all lessons and update the ratingSumByLesson and ratingCountByLesson maps
        for (String lessonName : lessonRatings.keySet()) {
            int rating = lessonRatings.get(lessonName);
            ratingSumByLesson.put(lessonName, 0);
            ratingCountByLesson.put(lessonName, 0);
            for (String day : customerCountByLessonByDay.keySet()) {
                Map<String, Integer> customerCountByLesson = customerCountByLessonByDay.get(day);
                if (customerCountByLesson.containsKey(lessonName)) {
                    int customerCount = customerCountByLesson.get(lessonName);
                    ratingSumByLesson.put(lessonName, ratingSumByLesson.get(lessonName) + rating * customerCount);
                    ratingCountByLesson.put(lessonName, ratingCountByLesson.get(lessonName) + customerCount);
                }
            }
        }
        
        // Print the report
        System.out.println("Lesson Report:");
        System.out.println("---------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %10s | %10s | %10s |%n","WEEK", "DAY", "LESSON", "CUSTOMERS","A");
        System.out.println("---------------------------------------------------------");
        for (String day : customerCountByLessonByDay.keySet()) {
            Map<String, Integer> customerCountByLesson         = customerCountByLessonByDay.get(day);
            for (String lessonName : customerCountByLesson.keySet()) {
                int customerCount = customerCountByLesson.get(lessonName);
                int ratingSum = ratingSumByLesson.get(lessonName);
                int ratingCount = ratingCountByLesson.get(lessonName);
                double averageRating = (double) ratingSum / ratingCount;
                System.out.printf("| %-10s | %-10s | %10s | %10s |%n", day, lessonName, customerCount, averageRating);
                System.out.println("---------------------------------------------------------");
            }
        }
    }
}
