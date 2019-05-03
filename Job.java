/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package precivilization;

/**
 *
 * @author bryantsahota
 */
//Production, Culture, Food
public class Job {
    final static int numMeals = 3;
    //Start with 5 people (Game's current population)
    static private int totalNumWorkers = 5;
    static private int numPeopleWorking = 0;
    //Army people = people not doing anything
    static int army = totalNumWorkers - numPeopleWorking;
    //Number of people times 3 meals a day
    private static int foodConsumedPerTurn = Job.getNumWorkers()*numMeals;
    
    //
    //Functions
    //
    
    //return size of army
    public static int getArmySize(){
        return army;
    }
    
    //Return food consumed per turn
    public static int returnFoodConsumedPerTurn(){
        return foodConsumedPerTurn;
    }
    
    //Display menu for jobs 
    public static void printJobsMenu(){
        System.out.println("There are " + Job.getArmySize() + " people in your army that can be used for other tasks.");
        System.out.println("What would you like them to do?");
        //Display all possible jobs that are unlocked
        //use array for this and check for unlock
        System.out.println("1.Farming: " + FarmerJob.getNumFarmers());
        System.out.println("2.Production: " + ProductionJob.getNumProdWork());
        System.out.println("3.Mining: " + MiningJob.getNumMiners());
        System.out.println("4.Worshipping: " + WorshippingJob.getNumWorshippers());
        System.out.println("5. End Turn (Needs completeing and possibly move to main menu)");
        //System.out.println("5.Army: " + Job.army);
    }
    
    //Return number of Player's population
    static public int getNumWorkers(){
        return totalNumWorkers;
    }
    
    //Change number of people working
    //
    //IMPORTANT
    static public void adjustNumPeopleWorking(){
        Job.numPeopleWorking = FarmerJob.getNumWorkers() + ProductionJob.getNumProdWork() + MiningJob.getNumMiners() + WorshippingJob.getNumWorshippers();
    }
}
