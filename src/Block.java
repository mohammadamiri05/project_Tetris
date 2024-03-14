public class Block {



    private int maxRow ;//height of a block
    private  int maxColumn ;//weight of a block

    private int row;//coordinates_x start block
    private int column;//coordinates_y start block
    private char[][] block ;


    public Block() {
        this.maxColumn = 4 ;
        this.maxRow = 4 ;
        this.row = 0;
        this.column = Random.random(3,5);
        this.block = new char[maxRow][maxColumn];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxColumn; j++) {
                block[i][j]=' ';
            }
        }
        makeRandomBlock();
    }

    public void makeRandomBlock() {
        int nStars = Random.random(2,7) ;
        int nRow1 = Random.random(1,nStars) ;

        for (int i = 0 ; i < nRow1 ; i++) {
            this.block[0][i]='*';
        }
        nStars = nStars - nRow1;// ستاره های باقی مانده
        if( nStars > 0 )
        {
            int nRow2 = Random.random(1 , nStars) ,  startRow2 = Random.random(0,nRow1) ;
            for (int i = startRow2; i < startRow2 + nRow2 ; i++) {
                this.block[1][i] = '*';
            }
            nStars = nStars - nRow2;
            if ( nStars > 0 )
            {
                int startRow3 = Random.random(startRow2,startRow2 + nRow2) , nRow3 = Random.random(1 , nStars );
                for (int i = startRow3 ; i < startRow3 + nRow3 ; i++) {
                    this.block[2][i] = '*';
                }
                nStars = nStars - nRow3;
                if(nStars > 0)
                {
                    int startRow4 = Random.random(startRow3,startRow3+nRow3) , nRow4 = Random.random(1,nStars );
                    for (int i = startRow4; i < startRow4 + nRow4 ; i++) {
                        this.block[3][i] = '*';
                    }
                }
            }
        }
    }

    public void printBlock() {
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxColumn; j++) {

                System.out.print(this.block[i][j]);
            }
            System.out.print("\n");
        }
    }



    //________________________ getter and setter :(

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getMaxRow() {
        return maxRow;
    }

    public void setMaxRow(int maxRow) {
        this.maxRow = maxRow;
    }

    public int getMaxColumn() {
        return maxColumn;
    }

    public void setMaxColumn(int maxColumn) {
        this.maxColumn = maxColumn;
    }

    public char[][] getBlock() {
        return block;
    }

    public void setBlock(char[][] block) {
        this.block = block;
    }

    //________________________ )






}
