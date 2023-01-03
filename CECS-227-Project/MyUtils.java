public class MyUtils {
  /**
	 * Checks if the inputted value is an integer and 
	 * within the specified range (ex: 1-10)
	 * @param min lower bound of the range.
	 * @param max upper bound of the range.
	 * @return the valid input.
	 */
  public static int randomIntRange(int min, int max) {
    return min + (int)(Math.random() * ((max - min) + 1));
  }
}