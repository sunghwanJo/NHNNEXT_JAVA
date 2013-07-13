package one.lesson;

import java.util.ArrayList;

public class Board {
	private ArrayList<Pawn> units= new ArrayList<Pawn>();
	
	
	public void enroll(Pawn pawn) {
		// TODO Auto-generated method stub
		units.add(pawn);
	}


	public int getUnitNumbers() {
		// TODO Auto-generated method stub
		return units.size();
	}
	
	public Pawn getUnit(int index){
		return units.get(index);
	}
	
}
