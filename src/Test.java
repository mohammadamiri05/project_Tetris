public class Test {

        public static void main(String[] args) {

            Frame frame = new Frame(19,10);
            Block block = new Block();
            frame.addBlock(block);
            frame.printFrame();
            frame.moveLeft(block);
            System.out.println("__________________________");
            frame.printFrame();
            frame.moveRight(block);
            System.out.println("__________________________");
            frame.printFrame();
            frame.moveDown(block);
            System.out.println("__________________________");
            frame.printFrame();

        }

}
