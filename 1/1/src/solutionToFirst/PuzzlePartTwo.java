package solutionToFirst;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PuzzlePartTwo {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		String in=s.nextLine();
		List<Integer> list=new LinkedList<Integer>();
		for(char c:in.toCharArray()) {
			list.add(Character.getNumericValue(c));
		}
		int compUpfront=list.size()/2;
		int sum=0;
		for(int i=0; i<list.size();i++) {
			if((i+compUpfront)<list.size()) {
				if(list.get(i)==list.get(i+compUpfront))sum+=list.get(i);
			}else {
				int position=(i+compUpfront)-list.size();
				if(list.get(i)==list.get(position))sum+=list.get(i);
			}
		}
		System.out.println(sum);
	}

}
