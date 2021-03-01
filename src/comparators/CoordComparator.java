package comparators;

import java.util.Comparator;

import atelier2.model.Coord;
import atelier2.model.PieceModel;

public class CoordComparator implements Comparator<PieceModel> {

	@Override
	public int compare(PieceModel arg0, PieceModel arg1) {
		Coord thisValue = new Coord((char)arg0.getColonne(), arg0.getLigne());
		Coord oValue = new Coord((char)arg1.getColonne(), arg1.getLigne());
		return thisValue.compareTo(oValue) ;
	}
}
