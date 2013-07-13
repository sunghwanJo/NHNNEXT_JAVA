package one.lesson.chess;

import java.util.ArrayList;

import one.lesson.pieces.Pawn;

public class Board {
	private java.util.ArrayList<Pawn> units= new ArrayList<Pawn>();
	
	/**
	 * 체스판에 말을 추가한
	 * @author josunghwan
	 * @param pawn 이 말은 현재 체스판에 추가될 말이
	 */
	public void enroll(Pawn pawn) {
		// TODO Auto-generated method stub
		units.add(pawn);
	}

	/**
	 * 현재 체스판위에있는 말의 수를 알 수 있
	 * @author josungwhan
	 * @return 체스판 위에 있는 말의 수
	 */
	public int getUnitNumbers() {
		// TODO Auto-generated method stub
		return units.size();
	}
	
	/**
	 * 원하는 Index의 말을 얻을 수 있다
	 * @author josunghwan
	 * @param index 인덱스이
	 * @return 말 
	 */
	public Pawn getUnit(int index){
		return units.get(index);
	}
	
}
