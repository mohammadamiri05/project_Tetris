public class Block {



    private int maxRow ;//height of a block
    private  int maxColumn ;//weight of a block

    private int Row;//coordinates_x start block
    private int Column;//coordinates_y start block
    private char[][] block ;


    public Block( int maxRow , int maxColumn)
    {
        this.maxColumn = maxRow ;
        this.maxRow = maxColumn ;
        this.block = new char[maxRow][maxColumn];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxColumn; j++) {
                block[i][j]=' ';
            }
        }
    }




}
