package atelier2.model;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import atelier2.nutsAndBolts.PieceSquareColor;
import comparators.ColumnLineComparator;
import comparators.CoordComparator;

/**
 * @author francoise.perrin
 * 
 * Cete classe fabrique et stocke toutes les PieceModel du Model dans une collection 
 * elle est donc responsable de rechercher et mettre � jour les PieceModel (leur position)
 * En r�alit�, elle d�l�gue � une fabrique le soin de fabriquer les bonnes PieceModel 
 * avec les bonnes coordonn�es
 * 
 * En revanche, elle n'est pas responsable des algorithme m�tiers li�s au d�placement des pi�ces
 * (responsabilit� de la classe Model)
 */
public class ModelImplementor {

	// la collection de pi�ces en jeu - m�lange noires et blanches
	private Collection<PieceModel> pieces ;	

	public ModelImplementor() {
		super();

		pieces = ModelFactory.createPieceModelCollection();
	}

	public PieceSquareColor getPieceColor(Coord coord) {
		PieceSquareColor color = null;
		PieceModel piece = this.findPiece(coord);

		if (piece != null) {
			color = piece.getPieceColor();
		}
		return color;
	}

	public boolean isPiecehere(Coord coord) {
		return this.findPiece(coord) != null;
	}

	public boolean isMovePieceOk(Coord initCoord, Coord targetCoord, boolean isPieceToTake) {

		boolean isMovePieceOk = false;
		PieceModel initPiece = this.findPiece(initCoord);
		if (initPiece != null) {
			isMovePieceOk = initPiece.isMoveOk(targetCoord, isPieceToTake ) ;
		}
		return isMovePieceOk;
	}


	public boolean movePiece(Coord initCoord, Coord targetCoord) {

		boolean isMovePieceDone = false;
		PieceModel initPiece = this.findPiece(initCoord);
		if (initPiece != null) {

			// d�placement pi�ce
			initPiece.move(targetCoord) ;
			isMovePieceDone = true;
		}
		return isMovePieceDone;
	}

	public void removePiece(Coord pieceToTakeCoord) {

		PieceModel pieceToTake = this.findPiece(pieceToTakeCoord);
		if (pieceToTake != null) {
			this.pieces.remove(pieceToTake);
		}
	}
	
	private void createQueen(Coord pieceToCreateCoord, PieceSquareColor pieceToCreateColor) {
		PieceModel pieceToCreate = new QueenModel(pieceToCreateCoord, pieceToCreateColor);
		pieces.add(pieceToCreate);
	}
	
	public boolean isPromotable(Coord pieceToPromoteCoord) {
		PieceModel pieceToPromote = this.findPiece(pieceToPromoteCoord);
		if(pieceToPromote instanceof Promotable) {
			if (((Promotable)pieceToPromote).isPromotable()) {
				return true;
			}
		}
		return false;
	}

	
	public List<Coord> getCoordsOnItinerary(Coord initCoord, Coord targetCoord) {
		List<Coord> coordsOnItinerary = null;
		PieceModel initPiece = this.findPiece(initCoord);
		if (initPiece != null) {
			coordsOnItinerary = initPiece.getCoordsOnItinerary(targetCoord) ;
		}

		return coordsOnItinerary;
	}
	
	public void promote(Coord pieceToPromoteCoord) {
		PieceModel pieceToPromote = this.findPiece(pieceToPromoteCoord);
		this.removePiece(pieceToPromoteCoord);
		this.createQueen(pieceToPromoteCoord, pieceToPromote.getPieceColor());
		
	}

	
	/**
	 * @param coord
	 * @return la pi�ce qui se trouve aux coordonn�es indiqu�es
	 */
	private PieceModel findPiece(Coord coord) {		
		PieceModel findPiece = null;

		for(PieceModel piece : this.pieces) {

			if(coord != null && piece.hasThisCoord(coord)) {
				findPiece = piece;
				break;
			}
		}
		return findPiece;
		
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * La m�thode toStrong() retourne une repr�sentation 
	 * de la liste de pi�ces sous forme d'un tableau 2D
	 * 
	 */
	public String toString() {


		String st = "";
//		Collections.sort((List<PieceModel>)this.pieces);
//		ListIterator<PieceModel> piecesList = ((List<PieceModel>)this.pieces).listIterator();
				
		int i=0;
		for(PieceModel piece : this.pieces) {
			if(i%5 == 0) {
				st+="\n";
			}
			st+=piece.toString();
			i++;
		}
		
		
//		int i=0;
//		while(piecesList.hasNext()) {
//			if(i%5 == 0) {
//				st+="\n";
//			}
//			st+=piecesList.next().toString();
//			i++;
//		}
	
		return st;
	}



}
