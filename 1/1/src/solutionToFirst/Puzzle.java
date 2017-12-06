package solutionToFirst;

import java.util.Scanner;

public class Puzzle {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		String number=s.nextLine();
		String naux=number;
		int lengt=number.length()-1;
		//int auxNumber=number;
		int digit, previous=100;
		int sum=0;
		while(lengt>=0) {
			if(previous==100) {//first iteration
				previous=Integer.valueOf(naux.substring(lengt));//auxNumber%10;
				//System.out.println(previous);
				naux=naux.substring(0,lengt);
				
				
				lengt=lengt-1;
			}else {//already processed one
				digit=Integer.valueOf(naux.substring(lengt));
				
				if(digit==previous) {
					sum+=digit;
					//System.out.println("there");
				}
				previous=digit;
				naux=naux.substring(0,lengt);
				//System.out.println(lengt);
				lengt=lengt-1;
				//verify if last
				if(lengt<0) {
					
					if(previous==Integer.valueOf(number.substring(number.length()-1))) {//first equals last
						sum+=previous;
						//System.out.println("here");
					}
				}
			}
			
			
		}
		System.out.println("Reached solution: "+String.valueOf(sum));
	}

}
