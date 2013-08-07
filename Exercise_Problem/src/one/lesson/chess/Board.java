package one.lesson.chess;

import java.util.ArrayList;

import one.lesson.pieces.Pawn;

public class Board {
	public ArrayList<Pawn>[] horseLists= new ArrayList[8];
	public ArrayList<Pawn> units= new ArrayList<Pawn>();
	public StringBuilder boardShape = new StringBuilder();
	static Pawn blackPawn = new Pawn();
	
	
	public Board(){
		
	}
	
	public Board createBoard(){
		Board board = new Board();
		
		board.initialize();
		
		return board;
	}
	
	public void initialize(){
		for(int i=0; i<horseLists.length; i++){
			horseLists[i] = new ArrayList<Pawn>();
		}
		
		for(int i=0; i<8; i++){
			
			if(i==1){
				Pawn pawn=new Pawn(Pawn.WHITE);
				
				for(int j=0; j<8; j++){
					horseLists[i].add(pawn);
					this.enroll(pawn);
				}
			}else if(i ==6 ){
				Pawn pawn=new Pawn(Pawn.BLACK);
				for(int j=0; j<8; j++){
					horseLists[i].add(pawn);
					this.enroll(pawn);
				}
			}else{
				for(int j=0; j<8; j++){
					horseLists[i].add(new Pawn(Pawn.BLANK));
				}
			}
		}
	}
	
	public void printBoard(){
		boardShape.replace(0, boardShape.toString().length(), "");
		for(int i=0; i<8; i++){
			for(Pawn pawn : horseLists[i]){
				boardShape.append(pawn.printedChar);
			}
			boardShape.append('\n');
		}
		
		System.out.println(boardShape.toString());
	}
	
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
	 * 현재 체스판위에있는 말의 수를 알 수 있다
	 * @author josungwhan
	 * @return 체스판 위에 있는 말의 수
	 */
	public int getUnitNumbers() {
		/*
		int num=0;
		
		for(int i=0; i<8; i++){
			for(Pawn horse : horseLists[i]){
				if(horse.getColor() != Pawn.BLANK){
					num++;
				}
			}
		}*/
		
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
