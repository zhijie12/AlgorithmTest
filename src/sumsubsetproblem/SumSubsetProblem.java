/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumsubsetproblem;

/**
 *
 * @author ohzj
 */
public class SumSubsetProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] A = { 3, 2, 7, 1};
        int[] solutionA = new int[10];
        int sum = 6;
        
        find(A,0,0,sum,solutionA);
        //Solution is O(2^n)
    }

public static void find(int[] A, int currSum, int index, int sum,
			int[] solution) {
		if (currSum == sum) {
			System.out.println("\nSum found");
			for (int i = 0; i < solution.length; i++) {
				if (solution[i] == 1) {
					System.out.print("  " + A[i]);
				}
			}

		} else if (index == A.length) {
			return;
		} else {
			solution[index] = 1;// select the element
			currSum += A[index];
			find(A, currSum, index + 1, sum, solution);
			currSum -= A[index];	
			solution[index] = 0;// do not select the element
			find(A, currSum, index + 1, sum, solution);
		}
		return;
	}    
}

