/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lotos
 */
public class Combination {
    
    final private int weight;
    final private int[] combination;
    
    private int numberOfPositionForTurn;
    final private int id;
    
    static int staticID = 0;
    
    static private int randomNumber1;
    
    public Combination(int w, int[] comb, int pos)
    {
        id = staticID;
        weight = w;
        combination = comb;
        numberOfPositionForTurn = pos;
        if(numberOfPositionForTurn == -1) // turn to right or left(top/bottom), for ex. *1111* or *111* and etc.
        {
            randomNumber1 = 0 + (int) (Math.random() * 2); // 0 - left, 1 - right
            
            if(randomNumber1 == 0)
            {
                numberOfPositionForTurn = 0;
            }
            else
            {
                numberOfPositionForTurn = comb.length-1;
            }
        }
        
        staticID++;
        
    }
    
    public int getID()
    {
        return id;
    }
    
    public int[] getCombination()
    {
        return combination;
    }
    
    public int getNumberOfPositionForTurn()
    {
        return numberOfPositionForTurn;
    }
    
    public int getWeight()
    {
        return weight;
    }
    
}
