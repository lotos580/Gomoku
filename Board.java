import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lotos on 03.12.16.
 */
public class Board {
    static int size_x;
    static int size_y;

    int fields[][];
    ArrayList<Combination> allCombinations;
    public Board(int sX, int sY)
    {
        size_x = sX;
        size_y = sY;

        fields = new int[sX][sY];
    }
    
    public void set(int i, int j)
    {
        fields[i][j] = 1;
    }
    
    public void setComb(ArrayList<Combination> allComb)
    {
        allCombinations = allComb;
    }

    public int end_analyze()
    {
        //?????? ?? ????? ???? (?????? ??????? ??? ?????? ??????)
        for (int i=0;i<size_x;i++)
        {
            for (int j=0;j<size_y;j++)
            {
                //?????????? ?????? ??????
                if (fields[i][j]==0) continue;
                int tek = fields[i][j];//???????? ??????? ??????
                int end;//??????? ????? ????
                int u;//???. ???????
                /////////////////////////////////////////
                //??????? ?????? ?? ??????? ??????
                end = 0;
                for (int k = j;k<j+5;k++)
                {
                    if ((k == size_y) || (fields[i][k] != tek))
                    {
                        //??? ???? ?? 5
                        break;
                    }
                    end++;
                }
                if (end == 5)
                {
                    //???? ??? ?? 5 - ????? ????
                    for (int k = j;k<j+5;k++)
                    {
                        fields[i][k]=tek+2; //????????? ??? ?????? ? ???? ????????? + 2 ??? ???????? ??????? ??????
                    }
                    return 1;
                }
                /////////////////////////////////////////
                //??????? ???? ? ?????? ?? ??????? ??????
                end = 0;
                u=i;
                for (int k = j;k<j+5;k++)
                {
                    if ((k == size_y) || (u==size_x) || (fields[u][k] != tek))
                    {
                        //??? ???? ?? 5
                        break;
                    }
                    end++;
                    u++;
                }
                if (end == 5)
                {
                    //???? ??? ?? 5 - ????? ????
                    u=i;
                    for (int k = j;k<j+5;k++)
                    {
                        fields[u][k]=tek+2; //????????? ??? ?????? ? ???? ????????? + 2 ??? ???????? ??????? ??????
                        u++;
                    }
                    return 1;
                }
                /////////////////////////////////////////
                // ??????? ???? ? ????? ?? ??????? ??????
                end = 0;
                u=i;
                for (int k = j;k>j-5;k--)
                {
                    if ((k == -1) || (u==size_x) || (fields[u][k] != tek))
                    {
                        //??? ???? ?? 5
                        break;
                    }
                    end++;
                    u++;
                }
                if (end == 5)
                {
                    //???? ??? ?? 5 - ????? ????
                    u=i;
                    for (int k = j;k>j-5;k--)
                    {
                        fields[u][k]=tek+2; //????????? ??? ?????? ? ???? ????????? + 2 ??? ???????? ??????? ??????
                        u++;
                    }
                    return 1;
                }
                /////////////////////////////////////////
                // ??????? ???? ?? ??????? ??????
                end = 0;
                for (int k = i;k<i+5;k++)
                {
                    if ((k == size_x) || (fields[k][j] != tek))
                    {
                        //??? ???? ?? 5
                        break;
                    }
                    end++;
                }
                if (end == 5)
                {
                    //???? ??? ?? 5 - ????? ????
                    for (int k = i;k<i+5;k++)
                    {
                        fields[k][j]=tek+2; //????????? ??? ?????? ? ???? ????????? + 2 ??? ???????? ??????? ??????
                    }
                    return 1;
                }
            }
        }
        //???? ?? ????????
        return 0;
    }
    
    public void init()
    {
        for(int i = 0; i < size_x; i++)
        {
            for(int j = 0; j < size_y; j++)
            {
                fields[i][j] = 0;
            }
        }
        fields[6][6] = 2; // set first motion "X" at i = 6 j = 6
    }
    
