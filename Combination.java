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
    
    int weight;
    int[] combination;
    int id;
    
    static int staticID = 0;
    
    public Combination(int w, int[] comb)
    {
        id = staticID;
        weight = w;
        combination = comb;
        
        staticID++;
    }
    
}
