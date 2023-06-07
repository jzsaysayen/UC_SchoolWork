import java.util.InputMismatchException;
import java.util.Scanner;

public class EnrollmentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the UC Enrollment System\n");

        // User information

        // Name input
        String name;
        while (true) {
            System.out.print("Enter your name (Letters and Spaces Only): ");
            name = scanner.nextLine();

            // Validate name input
            if (name.matches("[a-zA-Z\\s]+")) {
                break;  // Exit the loop if the input is valid
            } else {
                System.out.println("Invalid input. Please enter letters and spaces only.");
            }
        }

        // ID input
        int idNumber = 0;
        boolean validIdInput = false;
        while (!validIdInput) {
            try {
                System.out.print("Enter your ID number (9-digit number): ");
                String idString = scanner.nextLine();

                // Check if the input string has exactly 9 digits
                if (idString.length() != 9 || !idString.matches("\\d+")) {
                    throw new InputMismatchException();
                }

                // Convert the validated input string to an integer
                idNumber = Integer.parseInt(idString);
                validIdInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a 9-digit number.");
            }
        }



        // Sex input
        String sex = "";
        boolean validSexInput = false;
        while (!validSexInput) {
            try {
                System.out.print("Enter your sex (M/F): ");
                sex = scanner.nextLine();
                if (!sex.equalsIgnoreCase("M") && !sex.equalsIgnoreCase("F")) {
                    throw new InputMismatchException();
                }
                validSexInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter 'M' for male or 'F' for female.");
            }
        }

        // Course input
        String course = "";
        boolean validCourseInput = false;
        while (!validCourseInput) {
            try {
                System.out.print("Enter your course (BSIT/BSCS/BSDA): ");
                course = scanner.nextLine();
                if (!course.equalsIgnoreCase("BSIT") && !course.equalsIgnoreCase("BSCS") && !course.equalsIgnoreCase("BSDA")) {
                    throw new InputMismatchException();
                }
                validCourseInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid course.");
            }
        }

        System.out.println(); // Empty line for readability

        // Previous grades input
        System.out.println("Enter your previous trimester grades");

        int cc1 = 0;
        int cc2 = 0;
        int cc7 = 0;
        boolean validGradeInput = false;
        while (!validGradeInput) {
            try {
                System.out.print("CC1: ");
                cc1 = scanner.nextInt();
                if (cc1 < 0 || cc1 > 100) {
                    throw new InputMismatchException();
                }

                System.out.print("CC2: ");
                cc2 = scanner.nextInt();
                if (cc2 < 0 || cc2 > 100) {
                    throw new InputMismatchException();
                }

                System.out.print("CC7: ");
                cc7 = scanner.nextInt();
                if (cc7 < 0 || cc7 > 100) {
                    throw new InputMismatchException();
                }

                validGradeInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid grade (0-100).");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        }

        System.out.println("------------------------------"); // Empty line for readability

        System.out.println("Thank you for enrolling at the University of the Cordilleras! Here is your class schedule:");

        // Determine subjects based on course and grades
        int subjectCount = 0; // Initialize subject count

        switch (course) {
            case "BSIT":
                if (cc1 >= 75) {
                    System.out.println("CIT10 - MTh 7:30am - 11:30am");
                    subjectCount++;
                } else {
                    System.out.println("You failed CC1. You are not eligible to enroll in CIT10.");
                }
                if (cc2 >= 75) {
                    System.out.println("CIT11 - TF 7:30am - 11:30am");
                    subjectCount++;
                } else {
                    System.out.println("You failed CC2. You are not eligible to enroll in CIT11.");
                }
                if (cc7 >= 75) {
                    System.out.println("CIT12 - WS 7:30am - 11:30am");
                    subjectCount++;
                } else {
                    System.out.println("You failed CC7. You are not eligible to enroll in CIT12.");
                }
                break;
            case "BSCS":
                if (cc1 >= 75) {
                    System.out.println("CCS10 - MTh 7:30am - 11:30am");
                    subjectCount++;
                } else {
                    System.out.println("You failed CC1. You are not eligible to enroll in CCS10.");
                }
                if (cc2 >= 75) {
                    System.out.println("CCS11 - TF 7:30am - 11:30am");
                    subjectCount++;
                } else {
                    System.out.println("You failed CC2. You are not eligible to enroll in CCS11.");
                }
                if (cc7 >= 75) {
                    System.out.println("CCS12 - WS 7:30am - 11:30am");
                    subjectCount++;
                } else {
                    System.out.println("You failed CC7. You are not eligible to enroll in CCS12.");
                }
                break;
            case "BSDA":
                if (cc1 >= 75) {
                    System.out.println("CDA10 - MTh 7:30am - 11:30am");
                    subjectCount++;
                } else {
                    System.out.println("You failed CC1. You are not eligible to enroll in CDA10.");
                }
                if (cc2 >= 75) {
                    System.out.println("CDA11 - TF 7:30am - 11:30am");
                    subjectCount++;
                } else {
                    System.out.println("You failed CC2. You are not eligible to enroll in CDA11.");
                }
                if (cc7 >= 75) {
                    System.out.println("CDA12 - WS 7:30am - 11:30am");
                    subjectCount++;
                } else {
                    System.out.println("You failed CC7. You are not eligible to enroll in CDA12.");
                }
                break;
            default:
                System.out.println("Invalid course input. Please try again.");
                scanner.close();
                return;
        }

        if (subjectCount > 0) {
            int totalUnits = subjectCount * 3; // Calculate total units based on subject count
            System.out.println("Total number of units: " + totalUnits);
        } else {
            System.out.println("You failed all subjects. Please go to your college dean to get a promissory note.");
        }
        scanner.close();
    }
}
