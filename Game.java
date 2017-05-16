import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Board mainBoard;

    public Game(int sX, int sY) {
        mainBoard = new Board(sX, sY);
    }
    
    public static int getNumber()
    {
        int num = 0;
        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();
        if(s.matches("[-+]?\\d+") == false) // ???? ?? ???????? ??????:
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
    
    public boolean isCellsOK(int num)
    {
        if(num > mainBoard.size_x - 1)
            return false;
        if(num < 0)
            return false;
        return true;
    }

    public boolean isCellsEmpty(int x, int y)
    {
        if(mainBoard.fields[x][y] == 0)
            return true;
        else
            return false;
    }


    public void startGame()
    {
        int numberOfMotion = 1;  
        
        initCombination(); // initialization of all combinations
        mainBoard.init();
        mainBoard.printBoard();
        Scanner scan = new Scanner(System.in);
        
        while(true)
        {
            if(numberOfMotion % 2 == 0)
                System.out.println("\nKRESTIKI");
            else
            {
             System.out.println("\nNOLIKI");    
             System.out.println("Enter coordinate of row: ");
             int i = getNumber();
             while(isCellsOK(i) == false)
             {
                 System.out.println("Check your coordinte: ");
                 i = getNumber();
             }
             System.out.println("Enter coordinate of column: ");
             int j = getNumber();
             while(isCellsOK(j) == false)
             {
                 System.out.println("Check your coordinte: ");
                 j = getNumber();
             }

             if(isCellsEmpty(i, j) == false)
             {
                 while(isCellsEmpty(i, j) == false)
                 {
                     System.out.println("Cells is not empty. Try again ");

                     System.out.println("Enter coordinate of row: ");
                     i = getNumber();
                     while(isCellsOK(i) == false)
                     {
                         System.out.println("Check your coordinte: ");
                         i = getNumber();
                     }
                     System.out.println("Enter coordinate of column:: ");
                     j = getNumber();
                     while(isCellsOK(j) == false)
                     {
                         System.out.println("Check your coordinte: ");
                         j = getNumber();
                     }
                 }
             }
             mainBoard.fields[i][j] = 1; // set motion on board
             mainBoard.printBoard();  
             numberOfMotion++;
             continue;
               
           }
            mainBoard.searchCombination(mainBoard.allCombinations, numberOfMotion);
            mainBoard.printBoard();

            if(mainBoard.end_analyze() == 1) // end game check
            {
                if(numberOfMotion % 2 == 0)
                    System.out.println("X have won!");
                else
                    System.out.println("0 have won!");
                return;
            }
            numberOfMotion++;
        }
        
    }
    
    public void initCombination()
    {
        // INITIALIZATION OF ALL COMBINATIONS //
        
        ArrayList<Combination> allCombinations = new ArrayList<Combination>();
        mainBoard.setComb(allCombinations);
        
        int[] comb1 = {1, 1, 1, 1, 1};
        
        int[] comb2 =  {0, 1, 1, 1, 1, 0};
        int[] comb3 = {0, 1, 1, 1, 1};
        int[] comb4 = {1, 1, 1, 1, 0};
        
        int[] comb5 = {0, 1, 0, 1, 1, 1};
        int[] comb6 = {1, 1, 1, 0, 1, 0};
        int[] comb7 = {0, 1, 1, 0, 1, 1};
        int[] comb8 = {1, 1, 0, 1, 1, 0};
        int[] comb9 = {0, 1, 1, 1, 0, 1};
        
        int[] comb10 = {0, 1, 1, 1, 0};
        int[] comb11 = {0, 1, 1, 1};
        int[] comb12 = {1, 1, 1, 0};
        
        int[] comb13 = {0, 1, 1, 0, 1};
        int[] comb14 = {1, 0, 1, 1, 0};
        int[] comb15 = {0, 1, 0, 1, 1};
        int[] comb16 = {1, 1, 0, 1, 0};
        
        int[] comb17 = {0, 1, 1, 0};
        int[] comb18 = {0, 1, 0};
    
    
        Combination fiveInRow = new Combination(99999, comb1);
        allCombinations.add(fiveInRow);
        
        Combination openQuadr = new Combination(7000, comb2);
        allCombinations.add(openQuadr);
        
        Combination semiClosedQuadr1 = new Combination(4000, comb3);
        allCombinations.add(semiClosedQuadr1);
        Combination semiClosedQuadr2 = new Combination(4000, comb4);
        allCombinations.add(semiClosedQuadr2);
        
        Combination semiClosedQuadrWithBreach1 = new Combination(2000, comb5);
        allCombinations.add(semiClosedQuadrWithBreach1);
        Combination semiClosedQuadrWithBreach2 = new Combination(2000, comb6);
        allCombinations.add(semiClosedQuadrWithBreach2);
        Combination semiClosedQuadrWithBreach3 = new Combination(2000, comb7);
        allCombinations.add(semiClosedQuadrWithBreach3);
        Combination semiClosedQuadrWithBreach4 = new Combination(2000, comb8);
        allCombinations.add(semiClosedQuadrWithBreach4);
        Combination semiClosedQuadrWithBreach5 = new Combination(2000, comb9);
        allCombinations.add(semiClosedQuadrWithBreach5);
        
        Combination openTriplet = new Combination(3000, comb10);
        allCombinations.add(openTriplet);
        
        Combination semiClosedTriplet1 = new Combination(1500, comb11);
        allCombinations.add(semiClosedTriplet1);
        Combination semiClosedTriplet2 = new Combination(1500, comb12);
        allCombinations.add(semiClosedTriplet2);
        
        Combination semiClosedTripletWithBreach1 = new Combination(800, comb13);
        allCombinations.add(semiClosedTripletWithBreach1);
        Combination semiClosedTripletWithBreach2 = new Combination(800, comb14);
        allCombinations.add(semiClosedTripletWithBreach2);
        Combination semiClosedTripletWithBreach3 = new Combination(800, comb15);
        allCombinations.add(semiClosedTripletWithBreach3);
        Combination semiClosedTripletWithBreach4 = new Combination(800, comb16);
        allCombinations.add(semiClosedTripletWithBreach4);
        
        Combination openDeuce = new Combination(200, comb17);
        allCombinations.add(openDeuce);
        Combination openOne = new Combination(50, comb18);
        allCombinations.add(openOne);
        
        // END OF INITIALIZATION //

    }
}
