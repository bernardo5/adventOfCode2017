package solutionToSix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class NumberCount {

	ArrayList<Integer> memory;
	LinkedList<String> occuredSequences;
	int size;
	
	public NumberCount() {
		memory=new ArrayList<Integer>();
		occuredSequences=new LinkedList<String>();
	}
	
	public void loadMemory() {
		File f=new File("memory.txt");
		try {
			Scanner s=new Scanner(f);
			while(s.hasNextInt()) {
				memory.add(s.nextInt());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		size=memory.size();
	}
	
	public ArrayList<Integer> deepCopy(){
		ArrayList<Integer> n=new ArrayList<Integer>();
		for(int i:memory) {
			n.add(i);
		}
		return n;
	}
	
	public int[] findFullestMemoryPosition() {
		int[] result=new int[2];
		ArrayList<Integer> aux=deepCopy();
		aux.sort(Collections.reverseOrder());
		result[1]=aux.get(0);
		int index=0;
		for(int i:memory) {
			if(i==result[1])break;
			index++;
		}
		//System.out.println("Reached position: "+String.valueOf(index));
		result[0]=index;
		return result;
	}
	
	public String getSequenceString() {
		String s="";
		for(int i:memory) {
			s+=String.valueOf(i)+" ";
		}
		return s;
	}
	
	public void distributeCut(int position, int value) {
		//add to list of occured sequences
		occuredSequences.add(getSequenceString());
		int valueToDistribute=value;
		//System.out.println("value: "+String.valueOf(value));
		//System.out.println("position: "+String.valueOf(position));
		memory.set(position, 0);
		//System.out.println("Cleared: "+getSequenceString());
		int id=position+1;
		//System.out.println("new ");
		while(true) {
		//	System.out.println("id: "+String.valueOf(id));
		//	System.out.println("valueDistrib: "+String.valueOf(valueToDistribute));
			if(id==size)id=0;
			memory.set(id, memory.get(id)+1);
			//System.out.println("Dstribute step: "+getSequenceString());
			valueToDistribute--;
			id++;
		//	System.out.println("id: "+String.valueOf(id));
		//	System.out.println("valueDistrib: "+String.valueOf(valueToDistribute));
			if(id==size)id=0;
			if(valueToDistribute==0)break;
		}
		
	}
	
	public boolean repeated() {
		for(String s:occuredSequences) {
			if(s.equals(getSequenceString())) {
				//System.out.println("Actual sequence: "+getSequenceString());
				//System.out.println("Found sequence: "+s);
				return true;
			}
		}
		return false;
	}
	
	public void printSequence() {
		System.out.println("Current sequence is: "+getSequenceString());
	}
	
	public int numberRepeat() {
		int returnint=0;
		int index=0;
		for(String s:occuredSequences) {
			if(s.equals(getSequenceString())) {
				//System.out.println("Actual sequence: "+getSequenceString());
				//System.out.println("Found sequence: "+s);
				return index;
			}
			index++;
		}
		
		return returnint;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberCount m=new NumberCount();
		m.loadMemory();
		int iterations=0;
		m.printSequence();
		while(!m.repeated()) {
			int[] next=m.findFullestMemoryPosition();
			m.distributeCut(next[0], next[1]);
			iterations++;
			m.printSequence();
		}
		
		System.out.println(String.valueOf(iterations-m.numberRepeat()));

	}

}
