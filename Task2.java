
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args){
        System.out.println("This is a student grade calculator.");

        //total number of subjects
        System.out.print("Enter total number of subjects:");
        Scanner sc = new Scanner(System.in);
        int total_subjects = sc.nextInt();
        int subject_marks[] = new int[total_subjects];

        // entering marks of each subject
        for (int i = 0; i < total_subjects; i++) {
            System.out.print("Enter marks of subject_"+ (i+1) +":");
             subject_marks[i]= sc.nextInt();
        }
        System.out.println();

        //calculating total marks
        int total_marks = 0;
        for (int i = 0; i <total_subjects; i++) {
            total_marks = total_marks +subject_marks[i];
        }
        //calculating average percentage
        int average_percentage = (total_marks)/total_subjects;

        //calculating grade of students
        char grade;
        if(average_percentage<=100 && average_percentage>=90){
            grade= 'A';
        }else if(average_percentage<=89 && average_percentage>=80){
            grade= 'B';
        }else if(average_percentage<=79 && average_percentage>=70){
            grade= 'C';
        }else if(average_percentage<=69 && average_percentage>50){
            grade= 'D';
        }else if(average_percentage<=49 && average_percentage>=30){
            grade= 'E';
        }else{
            grade = 'F';
        }
        
        //displaying total marks , average percentage and grade
        System.out.println("Total Marks:" + " "+ total_marks);
        System.out.println();
        System.out.println("Average Percentage:" + " "+ average_percentage + "%");
        System.out.println();
        System.out.println("Grade:" + grade);
        System.out.println();
    }
}
