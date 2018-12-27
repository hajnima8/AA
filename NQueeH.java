

import java.util.*;

public class NQueeH {

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
	int[]	arr = new int[8];

		for (int i = 0; i < 8; i++) {
			
			arr[i]= getRandomNumberInRange(0, 7);

        }

		  return arr;
		}


	static int evaluate(int[] board) {
		int score = 0;
		for (int i = 0; i < 7; i++) {
			for (int j = i + 1; j < 7; j++) {
				if (board[i]== board[j]) {
					score++;
					continue;
				}
				if (board[i] - board[j] == i - j) {
					score++;
					continue;
				}
				if (board[i] - board[j] == j - i) {
					score++;
					continue;
				}
			}
		}
		return score;
	}
	 static int counter=0;
public 	static int[] make(int[] board) {
	
	  int oldscore = evaluate(board);
		System.out.println("\nthe score of  solution number "+counter+" is "+oldscore);
		System.out.println("the  solution number : " +counter);
	
		for (int i : board) {
			
			
			System.out.print("<"+i+">");
			
		}	 
		
	
		int[]	newboard = new int[8];
		
	
		int	position1=getRandomNumberInRange(0, 7);
		int	position2=getRandomNumberInRange(0, 7);
			//----------------------------------
			newboard=board;
		   int temp = newboard[position1] ;
		 
		   newboard[position1] = newboard[position2];
		   newboard[position2]=temp;
   
  
				int newscore = evaluate(newboard);

				int[] temparr = new int[8];
				temparr=board;
				  int old = evaluate(temparr);

				  for (int i = 0; i < board.length; i++) {
					
					  for (int j = 0; j < board.length; j++) {
						
					     	int tempo=  temparr[i];
						  temparr[i] =j;
						  
						   int k = evaluate(temparr);
						   
						  
                                 if (k <= old) {
							   
							   temparr[i]=j;
						       old=k;
							
				
						
						   }
                                 else {
  								   
  								   temparr[i]=tempo;
  							
  								
  							     break;

  							
  							   }
						  
					}	
				}
						
				
				
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

		
	

	
