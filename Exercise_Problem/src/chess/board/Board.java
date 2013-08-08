package chess.board;

import java.util.ArrayList;

import org.omg.CORBA.NO_PERMISSION;

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
	
	static Piece blankPiece = Piece.create(Piece.Color.BLANK, Piece.BLANK_REPRESENTATION, Piece.Type.NO_PIECE );	
	
	public Board(){	}
	
	public Board createBoard(){
		Board board = new Board();
		
		board.initialize();
		
		return board;
	}
	
	public void initialize(){
		Piece.Type SpecialPiece[] = {Piece.Type.ROOK, Piece.Type.KNIGHT, Piece.Type.BISHOP,
				Piece.Type.QUEEN, Piece.Type.KING, Piece.Type.BISHOP, Piece.Type.KNIGHT, Piece.Type.ROOK}; 
		
		for(int i=0; i<horseLists.length; i++){
			horseLists[i] = new ArrayList<Piece>();
		}
		
		for(int i=0; i<8; i++){
			if(i==0){
				for(Piece.Type type : SpecialPiece){
					Piece piece = Piece.createWhite(type);
					horseLists[i].add(piece);
					this.enroll(piece);
				}
			}else if(i==1){
				Piece pawn=Piece.createWhite(Piece.Type.PAWN);	
				for(int j=0; j<8; j++){
					horseLists[i].add(pawn);
					this.enroll(pawn);
				}
			}else if(i == 6){
				Piece pawn=Piece.createBlack(Piece.Type.PAWN);
				for(int j=0; j<8; j++){
					horseLists[i].add(pawn);
					this.enroll(pawn);
				}
			}else if(i == 7){
				for(Piece.Type type : SpecialPiece){
					Piece piece = Piece.createBlack(type);
					horseLists[i].add(piece);
					this.enroll(piece);
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
