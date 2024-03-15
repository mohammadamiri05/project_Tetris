public class Test {

        public static void main(String[] args) {

            Frame frame = new Frame(19,10);

            while (true){
                Block block = new Block();
                frame.addBlock(block);
                frame.printFrame();
                while (frame.isValidMoveDown(block)){
                    frame.choseMove(Menu.input.next().charAt(0),block);
                    frame.printFrame();
                    System.out.println("_______________________________");
                }
                break;
            }

        }

}
