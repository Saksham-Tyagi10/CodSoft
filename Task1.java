import java.util.Random;
import java.util.Scanner;
public class Task1{

    public static void main(String[] args){
     
        System.out.println(" It is a Number Game in which computer generates a number and user has to guess that number.");
        System.out.println();
        System.out.println("You have 5 attempts!");
        System.out.println();
        boolean choice=true;
      while(choice){
        //Generating a random number.
        Random num = new Random();
        int actual_number = num.nextInt(100);
        int count = 1;
        
        //User guessing the number.
        while(count<=5){
            System.out.print("Guess a Number:");
            Scanner sc = new Scanner(System.in);
            int guessed_number = sc.nextInt();

            //Guessed number is right.
            if(guessed_number == actual_number){
                System.out.println("You are Correct..!");
                break;
                
            }else{
                //Guessed number is wrong.
                if(guessed_number < actual_number){
                    System.out.println("You guessed a low number. Please guess a higher number");
                }else{
                    System.out.println("You guessed a high number. Please guess a lower number.");
                }
                if(count<5){
                    System.out.println("Oops, try again..!");
                    System.out.println();
                }
                if(count==5){
                    System.out.println(" It is the last Attempt and Not a right guess..!");
                     
                }
                count+=1;
            }
        }
        
        //Asking for a second round.
        System.out.println("Do you want to play again: yes(press-1) or no(press-0)");
        Scanner sc = new Scanner(System.in);
        int new_choice = sc.nextInt();
            choice = (new_choice == 1);
      } 
        
    }
    
}