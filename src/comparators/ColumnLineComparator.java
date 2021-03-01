package comparators;

import java.util.Comparator;

import atelier2.model.PieceModel;

public class ColumnLineComparator implements Comparator<PieceModel> {

	@Override
	public int compare(PieceModel arg0, PieceModel arg1) {
		int columnDiff = arg0.getColonne()-arg1.getColonne();
		int lineDiff = arg0.getLigne()-arg1.getLigne();
		return columnDiff == 0 ? lineDiff : columnDiff;
	}
}