    public FoundElement searchHorizontal(int myID, int symbol, int[] comb, int lengthComb, int endPoint) // symbol : 1 = O, 2 = X
    {
        //System.out.println(myID+";"+symbol+";"+lengthComb+";"+endPoint);
//        System.out.println("size_x: "+size_x);
//        System.out.println("end_point: "+endPoint);
//        System.out.println("lengthComb"+lengthComb);
        if(symbol == 2)
        {
            for(int i = 0; i < comb.length; i++)
            {
                if(comb[i] == 1)
                    comb[i] = 2;
            }
        }
        else
        {
            if(symbol == 1)
            {
                for(int i = 0; i < comb.length; i++)
                {
                    if(comb[i] == 2)
                        comb[i] = 1;
                }
            }
        }
        
        
        int k = 0; 
        for(int i = 0; i < size_x; i++)
        {
            for(int j = 0; j < endPoint; j++)
            {
                for(int s = j; s < j + lengthComb; s++)
                {
                    //System.out.println("i="+i+";s="+s+";k="+k);
                    if(fields[i][s] == comb[k])
                    {
                        k++;
                        if(k == lengthComb)
                        {
                            FoundElement foundElem = new FoundElement(i, j, myID, 0);
                            //System.out.println("-----"+i+";"+j+"; symbol = "+symbol);
                            return foundElem;
                        }
                    }
                    else
                        k = 0;
                }
                k=0;
                
            }
            k = 0;
        }
        //System.out.println("k = " + k);
        //System.out.println("return null");
        return null;
    }
    
    public FoundElement searchVertical(int myID, int symbol, int[] comb, int lengthComb, int endPoint)
    {
//        System.out.println("size_x: "+size_x);
//        System.out.println("end_point: "+endPoint);
//        System.out.println("lengthComb"+lengthComb);
        if(symbol == 2)
        {
            for(int i = 0; i < comb.length; i++)
            {
                if(comb[i] == 1)
                    comb[i] = 2;
            }
        }
        else
        {
            if(symbol == 1)
            {
                for(int i = 0; i < comb.length; i++)
                {
                    if(comb[i] == 2)
                        comb[i] = 1;
                }
            }
        }
        
        int k = 0; 
        for(int j = 0; j < size_x; j++)
        {
            for(int i = 0; i < endPoint; i++)
            {
                for(int s = i; s < i + lengthComb; s++)
                {
                    //System.out.println("i="+i+";s="+s+";k="+k);
                    if(fields[s][j] == comb[k])
                    {
                        k++;
                        if(k == lengthComb)
                        {
                            FoundElement foundElem = new FoundElement(i, j, myID,1);
                            return foundElem;
                        }
                    }
                    else
                        k = 0;
                }
                k=0;
                
            }
            k = 0;
        }
        //System.out.println("k = " + k);
        //System.out.println("null");
        return null;
    }
    
    public FoundElement searchLeftDiagonal(int myID, int symbol, int[] comb, int lengthComb, int endPoint)
    {
        if(symbol == 2)
        {
            for(int i = 0; i < comb.length; i++)
            {
                if(comb[i] == 1)
                    comb[i] = 2;
            }
        }
        else
        {
            if(symbol == 1)
            {
                for(int i = 0; i < comb.length; i++)
                {
                    if(comb[i] == 2)
                        comb[i] = 1;
                }
            }
        }
        
        int k = 0; 
        for(int i = lengthComb-1; i < size_x; i++)
        {
            for(int j = 0; j < size_x-lengthComb+1; j++)
            {
                for(int s = 0; s < lengthComb; s++)
                {
                    //System.out.println("i="+i+";j="+j+";s="+s);
                    if(fields[i-s][j+s] == comb[k])
                    {
                        k++;
                        //System.out.println("k ="+k);
                        if(k == lengthComb)
                        {
                            FoundElement foundElem = new FoundElement(i, j, myID, 2);
                            return foundElem;
                        }
                    }
                    else
                        k = 0;
                }
                k=0;
                
            }
            k = 0;
        }
        
        return null;
    }
    
    public FoundElement searchRightDiagonal(int myID, int symbol, int[] comb, int lengthComb, int endPoint)
    {
        if(symbol == 2)
        {
            for(int i = 0; i < comb.length; i++)
            {
                if(comb[i] == 1)
                    comb[i] = 2;
            }
        }
        else
        {
            if(symbol == 1)
            {
                for(int i = 0; i < comb.length; i++)
                {
                    if(comb[i] == 2)
                        comb[i] = 1;
                }
            }
        }
        
        int k = 0; 
        for(int i = lengthComb-1; i < size_x; i++)
        {
            for(int j = lengthComb-1; j < size_x; j++)
            {
                for(int s = 0; s < lengthComb; s++)
                {
                    //System.out.println("i="+i+";j="+j+";s="+s);
                    if(fields[i-s][j-s] == comb[k])
                    {
                        k++;
                        //System.out.println("k ="+k);
                        if(k == lengthComb)
                        {
                            FoundElement foundElem = new FoundElement(i, j, myID, 3);
                            return foundElem;
                        }
                    }
                    else
                        k = 0;
                }
                k=0;
                
            }
            k = 0;
        }
        
        return null;
    }
    
