/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package precivilization;

import java.util.Scanner;
import static precivilization.MiningJob.getNumMiners;

/**
 *
 * @author bryantsahota
 */
public class WorshippingJob {
    private final String jobTitle = "Worshipper";
    private static int numWorshippers = 0;
    //Number of culture points per turn
    private static int numCultPtsPerWorker = 2;
    
    //
    //Functions
    //
    
    //return num Worshipping
    public static int getNumWorshippers(){
        return numWorshippers;
    }
    
    //return number of points gained per worker
    public static int getCultPtsPerWorshipper(){
        return numCultPtsPerWorker;
    }
    
    //Sets the numbers of Worshippers
    public static void setNumWorshippers(int numWorkers){
        //Read numWorkers if fails
        Scanner sc = new Scanner(System.in);
        while(numWorkers > Job.army){
            System.out.println("You dont have that many free people!");
            System.out.println("Please enter a number less than or equal to: " + Job.army);
            numWorkers = sc.nextInt();
        }
        numWorshippers = numWorkers;
    }
    //Ask Player how many productions workers they want
    public static void userSetNumWorshippers(){
        System.out.println("You have " + Job.army + " people free.");
        System.out.println("You have " + getNumWorshippers() + " Worshippers currently working");
        System.out.println("How many Worshippers would you like?");
        Scanner sc = new Scanner(System.in);
        int userIntWorship = sc.nextInt();
        WorshippingJob.setNumWorshippers(userIntWorship);
    }
    
}
