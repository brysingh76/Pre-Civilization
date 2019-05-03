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
public class MiningJob {
    private final String jobTitle = "Miner";
    private static int numMiners = 0;
    private static int numProdPtsPerTurn = 2;
    
    //
    //Functions
    //
    
    //return number of production points per worker
    public static int getProdPtsPerTurn(){
        return numProdPtsPerTurn;
    }
    
    //return number of miners
    public static int getNumMiners(){
        return numMiners;
    }
    
     //Sets the numbers of Miners
    public static void setNumMiners(int numWorkers){
        //Read numWorkers if fails
        Scanner sc = new Scanner(System.in);
        while(numWorkers > Job.army){
            System.out.println("You dont have that many free people!");
            System.out.println("Please enter a number less than or equal to: " + Job.army);
            numWorkers = sc.nextInt();
        }
        numMiners = numWorkers;
    }
    //Ask Player how many productions workers they want
    public static void userSetNumMiners(){
        System.out.println("You have " + Job.army + " people free.");
        System.out.println("You have " + getNumMiners() + " Miners currently working");
        System.out.println("How many Miners would you like?");
        Scanner sc = new Scanner(System.in);
        int userIntMWork = sc.nextInt();
        MiningJob.setNumMiners(userIntMWork);
    }

}
