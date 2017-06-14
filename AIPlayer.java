
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lotos
 */
public class AIPlayer {
    
    private final Game mainGame;
    private final int size;
    private final int fields[][];
    static boolean end = false;
    
    public AIPlayer(Game myGame)
    {
        mainGame = myGame;
        
        size = mainGame.getMainBoard().getSize();
        fields = mainGame.getMainBoard().getFields();
    }
    
    public int[] processComb(int initComb[], int symbol)
    {
        int[] comb = new int[initComb.length];
        for(int i = 0; i < initComb.length; i++)
        {
            comb[i] = initComb[i];
            if(symbol == 1 && comb[i] == 2)
            {
                comb[i] = 1;
            }
            else
            {
                if(symbol == 2 && comb[i] == 1)
                {
                    comb[i] = 2;
                }
            }
        }
        return comb;
    }
    
    public FoundElement searchHorizontal(int myID, int symbol, int[] initComb, int lengthComb, int endPoint) // symbol : 1 = O, 2 = X
    {
        //System.out.println(myID+";"+symbol+";"+lengthComb+";"+endPoint);
//        System.out.println("size_x: "+size_x);
//        System.out.println("end_point: "+endPoint);
//        System.out.println("lengthComb"+lengthComb);
        int[] comb = processComb(initComb, symbol);
        
        int k = 0; 
        for(int i = 0; i < size; i++)
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
    
    public FoundElement searchVertical(int myID, int symbol, int[] initComb, int lengthComb, int endPoint)
    {
//        System.out.println("size_x: "+size_x);
//        System.out.println("end_point: "+endPoint);
//        System.out.println("lengthComb"+lengthComb);
        int[] comb = processComb(initComb, symbol);
        
        int k = 0; 
        for(int j = 0; j < size; j++)
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
    
    public FoundElement searchLeftDiagonal(int myID, int symbol, int[] initComb, int lengthComb, int endPoint)
    {
        int[] comb = processComb(initComb, symbol);
        
        int k = 0; 
        for(int i = lengthComb-1; i < size; i++)
        {
            for(int j = 0; j < size-lengthComb+1; j++)
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
    
    public FoundElement searchRightDiagonal(int myID, int symbol, int[] initComb, int lengthComb, int endPoint)
    {
        int[] comb = processComb(initComb, symbol);
        
        int k = 0; 
        for(int i = lengthComb-1; i < size; i++)
        {
            for(int j = lengthComb-1; j < size; j++)
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
    
    public boolean processTurn(int dir, FoundElement elem, Combination comb, int k)
    {
//        System.out.println("we're going to process combination: ");
//        for(int i =0; i < comb.getCombination().length; i++)
//        {
//            System.out.print(comb.getCombination()[i]);
//        }
//        System.out.print("Symbol: ");
//        
//        System.out.println("set at: "+comb.getNumberOfPositionForTurn()+" position");
//        System.out.println("direction "+dir);
//        System.out.println("start coordinate: "+elem.getStartI()+" "+elem.getStartJ());

        if(comb.getWeight() == 99999)
        {
            if(k == 2)
                System.out.println("0 have won.");
            else
                System.out.println("X have won.");
            System.exit(0);
        }
        
        int symbol; // 1 - X, 2 = 0
        if(k == 1)
        {
            symbol = 1;
        }
        else
        {
            symbol = 2;
        }
        
        /////////////////
        
        switch (dir) {
                case 0:  //System.out.println("set at "+(elem.getStartI())
                         //+" "+(elem.getStartJ()+comb.getNumberOfPositionForTurn()));
                         mainGame.getMainBoard().setValue((elem.getStartI()), 
                                 (elem.getStartJ()+comb.getNumberOfPositionForTurn()), symbol);
                         break;
                case 1:  //System.out.println("set at "+(elem.getStartI()+comb.getNumberOfPositionForTurn())
                         //+" "+(elem.getStartJ()));
                         mainGame.getMainBoard().setValue((elem.getStartI()+comb.getNumberOfPositionForTurn()), 
                                 (elem.getStartJ()), symbol);
                         break;
                case 2:  //System.out.println("set at "+(elem.getStartI()-comb.getNumberOfPositionForTurn())
                         //+" "+(elem.getStartJ()+comb.getNumberOfPositionForTurn()));
                         mainGame.getMainBoard().setValue((elem.getStartI()-comb.getNumberOfPositionForTurn()), 
                                 (elem.getStartJ()+comb.getNumberOfPositionForTurn()), symbol);
                         break;
                case 3: //System.out.println("set at "+(elem.getStartI()-comb.getNumberOfPositionForTurn())
                        //+" "+(elem.getStartJ()-comb.getNumberOfPositionForTurn()));
                        mainGame.getMainBoard().setValue((elem.getStartI()-comb.getNumberOfPositionForTurn()), 
                                (elem.getStartJ()-comb.getNumberOfPositionForTurn()), symbol);
                        break;
        }
        return false;
    }
    
    public boolean searchCombination(List<Combination> allCombinations, int numberOfMotion)
    {
        boolean end = false;
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
            int[] combination = allCombinations.get(i).getCombination();
            
            int lengthComb = combination.length;
            int endPoint = size-lengthComb+1;
            
            /* looking for the most valuable combination (firstly looking for attack (motion "X"),
            if not - looking for defense (motion "0")) */
            elem = searchRightDiagonal(i, 2, combination, lengthComb, endPoint);
            
            if(elem != null )
            {
                //System.out.println("case4");
                
                Combination comb = allCombinations.get(elem.getID());
                end = processTurn(3, elem, comb, k);
                return end;
            }
            else
            {
                elem = searchLeftDiagonal(i, 2, combination, lengthComb, endPoint);
                
                if(elem != null )
                {
                    //System.out.println("case3");
                    Combination comb = allCombinations.get(elem.getID());
                    end = processTurn(2, elem, comb, k);
                    return end;
                }
                else
                {
                    elem = searchVertical(i, 2, combination, lengthComb, endPoint);
                    
                    if(elem != null )
                    {
                        //System.out.println("case2++");
                        
                        Combination comb = allCombinations.get(elem.getID());
                        
                        end = processTurn(1, elem, comb, k);
                        
                        return end;
                    }
                    else
                    {
                        elem = searchHorizontal(i, 2, combination, lengthComb, endPoint);
                        
                        if(elem != null )
                        {
                            //System.out.println("case1");
                            Combination comb = allCombinations.get(elem.getID());
                            end = processTurn(0, elem, comb, k);
                            return end;
                        }
                        else
                        {
                            ////
                            elem = searchRightDiagonal(i, 1, combination, lengthComb, endPoint);

                            if(elem != null )
                            {
                                //System.out.println("case5");
                                Combination comb = allCombinations.get(elem.getID());
                                end = processTurn(3, elem, comb, k);
                                return end;
                            }
                            else
                            {
                                elem = searchLeftDiagonal(i, 1, combination, lengthComb, endPoint);
                                
                                if(elem != null )
                                {
                                    //System.out.println("case6");
                                    Combination comb = allCombinations.get(elem.getID());
                                    end = processTurn(2, elem, comb, k);
                                    return end;
                                }
                                else
                                {
                                    elem = searchVertical(i, 1, combination, lengthComb, endPoint);
                                    
                                    if(elem != null )
                                    {
                                        //System.out.println("case7");
                                        Combination comb = allCombinations.get(elem.getID());
                                        end = processTurn(1, elem, comb, k);
                                        return end;
                                    }
                                    else
                                    {
                                        elem = searchHorizontal(i, 1, combination, lengthComb, endPoint);
                                        
                                        if(elem != null )
                                        {
                                            //System.out.println("case8");
                                            Combination comb = allCombinations.get(elem.getID());
                                            end = processTurn(0, elem, comb, k);
                                            return end;
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
        if(!mainGame.getMainBoard().isHasEmptyCell())
        {
            System.out.println("Draw!");
            System.exit(0);
        }
        int posI = 0;
        int posJ = 0;
        while(!mainGame.isCellEmpty(posI, posJ))
        {
            posI = (int) (Math.random() * size); // 0 - left, 1 - right
            posJ = (int) (Math.random() * size); // 0 - left, 1 - right
        }
        mainGame.getMainBoard().setFields(posI, posJ, k);
        return false;
    }
}
