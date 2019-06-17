package be.ipeters.designpatterns.grading;
import com.google.common.collect.ImmutableList;

public class ConventionalGrading implements GradingScheme{
	

	private static final ImmutableList<Float> RANGE_BOTTOMS = ImmutableList.of(0.9f,0.8f, 0.7f, 0.65f);
	
	public LetterGrade convert(float percent) {
		for (int i = 0;i<LetterGrade.values().length -1;i++) {
			float rangeBottom = RANGE_BOTTOMS.get(i);
			if(percent>= rangeBottom) {
				return LetterGrade.values()[i];
			}
		}
		return LetterGrade.F;
	}
	@Override
	public String toString() {
		return "ConventionalGrading" ;
	}
}
