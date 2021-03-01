package atelier2.model;

import java.util.LinkedList;
import java.util.List;

import atelier2.nutsAndBolts.PieceSquareColor;

public abstract class AbstractPieceModel implements PieceModel {
	
	protected Coord coord;
	protected PieceSquareColor pieceColor;
	
	public AbstractPieceModel(Coord coord, PieceSquareColor pieceColor) {
		this.coord = coord; 
		this.pieceColor = pieceColor;
	}

	@Override
	public char getColonne() {
		return this.coord.getColonne();
	}
	
	@Override
	public int getLigne() {
		return this.coord.getLigne();
	}
	

	@Override
	public boolean hasThisCoord(Coord coord) {
		return this.coord.equals(coord);
	}

	@Override
	public void move(Coord coord) {
		this.coord = coord;
	}

	@Override
	public PieceSquareColor getPieceColor() {
		return this.pieceColor;
	}

	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Coord> getCoordsOnItinerary(Coord targetCoord) {
		
		List<Coord> coordsOnItinery = new LinkedList<Coord>(); 
		int initCol = this.getColonne();
		int initLig = this.getLigne();
		int colDistance = targetCoord.getColonne() - this.getColonne();
		int ligDistance = targetCoord.getLigne() - this.getLigne();
		int deltaLig = (int) Math.signum(ligDistance);
		int deltaCol = (int) Math.signum(colDistance);

		// V�rif d�placement en diagonale
		if (Math.abs(colDistance) == Math.abs(ligDistance)){

			// recherche coordonn�es des cases travers�es
			for (int i = 1; i < Math.abs(colDistance); i++) {
				Coord coord = new Coord((char) (initCol + i*deltaCol), initLig + i*deltaLig);
				coordsOnItinery.add(coord);
			}
		}
		return coordsOnItinery;
	}
	
	@Override
	public int compareTo(PieceModel o) {
		Coord thisValue = this.coord;
		Coord oValue = new Coord((char)o.getColonne(), o.getLigne());
		return thisValue.compareTo(oValue) ;
	}

}
