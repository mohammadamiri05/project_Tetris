public class Frame {

    private int row ;//height of a frame
    private int column ;//weight of a block
    private char[][] frame ;


    public Frame( int row , int column) {
        this.row = row;
        this.column = column;
        this.frame = new char[row][column] ;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                if ( j == 0  || j == column - 1 ){
                    this.frame[i][j] = '*';
                } else if (i == row - 1 ) {
                    this.frame[i][j] = '*';
                }
                else {
                    this.frame[i][j] = ' ';
                }
            }
        }
    }







}
