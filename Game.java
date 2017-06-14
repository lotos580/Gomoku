import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Board mainBoard;
    private AIPlayer computerPlayer;
    
    public int return1() {return 1; }

    public Game() {
        mainBoard = new Board(this);
        computerPlayer = new AIPlayer(this);
    }
    
    public AIPlayer getAIPlayer()
    {
        return computerPlayer;
    }
    
    public Board getMainBoard()
    {
        return mainBoard;
    }
    
    public static int getNumber()
    {
        int num = 0;
        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();
        if(s.matches("[-+]?\\d+") == false) 
        {
            System.out.println("You've entered not a number ");
            s = scan.nextLine();
            while(s.matches("[-+]?\\d+") == false)
            {
                System.out.println("You've entered not a number ");
                s = scan.nextLine();
            }
            num = Integer.parseInt(s);
        }
        else
        {
            num = Integer.parseInt(s);
        }
        return num;
    }
    
   public boolean isCellOK(int num)
    {
        return num >= 0 && num < mainBoard.getSize();
    }

    public boolean isCellEmpty(int x, int y)
    {
        return mainBoard.getFields(x, y) == 0;
    }


    public void startGame()
    {
        int numberOfTurn = 1;  
        
        initCombination(); // initialization of all combinations
        mainBoard.init();
        mainBoard.printBoard();
        Scanner scan = new Scanner(System.in);
        
        while(true)
        {
            if(numberOfTurn % 2 != 0)
            {
             System.out.println("\nNOLIKI");    
             System.out.println("Enter coordinate of row: ");
             int i = getNumber();
             while(!isCellOK(i))
             {
                 System.out.println("Check your coordinte: ");
                 i = getNumber();
             }
             System.out.println("Enter coordinate of column: ");
             int j = getNumber();
             while(!isCellOK(j))
             {
                 System.out.println("Check your coordinte: ");
                 j = getNumber();
             }

             if(!isCellEmpty(i, j))
             {
                 while(!isCellEmpty(i, j))
                 {
                     System.out.println("Cells is not empty. Try again ");

                     System.out.println("Enter coordinate of row: ");
                     i = getNumber();
                     while(!isCellOK(i))
                     {
                         System.out.println("Check your coordinte: ");
                         i = getNumber();
                     }
                     System.out.println("Enter coordinate of column:: ");
                     j = getNumber();
                     while(!isCellOK(j))
                     {
                         System.out.println("Check your coordinte: ");
                         j = getNumber();
                     }
                 }
             }
             mainBoard.setFields(i, j, 1); // set motion on board
             mainBoard.printBoard();  
             numberOfTurn++;
             continue;
               
           }
            computerPlayer.searchCombination(mainBoard.getAllCombinations(), numberOfTurn);
            mainBoard.printBoard();

            numberOfTurn++;
        }
        
    }
    
    public boolean startGameComputerVsComputer()
    {
        boolean end = false;
        int numberOfTurn = 1;  
        
        initCombination(); // initialization of all combinations
        mainBoard.init();
        mainBoard.printBoard();
        Scanner scan = new Scanner(System.in);
        //computerPlayer.searchCombination(mainBoard.getAllCombinations(), numberOfTurn);
        while(true)
        {
            if(numberOfTurn % 2 != 0)
            {
             
             end = computerPlayer.searchCombination(mainBoard.getAllCombinations(), numberOfTurn);
             
             mainBoard.printBoard();  
             numberOfTurn++;
             continue;
               
           }
            end = computerPlayer.searchCombination(mainBoard.getAllCombinations(), numberOfTurn);
            mainBoard.printBoard();

            numberOfTurn++;
        }
        //return end;
    }
    
    public void initCombination()
    {
        // INITIALIZATION OF ALL COMBINATIONS //
        
        List<Combination> allCombinations = new ArrayList<Combination>();
        
        mainBoard.setComb(allCombinations);
        
        int[] comb1 = {1, 1, 1, 1, 1};
        
        int[] comb2 =  {0, 1, 1, 1, 1, 0};
        int[] comb3 = {0, 1, 1, 1, 1};
        int[] comb4 = {1, 1, 1, 1, 0};
        
        int[] comb5 = {1, 0, 1, 1, 1};
        int[] comb6 = {1, 1, 1, 0, 1};
        int[] comb7 = {1, 1, 0, 1, 1};
        int[] comb8 = {1, 1, 0, 1, 1};
        int[] comb9 = {1, 1, 1, 0, 1};
        
        int[] comb10 = {0, 1, 1, 1, 0};
        int[] comb11 = {0, 1, 1, 1};
        int[] comb12 = {1, 1, 1, 0};
        
        int[] comb13 = {0, 1, 1, 0, 1};
        int[] comb13_1 = {0, 1, 1, 0, 1, 0};
        int[] comb14 = {1, 0, 1, 1, 0};
        int[] comb14_1 = {0, 1, 0, 1, 1, 0};
        int[] comb15 = {0, 1, 0, 1, 1};
        int[] comb15_1 = {0, 1, 0, 1, 1, 0};
        int[] comb16 = {1, 1, 0, 1, 0};
        int[] comb16_1 = {0, 1, 1, 0, 1, 0};
        
        int[] comb17 = {0, 1, 1, 0};
        int[] comb18 = {0, 1, 0};
    
    
        Combination fiveInRow = new Combination(99999, comb1, 100);
        allCombinations.add(fiveInRow);
        
        Combination openQuadr = new Combination(7000, comb2, -1);
        allCombinations.add(openQuadr);
        
        Combination semiClosedQuadr1 = new Combination(4000, comb3, 0);
        allCombinations.add(semiClosedQuadr1);
        Combination semiClosedQuadr2 = new Combination(4000, comb4, 4);
        allCombinations.add(semiClosedQuadr2);
        
        Combination semiClosedQuadrWithBreach1 = new Combination(2000, comb5, 1);
        allCombinations.add(semiClosedQuadrWithBreach1);
        Combination semiClosedQuadrWithBreach2 = new Combination(2000, comb6, 3);
        allCombinations.add(semiClosedQuadrWithBreach2);
        Combination semiClosedQuadrWithBreach3 = new Combination(2000, comb7, 2);
        allCombinations.add(semiClosedQuadrWithBreach3);
        Combination semiClosedQuadrWithBreach4 = new Combination(2000, comb8, 2);
        allCombinations.add(semiClosedQuadrWithBreach4);
        Combination semiClosedQuadrWithBreach5 = new Combination(2000, comb9, 3);
        allCombinations.add(semiClosedQuadrWithBreach5);
        
        Combination openTriplet = new Combination(3000, comb10, -1);
        allCombinations.add(openTriplet);
        
        Combination semiClosedTripletWithBreach1_1 = new Combination(2000, comb13_1, 3);
        allCombinations.add(semiClosedTripletWithBreach1_1);
        Combination semiClosedTripletWithBreach2_1 = new Combination(2000, comb14_1, 2);
        allCombinations.add(semiClosedTripletWithBreach2_1);
        Combination semiClosedTripletWithBreach3_1 = new Combination(2000, comb15_1, 2);
        allCombinations.add(semiClosedTripletWithBreach3_1);
        Combination semiClosedTripletWithBreach4_1 = new Combination(2000, comb16_1, 3);
        allCombinations.add(semiClosedTripletWithBreach4_1);
        
        Combination semiClosedTriplet1 = new Combination(1500, comb11, 0);
        allCombinations.add(semiClosedTriplet1);
        Combination semiClosedTriplet2 = new Combination(1500, comb12, 3);
        allCombinations.add(semiClosedTriplet2);
        
        Combination semiClosedTripletWithBreach1 = new Combination(800, comb13, 3);
        allCombinations.add(semiClosedTripletWithBreach1);
        Combination semiClosedTripletWithBreach2 = new Combination(800, comb14, 1);
        allCombinations.add(semiClosedTripletWithBreach2);
        Combination semiClosedTripletWithBreach3 = new Combination(800, comb15, 2);
        allCombinations.add(semiClosedTripletWithBreach3);
        Combination semiClosedTripletWithBreach4 = new Combination(800, comb16, 2);
        allCombinations.add(semiClosedTripletWithBreach4);
        
        
        Combination openDeuce = new Combination(200, comb17, -1);
        allCombinations.add(openDeuce);
        Combination openOne = new Combination(50, comb18, -1);
        allCombinations.add(openOne);
        
        // END OF INITIALIZATION //

    }
}
