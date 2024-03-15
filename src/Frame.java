public class Frame {

    private int row ;//height of a frame
    private int column ;//weight of a block
    private char[][] frame ;

    public Menu menu = new Menu();
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

    public void printFrame() {

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                System.out.print(this.frame[i][j]);
            }
            System.out.print("\n");
        }
    }

    public void addBlock( Block block ) {
        for (int i = 0 ; i < block.getMaxRow() ; i++) {
            for (int j = 0 ; j < block.getMaxColumn() ; j++) {
                if (block.getBlock()[i][j] == '*')
                {
                    this.frame[i + block.getRow()][j + block.getColumn()] = '*';
                }
            }
        }
    }

    public void clearBlock( Block block ) {
        for (int i = 0 ; i < block.getMaxRow() ; i++) {
            for (int j = 0 ; j < block.getMaxColumn() ; j++) {
                if (block.getBlock()[i][j] == '*')
                {
                    this.frame[i + block.getRow()][j + block.getColumn()] = ' ';
                }
            }
        }
    }

    public boolean isValidMoveDown( Block block ) {
        clearBlock(block);
        block.setRow(block.getRow()+1);
        for (int i = 0 ; i < block.getMaxRow() ; i++) {
            for (int j = 0 ; j < block.getMaxColumn() ; j++) {
                if (block.getBlock()[i][j] == '*')
                {
                    if (this.frame[i + block.getRow()][j + block.getColumn()] == '*')
                    {
                        block.setRow(block.getRow() - 1);
                        addBlock(block);
                        return false;
                    }
                }
            }
        }
        return true;

    }

    public boolean isValidMoveLeft( Block block) {
        clearBlock(block);
        block.setRow(block.getRow()+1);
        block.setColumn(block.getColumn()-1);
        for (int i = 0 ; i < block.getMaxRow() ; i++) {
            for (int j = 0 ; j < block.getMaxColumn() ; j++) {
                if (block.getBlock()[i][j] == '*')
                {
                    if (this.frame[i + block.getRow()][j + block.getColumn()] == '*')
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidMoveRight(Block block) {
        clearBlock(block);
        block.setRow(block.getRow()+1);
        block.setColumn(block.getColumn()+1);
        for (int i = 0 ; i < block.getMaxRow() ; i++) {
            for (int j = 0 ; j < block.getMaxColumn() ; j++) {
                if (block.getBlock()[i][j] == '*')
                {
                    if (this.frame[i + block.getRow()][j + block.getColumn()] == '*')
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void moveDown( Block block ) {
        if (isValidMoveDown(block))
        {
            addBlock(block);
        }
    }

    public void moveLeft( Block block ) {
        if (!isValidMoveLeft(block))
        {
            block.setRow(block.getRow()-1);
            block.setColumn(block.getColumn()+1);
            moveDown(block);
        }
        addBlock(block);
    }
    public void moveRight( Block block ) {
        if (!isValidMoveRight(block))
        {
            block.setRow(block.getRow()-1);
            block.setColumn(block.getColumn()-1);
            moveDown(block);
        }
        addBlock(block);
    }

    public void Rotate( Block block ) {
        char[][] tempMatrix = new char[block.getMaxRow()][block.getMaxColumn()];

        for (int i = 0; i < block.getMaxRow(); i++) {
            for (int j = 0; j < block.getMaxColumn(); j++) {

                tempMatrix[j][block.getMaxRow() - i - 1] = block.getBlock()[i][j];
            }
        }
        block.setBlock(tempMatrix);
        moveDown(block);
        addBlock(block);
    }







}
