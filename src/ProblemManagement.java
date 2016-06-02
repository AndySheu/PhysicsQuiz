
import java.util.ArrayList;

public class ProblemManagement {
    private static ArrayList<Problem> problems = new ArrayList<Problem>();
    private static Problem problem;
    private static int question = 0;
    
  //@formatter:off
    // Sets everything. Call this or everything will throw errors
    public static void init() {
	problem = new Problem("What unit are charges measured in?", "Coulomb", "Volt", "Ampere", "Newton", "Watt", "Coulomb", "");
	problems.add(problem);
	problem = new Problem("What unit are electric potentials measured in?", "Coulomb", "Volt", "Ampere", "Teslas", "Watt", "Volt", "");
	problems.add(problem);
	problem = new Problem("What unit is current measured in?", "Farad", "Volt", "Ampere", "Ohm", "Watt", "Ampere", "");
	problems.add(problem);
	problem = new Problem("What unit is resistance measured in?", "Coulomb", "Volt", "Ampere", "Ohm", "Watt", "Ohm", "");
	problems.add(problem);
	problem = new Problem("What unit is power measured in?", "Coulomb", "Volt", "Ampere", "Teslas", "Watt", "Watt", "");
	problems.add(problem);
	problem = new Problem("What unit is capacitance measured in?", "Coulomb", "Farad", "Ampere", "Ohm", "Watt", "Farad", "");
	problems.add(problem);
	problem = new Problem("Three charges from left to right, A, B, and C, exist in a region of space. Charge A attracts B and B repels C. If A is positive, what is the sign of charge C?", "Positive", "Negative", "Left", "Right", "Neutral", "Negative", "A is positive and attracts B so B is negative. B repels C so C is also negative.");
	problems.add(problem);
	problem = new Problem("Three charges from left to right, A, B, and C, exist in a region of space. Charge A attracts B and B repels C. If A is negative, what is the sign of charge C?", "Positive", "Negative", "Left", "Right", "Neutral", "Positive", "A is negative and attracts B so B is positive. B repels C so C is also positive.");
	problems.add(problem);
	problem = new Problem("Two charged particles are identical other than their charge. One is (-∞,0) C and the other is (0,∞) C. What interaction do they undergo?", "Attraction", "Repulsion", "Explosion", "Nothing", "Magnetism", "Attraction", "Opposite charges attract.");
	problems.add(problem);
	problem = new Problem("Two charged particles are identical other than their charge. One is (-∞,0) C and the other is (-∞,0) C. What interaction do they undergo?", "Attraction", "Repulsion", "Explosion", "Nothing", "Magnetism", "Repulsion", "Same-sign charges repulse.");
	problems.add(problem);
	problem = new Problem("Two charged particles are identical other than their charge. One is (0,∞) C and the other is (0,∞) C. What interaction do they undergo?", "Attraction", "Repulsion", "Explosion", "Nothing", "Magnetism", "Repulsion", "Same-sign charges repulse.");
	problems.add(problem);
	problem = new Problem("Two charges (q_1 and q_2) are separated by a distance r. What happens to force F if the charge on q_1 is doubled?", "0.25 F", "0.5 F", "1 F", "2 F", "4 F", "2 F", "F=(kq_1q_2)/d^2");
	problems.add(problem);
	problem = new Problem("Two charges (q_1 and q_2) are separated by a distance r. What happens to force F if the charge on q_2 is halved?", "0.25 F", "0.5 F", "1 F", "2 F", "4 F", "0.5 F", "F=(kq_1q_2)/d^2");
	problems.add(problem);
	problem = new Problem("Two charges (q_1 and q_2) are separated by a distance r. What happens to force F if the distance is doubled?", "0.25 F", "0.5 F", "1 F", "2 F", "4 F", "0.25 F", "F=(kq_1q_2)/d^2");
	problems.add(problem);
	problem = new Problem("Two charges (q_1 and q_2) are separated by a distance r. What happens to force F if the charge on q_1 is halved and the distance is halved?", "0.25 F", "0.5 F", "1 F", "2 F", "4 F", "2 F", "F=(kq_1q_2)/d^2");
	problems.add(problem);
    }
  //@formatter:on
    
    public static Problem getProblem() {
	if (question < 10) { // Sets first 3 questions always (in order).
	    question++;
	    return problems.get(question - 1).randomize();
	} else {
	    return problems.get((int) (Math.random() * problems.size())).randomize();
	}
    }
}
