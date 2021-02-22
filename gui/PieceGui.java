package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Coord;
import nutsAndBolts.PieceSquareColor;


/**
 * @author francoise.perrin
 * 
 * Cette classe permet de donner une image aux pi�ces
 *
 */

public class PieceGui extends ImageView implements CheckersPieceGui {
	
	// ToDo Atelier 2
	private PieceSquareColor pieceColor;
	
	public PieceGui(PieceSquareColor pieceColor) {
		super();

		this.pieceColor = pieceColor;

	} 
	
	@Override
	public void promote(Image image) {
		
		// ToDo Atelier 2, utile pour Atelier 3
		this.setImage(image);
		
	}

	@Override
	public boolean hasSameColorAsGamer(PieceSquareColor gamerColor) {

		// ToDo Atelier 2, utile pour Atelier 4
		
		return gamerColor == this.pieceColor; // � changer 
	}
	
}