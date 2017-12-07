package solutionToThird;

import java.util.Scanner;

public class SpiralMemory {
	//if you consider an iteration as an increase of a square, you will note that the number of
	//numbers on each line of the square suffers an increase to the next odd number (n) and that the maximum
	//number corresponds to the n^2
	
	private static double[] findSquareSizeAndBiggestNumber(double sideSize, int received) {
		double[] result=new double[2];
		double size=sideSize;
		while(Math.pow(size, 2)<received) {
			size+=2;
		}
		//reached the size of the final spiral
		result[0]=size;
		result[1]=Math.pow(size, 2);
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("Intruduce the number to fetch the solution:");
		Scanner s=new Scanner(System.in);
		int number=s.nextInt();
		double squareSideNumbers=1;
		double[] d=findSquareSizeAndBiggestNumber(squareSideNumbers, number);
		System.out.println("Square size side: "+String.valueOf(d[0]));
		System.out.println("Biggest number in Square: "+String.valueOf(d[1]));
		double difference=0;
		int result=0;
		if(number<=((Math.pow(d[0]-2, 2))+(d[0]-1))) {//right vertical side
			System.out.println("b: "+String.valueOf(((Math.pow(d[0]-2, 2))+(d[0]-1))));
			difference= (((Math.pow(d[0]-2, 2))+(d[0]-1))-number);
		}else if(number<=((Math.pow(d[0]-2, 2))+(2*(d[0]-1)))) {//to side
			System.out.println("b: "+String.valueOf(((Math.pow(d[0]-2, 2))+(2*d[0]))));
			difference= (((Math.pow(d[0]-2, 2))+(2*(d[0]-1)))-number);
		}else if(number<=((Math.pow(d[0]-2, 2))+(3*(d[0]-1)))){//left side
			System.out.println("b: "+String.valueOf(((Math.pow(d[0]-2, 2))+(3*d[0]))));
			difference= (((Math.pow(d[0]-2, 2))+(3*(d[0]-1)))-number);
		}else if(number<=((Math.pow(d[0]-2, 2))+(4*(d[0]-1)))){//down side
			System.out.println("b: "+String.valueOf(((Math.pow(d[0]-2, 2))+(4*d[0]))));
			difference= (((Math.pow(d[0]-2, 2))+(4*(d[0]-1)))-number);
		}
		System.out.println("Difference: "+String.valueOf(difference));
		result= (int) (((int)(d[0]/2))+(Math.abs(difference-(((int)(d[0]/2))))));
		System.out.println(result);
		
	}

}