    public void processMotion(int dir, FoundElement elem, Combination comb, int k)
    {
        char symbol;
        
        
        if(dir == 0)
        {
        // process horizontal 
        if(comb.id == 1 || comb.id == 9 || comb.id == 16 || comb.id == 17)
        {
            
            
            int random_number1 = 0 + (int) (Math.random() * 2); // 0 - left, 1 - right
            
            if(random_number1 == 0)
            {
                //System.out.print("id0 Set left at "+elem.startI+"; "+elem.startJ);
                fields[elem.startI][elem.startJ] = k;
            }
            else
            {
                //System.out.print("id1 Set right at "+elem.startI+"; "+(int)(elem.startJ+comb.combination.length -1));
                fields[elem.startI][elem.startJ+comb.combination.length -1] = k;
            }
        }
        
        if(comb.id == 2 || comb.id == 10)
        {
            //System.out.println("id2 set at"+elem.startI+"; "+elem.startJ);
            fields[elem.startI][elem.startJ] = k;
        }
        
        if(comb.id == 4 || comb.id == 7 || comb.id == 14 || comb.id == 15)
        {
            //System.out.println("id4 set at "+elem.startI+"; "+(int)(elem.startJ+2));
            fields[elem.startI][elem.startJ + 2] = k;
        }
        if(comb.id == 5 || comb.id == 6 || comb.id == 11 || comb.id == 12)
        {
            //System.out.println("id5 set at "+elem.startI+"; "+(int)(elem.startJ+3));
            fields[elem.startI][elem.startJ+3] = k;
        }
        if(comb.id == 8 || comb.id == 3)
        {
            //System.out.println("id6 set at "+elem.startI+"; "+(int)(elem.startJ+4));
            fields[elem.startI][elem.startJ + 4] = k;
        }
        if(comb.id == 13)
        {
            //System.out.println("id7 set at "+elem.startI+"; "+(int)(elem.startJ+1));
            fields[elem.startI][elem.startJ +1] = k;
        }
        // end process horizontal
        }
        else
        {
            if(dir == 1) // vertical
            {
                
                if(comb.id == 1 || comb.id == 9 || comb.id == 16 || comb.id == 17)
                {
                    //System.out.println("we're going to process comb 1");
                    int random_number1 = 0 + (int) (Math.random() * 2); // 0 - left, 1 - right
                    if(random_number1 == 0)
                    {
                        fields[elem.startI][elem.startJ] = k;
                        //System.out.print("id8 Set top at "+elem.startI+"; "+elem.startJ);
                    }
                    else
                    {
                        //System.out.print("id9 Set bottom at "+(int)(elem.startI+comb.combination.length -1)+"; "+elem.startJ);
                        fields[elem.startI+comb.combination.length -1][elem.startJ] = k;
                    }
                }

                if(comb.id == 2 || comb.id == 10)
                {
                    fields[elem.startI][elem.startJ] = k;
                    //System.out.println("id10 set at"+elem.startI+"; "+elem.startJ);
                }

                if(comb.id == 4 || comb.id == 7 || comb.id == 14 || comb.id == 15)
                {
                    fields[elem.startI+2][elem.startJ] = k;
                    //System.out.println("id11 set at "+elem.startI+"; "+(int)(elem.startJ+2));
                }
                if(comb.id == 5 || comb.id == 6 || comb.id == 11 || comb.id == 12)
                {
                    fields[elem.startI+3][elem.startJ] = k;
                    //System.out.println("id12 set at "+elem.startI+"; "+(int)(elem.startJ+3));
                }
                if(comb.id == 8 || comb.id == 3)
                {
                    fields[elem.startI+4][elem.startJ] = k;
                    //System.out.println("id13 set at "+elem.startI+"; "+(int)(elem.startJ+4));
                }
                if(comb.id == 13)
                {
                    //System.out.println("id14 set at "+elem.startI+"; "+(int)(elem.startJ+1));
                    fields[elem.startI+1][elem.startJ] = k;
                }
                // end vertical
            }
            else
            {
                if(dir == 2) // left diagonal
                {
                    if(comb.id == 1 || comb.id == 9 || comb.id == 16 || comb.id == 17)
                {
                    //System.out.println("00000+"+elem.startI+"; "+elem.startJ+"; "+(int)(comb.combination.length -1));
                    //System.out.println("we're going to process comb 1");
                    int random_number1 = 0 + (int) (Math.random() * 2); // 0 - left, 1 - right
                    
                    if(random_number1 == 0)
                    {
                        //System.out.print("id15 Set top at "+elem.startI+"; "+elem.startJ);
                        fields[elem.startI][elem.startJ] = k;
                    }
                    else
                    {
                        //System.out.print("id16 Set bottom at "+(int)(elem.startI-comb.combination.length +1)+"; "+(int)(elem.startJ+comb.combination.length -1));
                        fields[elem.startI-comb.combination.length +1][elem.startJ+comb.combination.length -1] = k;
                    }
                }

                if(comb.id == 2 || comb.id == 10)
                {
                    fields[elem.startI][elem.startJ] = k;
                    //System.out.println("id17 set at"+elem.startI+"; "+elem.startJ);
                }

                if(comb.id == 4 || comb.id == 7 || comb.id == 14 || comb.id == 15)
                {
                    //System.out.println("id18 set at "+(int)(elem.startI-2)+"; "+(int)(elem.startJ+2));
                    fields[elem.startI-2][elem.startJ+2] = k;
                }
                
                    //System.out.println("startI"+elem.startI+"; "+elem.startJ);
                if(comb.id == 5 || comb.id == 6 || comb.id == 11 || comb.id == 12)
                {
                    fields[elem.startI-3][elem.startJ+3] = k;
                    //System.out.println("id19 set at "+(int)(elem.startI-3)+"; "+(int)(elem.startJ+3));
                }
                
                if(comb.id == 8 || comb.id == 3)
                {
                    //System.out.println("id20 set at "+(int)(elem.startI-4)+"; "+(int)(elem.startJ+4));
                    fields[elem.startI-4][elem.startJ+4] = k;
                }
                if(comb.id == 13)
                {
                    fields[elem.startI-1][elem.startJ+1] = k;
                    //System.out.println("id21 set at "+(int)(elem.startI-1)+"; "+(int)(elem.startJ+1));
                }
                // end left diag
                }
                else
                {
                    if(dir == 3) // right vertic
                    {
                        if(comb.id == 1 || comb.id == 9 || comb.id == 16 || comb.id == 17)
                        {
                            //System.out.println("00000+"+elem.startI+"; "+elem.startJ+"; "+(int)(comb.combination.length -1));
                            //System.out.println("we're going to process comb 1");
                            int random_number1 = 0 + (int) (Math.random() * 2); // 0 - left, 1 - right

                            if(random_number1 == 0)
                            {
                                fields[elem.startI][elem.startJ] = k;
                                //System.out.print("id22 Set top at "+elem.startI+"; "+elem.startJ);
                            }
                            else
                            {
                                fields[elem.startI-comb.combination.length +1][elem.startJ-comb.combination.length +1] = k;

                                //System.out.print("id23 Set bottom at "+(int)(elem.startI-comb.combination.length +1)+"; "+(int)(elem.startJ-comb.combination.length +1));
                            }
                        }

                        if(comb.id == 2 || comb.id == 10)
                        {
                            fields[elem.startI][elem.startJ] = k;
                            //System.out.println("id24 set at"+elem.startI+"; "+elem.startJ);
                        }

                        if(comb.id == 4 || comb.id == 7 || comb.id == 14 || comb.id == 15)
                        {
                            fields[elem.startI-2][elem.startJ-2] = k;
                            //System.out.println("id25 set at "+(int)(elem.startI-2)+"; "+(int)(elem.startJ-2));
                        }

                            //System.out.println("startI"+elem.startI+"; "+elem.startJ);
                        if(comb.id == 5 || comb.id == 6 || comb.id == 11 || comb.id == 12)
                        {
                            fields[elem.startI-3][elem.startJ-3] = k;
                            //System.out.println("id26 set at "+(int)(elem.startI-3)+"; "+(int)(elem.startJ-3));
                        }

                        if(comb.id == 8 || comb.id == 3)
                        {
                            fields[elem.startI-4][elem.startJ-4] = k;
                            //System.out.println("id27 set at "+(int)(elem.startI-4)+"; "+(int)(elem.startJ-4));
                        }
                        if(comb.id == 13)
                        {
                            fields[elem.startI-1][elem.startJ-1] = k;
                            //System.out.println("id28 set at "+(int)(elem.startI-1)+"; "+(int)(elem.startJ-1));
                        }
                        // end right diag
                    }
                }
            }
        }
        
        
    }
    
