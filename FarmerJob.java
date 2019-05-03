/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package precivilization;

import java.util.Scanner;

/**
 *
 * @author bryantsahota
 */
public class FarmerJob extends Job {
    private final String jobTitle = "Farmer";
    private boolean unlocked = true;
    private static int numFarmers = 0;
    //Food Gained Per Turn
    private static int numFoodGained = numFarmers*7; // less for challenge can also change 7 to variable to change over course of game
    //total food left
    private static int foodSurplus = numFoodGained - Job.returnFoodConsumedPerTurn();
    
    //
    //Functions
    //
    
    //Return food surplus
    public static int getFoodSurplus(){
        return foodSurplus;
    }
    
    public static void setNumFarmers(int numWorkers){
        //Read numWorkers if fails
        Scanner sc = new Scanner(System.in);
        while(numWorkers > Job.army){
            System.out.println("You dont have that many free people!");
            System.out.println("Please enter a number less than or equal to: " + Job.army);
            numWorkers = sc.nextInt();
        }
        numFarmers = numWorkers;
        //Change numWorkers for all functions (Bad design)
        //Job.numPeopleWorking 
    }
    
    //Returns number of Farmers
    public static int getNumFarmers()
    {
        return numFarmers;
    }
    
    //Returns Job Title
    public String getJobTitle(){
        return jobTitle;
    }
    
    //return num Food gained per turn
    public int getNumFood(){
        return numFoodGained;
    }
    
    //Display num farmers and ask how many farmers player wants working
    //Switch to jobs.Java all classes have same function
    //Make it generic for all classes
    public static void userSetNumFarmers(){
        System.out.println("You have " + Job.army + " people free.");
        System.out.println("You have " + getNumFarmers() + " farmers currently working");
        System.out.println("How many farmers would you like?");
        Scanner sc = new Scanner(System.in);
        int userIntFarmer = sc.nextInt();
        FarmerJob.setNumFarmers(userIntFarmer);
    }
}
