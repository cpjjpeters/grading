package be.ipeters.designpatterns.grading;

import com.google.common.collect.*;

public class TriageGrading  implements GradingScheme{

	private static final ImmutableList<Float> RANGE_BOTTOMS =  ImmutableList.of(8f/9, 13f/18, 8f/15, 1f/3);
	
	public LetterGrade convert(float percent) {
		for(int i = 0; i<LetterGrade.values().length -1; i++) {
			float rangeTop = RANGE_BOTTOMS.get(i);
			if(percent > rangeTop) {
				return LetterGrade.values()[i];
			}
		}
		return LetterGrade.F;
	}

	@Override
	public String toString() {
		return "TriageGrading " ;
	}

	
}
