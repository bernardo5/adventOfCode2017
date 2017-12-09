package solutionToFifth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MazeTrampolins {
	ArrayList<Integer> maze;
	int position;
	int mazeSize;
	
	public MazeTrampolins() {
		maze=new ArrayList<Integer>();
		position=0;
	}
	
	public void addElementToMaze(int number) {
		maze.add(number);
	}
	
	public void jumpInMaze() {
		int numberToJumpTo=maze.get(position);
		maze.set(position, numberToJumpTo+1);
		position=position+ numberToJumpTo;
		
	}
	
	public void loadMaze() {
		File f=new File("maze.txt");
		int size=0;
		try {
			Scanner s=new Scanner(f);
			while(s.hasNextLine()) {
				maze.add(s.nextInt());
				size++;
			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mazeSize=size;
	}
	
	public int getPosition() {
		return position;
	}
	
	public int getMazeSize() {
		return mazeSize;
	}
	
	public static void main(String[] args) {
		MazeTrampolins m=new MazeTrampolins();
		m.loadMaze();
		int numberJumps=0;
		while(!(m.getPosition()<0) && (m.getPosition()<m.getMazeSize())) {
			m.jumpInMaze();
			numberJumps++;
		}
		System.out.println(numberJumps);
	}

}
