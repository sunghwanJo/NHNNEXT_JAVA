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
	public StringBuilder boardShape = new StringBuilder();
	
	static Piece blankPiece = Piece.noPiece();	
	
	private Board(){	}
	
	public static Board createBoard(){
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
					
				}
			}else if(i==1){
				Piece pawn=Piece.createWhite(Piece.Type.PAWN);	
				for(int j=0; j<8; j++){
					horseLists[i].add(pawn);
					
				}
			}else if(i == 6){
				Piece pawn=Piece.createBlack(Piece.Type.PAWN);
				for(int j=0; j<8; j++){
					horseLists[i].add(pawn);
					
				}
			}else if(i == 7){
				for(Piece.Type type : SpecialPiece){
					Piece piece = Piece.createBlack(type);
					horseLists[i].add(piece);
					
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

	public int getPieceNumbers() {
		int sum=0;
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(horseLists[i].get(j).getType() != Piece.Type.NO_PIECE)
					sum++;
			}
		}
		
		return sum;
	}
		
}
