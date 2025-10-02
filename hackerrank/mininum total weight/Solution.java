import java.util.*;

public class Solution {
	public static int findMinWeight(int[] weights, int d) {
		// min heap by default, pass a comparator to make it into a max heap
		// here we make sure that if a/2 >= b/2, then pq
		// will prioritize a to be removed next
		var pq = new PriorityQueue<Integer>((a, b) -> b / 2 - a / 2);

		// add all the weights
		for (var weight : weights) {
			pq.add(weight);
		}
		for (int i = 0; i < d; i++) {
			var largestCurrentChocolateWeight = pq.poll();
			var eatenWeight = largestCurrentChocolateWeight / 2;
			// remove the weight eaten and throw it back in the priority queue
			pq.add(largestCurrentChocolateWeight - eatenWeight);
		}
		// loop through the weights and sum them
		// NOTE: for loop does not loop in priority order,
		// but doesn't matter for this case.
		var sum = 0;
		for (var weight : pq) {
			sum += weight;
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] weights = { 30, 20, 25 };
		var minWeight = Solution.findMinWeight(weights, 4);
		System.out.println(minWeight);
	}
}
