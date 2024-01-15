import java.util.Scanner;
class Sudoku
{ 
public static boolean SafetyCheck(int[][] grid, int row, int col, int num)  
{ 
    //row
    for (int i = 0; i < grid.length; i++)  
    {  
        if (grid[row][i] == num)  
        { 
            return false; 
        } 
    } 
      
    // column
    for (int i = 0; i < grid.length; i++) 
    {   
        if (grid[i][col] == num) 
        { 
            return false; 
        } 
    } 
  
    //3x3 grid
    int root = (int) Math.sqrt(grid.length); 
    int Gridrow = row - row % root; 
    int GridCol = col - col % root; 
  
    for (int i = Gridrow;i < Gridrow + root; i++)  
    { 
        for (int j = GridCol;j < GridCol + root; j++)  
        { 
            if (grid[i][j] == num)  
            { 
                return false; 
            } 
        } 
    } 
  
    return true; 
} 
  
public static boolean SudokuSolver(int[][] grid, int n)  
{ 
    int row = -1; 
    int col = -1; 
    boolean empty = true; 
    for (int i = 0; i < n; i++) 
    { 
        for (int j = 0; j < n; j++)  
        { 
            if (grid[i][j] == 0)  
            { 
                row = i; 
                col = j; 
                empty = false;   //for empty spaces  
                break; 
            } 
        } 
        if (!empty) 
        { 
            break; 
        } 
    } 
   
    if (empty)  
    { 
        return true; 
    } 

    for (int k = 1; k <= n; k++) 
    { 
        if (SafetyCheck(grid, row, col, k)) 
        { 
            grid[row][col] = k; 
            if (SudokuSolver(grid, n))  
            { 
              return true; 
            }  
            else
            { 
                grid[row][col] = 0;  
            } 
        } 
    } 
    return false; 
} 
  
//printing the solved sudoku 
public static void print(int[][] grid, int N)     
{  System.out.println("\n\n\nThe Solution:\n");

    for (int i = 0; i < N; i++) 
    { 
        for (int j = 0; j < N; j++) 
        { 
            System.out.print(grid[i][j]); 
            System.out.print(" "); 
        } 
        System.out.print("\n"); 
        if ((i + 1) % (int) Math.sqrt(N) == 0)  
        { 
            System.out.print(""); 
        } 
    } 
} 
  
public static void main(String args[]) 
{   
    int[][] grid = new int[9][9];
    Scanner sc= new Scanner(System.in); 
    try{
    for(int i=0;i<9;i++){
  for(int j=0;j<9;j++){
    grid[i][j]=sc.nextInt();  
  }
 } 
}  finally{
    sc.close();
}
   
int length = grid.length; 
  
    if (SudokuSolver(grid, length)) 
    { 
        print(grid, length); 
    }  
    else
    { 
        System.out.println("No Solution Exists"); 
    } 
} 
}