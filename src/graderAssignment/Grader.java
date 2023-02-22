/**
 * 
 */
package graderAssignment;

import java.util.Scanner;

/**
 * @author charapyge
 *
 */
public class Grader {

	/**
	 * @param <Stand>
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Declare global variables
		int assessment_score = 0, exam_score = 0, checker = 0, fee_amount = 0;
		String paid = "Y", cert_status;
		
		
		// Creating an instance of data picker for storing user input
		Scanner picker = new Scanner(System.in);
		
		// Getting exam score from user
		System.out.print("Please enter your exam score: ");
		exam_score = picker.nextInt(); // Capturing user input
		
		// Check for integer value
		if (!(Integer.class.isInstance(exam_score))) {
			System.out.println("Sorry, you supplied an invalid answer. Program will now exit. ");
			System.exit(0);
		}
		
		// Getting assessment score from user
		System.out.print("Please enter your assessment score: ");
		assessment_score = picker.nextInt(); // Capturing user input
		
		// Check for integer value
		if (!(Integer.class.isInstance(assessment_score))) {
			System.out.println("Sorry, you supplied an invalid answer. Program will now exit. ");
			System.exit(0);
		}
		
		int total_score = exam_score + assessment_score;
		
		// Getting fee status from user
		System.out.print("Have you paid your fees in full? (Y/N, y/n, Yes/No, YES/NO): ");
		String fees = picker.next(); // Capturing user input
		
		if (!(String.class.isInstance(paid))) {
			System.out.println("Sorry, you supplied an invalid answer. Program will now exit. ");
			System.exit(0);
		}
		else if (fees.toUpperCase() == "Y" || fees.toUpperCase() == "YES") {
			paid = "Y";
		}
		else if (fees.toUpperCase() == "N" || fees.toUpperCase() == "NO") {
			paid = "N";
		}

		// Getting Fee amount paid from user
		System.out.print("Please enter your fee amount paid: ");
		fee_amount = picker.nextInt(); // Capturing user input
		
		// Check for integer value
		if (!(Integer.class.isInstance(fee_amount))) {
			System.out.println("Sorry, you supplied an invalid answer. Program will now exit. ");
			System.exit(0);
		}
		
		// Catching possible throw exception
		if (fee_amount < 0 || fee_amount > 100) {
			System.out.println("The value you supplied is invalid. Program will now exit.");
			System.exit(0);
		}
		
		// Implement switching on the fee amount paid
		switch (fee_amount/100) { // Should be divided by 100 which will result in 1
			case 1: // If it results in 1 after division, then cert is approved
				cert_status = "APPROVED";
				break;
			case 0:
				cert_status = "DENIED";
				break;
			default: // Otherwise, cert is denied
				cert_status = "CANNOT DETERMINE";
		}
		// User has paid in full, has exam score being 25 or more and assessment score being 15 or more.
		if (cert_status == "APPROVED") {
			if (exam_score >= 25 && assessment_score >= 15) {
				System.out.println("=================================================================");
				System.out.println("Congratulations! You passed and have been awarded a CERTIFICATE.");
				System.out.println("=================================================================");
				System.out.println("This the summary of your result.");
				System.out.println("=================================================================");
				System.out.println("Total Score: " +  total_score);
				System.out.println("Exam Score: " +  exam_score);
				System.out.println("Assessment Score: " +  assessment_score);
				System.out.println("Your cert status is: " + cert_status);
				System.out.println("=================================================================");
			}
			// User has paid in full, has exam score being 25 and assessment score being 14.
			else if ((total_score == 39) && (exam_score == 25 && assessment_score == 14)) {
				System.out.println("=================================================================");
				System.out.println("You are condoned as your total score is 39. Below is the summary:");
				System.out.println("=================================================================");
				System.out.println("Total Score: " +  total_score);
				System.out.println("Exam Score: " +  exam_score + " <= Condoning factor");
				System.out.println("Assessment Score: " +  assessment_score);
				System.out.println("Your cert status is: " + cert_status);
				System.out.println("You have been awarded a CERTIFICATE. ");
				System.out.println("=================================================================");
			}
			// User has paid in full, has exam score being 24 and assessment score being 15.
			else if ((total_score == 39) && (exam_score == 24 && assessment_score == 15)) {
				System.out.println("=================================================================");
				System.out.println("You are condoned as your total score is 39. Below is the summary:");
				System.out.println("=================================================================");
				System.out.println("Total Score: " +  total_score);
				System.out.println("Exam Score: " +  exam_score);
				System.out.println("Assessment Score: " +  assessment_score + " <= Condoning factor");
				System.out.println("Your cert status is: " + cert_status);
				System.out.println("You have been awarded a CERTIFICATE. ");
				System.out.println("=================================================================");
			}
			// User has paid in full, has exam score being less than 24 and assessment score being 15.
			else if ((total_score < 39) && (exam_score < 24 || assessment_score == 15)) {
				System.out.println("=================================================================");
				System.out.println("Sorry, you failed this round. Below is the summary:");
				System.out.println("=================================================================");
				System.out.println("Total Score: " +  total_score);
				System.out.println("Low Exam Score: " +  exam_score);
				System.out.println("Assessment Score: " +  assessment_score);
				cert_status = "NOT ISSUED";
				System.out.println("Your cert status is: " + cert_status);
				System.out.println("=================================================================");
			}
			// User has paid in full, has exam score being 24 and assessment score being less than 15.
			else if ((total_score < 39) && (exam_score == 24 || assessment_score < 15)) {
				System.out.println("=================================================================");
				System.out.println("Sorry, you failed this round. Below is the summary:");
				System.out.println("=================================================================");
				System.out.println("Total Score: " +  total_score);
				System.out.println("Exam Score: " +  exam_score);
				System.out.println("Low Assessment Score: " +  assessment_score);
				cert_status = "NOT ISSUED";
				System.out.println("Your cert status is: " + cert_status);
				System.out.println("=================================================================");
			}
		} 
		// User has not paid in full, has exam score being 25 or more and assessment score being 15 or more.
		else if (cert_status == "DENIED") {
			// User has not paid in full, has exam score being 25 and assessment score being less than 14.
			if ((total_score < 39) && (exam_score == 25 && assessment_score < 14)) {
				System.out.println("=================================================================");
				System.out.println("Sorry, you failed this time around. Below is the summary:");
				System.out.println("=================================================================");
				System.out.println("Total Score: " +  total_score);
				System.out.println("Reason for failure: Low assessment score:\nAssessment score: " +  assessment_score);
				System.out.println("Exam Score: " +  exam_score);
				System.out.println("Assessment Score: " +  assessment_score);
				System.out.println("You are not awarded a CERTIFICATE. ");
				System.out.println("Reason for Certificate denial: Exam fee not paid in full:\nExam fee paid: " +  fee_amount);
				System.out.println("=================================================================");
			}
			// User has not paid in full, has exam score being less than 25 and assessment score being 14.
			else if ((total_score < 39) && (exam_score < 25 && assessment_score == 14)) {
				System.out.println("=================================================================");
				System.out.println("Sorry, you failed this time around. Below is the summary:");
				System.out.println("=================================================================");
				System.out.println("Total Score: " +  total_score);
				System.out.println("Reason for failure: Low exam score:\nExam score: " +  exam_score);
				System.out.println("Assessment Score: " +  assessment_score);
				System.out.println("You are not awarded a CERTIFICATE. ");
				System.out.println("Reason for Certificate denial: Exam fee not paid in full:\nExam fee paid: " +  fee_amount);
				System.out.println("=================================================================");
			}
			// User has not paid in full, has exam score being 25 and assessment score being 14.
			else if  ((total_score == 39) && (exam_score == 25 && assessment_score == 14)) {
				System.out.println("=================================================================");
				System.out.println("You are condoned as your total score is 39. Below is the summary:");
				System.out.println("=================================================================");
				System.out.println("Total Score: " +  total_score);
				System.out.println("Exam Score: " +  exam_score + " <= Condoning factor");
				System.out.println("Assessment Score: " +  assessment_score);
				System.out.println("You are not awarded a CERTIFICATE. ");
				System.out.println("Reason for Certificate denial: Exam fee not paid in full:\nExam fee paid: " +  fee_amount);
				System.out.println("=================================================================");
			}
		} 
		
		else {System.out.println("Nothing worked"); System.exit(0);}
		picker.close(); // Closing picker object to avoid memory leak

	}

}
