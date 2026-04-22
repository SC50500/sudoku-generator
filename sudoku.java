import java.util.ArrayList;

public class sudoku
{
    public static int[][] fullPuzzle = new int[9][9];
    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();
        for(int k = 0; k < 1000; k++){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    generate(i, j);
                }
            }
            printPuzzle();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
    
    public static boolean isValid(int row, int col, int num){
        for(int i = 0; i < fullPuzzle.length; i++){
            if(i != row && fullPuzzle[i][col] == num){
                return false;
            }
        }
        for(int j = 0; j < fullPuzzle.length; j++){
            if(j != col && fullPuzzle[row][j] == num){
                return false;
            }
        }
        int rBlock = row - row % 3; 
        int cBlock = col - col % 3; 
        for(int k = rBlock; k < rBlock + 3; k++){
            for(int l = cBlock; l < cBlock + 3; l++){
                if(k != row && l != col && fullPuzzle[k][l] == num){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean generate(int row, int col){
        if(row == 9){
            return true;
        }
        if(col == 9){
            return generate(row + 1, 0);
        }
    
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 1; i <= 9; i++){
            nums.add(i);
        }
    
        while(nums.size() > 0){
            int randomIndex = (int)(Math.random()*nums.size());
            int num = nums.get(randomIndex);
            nums.remove(randomIndex);
    
            if(isValid(row, col, num)){
                fullPuzzle[row][col] = num;
                if(generate(row, col + 1)){
                    return true;
                }
                fullPuzzle[row][col] = 0;
            }
        }
    
        return false;
    }
    
    public static void printPuzzle(){
        for(int i = 0; i < fullPuzzle.length; i++){
            if(i % 3 == 0){
                System.out.println("+-------+-------+-------+");
            }
            for(int j = 0; j < fullPuzzle[i].length; j++){
                if(j % 3 == 0){
                    System.out.print("| ");
                }
                System.out.print(fullPuzzle[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("+-------+-------+-------+");
    }
}