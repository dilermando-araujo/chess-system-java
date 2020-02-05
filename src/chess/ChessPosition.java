package chess;

import boardgame.Position;

public class ChessPosition {
	private char column;
	private int row;
	
	public ChessPosition(int row, char column) {
		if (column < 'a' || column > 'h' || row < 0 || row > 8) {
			throw new ChessException("Error instantiating chessPositon. Valid values are from a1 to h8.");
		}

		this.row = row;
		this.column = column;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	protected ChessPosition fromPosition(Position position) {
		return new ChessPosition(8 - position.getRow(),(char)('a' + position.getColumn()));
	}
	
	@Override
	public String toString() {
		// Truque para aceitar concatenar em uma string tipos diferentes.
		return "" + column + row;
	}
}
