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
public class ProductionJob extends Job {
    private final String jobTitle = "Production";
    private static int numProductionWorkers = 0;
    //Production Points gained per turn (Num workers * variable) var can change over course of game
    static int prodPtsPerWorker = 1;
    
    
    
    //
    //Functions
    //
    
    //return number of production points per worker
    static public int getProdPtsPerWorker(){
        return prodPtsPerWorker;
    }
    
    //Return number of oroduction workers
    public static int getNumProdWork(){
        return numProductionWorkers;
    }
    
    //Sets the numbers of production workers
    public static void setNumProdWork(int numWorkers){
        //Read numWorkers if fails
        Scanner sc = new Scanner(System.in);
        while(numWorkers > Job.army){
            System.out.println("You dont have that many free people!");
            System.out.println("Please enter a number less than or equal to: " + Job.army);
            numWorkers = sc.nextInt();
        }
        numProductionWorkers = numWorkers;
    }
    //Ask Player how many productions workers they want
    public static void userSetNumProdWorkers(){
        System.out.println("You have " + Job.army + " people free.");
        System.out.println("You have " + getNumProdWork() + " Production Workers currently working");
        System.out.println("How many Production Workers would you like?");
        Scanner sc = new Scanner(System.in);
        int userIntPWork = sc.nextInt();
        ProductionJob.setNumProdWork(userIntPWork);
        return;
    }

}
