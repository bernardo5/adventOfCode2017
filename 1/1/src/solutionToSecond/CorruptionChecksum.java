package solutionToSecond;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class CorruptionChecksum {

	public static void main(String[] args) {
		int checksum=0;
		File puzzle=new File("spreadsheet.txt");
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
				checksum+=list.getFirst()-list.getLast();
			}
			System.out.println(String.valueOf(checksum));
			s.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}
