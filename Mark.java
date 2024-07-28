import java.util.InputMismatchException;
import java.util.Scanner;

public class Mark {
    private static final int MAX_MARKS = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numSubjects = getNumSubjects(scanner);
        double totalMarks = getTotalMarks(scanner, numSubjects);
        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);
        char grade = calculateGrade(averagePercentage);

        System.out.printf("Total Marks: %.2f%n", totalMarks);
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.println("Grade: " + grade);
    }

    private static int getNumSubjects(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter the number of subjects: ");
                int numSubjects = scanner.nextInt();
                if (numSubjects <= 0) {
                    System.out.println("Number of subjects must be a positive integer.");
                    continue;
                }
                return numSubjects;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    private static double getTotalMarks(Scanner scanner, int numSubjects) {
        double totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++) {
            while (true) {
                try {
                    System.out.print("Enter marks obtained in subject " + i + " (out of " + MAX_MARKS + "): ");
                    double marks = scanner.nextDouble();
                    if (marks < 0 || marks > MAX_MARKS) {
                        System.out.println("Marks must be between 0 and " + MAX_MARKS + ".");
                        continue;
                    }
                    totalMarks += marks;
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next();
                }
            }
        }
        return totalMarks;
    }

    private static double calculateAveragePercentage(double totalMarks, int numSubjects) {
        return totalMarks / numSubjects;
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
    
