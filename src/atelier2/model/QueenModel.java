package atelier2.model;


import java.util.LinkedList;
import java.util.List;

import atelier2.nutsAndBolts.PieceSquareColor;
/**
 * @author francoiseperrin
 *
 *le mode de d�placement et de prise de la reine est diff�rent de celui du pion
 */
public class QueenModel extends AbstractPieceModel {

	public QueenModel(Coord coord, PieceSquareColor pieceColor) {
		super(coord, pieceColor);
	}
	
	//MUTUAL
	
	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		boolean ret = false;

		int colDistance = targetCoord.getColonne() - this.getColonne();
		int ligDistance = targetCoord.getLigne() - this.getLigne();
		int deltaLig = (int) Math.signum(ligDistance);
		
		// Cas d'un d�placement en diagonale
		if (Math.abs(colDistance) == Math.abs(ligDistance)) {
			ret = true;
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

}

