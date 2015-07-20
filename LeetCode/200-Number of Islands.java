/*
* Main Thought
* find a island that marked as 1
* res ++
* then turn itself and dfs all neighbors to 0
*
* Search the grid, until the entire grid is completed
*/
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '1') {
                    continue;
                }else {
                    res++;
                    dfs(grid, i , j);
                }
            }
        }
        
        return res;
    }
    
    public void dfs (char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }
}