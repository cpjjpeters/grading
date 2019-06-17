package be.ipeters.designpatterns.grading;

public interface GradingScheme {
	LetterGrade convert(float percent);
}
