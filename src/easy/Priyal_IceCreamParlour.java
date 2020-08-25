package hackerrank.easy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
/**
 * brute force O(n^2)
 *
 */
public class Priyal_IceCreamParlour {

	// This method is not working for test case 2.
	static void whatFlavors(int[] cost, int money) {

		List<Integer> list = Arrays.stream(cost).boxed().collect(Collectors.toList());
		int x = 0, y = 0;
		
		for (int i = 0; i < cost.length; i++) {

			int c = cost[i];

			if (c < money) {

				int temp = list.indexOf(c);
				int diff = money - c;

				if (diff == c) {
					list.remove(Integer.valueOf(c));
				}

				if (list.contains(diff)) {

					y = list.indexOf(diff);
					

					if (diff == c)
						y = y + 1;

					x=temp;
					++x;
					++y;
					break;
				}
			}
		}
		System.out.println(x + " " + y);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int money = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] cost = new int[n];

			String[] costItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int costItem = Integer.parseInt(costItems[i]);
				cost[i] = costItem;
			}

			whatFlavorsSu(cost, money);
		}

		scanner.close();
	}

	private static void whatFlavorsSu(int[] cost, int money) {
		
		int x = -1, y = -1,j=0;
		
		for (int i = 0; i < cost.length; i++) {

			int c = cost[i];
			x=i;
			if (c < money) {

				int diff = money - c;

				for ( j = i+1; j < cost.length; j++) {
					
					if(cost[j]==diff) {
						y=j;
						break;
					}
					
				}
				if(j<cost.length)
					break;
			}
		}
		x++;
		y++;
		System.out.println(x + " " + y);
	}
}
