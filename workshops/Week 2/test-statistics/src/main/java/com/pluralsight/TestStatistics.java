package com.pluralsight;
import java.util.Arrays;

public class TestStatistics {
    public static void main(String[] args) {

        int[] scores = {85, 92, 78, 90, 88, 76, 95, 82, 89, 91};


        Arrays.sort(scores);

        System.out.println("Sorted Test Scores: " + Arrays.toString(scores));


        int lowScore = scores[0];
        int highScore = scores[scores.length - 1];


        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double average = sum / scores.length;


        double median;
        int middleIndex = scores.length / 2;
        if (scores.length % 2 == 0) {
            median = (scores[middleIndex - 1] + scores[middleIndex]) / 2.0;
        } else {
            median = scores[middleIndex];
        }

        double difference = average - median;


        System.out.println("\n--- Test Statistics ---");
        System.out.println("Low Score : " + lowScore);
        System.out.println("High Score: " + highScore);
        System.out.println("Average   : " + average);
        System.out.println("Median    : " + median);
        System.out.println("Difference: " + difference);
    }
}