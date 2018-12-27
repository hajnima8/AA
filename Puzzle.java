

import java.util.*;

public class Puzzle {

	private static int[] actions;
	public static void main(String[] args) {
make(initial());


	}

	private static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	public static  int[] initial()
	{

		int[]		arr= {1,2,3,4,5,6,7,8,0};

		for (int i = 0; i <= 8; i++) {
			int	position1=getRandomNumberInRange(0, 8);
			int	position2=getRandomNumberInRange(0, 8);
			
			
		int temp =arr[position1];
		arr[position1]=arr[position2];
		arr[position2]=temp;
        }
        for (int i : arr) {
			
			
			System.out.print("<"+i+">");
			
		}	

		  return arr;
		}


	static int evaluate(int[] board) {
		int score = 0;
		for (int i = 0; i <= 3; i++) {
		
				if (board[i]!= i+1) {
					score++;
				
				}
				
		}
		for (int i = 5; i <= 8; i++) {
			
			if (board[i]!= i+1) {
				score++;
			
			}
			
	}
		
		if (board[4]!= 0) score++;
		
		if(score==2||score==4||score==6||score==8) {System.out.println("\nPROBLEM CAN NOT SOLVE"); return -1;}
		else {
		System.out.println("\n"+score);
		return score;}
	}
	
	
	

	
	

	 
	 public static int findzero(int[] board) {
		 int find = 0;
		 for (int i = 0; i <= 8; i++) {
				
				if (board[i]== 0) {
				find=i;	
				break;
				
				}
				
		}
		 System.out.println(find);
		 return find;
		 
	 }
	 
	
	 static int counter=0;
public 	static int[] make(int[] board) {
	
	  int oldscore = evaluate(board);
		System.out.println("\nthe score of  solution number "+counter+" is "+oldscore);
		System.out.println("the  solution number : " +counter);
	
		for (int i : board) {
			
			
			System.out.print("<"+i+">");
			
		}	 
		
	
		int[]	newboard = new int[9];
		newboard=board;
	    int newscore =0;
	do {
		 int	position2=getRandomNumberInRange(0, 8);
			//----------------------------------
			
			int	position1=findzero(newboard);
		   int temp = newboard[position1] ;
		 
		   newboard[position1] = newboard[position2];
		   newboard[position2]=temp;
		   int newscore1 = evaluate(newboard);
		   newscore=newscore1;
			
	} while (newscore!=-1);
		
		
				
				
				System.out.println("\n-----------------------");
				
					if (newscore>oldscore) {
						
				
			
							
							System.out.println("the score of  optimized solution is : "+oldscore);
		
							System.out.println("the optimized solution : ");
							
							for (int i1 : board) {
								
								
								System.out.print("<"+i1+">");
							}	 
							
						
							
				return board;}
				else { counter++;	 return  	make(newboard);	}
				}

	
	


	

		


	


		}

		