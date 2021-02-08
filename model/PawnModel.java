package model;


import java.util.LinkedList;
import java.util.List;

import nutsAndBolts.PieceSquareColor;

public class PawnModel implements PieceModel{

	private Coord coord;
	private PieceSquareColor pieceColor;

	public PawnModel(Coord coord, PieceSquareColor pieceColor) {
		super();

		this.coord = coord;
		this.pieceColor = pieceColor;

	}

	@Override
	public char getColonne() {
		char colonne = ' ';
		
		// TODO Atelier 1

		return colonne;
	}

	@Override
	public int getLigne() {
		int ligne = -1;
		
		// TODO Atelier 1

		return ligne;
	}

	@Override
	public boolean hasThisCoord(Coord coord) {
		boolean hasThisCoord = false;
		
		if(this.coord.equals(coord))
			hasThisCoord = true;
		
		return hasThisCoord;
	}

	@Override
	public PieceSquareColor getPieceColor() {
		PieceSquareColor color = null;
		
		// TODO Atelier 1

		return color;	
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String st = null;

		st = "[" + this.pieceColor.toString().charAt(0) + this.coord.toString() + "]";

		return st;
	}

	@Override
	public void move(Coord coord) {

		this.coord = coord;

	}

	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		boolean ret = false;
		boolean color = false;
		int degree = 1; //Variable indiquant le degrée de liberté de mouvement d'un pion (il passe à 2 si il capture un pion)
		
		//On test si la couleur du pion est noire, on test ensuite si les pions avancent et ne reculent pas
		if(this.pieceColor == PieceSquareColor.BLACK) {
			if(this.coord.getLigne() > targetCoord.getLigne()) {
				color = true;
			}
		} else {
			if(this.coord.getLigne() < targetCoord.getLigne()) {
				color = true;
			}
		}
		
		if(isPieceToCapture) {
			degree = 2;
		}
		
		if(Coord.coordonnees_valides(targetCoord)) {
			if((Math.abs(this.coord.getLigne() - targetCoord.getLigne()) + Math.abs(this.coord.getColonne() - targetCoord.getColonne()))/2 == degree)
				ret = true;
		}

		return ret && color;
	}

	@Override
	public List<Coord> getCoordsOnItinerary(Coord targetCoord) {

		List<Coord> coordsOnItinery = new LinkedList<Coord>(); 

		// TODO Atelier 2

		return coordsOnItinery;
	}

	
}

