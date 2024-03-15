import java.util.Scanner;

public class Menu {

    public static Scanner input = new Scanner(System.in);


    public void choseMove(Frame frame, Block block ) {

        System.out.print("Chose your move: ");
        switch (input.next().charAt(0))
        {
            case 'D':
                frame.moveDown(block);
                break;
            case 'L':
                frame.moveLeft(block);
                break;
            case 'R':
                frame.moveRight(block);
                break;
            case 'O':
                frame.Rotate(block);
                break;
            case 'M':
                for (int i = 0; i < 4; i++) {
                    frame.moveDown(block);
                }
                break;
            default:
//                System.err.println("Invalid argument!");
                frame.moveDown(block);
                break;
        }
    }
}
