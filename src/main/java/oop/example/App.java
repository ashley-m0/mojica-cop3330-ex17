package oop.example;

import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Ashley Mojica
 */

/*
Exercise 17 - Blood Alcohol Calculator
Sometimes you have to perform a more complex calculation based on some provided inputs and then use
that result to make a determination.

Create a program that prompts for your weight, gender, total alcohol consumed (in ounces), and the
amount of time since your last drink. Calculate your blood alcohol content (BAC) using this formula

BAC = (A × 5.14 / W × r) − .015 × H

where:
A is total alcohol consumed, in ounces (oz).
W is body weight in pounds.
r is the alcohol distribution ratio:
0.73 for men
0.66 for women
H is number of hours since the last drink.

Display whether or not it’s legal to drive by comparing the blood alcohol content to 0.08.

Example Output:
Enter a 1 is you are male or a 2 if you are female: 1
How many ounces of alcohol did you have? 3
What is your weight, in pounds? 175
How many hours has it been since your last drink? 1

Your BAC is 0.049323
It is legal for you to drive.

or

Enter a 1 is you are male or a 2 if you are female: 1
How many ounces of alcohol did you have? 5
What is your weight, in pounds? 175
How many hours has it been since your last drink? 1

Your BAC is 0.092206
It is not legal for you to drive.

Constraint:
-Prevent the user from entering non-numeric values.

Challenges:
-Handle metric units.
-Look up the legal BAC limit by state and prompt for the state. Display a message that states whether
 or not it’s legal to drive based on the computed BAC.
-Develop this as a mobile application that makes it easy to record each drink, updating the BAC each
 time a drink is entered.
 */

public class App 
{
    static Scanner input = new Scanner(System.in);
    public static void main( String[] args )
    {
        App myApp = new App();
        int gender = myApp.getGender();
        int alcohol = myApp.getAlcoholConsumed();
        int weight = myApp.getWeight();
        int time = myApp.getTime();

        double distribution = myApp.getDistribution(gender);

        double BAC = myApp.calcBAC(alcohol, weight, distribution, time);
        String message = myApp.generateMessage(BAC);
        System.out.print(message);
    }

    public int getGender(){
        System.out.print("Enter a 1 is you are male or a 2 if you are female: ");
        int gender = input.nextInt();
        return gender;
    }

    public int getAlcoholConsumed(){
        System.out.print("How many ounces of alcohol did you have? ");
        int alc = input.nextInt();
        return alc;
    }

    public int getWeight(){
        System.out.print("What is your weight, in pounds? ");
        int weight = input.nextInt();
        return weight;
    }

    public int getTime(){
        System.out.print("How many hours has it been since your last drink? ");
        int hours = input.nextInt();
        return hours;
    }

    public double getDistribution(int gender){
        //male case
        if (gender == 1){
            return 0.73;
        } else {
            return 0.66;
        }
    }

    public double calcBAC(int alcohol, int weight, double distribution, int hours){
        //BAC = (A × 5.14 / W × r) − .015 × H
        return (alcohol * 5.14 / weight * distribution) - 0.015 * hours;
    }

    public String generateMessage(double BAC) {
        String message = String.format("Your BAC is %.6f", BAC);

        if (BAC >= 0.08){
            message = message.concat("\nIt is not legal for you to drive.");
        } else {
            message = message.concat("\nIt is legal for you to drive.");
        }

        return message;
    }

}
