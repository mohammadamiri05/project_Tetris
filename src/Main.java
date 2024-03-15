public class Main {
    public static void main(String[] args) {

        Frame frame = new Frame(18,10);

        while (true){
            Block block = new Block();
            frame.addBlock(block);
            for (int i = 0; i < 3; i++) {

                if (frame.isValidMoveDown(block)){
                    block.setRow(block.getRow() - 1);
                    frame.moveDown(block);
                }
                else
                {
                    frame.checkFirstColumn(frame);
                }
            }
            frame.printFrame();
            System.out.println("_______________________________");
            while (frame.isValidMoveDown(block)){
                block.setRow(block.getRow() - 1);
                frame.giveScore(frame);
                frame.menu.choseMove(frame,block);
                frame.printFrame();
                System.out.println( "Your score is: " + frame.getScore());
                System.out.println("_______________________________");
            }
        }

    }
}