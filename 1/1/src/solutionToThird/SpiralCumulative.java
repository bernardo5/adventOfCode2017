package solutionToThird;

import java.util.Scanner;

public class SpiralCumulative {
	int[] right;
	int[] top;
	int[] left;
	int[] bottom;
	
	int[] rightPrev;
	int[] topPrev;
	int[] leftPrev;
	int[] bottomPrev;
	
	int currentSize;
	
	int goal, currentNumber;
	
	public SpiralCumulative() {
		//------------Initialization of initial matrix-------------
		currentNumber=0;
		currentSize=3;
		rightPrev=new int[3];
		rightPrev[0]=25;
		rightPrev[1]=1;
		rightPrev[2]=2;
		
		topPrev=new int[3];
		topPrev[0]=2;
		topPrev[1]=4;
		topPrev[2]=5;
		
		leftPrev=new int[3];
		leftPrev[0]=5;
		leftPrev[1]=10;
		leftPrev[2]=11;
		
		bottomPrev=new int[3];
		bottomPrev[0]=11;
		bottomPrev[1]=23;
		bottomPrev[2]=25;
		
		//---------------------------------------------------------
	}
	
	public void setGoal() {
		Scanner s=new Scanner(System.in);
		goal=s.nextInt();
	}
	
	public int getGoal() {
		return goal;
	}
	
	public int getCurrentNumber() {
		return currentNumber;
	}
	
	public void increaseMatrixSize() {
		currentSize+=2;
	}
	
	public void allocateNewSides() {
		right=new int[currentSize];
		top=new int[currentSize];
		left=new int[currentSize];
		bottom=new int[currentSize];
	}
	
	public void passTestemonial() {
		rightPrev=right;
		topPrev=top;
		leftPrev=left;
		bottomPrev=bottom;
	}
	
	public void processRight() {
		for(int i=1;i<currentSize; i++) {
			if(!reachedGoal()) {
				if(i==1) {//first is special
					right[i]=rightPrev[i-1]/*left number*/+rightPrev[i];/*diagonal up*/
				}else {
					if(i==(currentSize-1)) {//last is special
						right[i]=/*bottom*/right[i-1]+/*diagonal down*/rightPrev[i-2];	
					}else {//middle numbers
						right[i]=/*bottom*/right[i-1]+/*diagonal down*/rightPrev[i-2]+/*left number*/+rightPrev[i-1];
						if(i!=(currentSize-2))right[i]+=/*diagonal up*/rightPrev[i];
					}
				}
				currentNumber=right[i];
			}else {
				System.out.println(currentNumber);
				System.exit(0);
			}
			
		}
	}
	
	public void processUp() {
		top[0]=right[currentSize-1];
		
		for(int i=1;i<currentSize; i++) {
			if(!reachedGoal()) {
				//System.out.println(i);
				if(i==1) {//first is special
					//System.out.println(top[i-1]);
					//System.out.println(right[currentSize-2]);
					//System.out.println(topPrev[i-1]);
					//System.out.println("-----------------");
					
					top[i]=top[i-1]/*right number*/+/*diagonal down*/right[currentSize-2]+/*down*/topPrev[i-1]+/*diagonal down left*/topPrev[i];
				}else {
					if(i==(currentSize-1)) {//last is special
						top[i]=top[i-1]/*right number*/+/*diagonal down right*/topPrev[i-2];
					}else {//middle numbers
						top[i]=top[i-1]/*right number*/+/*diagonal down right*/topPrev[i-2]+/*down*/topPrev[i-1];
						if(i!=(currentSize-2))top[i]+=/*diagonal down left*/topPrev[i];
					}
				}
				currentNumber=top[i];
			}else {
				System.out.println(currentNumber);
				System.exit(0);
			}
			
		}
	}
	
	public void processLeft() {
		left[0]=top[currentSize-1];
		
		for(int i=1;i<currentSize; i++) {
			if(!reachedGoal()) {
				//System.out.println(i);
				if(i==1) {//first is special
					//System.out.println(top[i-1]);
					//System.out.println(right[currentSize-2]);
					//System.out.println(topPrev[i-1]);
					//System.out.println("-----------------");
					
					left[i]=left[i-1]/*top number*/+/*diagonal down*/top[currentSize-2]+/*right*/leftPrev[i-1]+/*diagonal down right*/leftPrev[i];
				}else {
					if(i==(currentSize-1)) {//last is special
						left[i]=left[i-1]/*up number*/+/*diagonal up right*/leftPrev[i-2];
					}else {//middle numbers
						left[i]=left[i-1]/*up number*/+/*diagonal up right*/leftPrev[i-2]+/*right*/leftPrev[i-1];
						if(i!=(currentSize-2))left[i]+=/*diagonal down right*/leftPrev[i];
					}
				}
				currentNumber=left[i];
			}else {
				System.out.println(currentNumber);
				System.exit(0);
			}
			
		}
	}
	
	public void processBottom() {
		bottom[0]=left[currentSize-1];
		
		for(int i=1;i<currentSize; i++) {
			
			if(!reachedGoal()) {
				//System.out.println(i);
				if(i==1) {//first is special
					//System.out.println(top[i-1]);
					//System.out.println(right[currentSize-2]);
					//System.out.println(topPrev[i-1]);
					//System.out.println("-----------------");
					
					bottom[i]=bottom[i-1]/*top number*/+/*diagonal down*/left[currentSize-2]+/*right*/bottomPrev[i-1]+/*diagonal down right*/bottomPrev[i];
				}else {
					if(i==(currentSize-1)) {//last is special
						bottom[i]=bottom[i-1]/*up number*/+/*diagonal up right*/bottomPrev[i-2]+right[1];
					}else {//middle numbers
						bottom[i]=bottom[i-1]/*left number*/+/*diagonal up left*/bottomPrev[i-2]+/*up*/bottomPrev[i-1];
						if(i!=(currentSize-2))bottom[i]+=/*diagonal up right*/bottomPrev[i];
						else bottom[i]+=/*diagonal up right*/right[1];
					}
				}
				currentNumber=bottom[i];
			}else {
				System.out.println(currentNumber);
				System.exit(0);
			}
			
		}
		right[0]=bottom[currentSize-1];
	}
	
	public boolean reachedGoal() {
		if(getCurrentNumber()<getGoal())return false;
		return true;
	}

	public static void main(String[] args) {
		SpiralCumulative spiral=new SpiralCumulative();
		spiral.setGoal();
		System.out.println("Goal Number is: "+String.valueOf(spiral.getGoal()));
		while(spiral.getCurrentNumber()<spiral.getGoal()) {
			spiral.increaseMatrixSize();
			spiral.allocateNewSides();
			spiral.processRight();
			spiral.processUp();
			spiral.processLeft();
			spiral.processBottom();
			
			//prepare next iteration
			spiral.passTestemonial();
		}
		
		
		
		
	}

}
