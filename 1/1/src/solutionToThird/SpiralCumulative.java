package solutionToThird;

import java.util.Scanner;

public class SpiralCumulative {

	public static void main(String[] args) {
		//------------Initialization of initial matrix-------------
		int[] rightPrev=new int[2];
		rightPrev[0]=1;
		rightPrev[1]=2;
		
		int[] topPrev=new int[2];
		topPrev[0]=4;
		topPrev[1]=5;
		
		int[] leftPrev=new int[2];
		leftPrev[0]=10;
		leftPrev[1]=11;
		
		int[] bottomPrev=new int[2];
		bottomPrev[0]=23;
		bottomPrev[1]=25;
		//---------------------------------------------------------
		Scanner s=new Scanner(System.in);
		int input=s.nextInt();
		int size=4;
		int number=0;
		while(number<input) {
			int[] right=new int[size];
			int[] top=new int[size];
			int[] left=new int[size];
			int[] bottom=new int[size];
			
			
			
			//prepare next iteration
			rightPrev=right;
			topPrev=top;
			leftPrev=left;
			bottomPrev=bottom;
			size+=2;
		}
		
		
		
		
	}

}
