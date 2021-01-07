package com.jelly;

import java.util.Scanner;

public class Main {

    private static int getDesiredUsers(int minimumUsers) {
        System.out.print("Please enter the number of users you'd like to create: ");
        int input;
        if ((input = new Scanner(System.in).nextInt()) < minimumUsers) getDesiredUsers(minimumUsers); // Start again if user enters less than 5.
        return input;
    }

    private static void getUsersDetails(int users, String[] names, byte[] ages, String[] jobTitles) {
        for (int i = 0; i < users; i++) {
            System.out.print("\nPlease enter the name for user " + (i + 1) + ": ");
            names[i] = new Scanner(System.in).nextLine();
            System.out.print("Please enter the age for user " + (i + 1) + ": ");
            ages[i] = new Scanner(System.in).nextByte();
            System.out.print("Please enter the job title for user " + (i + 1) + ": ");
            jobTitles[i] = new Scanner(System.in).nextLine();
        }
    }

    private static void outputUsersDetails(String[] names, byte[] ages, String[] jobTitles) {
        StringBuilder output = new StringBuilder().append('\n');
        for (int i = 0; i < names.length; i++) {
            output.append("User ").append(i + 1).append(" Details - ")
            .append("Name: ").append(!names[i].equals("") ? names[i] : "NOT FOUND").append(", ") // Checking for "", since Scanner#nextLine() returns "" for no input, not null.
            .append("Age: ").append(ages[i]).append(", ") // No consideration for if the age isn't present, since Scanner#nextByte() doesn't read an 'enter' keypress as blank input, and keeps going until you enter something, and a user could technically be 0 years old.
            .append("Job Title: ").append(!jobTitles[i].equals("") ? jobTitles[i] : "NOT FOUND").append(".\n");
        }
        System.out.print(output.toString());
    }

    public static void main(String[] args) {
        // 1. Create three parallel arrays.
        final int INPUT = getDesiredUsers(5); // Configurable minimum users for testing purposes, minimum should be set to 5 or above for the purposes of the assignment's rubric.
        String[] names = new String[INPUT], jobTitles = new String[INPUT];
        byte[] ages = new byte[INPUT]; // Doesn't really make sense to use anything more than a byte here, since no one has ever come close to living over 127 years.

        // 2. Fill the parallel arrays.
        getUsersDetails(INPUT, names, ages, jobTitles);

        // 3. Output the parallel arrays information with one for loop.
        outputUsersDetails(names, ages, jobTitles);
    }
}
