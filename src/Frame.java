public class Frame {

    private int row ;//height of a frame
    private int column ;//weight of a block
    private char[][] frame ;

    private int score ;

    public Menu menu = new Menu();


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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Frame(int row , int column) {
        this.row = row;
        this.column = column;
        this.frame = new char[row][column] ;
        this.score = 0 ;
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

    public void giveScore(Frame frame){

        while (true ){
            int col = checkColumn(frame);
            if (col == -1){
                break;
            }
            else
            {
                clearColumn(col,frame);
                this.score = this.score - 10;
            }
        }

        while (true ){
            int row = checkRow(frame);
            if (row == -1){
                break;
            }
            else
            {
                clearRow(row , frame);
                this.score = this.score + 100 ;
            }
        }


    }

    public int checkRow(Frame frame){
        boolean flag;
        for (int i = 3; i < this.row - 1; i++) {
            flag = true;
            for (int j = 0; j < this.column; j++) {
                if (this.frame[i][j] != '*' ){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return i;
            }
        }
        return -1;

    }

    public int checkColumn(Frame frame){
        boolean flag;
        for (int i = 1; i < this.column - 1; i++) {
            flag = true;
            for (int j = 2; j < this.row - 1; j++) {
                if (this.frame[j][i] != '*'){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return i;
            }
        }
        return -1;
    }

    public void checkFirstColumn(Frame frame) {

        for (int i = 1; i < this.column - 1; i++) {
            if (this.frame[0][i] == '*'){
                clearColumn(i , frame);
            }
            this.score = this.score - 10;
        }

    }
    public void clearColumn(int col , Frame frame){
        for (int i = 0; i < this.row - 1; i++) {
            this.frame[i][col] = ' ';
        }
    }

    public void clearRow( int ro , Frame frame){
        for (int i = 0; i <this.column ; i++) {
            this.frame[ro][i] = ' ';
        }
    }

}
