package atelier2.model;


import java.util.LinkedList;
import java.util.List;

import atelier2.nutsAndBolts.PieceSquareColor;

public class PawnModel extends AbstractPieceModel implements Promotable{

	private int direction;
	
	public PawnModel(Coord coord, PieceSquareColor pieceColor) {
		super(coord, pieceColor);
		this.direction = PieceSquareColor.BLACK.equals(this.getPieceColor()) ? -1 : 1;
		
	}
	
	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		boolean ret = false;

		int colDistance = targetCoord.getColonne() - this.getColonne();
		int ligDistance = targetCoord.getLigne() - this.getLigne();
		int deltaLig = (int) Math.signum(ligDistance);
		
		// Cas d'un d�placement en diagonale
		if (Math.abs(colDistance) == Math.abs(ligDistance)){
			
			// sans prise
			if (!isPieceToCapture) {
				if (deltaLig == this.direction && Math.abs(colDistance) == 1) {
					ret = true;
				}
			}
			// avec prise
			else {
				if (Math.abs(colDistance) == 2) {
					ret = true;
				}
			}
		}
		return ret;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " ["+pieceColor.toString().charAt(0) + coord + "]";
	}

	@Override
	public boolean isPromotable() {
		if(this.pieceColor == PieceSquareColor.WHITE && this.coord.getLigne() == 10) {
			return true;
		} else if (this.pieceColor == PieceSquareColor.BLACK && this.coord.getLigne() == 1) {			
			return true;
		}
		return false;
	}

	@Override
	public void promote() {
		throw new UnsupportedOperationException();
	}

}

