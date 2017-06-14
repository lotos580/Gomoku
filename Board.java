import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lotos on 03.12.16.
 */
public class Board {
    final static private int size = 15;
    private int fields[][];
    private List<Combination> allCombinations;
    final private Game mainGame;
    
    private static int lastI = -1;
    private static int lastJ = -1;
    
    public Board(Game myGame)
    {
        mainGame = myGame;
        fields = new int[size][size];
    }
    
    public int getLastI()
    {
        return lastI;
    }
    
    public int getLastJ()
    {
        return lastJ;
    }
    
    public boolean isHasEmptyCell()
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                if(fields[i][j] == 0)
                    return true;
            }
        }
        return false;
    }
    
    public List<Combination> getAllCombinations()
    {
        return allCombinations;
    }
    
    public void setValue(int posI, int posJ, int symbol)
    {
        //System.out.println("posI, posJ = "+posI+"; "+posJ);
        fields[posI][posJ] = symbol;
        lastI = posI;
        lastJ = posJ;
    }
    
    public int getSize()
    {
        return size;
    }
    
    public int getFields(int posI, int posJ)
    {
        return fields[posI][posJ];
    }
    
    public void setFields(int posI, int posJ, int value)
    {
        fields[posI][posJ] = value;
    }
    
    public void set(int i, int j)
    {
        fields[i][j] = 1;
    }
    
    public void setComb(List<Combination> allComb)
    {
        allCombinations = allComb;
    }
    
    public void init()
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                fields[i][j] = 0;
            }
        }
        int attackI = (int)(size / 2);
        int attackJ = (int)(size / 2);
        
        fields[attackI][attackJ] = 2; // set first motion "X"  

    }
    
    public void initForTest1()
    {
        // 1 - 0; 2 - X
        int[] a1 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a2 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a3 =  {0, 1, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a4 =  {0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a5 =  {0, 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a6 =  {0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a7 =  {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a8 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a9 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a10 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a11 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a12 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a13 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a14 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a15 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        fields[0] = a1;
        fields[1] = a2;
        fields[2] = a3;
        fields[3] = a4;
        fields[4] = a5;
        
        fields[5] = a6;
        fields[6] = a7;
        fields[7] = a8;
        fields[8] = a9;
        fields[9] = a10;
        fields[10] = a11;
        fields[11] = a12;
        fields[12] = a13;
        fields[13] = a14;
        fields[14] = a15;
    }
    
    public void initForTest2()
    {
        // 1 - 0; 2 - X
        int[] a1 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a2 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a3 =  {0, 1, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a4 =  {0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a5 =  {0, 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a6 =  {0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a7 =  {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a8 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a9 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a10 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a11 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a12 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a13 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a14 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a15 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        fields[0] = a1;
        fields[1] = a2;
        fields[2] = a3;
        fields[3] = a4;
        fields[4] = a5;
        
        fields[5] = a6;
        fields[6] = a7;
        fields[7] = a8;
        fields[8] = a9;
        fields[9] = a10;
        fields[10] = a11;
        fields[11] = a12;
        fields[12] = a13;
        fields[13] = a14;
        fields[14] = a15;
    }
    
    public void initForTest3()
    {
        // 1 - 0; 2 - X
        int[] a1 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a2 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a3 =  {0, 0, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a4 =  {0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a5 =  {0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a6 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a7 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a8 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a9 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a10 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a11 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a12 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a13 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a14 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a15 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        fields[0] = a1;
        fields[1] = a2;
        fields[2] = a3;
        fields[3] = a4;
        fields[4] = a5;
        
        fields[5] = a6;
        fields[6] = a7;
        fields[7] = a8;
        fields[8] = a9;
        fields[9] = a10;
        fields[10] = a11;
        fields[11] = a12;
        fields[12] = a13;
        fields[13] = a14;
        fields[14] = a15;
    }
    
    public void initForTest4()
    {
        // 1 - 0; 2 - X
        int[] a1 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a2 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a3 =  {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a4 =  {0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a5 =  {0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a6 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a7 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a8 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a9 =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a10 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a11 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a12 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a13 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a14 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a15 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        fields[0] = a1;
        fields[1] = a2;
        fields[2] = a3;
        fields[3] = a4;
        fields[4] = a5;
        
        fields[5] = a6;
        fields[6] = a7;
        fields[7] = a8;
        fields[8] = a9;
        fields[9] = a10;
        fields[10] = a11;
        fields[11] = a12;
        fields[12] = a13;
        fields[13] = a14;
        fields[14] = a15;
    }
    
    public int[][] getFields()
    {
        return fields;
    }
    
    public int endAnalyze()
    {
        for (int i=0;i<size;i++)
        {
            for (int j=0;j<size;j++)
            {
                if (fields[i][j]==0) continue;
                int tek = fields[i][j];
                int end;
                int u;
                end = 0;
                for (int k = j;k<j+5;k++)
                {
                    if ((k == size) || (fields[i][k] != tek))
                    {
                        break;
                    }
                    end++;
                }
                if (end == 5)
                {
                    for (int k = j;k<j+5;k++)
                    {
                        fields[i][k]=tek+2; 
                    }
                    return 1;
                }
                end = 0;
                u=i;
                for (int k = j;k<j+5;k++)
                {
                    if ((k == size) || (u==size) || (fields[u][k] != tek))
                    {
                        break;
                    }
                    end++;
                    u++;
                }
                if (end == 5)
                {
                    u=i;
                    for (int k = j;k<j+5;k++)
                    {
                        fields[u][k]=tek+2; 
                        u++;
                    }
                    return 1;
                }
                end = 0;
                u=i;
                for (int k = j;k>j-5;k--)
                {
                    if ((k == -1) || (u==size) || (fields[u][k] != tek))
                    {
                        break;
                    }
                    end++;
                    u++;
                }
                if (end == 5)
                {
                    u=i;
                    for (int k = j;k>j-5;k--)
                    {
                        fields[u][k]=tek+2;
                        u++;
                    }
                    return 1;
                }
                end = 0;
                for (int k = i;k<i+5;k++)
                {
                    if ((k == size) || (fields[k][j] != tek))
                    {
                        break;
                    }
                    end++;
                }
                if (end == 5)
                {
                    for (int k = i;k<i+5;k++)
                    {
                        fields[k][j]=tek+2; 
                    }
                    return 1;
                }
            }
        }
        return 0;
    }

    public void motion(int mySign)
    {
        int sign = mySign;

        System.out.println("Enter coordinate of row: ");
        int i = mainGame.getNumber();
        while(!mainGame.isCellOK(i))
        {
            System.out.println("Check your coordinte: ");
            i = mainGame.getNumber();
        }
        System.out.println("Enter coordinate of column: ");
        int j = mainGame.getNumber();
        while(!mainGame.isCellOK(j))
        {
            System.out.println("Check your coordinte: ");
            j = mainGame.getNumber();
        }

        if(!mainGame.isCellEmpty(i, j))
        {
            while(!mainGame.isCellEmpty(i, j))
            {
                System.out.println("Cells is not empty. Try again ");

                System.out.println("Enter coordinate of row: ");
                i = mainGame.getNumber();
                while(!mainGame.isCellOK(i))
                {
                    System.out.println("Check your coordinte: ");
                    i = mainGame.getNumber();
                }
                System.out.println("Enter coordinate of column:: ");
                j = mainGame.getNumber();
                while(!mainGame.isCellOK(j))
                {
                    System.out.println("Check your coordinte: ");
                    j = mainGame.getNumber();
                }
            }
        }
        fields[i][j] = sign;
    }

    public void printBoard()
    {
        System.out.println("\n   0  1  2  3  4  5  6  7  8  9 10 11 12 13 14");
        for(int i = 0; i < size; i++)
        {
            System.out.print(i+" ");
            if(i < 10)
                System.out.print(" ");
            for(int j = 0; j < size; j++)
            {
                switch (fields[i][j]) {
                case 0:  System.out.print("-  ");
                         break;
                case 1:  System.out.print("0  ");
                         break;
                case 2:  System.out.print("X  ");
                         break;
                }
            }
            System.out.println("\n");
        }
    }
}
