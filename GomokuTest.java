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
        
        
        // 1st test
        mainGame.getMainBoard().initForTest1(); // (fields)
        mainGame.getAIPlayer().searchCombination(mainGame.getMainBoard().getAllCombinations(), 2);
        assertEquals(1, mainGame.getMainBoard().getLastI()); // Determining the turn "X" [pos I]
        assertEquals(5, mainGame.getMainBoard().getLastJ()); // Determining the turn "X" [pos J]
        // End 1st test
        
        // 2nd test
        mainGame.getMainBoard().initForTest2(); // (fields)
        mainGame.getAIPlayer().searchCombination(mainGame.getMainBoard().getAllCombinations(), 2);
        assertEquals(2, mainGame.getMainBoard().getLastI()); // Determining the turn "X" [pos I]
        assertEquals(0, mainGame.getMainBoard().getLastJ()); // Determining the turn "X" [pos J]
        // End 2nd test
        
        // 3rd test
        mainGame.getMainBoard().initForTest3(); // (fields)
        mainGame.getAIPlayer().searchCombination(mainGame.getMainBoard().getAllCombinations(), 2);
        if(mainGame.getMainBoard().getLastI() == 1) // if turn is up
        {
            assertEquals(1, mainGame.getMainBoard().getLastI()); // Determining the turn "X" [pos I]
            assertEquals(5, mainGame.getMainBoard().getLastJ()); // Determining the turn "X" [pos J]
        }
        else // if turn is down
        {
            assertEquals(5, mainGame.getMainBoard().getLastI()); // Determining the turn "X" [pos I]
            assertEquals(5, mainGame.getMainBoard().getLastJ()); // Determining the turn "X" [pos J]
        }
        // End 3rd test
        
        // 4th test
        mainGame.getMainBoard().initForTest4(); // (fields)
        mainGame.getAIPlayer().searchCombination(mainGame.getMainBoard().getAllCombinations(), 2);
        if(mainGame.getMainBoard().getLastJ() == 1) // if turn is left
        {
            assertEquals(2, mainGame.getMainBoard().getLastI()); // Determining the turn "X" [pos I]
            assertEquals(1, mainGame.getMainBoard().getLastJ()); // Determining the turn "X" [pos J]
        }
        else // if turn is right
        {
            assertEquals(2, mainGame.getMainBoard().getLastI()); // Determining the turn "X" [pos I]
            assertEquals(5, mainGame.getMainBoard().getLastJ()); // Determining the turn "X" [pos J]
        }
        // end 4th test
        
        
        //assertEquals(1, mainGame.getMainBoard().endAnalyze()); // Determining the winner (if comment determing the turn) 
        
    }
    
}
