package be.ipeters.designpatterns.grading;
import com.google.common.base.Preconditions;
import com.google.common.collect.Range;

class SpecificationsGrading  implements GradingScheme{  //implements GradingScheme
	private static final Range<Float> VALID_THRESHOLD_RANGE = Range.closed(0f,1f);
	
	private final float threshold;
	
	public SpecificationsGrading(float threshold) {
		Preconditions.checkArgument(VALID_THRESHOLD_RANGE.contains(threshold));
		this.threshold= threshold;
	}

	public LetterGrade convert(float percent) {
			if(percent>= threshold) {
				return LetterGrade.A;
			}
			else {
				return LetterGrade.F;
		}
		
	}
	@Override
	public String toString() {
		return "Specifications ("+threshold + ")" ;
	}
}
