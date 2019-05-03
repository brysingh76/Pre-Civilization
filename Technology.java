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
public class Technology {
    private String techName;
    //Points to unlock
    private int reqResearchPts;
    //Required tech (May not be any)
    private Technology requiredTech;
    //bool for required tech to unlock
    private boolean  unlocked = false;
    
    //
    //Functions
    //
    
    //Constructor
    Technology(String tName, int unlockPts, Technology techToUnlock){
        techName = tName;
        reqResearchPts = unlockPts;
        requiredTech = techToUnlock;
        //unlocked = false;
    }
    
    //toggle unlock (mostlikely just to true)
    public void unlockTech(){
        unlocked = true;
    }
    
    //Return is tech has been unlocked
    public boolean checkUnlock(){
        return unlocked;
    }
    
    //return name of tech
    public String getTechName(){
        return techName;
    }
    
    //get research point cost for building
    public int getTechCost(){
        return reqResearchPts;
    }
    
    //get required technology to unlock building
    public String getRequiredTech(){
        if(requiredTech == null){
            return "None";
        }
        else{
            return requiredTech.getTechName();
        }
    }
    
    
    //Create the different tech;
    public static ArrayList<Technology> techConstruct(){
        //Stash all these into an array and return it
        Technology primitiveFarm = new Technology("Primitive Farming", 1, null);
        Technology mudbrickHouse = new Technology("Mudbrick House", 1, null);
        Technology advStoneTools = new Technology("Advanced Stone Tools", 3, null);
        Technology primAnimBreed = new Technology("Primitive Animal Breeding", 2, primitiveFarm);
        Technology cattleTechnol = new Technology("Cattle Production", 3, primAnimBreed);
        Technology cultivateTech = new Technology("Culivation", 3, primitiveFarm);
        Technology miningTechnol = new Technology("Mining", 3, advStoneTools);
        Technology advStoneWeapn = new Technology("Advanced Stone Weapons", 4, advStoneTools);
        Technology mysticTechnol = new Technology("Mysticism", 2, null);
        ArrayList <Technology> techArr = new ArrayList();
        techArr.add(mudbrickHouse);
        techArr.add(advStoneTools);
        techArr.add(primAnimBreed);
        techArr.add(cattleTechnol);
        techArr.add(cultivateTech);
        techArr.add(miningTechnol);
        techArr.add(advStoneWeapn);
        techArr.add(mysticTechnol);
        //System.out.println("TEST.");
        //Technology.printTechnology(techArr);
        return techArr;
    }
    //Display all available tech
    public static void printTechnology(ArrayList<Technology> techArr){
        //cycle through array only printing whicever unlocked boolean == true
        System.out.println("Total Research Points: " + Player.getPlayerResearchPts());
        System.out.println();
        int i = 0;
        ArrayList<Technology> techArray = new ArrayList();
        techArray = techArr;
        while(i < techArray.size()){
            //if(techArray.get(i).checkUnlock() == true)
            System.out.println(i + ". " + techArray.get(i).getTechName());
            if(techArray.get(i).checkUnlock() == true){
                System.out.println("Unlocked");
                System.out.println();
            }
            else
            {
                System.out.println("Required Technology: " + techArray.get(i).getRequiredTech());
                System.out.println("Research Point Cost: " + techArray.get(i).getTechCost());
                System.out.println();
            }
            i++;
        }
    }

    
    
    
    
    
    
}

