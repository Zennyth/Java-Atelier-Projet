package atelier2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import atelier2.nutsAndBolts.PieceSquareColor;

public class ModelFactory {

	public static Collection<PieceModel> createPieceModelCollection() {
		
		//HashSet<PieceModel> pieces = new HashSet<PieceModel>();
		Collection<PieceModel> pieces = new LinkedList<PieceModel>(); // LinkedList est préférable pour manipuler les données
		//Collection<PieceModel> pieces = new ArrayList<PieceModel>(); // ArrayList est préférable pour accéder et stocker les données

		// Cr�ation des pion blancs et ajout dans la collection de pi�ces
		for ( Coord coord : ModelConfig.WHITE_PIECE_COORDS){
			pieces.add(new PawnModel(coord, PieceSquareColor.WHITE));
		}

		// Cr�ation des pions noirs et ajout dans la collection de pi�ces
		for ( Coord coord : ModelConfig.BLACK_PIECE_COORDS){
			pieces.add(new PawnModel(coord, PieceSquareColor.BLACK));
		}
		return pieces;
	}
}
