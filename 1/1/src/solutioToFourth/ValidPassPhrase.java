package solutioToFourth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ValidPassPhrase {
	public static boolean elementInList(String ele, List<String> list) {
		for(String s:list)if(s.equals(ele)) return true;
		return false;
	}

	public static void main(String[] args) {
		File f=new File("passphrases.txt");
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
					if(ValidPassPhrase.elementInList(word, words)) {
						valid=false;
					}else {
						words.add(word);
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
