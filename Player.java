/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package precivilization;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bryantsahota
 */
public class Player {
    static private int maxPop = 5;
    private int numHouses;
    private static int numTurn = 0;
    private static int culturePoints = 5;
    private static int researchPoints = 1000;
    //Num productuction points player has
    private static int playerProductionPoints = 1000;
    
    //
    //Functions
    //
    
    //print player points and info
    public static void printPlayerPoints(){
        System.out.println("Turn Number: " + Player.getTurnNum());
        System.out.println("Culture Points: " + Player.getCultPts());
        System.out.println("Production Points: " + Player.getPlayerProdPoints());
        System.out.println("Research Points: " + Player.getPlayerResearchPts());
        System.out.println("Food Surplus: " + FarmerJob.getFoodSurplus());
    }
    
    //returns number of Research points player has
    public static int getPlayerResearchPts(){
        return researchPoints;
    }
    
    //return turn number
    public static int getTurnNum(){
        return numTurn;
    }
    
    //return number of culture points
    public static int getCultPts(){
        return culturePoints;
    }
    
    //sets the number of research points after purchase
    public static void setPlayerResearchPts(Technology purchased){
        researchPoints = researchPoints - purchased.getTechCost();
    }
    
    //Return number of production points
    public static int getPlayerProdPoints(){
        return playerProductionPoints;
    }
    
    //Sets number of production points after purchase
    public static void setPlayerProdPts(Building purchased){
        playerProductionPoints = playerProductionPoints - purchased.getBuildingCost();
    }
    
    //Retuns numbers of player owned houses
    public int getNumberOfHouses(){
        return numHouses;
    }
    
    //Print menu of all options
    public static void printMenuOptions(){
        System.out.println("1. Arrange Workers");
        System.out.println("2. View Technology");
        System.out.println("3. View Buildings");
        System.out.println("4. End Turn (Needs completeing)");
    }
    
    public static void printBuildings(ArrayList<Building> buildArr){
        System.out.println("Total Production Points: " + Player.getPlayerProdPoints());
        System.out.println();
        int i = 0;
        while(i < buildArr.size()){
            System.out.println(i + ". " + buildArr.get(i).getBuildingName());
            if(buildArr.get(i).checkUnlock() == true){
                System.out.println("Unlocked");
                System.out.println();
            }
             else
            {
                System.out.println("Required Technology: " + buildArr.get(i).getRequiredTech());
                System.out.println("Production Point Cost: " + buildArr.get(i).getBuildingCost());
                System.out.println();
            }
            i++;
        }
    }
    
    //Display Work Menu
    public static void printWorkMenu(int menuNum){
        switch(menuNum){
            case 1: 
                FarmerJob.userSetNumFarmers();
                System.out.println(FarmerJob.getNumFarmers());
                break;
                //Add if statement to check boolUnlocked (Add feature)
            case 2: 
                ProductionJob.userSetNumProdWorkers();
                break;
            case 3: 
                MiningJob.userSetNumMiners();
                break;
            case 4: 
                WorshippingJob.userSetNumWorshippers();
                break;
        }
        Job.printJobsMenu();
        Job.adjustNumPeopleWorking();
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanner to read in
        Scanner sc = new Scanner(System.in);
        
        //Array of technology
        ArrayList<Technology> techArray = new ArrayList();
        techArray = Technology.techConstruct();
        
        //Array of buildings
        ArrayList<Building> buildingArray = new ArrayList();
        buildingArray = Building.buildingConstruct(techArray);

        //Intro Messages
        System.out.println("Welcome to Pre-Civilizatoin!");
        System.out.println("You lead a pack of 4 people.");
        System.out.println("Your tribe is hungry. What would you like to do?");
        while(numTurn < 25){
            //Print options menu
            Player.printMenuOptions();
            int selectedOption = sc.nextInt();
            //menuNum for switch
            int menuNum;
            switch(selectedOption){
                //User selects to arrange workers
                case 1: 
                    //Displays each job and number of workers
                    Job.printJobsMenu();
                    menuNum = sc.nextInt();
                    Player.printWorkMenu(menuNum);
                    break;
                //User selects to view technology
                case 2:
                    System.out.println("What Technology would you like to unlock?");
                    Technology.printTechnology(techArray);
                    menuNum = sc.nextInt();
                
                    //Turn to function
                    //What happens when int tech is selected
                    if(techArray.get(menuNum).checkUnlock() == true){
                        System.out.println("Technology is already unlocked!");
                    }
                    if(Player.getPlayerResearchPts() < techArray.get(menuNum).getTechCost()){
                        System.out.println("You don't have enough research points.");
                    }
                    else{
                        System.out.println("Successful unlock!");
                        Player.setPlayerResearchPts(techArray.get(menuNum));
                        techArray.get(menuNum).unlockTech();
                    }
                    //System.out.println("Reprint test");
                    Technology.printTechnology(techArray);
                    break;
                //User selects to view Buildings
                case 3:
                    System.out.println("What building would you like to unlock?");
                    System.out.println();
                    Player.printBuildings(buildingArray);
                    menuNum = sc.nextInt();
                    buildingArray.get(menuNum).unlockBuilding();
                    setPlayerProdPts(buildingArray.get(menuNum));
                    Player.printBuildings(buildingArray);
                //User selects to end turn
                case 4:
                    //Increase research points
                    Player.researchPoints = Player.getPlayerResearchPts() + (Player.getCultPts()/5);
                    //Increment number of turn
                    Player.numTurn++;
                    //Increase culture points based on num workers and points per worker
                    Player.culturePoints = WorshippingJob.getNumWorshippers() * WorshippingJob.getCultPtsPerWorshipper();
                    //Increease production points based on num workers and points per worker
                    Player.playerProductionPoints = Player.playerProductionPoints + MiningJob.getNumMiners() * MiningJob.getProdPtsPerTurn();
                    Player.playerProductionPoints = Player.playerProductionPoints + ProductionJob.getNumProdWork() * ProductionJob.getProdPtsPerWorker();
                    Player.printPlayerPoints();
            }
        }
    }  
}
