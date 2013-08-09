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
	
	private Board(){}
	
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
				boardShape.append(pawn.getRepresentation());
			}
			boardShape.append('\n');
		}
		
		return boardShape.toString();
	}
	
	public int getCountPieces(Piece.Color color, Piece.Type type){;
		int count=0;
		
		for(int i=0; i<8; i++){
			count += getCountPiecesWithCols(color, type, i);
		}
		return count;
	}
	
	public int getCountPiecesWithCols(Piece.Color color, Piece.Type type, int col){
		int count=0;
		Piece piece;
		
		for(int i=0; i<8; i++){
			piece = horseLists[i].get(col);
			if(piece.getType() == type && piece.getColor() == color){
				count++;
			}
		}
		return count;
	}
	
	public int getPieceNumbers() {
		int count=0;
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(horseLists[i].get(j).getType() != Piece.Type.NO_PIECE)
					count++;
			}
		}
		return count;
	}
	
	public double getPointWithColor(Piece.Color color){
		double point=0;
		Piece piece;
	
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				piece = horseLists[i].get(j);
				
				if(piece.getColor() != color)
					continue;
				
				switch(piece.getType()){
					case NO_PIECE: point+= 0;break;
					case PAWN: 
						if(getCountPiecesWithCols(color, Piece.Type.PAWN, j) > 1)
							point +=  0.5;
						else
							point +=  1;
						break;
					case ROOK: point +=  5;break;
					case KNIGHT: point +=  2.5;break;
					case BISHOP: point +=  3;break;
					case QUEEN: point +=  9;break;
					case KING: point +=  100;break;
				}
			}
		}
		
		if(point < 100)
			return -1;//lose game
		point -= 100;
		return point;
	}

	public Piece getPieceWithPosition(String string) {
		Piece piece;
		int row, col;
		
		row = 8-Character.digit(string.charAt(1), 10);
		col = convertCharToIntForChess(string.charAt(0));
		
		piece = horseLists[row].get(col);
		
		return piece;
	}
	
	private int convertCharToIntForChess(char ch){;
		return Character.getNumericValue(ch)-10;
	}

	public void setPieceWithPosition(Piece piece, String string) {
		int row, col;
		
		col = convertCharToIntForChess(string.charAt(0));
		row = 8-Character.digit(string.charAt(1), 10);	
		
		horseLists[row].remove(col);
		horseLists[row].add(col, piece);
	}
}
