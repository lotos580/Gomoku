/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lotos
 */
public class GomokuTest {
    
    public GomokuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Gomoku.
     */
    @Test
    public void testMain() {
        
        Game mainGame = new Game(); // init game with board 15x15
        mainGame.initCombination();
        mainGame.getMainBoard().initForTest(); // (fields)
        
        
        // Determinig the turn
        mainGame.getAIPlayer().searchCombination(mainGame.getMainBoard().getAllCombinations(), 2);
        assertEquals(8, mainGame.getMainBoard().getLastI()); // Determining the turn "X" [pos I]
        assertEquals(10, mainGame.getMainBoard().getLastJ()); // Determining the turn "X" [pos J]
        // End determining the turn
        
        
        //assertEquals(1, mainGame.getMainBoard().endAnalyze()); // Determining the winner (if comment determing the turn) 
        
    }
    
}
