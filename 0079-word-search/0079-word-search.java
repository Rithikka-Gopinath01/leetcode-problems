class Solution {
    boolean search(char[][] board,int row,int col,String word,int i,boolean[][] check){

        if(i==word.length()){
            return true;
        }
        if(row<0||row==board.length||col<0||col==board[0].length){
            return false;
        }
        if(check[row][col]){
            return false;
        }
        if(board[row][col]!=word.charAt(i)){
            return false;
        }
        check[row][col]=true;
        boolean found=search(board,row,col+1,word,i+1,check)||search(board,row,col-1,word,i+1,check)||search(board,row-1,col,word,i+1,check)||search(board,row+1,col,word,i+1,check);
        check[row][col] = false;
        return found;

    }
    public boolean exist(char[][] board, String word) {
        int r=board.length;
        int c=board[0].length;
        boolean[][] check=new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(search(board,i,j,word,0,check)){
                    return true;
                }
            }
        }
        return false;
    }
}