    public boolean searchCombination(ArrayList<Combination> allCombinations, int numberOfMotion)
    {
        int k = 0;
        if(numberOfMotion % 2 == 0) 
              k = 2;
        else
              k = 1;
        //System.out.println("K ="+k);
        
        //System.out.println(allCombinations.size());
        FoundElement elem;
        for(int i = 0; i < allCombinations.size(); i++)
        {
            //System.out.println("I = "+i);
            int[] combination = allCombinations.get(i).combination;
            
            int lengthComb = combination.length;
            int endPoint = size_x-lengthComb+1;
            
            /* looking for the most valuable combination (firstly looking for attack (motion "X"),
            if not - looking for defense (motion "0")) */
            
            if(searchRightDiagonal(i, 2, combination, lengthComb, endPoint) != null )
            {
                //System.out.println("case4");
                elem = searchRightDiagonal(i, 2, combination, lengthComb, endPoint);
                Combination comb = allCombinations.get(elem.id);
                processMotion(3, elem, comb, k);
                return true;
            }
            else
            {
                if(searchLeftDiagonal(i, 2, combination, lengthComb, endPoint) != null )
                {
                    //System.out.println("case3");
                    elem = searchLeftDiagonal(i, 2, combination, lengthComb, endPoint);
                    Combination comb = allCombinations.get(elem.id);
                    processMotion(2, elem, comb, k);
                    return true;
                }
                else
                {
                    if(searchVertical(i, 2, combination, lengthComb, endPoint) != null )
                    {
                        //System.out.println("case2++");
                        elem = searchVertical(i, 2, combination, lengthComb, endPoint);
                        
                        Combination comb = allCombinations.get(elem.id);
                        
                        processMotion(1, elem, comb, k);
                        
                        return true;
                    }
                    else
                    {
                        if(searchHorizontal(i, 2, combination, lengthComb, endPoint) != null )
                        {
                            //System.out.println("case1");
                            elem = searchHorizontal(i, 2, combination, lengthComb, endPoint);
                            Combination comb = allCombinations.get(elem.id);
                            processMotion(0, elem, comb, k);
                            return true;
                        }
                        else
                        {
                            ////
                            
                            if(searchRightDiagonal(i, 1, combination, lengthComb, endPoint) != null )
                            {
                                //System.out.println("case5");
                                elem = searchRightDiagonal(i, 1, combination, lengthComb, endPoint);
                                Combination comb = allCombinations.get(elem.id);
                                processMotion(3, elem, comb, k);
                                return true;
                            }
                            else
                            {
                                if(searchLeftDiagonal(i, 1, combination, lengthComb, endPoint) != null )
                                {
                                    //System.out.println("case6");
                                    elem = searchLeftDiagonal(i, 1, combination, lengthComb, endPoint);
                                    Combination comb = allCombinations.get(elem.id);
                                    processMotion(2, elem, comb, k);
                                    return true;
                                }
                                else
                                {
                                    if(searchVertical(i, 1, combination, lengthComb, endPoint) != null )
                                    {
                                        //System.out.println("case7");
                                        elem = searchVertical(i, 1, combination, lengthComb, endPoint);
                                        Combination comb = allCombinations.get(elem.id);
                                        processMotion(1, elem, comb, k);
                                        return true;
                                    }
                                    else
                                    {
                                        if(searchHorizontal(i, 1, combination, lengthComb, endPoint) != null )
                                        {
                                            //System.out.println("case8");
                                            elem = searchHorizontal(i, 1, combination, lengthComb, endPoint);
                                            Combination comb = allCombinations.get(elem.id);
                                            processMotion(0, elem, comb, k);
                                            return true;
                                        }
                                    }
                                }
                            }
                            
                            ////
                        }
                    }
                }
            }
            
        }
        
        return false;
    }
    
