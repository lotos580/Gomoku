import java.util.Scanner;

public class Gomoku {
    public static void main(String[] args){
        Game mainGame = new Game(15, 15); // init game with board 10x10
        mainGame.startGame();
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

    public static boolean isNumberOK(int n)
    {
        if(n == 1 || n == 2)
            return true;
        else
            return false;
    }
}
