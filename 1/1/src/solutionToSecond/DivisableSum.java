package solutionToSecond;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class DivisableSum {

	public static void main(String[] args) {
		int checksum=0;
		File puzzle=new File("spreadsheet1.txt");
		try {
			Scanner s=new Scanner(puzzle);
			while(s.hasNext()) {
				LinkedList<Integer> list=new LinkedList<Integer>();
				String row=s.nextLine();
				Scanner si=new Scanner(row);
				while(si.hasNext()) {
					list.add(si.nextInt());
				}
				list.sort(Comparator.reverseOrder());
				for(int i=0;i<list.size()-1;i++) {
					for(int j=i+1;j<list.size();j++) {
						if(list.get(i)%list.get(j)==0) {
							//System.out.println("one: "+String.valueOf(list.get(i)));
							//System.out.println("second: "+String.valueOf(list.get(j)));
							checksum+=list.get(i)/list.get(j);
							//System.out.println("checksum: "+String.valueOf(checksum));
							break;
						}
					}
				}
			}
			System.out.println(String.valueOf(checksum));
			s.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
