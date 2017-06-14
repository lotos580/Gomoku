/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lotos
 */
public class FoundElement {
    
    final private int startI;
    final private int startJ;
    final private int id;
    final private int direction; // 0 - horizontal, 1 - vertical, 2 - left diag, 3 - right diag
    
    private int value; // 0 = "X", 1 = "0"
    
    public int getStartI()
    {
        return startI;
    }
    
    public int getStartJ()
    {
        return startJ;
    }
    
    public int getID()
    {
        return id;
    }
    
    public FoundElement(int stI, int stJ, int myID, int dir)
    {
        startI = stI;
        startJ = stJ;
        id = myID;
        direction = dir;
        
//        System.out.println("I've created foundElement with coordinate: "+startI+"; startJ="
//                +startJ+"; ID= "+myID);
    }
}
