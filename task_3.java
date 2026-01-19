package tejal;

import java.util.Scanner;

public class task_3
{

    // Method to calculate grade
    public static char calculateGrade(double percentage) {
        if (percentage >= 90) return 'A';
        else if (percentage >= 75) return 'B';
        else if (percentage >= 60) return 'C';
        else if (percentage >= 40) return 'D';
        else return 'F';
    }

    // Method to display grade message using switch
    public static void gradeMessage(char grade) {
        switch (grade) {
            case 'A':
                System.out.println("Excellent Performance");
                break;
            case 'B':
                System.out.println("Very Good");
                break;
            case 'C':
                System.out.println("Good");
                break;
            case 'D':
                System.out.println("Pass");
                break;
            case 'F':
                System.out.println("Fail");
                break;
            default:
                System.out.println("Invalid Grade");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char choice;

        while (true) {

            int totalMarks = 0;
            boolean invalid = false;

            System.out.println("\nEnter marks for 5 subjects:");

            for (int i = 1; i <= 5; i++) {
                System.out.print("Subject " + i + ": ");
                int marks = sc.nextInt();

                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks! Enter between 0 and 100.");
                    invalid = true;
                    break;   // stop subject entry
                }
                totalMarks += marks;
            }

            if (invalid) {
                continue;   // skip result calculation
            }

            double percentage = (totalMarks / 500.0) * 100;
            char grade = calculateGrade(percentage);

            System.out.println("\n--- Result Summary ---");
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Percentage: " + percentage + "%");
            System.out.println("Grade: " + grade);
            gradeMessage(grade);

            System.out.print("\nDo you want to enter another student? (Y/N): ");
            choice = sc.next().charAt(0);

            if (choice == 'N' || choice == 'n') {
                break;   // exit loop
            }
        }

        sc.close();
        System.out.println("Program Ended.");
    }
}