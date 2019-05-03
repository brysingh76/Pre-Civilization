/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package precivilization;

import java.util.ArrayList;

/**
 *
 * @author bryantsahota
 */
public class Building {
    private String buildingName;
    //Cost of Building (in production points)
    private int buildingCost;
    
    //bool to see if building is unlocked
    private boolean unlocked = false;
    
    //Boost depending on building
    private int foodBoost;
    private int strBoost;
    private int popBoost;
    
    //Required tech for building
    Technology requiredTech;
    
    //
    //Functions
    //
    
    //Check to see if building is unlocked
    public boolean checkUnlock(){
        return unlocked;
    }
    
    //Constructor
    Building(String bName, int bCost, int fBoost, int sBoost, int pBoost, Technology reqTech){
        buildingName = bName;
        buildingCost = bCost;
        foodBoost = fBoost;
        strBoost = sBoost;
        popBoost = pBoost;
        requiredTech = reqTech;
    }
    
    //return required technology for building
    public String getRequiredTech(){
        return requiredTech.getTechName();
    }
    
    //return building cost
    public int getBuildingCost(){
        return buildingCost;
    }
    
    //unlock building
    public void toggleBuildUnlock(){
        unlocked = true;
    }
    
    //Create Building place in array and return
    //call techConstruct or pass array
    public static ArrayList<Building> buildingConstruct(ArrayList<Technology> tArr){
        //to hold passed in array of tech
        ArrayList<Technology> techArr = new ArrayList();
        techArr = tArr;
        
        //Tech variables to hold techReqs
        Technology mudHouse = null;
        Technology advStoneWeap = null;
        Technology cattleProduc = null; //corral
        
        //Cycle through the array and places proper array elements into proper tech variables
        int i = 0;
        while(i < techArr.size()){
            if(techArr.get(i).getTechName() == "Mudbrick House" ){
                mudHouse = techArr.get(i);
            }
            if(techArr.get(i).getTechName() == "Advanced Stone Weapons" ){
                advStoneWeap = techArr.get(i);
            }
            if(techArr.get(i).getTechName() == "Cattle Production" ){
                cattleProduc = techArr.get(i);
            }
            i++;
        }
        //Construct the three buildings
        Building mudbrickHouse = new Building("Mudbrick House", 5, 0, 0, 100, mudHouse);
        Building barracksObama = new Building("Barracks", 10, 0, 20, 0, advStoneWeap);
        Building corral = new Building("Corral", 7, 5, 0, 0, cattleProduc);
        
        //Array to hold building
        ArrayList<Building> buildArr = new ArrayList();
        buildArr.add(mudbrickHouse);
        buildArr.add(barracksObama);
        buildArr.add(corral);
        
        //Return array of buildings
        return buildArr;
    }
    
    //try to unlock building for player
    public void unlockBuilding(){
        if(Player.getPlayerProdPoints() < getBuildingCost()){
            System.out.println("You dont have enough production points.");
        }
        else{
            toggleBuildUnlock();
            System.out.println("Successfully purchased building!");
        }
    }
    
    //get Name of Building
    public String getBuildingName(){
        return buildingName;
    }
}
