package solutioToFourth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PassAnagram {
	
	public static boolean elementInList(String ele, List<String> list) {
		for(String s:list)if(s.equals(ele)) return true;
		return false;
	}

	public static void main(String[] args) {
		File f=new File("passphrases1.txt");
		int validpasses=0;
		try {
			Scanner s=new Scanner(f);
			while(s.hasNextLine()) {
				boolean valid=true;
				List<String> words=new LinkedList<String>();
				String passphrase=s.nextLine();
				Scanner pass=new Scanner(passphrase);
				while(pass.hasNext()) {
					String word=pass.next();
					char[] w=word.toCharArray();
					Arrays.sort(w);
					String newWord=String.valueOf(w);
					if(ValidPassPhrase.elementInList(newWord, words)) {
						valid=false;
					}else {
						words.add(newWord);
					}
				}
				if(valid)validpasses+=1;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(validpasses);

	}

}
