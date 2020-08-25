package hackerrank.hard;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * TC : O(n) + Arrays.sort()nlogn
 * SC : O(1)
 */
public class Priyal_CuttingBoards {

	static long boardCutting(long[] cost_y, long[] cost_x) {

		long xSeg = 1, ySeg = 1, sum = 0;
		final long CONSTANT = 1000000007;

		int yLen = cost_y.length, xLen = cost_x.length;

		// IntStream str = IntStream.concat(Arrays.stream(cost_y),
		// Arrays.stream(cost_x));

		Arrays.sort(cost_y);
		Arrays.sort(cost_x);

		xLen--;
		yLen--;

		while (xLen >= 0 && yLen >= 0) {

			long x = cost_x[xLen];
			long y = cost_y[yLen];

			if (y > x) {
				sum = (sum + (y * ySeg)) % CONSTANT;
				xSeg++;
				yLen--;

			} else if (x > y) {
				sum = (sum + (x * xSeg)) % CONSTANT;
				sum = (sum % CONSTANT);
				ySeg++;
				xLen--;
			} else if (y == x) {

				if (yLen > xLen) {
					sum = (sum + (y * ySeg)) % CONSTANT;
					xSeg++;
					yLen--;
				} else {
					sum = (sum + (x * xSeg)) % CONSTANT;
					ySeg++;
					xLen--;
				}

			}

			// System.out.println(sum+" "+xSeg+" "+ySeg+" "+x+" "+y+" "+xLen+" "+yLen);
			// System.out.println(x + " at " + y);
		}

		if (yLen > xLen) {
			while (yLen >= 0) {
				long y = cost_y[yLen];
				sum = (sum + (y * ySeg)) % CONSTANT;
				xSeg++;
				yLen--;
				// System.out.println(" fory " + y);
				// System.out.println(sum+" "+xSeg+" "+ySeg+" Out as "+y+" "+xLen+" "+yLen);
			}
		}

		while (xLen >= 0) {
			long x = cost_x[xLen];
			sum = (sum + (x * xSeg)) % CONSTANT;
			ySeg++;
			xLen--;
			// System.out.println(x + " forx ");
			// System.out.println(sum+" "+xSeg+" "+ySeg+" "+x+" Lopping for "+xLen+"
			// "+yLen);
		}

		if (xLen > yLen) {
			while (yLen >= 0) {
				long y = cost_y[yLen];
				sum = (sum + (y * ySeg)) % CONSTANT;
				xSeg++;
				yLen--;
				// System.out.println(" fory " + y);
				// System.out.println(sum+" "+xSeg+" "+ySeg+" Out as "+y+" "+xLen+" "+yLen);
			}
		}

		return sum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String[] mn = scanner.nextLine().split(" ");

			int m = Integer.parseInt(mn[0]);

			int n = Integer.parseInt(mn[1]);

			long[] cost_y = new long[m - 1];

			String[] cost_yItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < m - 1; i++) {
				int cost_yItem = Integer.parseInt(cost_yItems[i]);
				cost_y[i] = cost_yItem;
			}

			long[] cost_x = new long[n - 1];

			String[] cost_xItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n - 1; i++) {
				int cost_xItem = Integer.parseInt(cost_xItems[i]);
				cost_x[i] = cost_xItem;
			}

			long result = boardCutting(cost_y, cost_x);

			System.out.println(result);
		}

		scanner.close();
	}
}
