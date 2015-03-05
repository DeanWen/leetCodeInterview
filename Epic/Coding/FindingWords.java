import java.util.*;


//Write a program for a word search. If thereis an NxN grid with one letter in each cell. 
//Let the user enter a word and theletters of the word are said to be found in the grid either the letters matchvertically, horizontally or diagonally in the grid. 
//If the word is found, printthe coordinates of the letters as output.



//直接检索，用DFS的话耗空间，且也没有快一点


public class FindingWords {
	
	public void test(){
		char[][] theboard = {{'a','b','c','d'}, {'e','f', 'g', 'h'}, {'i','j','k','l'}, {'m','n','o','p'}};
		System.out.println("finding fkp:" + sol(theboard,"fkp"));
		System.out.println("finding kai:" + sol(theboard,"kai"));
	}
	
	public boolean sol(char[][] board, String find){
		int len = find.length();
		if(board.length < len) return false;
		if(len == 0) return true;
		char thehead = find.charAt(0);
		int n = board.length;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(thehead == board[i][j]){
					if(findwords(board, i, j, len, find)){
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean findwords(char[][] board, int headrow, int headcol, int len, String find){
		boolean flag = false;
		int n = board.length;
		if(headcol >= len-1){
			for(int i = 1; i < len; i++){
				if(board[headrow][headcol-i] != find.charAt(i)){
					flag = true;
					break;
				}
			}
			if(!flag) return true;
			flag = false;
		}
		if(headrow >= len -1){
			for(int i = 1; i < len; i++){
				if(board[headrow-i][headcol] != find.charAt(i)){
					flag = true;
					break;
				}
			}
			if(!flag) return true;
			flag = false;
		}
		if(headcol >= len-1 && headrow>= len-1){
			for(int i = 1; i < len; i++){
				if(board[headrow-i][headcol-i] != find.charAt(i)){
					flag = true;
					break;
				}
			}
			if(!flag) return true;
			flag = false;
		}
		if(n - headcol >= len){
			for(int i = 1; i < len; i++){
				if(board[headrow][headcol+i] != find.charAt(i)){
					flag = true;
					break;
				}
			}
			if(!flag) return true;
			flag = false;
		}
		if(n - headcol >= len && headrow >= len-1){
			for(int i = 1; i < len; i++){
				if(board[headrow-i][headcol+i] != find.charAt(i)){
					flag = true;
					break;
				}
			}
			if(!flag) return true;
			flag = false;
		}
		if(n - headcol >= len && n - headrow >= len){
			for(int i = 1; i < len; i++){
				if(board[headrow+i][headcol+i] != find.charAt(i)){
					flag = true;
					break;
				}
			}
			if(!flag) return true;
			flag = false;
		}
		if(n - headrow >= len){
			for(int i = 1; i < len; i++){
				if(board[headrow+i][headcol] != find.charAt(i)){
					flag = true;
					break;
				}
			}
			if(!flag) return true;
			flag = false;
		}
		if(headcol >= len-1 && n - headrow >= len){
			for(int i = 1; i < len; i++){
				if(board[headrow+i][headcol-i] != find.charAt(i)){
					flag = true;
					break;
				}
			}
			if(!flag) return true;
			flag = false;
		}
		return false;
	}
	
}