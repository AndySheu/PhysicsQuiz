
import java.util.ArrayList;

public class ProblemManagement {
    private static ArrayList<Problem> problems = new ArrayList<Problem>();
    private static Problem problem;
    
    // Sets everything. Call this or everything will throw errors
    public static void init() {
	problem = new Problem("What grade am I going to get on this project?", "A", "B", "C", "D", "F", "A", "I'm Andy.");
	problems.add(problem);

	problem = new Problem("What grade are you going to get on this project?", "A", "B", "C", "D", "F", "F", "You're Dhruv.");
	problems.add(problem);
	
	problem = new Problem("Which of the following will be elected president?", "Trump", "Clinton", "Sanders", "Obama", "Andy", "Andy", "I'm electable...");
	problems.add(problem);
    }
    
    public static Problem getProblem() {
	return problems.get((int) (Math.random() * problems.size())).randomize();
    }
}