    public Combination searchByID(ArrayList<Combination> allCombinations, int myID)
    {
        for(int i = 0; i < allCombinations.size(); i++)
        {
            if(allCombinations.get(i).id == myID)
                return allCombinations.get(i);
        }
        return null;
    }

    public int getNumber()
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

    public void motion(int mySign)
    {
        int sign = mySign;

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
        fields[i][j] = sign;
    }

    public boolean isCellsOK(int num)
    {
        if(num > size_x - 1)
            return false;
        if(num < 0)
            return false;
        return true;
    }

    public boolean isCellsEmpty(int x, int y)
    {
        if(fields[x][y] == 0)
            return true;
        else
            return false;
    }

    public void printBoard()
    {
        System.out.println("\n   0  1  2  3  4  5  6  7  8  9 10 11 12 13 14");
        for(int i = 0; i < size_x; i++)
        {
            System.out.print(i+" ");
            if(i < 10)
                System.out.print(" ");
            for(int j = 0; j < size_y; j++)
            {
                if(fields[i][j] == 1)
                    System.out.print("0  ");
                else {
                    if(fields[i][j] == 2)
                        System.out.print("X  ");
                    else
                        if(fields[i][j] == 0)
                            System.out.print("-  ");
                }
            }
            System.out.println("\n");
        }
    }
}
