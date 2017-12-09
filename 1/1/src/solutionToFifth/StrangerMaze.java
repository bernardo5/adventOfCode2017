package solutionToFifth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StrangerMaze {
	ArrayList<Integer> maze;
	int position;
	int mazeSize;
	
	public StrangerMaze() {
		maze=new ArrayList<Integer>();
		position=0;
	}
	
	public void addElementToMaze(int number) {
		maze.add(number);
	}
	
	public void jumpInMaze() {
		int numberToJumpTo=maze.get(position);
		if(numberToJumpTo<3)
			maze.set(position, numberToJumpTo+1);
		else maze.set(position, numberToJumpTo-1);
		position=position+ numberToJumpTo;
		
	}
	
	public void loadMaze() {
		File f=new File("maze1.txt");
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
		StrangerMaze m=new StrangerMaze();
		m.loadMaze();
		int numberJumps=0;
		while(!(m.getPosition()<0) && (m.getPosition()<m.getMazeSize())) {
			m.jumpInMaze();
			numberJumps++;
		}
		System.out.println(numberJumps);
		//System.out.println("maze status:");
		//for(int i:m.maze)System.out.println(String.valueOf(i));
	}
}
