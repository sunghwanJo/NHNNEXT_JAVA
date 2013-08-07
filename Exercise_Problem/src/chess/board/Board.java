package chess.board;

import java.util.ArrayList;

import chess.pieces.Piece;
/**
 * 
 * @author josunghwan
 *
 */
public class Board {
	public ArrayList<Piece>[] horseLists= new ArrayList[8];
	public ArrayList<Piece> units= new ArrayList<Piece>();
	public StringBuilder boardShape = new StringBuilder();
	
	static Piece blankPiece = Piece.create(Piece.BLANK, ".");	
	
	public Board(){	}
	
	public Board createBoard(){
		Board board = new Board();
		
		board.initialize();
		
		return board;
	}
	
	public void initialize(){
		for(int i=0; i<horseLists.length; i++){
			horseLists[i] = new ArrayList<Piece>();
		}
		
		for(int i=0; i<8; i++){
			if(i==0){
				String WhiteSpecialPiece[] = {"r", "n", "b", "q", "k", "b", "n", "r"};
				for(String name : WhiteSpecialPiece){
					Piece pawn = Piece.create(Piece.WHITE, name);
					horseLists[i].add(pawn);
					this.enroll(pawn);
				}
			}else if(i==1){
				Piece pawn=Piece.create(Piece.WHITE, "p");	
				for(int j=0; j<8; j++){
					horseLists[i].add(pawn);
					this.enroll(pawn);
				}
			}else if(i == 6){
				Piece pawn=Piece.create(Piece.BLACK, "P");
				for(int j=0; j<8; j++){
					horseLists[i].add(pawn);
					this.enroll(pawn);
				}
			}else if(i == 7){
				String BlackSpecialPiece[] = {"R", "N", "B", "Q", "K", "B", "N", "R"};
				for(String name : BlackSpecialPiece){
					Piece pawn = Piece.create(Piece.WHITE, name);
					horseLists[i].add(pawn);
					this.enroll(pawn);
				}
			}else{
				for(int j=0; j<8; j++){
					horseLists[i].add(blankPiece);
				}
			}
		}
	}
	
	public String printBoard(){
		boardShape.replace(0, boardShape.toString().length(), "");
		for(int i=0; i<8; i++){
			for(Piece pawn : horseLists[i]){
				boardShape.append(pawn.getName());
			}
			boardShape.append('\n');
		}
		
		return boardShape.toString();
	}
	
	public void enroll(Piece pawn) {
		units.add(pawn);
	}


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
	

	public Piece getUnit(int index){
		return units.get(index);
	}
	
}
