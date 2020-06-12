package hackerrank.medium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Priyal_RoadsLibrary {

	private static boolean[] visited;
	private static int count;
	static ArrayList<Integer> adjlist[];

	static long roadsAndLibraries(int ncity, int clib, int croad, int[][] cities) {

		int n = ncity + 1;

		// System.out.println(n);
		visited = new boolean[n];
		adjlist = new ArrayList[n];

		for (int i = 0; i < cities.length; i++) {

			int key = cities[i][0], value = cities[i][1];

			if (adjlist[value] == null)
				adjlist[value] = new ArrayList<Integer>();
			if (adjlist[key] == null)
				adjlist[key] = new ArrayList<Integer>();

			adjlist[value].add(key);
			adjlist[key].add(value);
		}

		long cost = 0;

		for (int i = 1; i < n; i++) {
			if (!visited[i]) {
				count = 0;
				DFSUtil(i);
				if (clib > croad) {
					cost += clib + croad * (count - 1);
				} else {
					cost += clib * count;
				}
			}
		}
		return cost;
	}

	private static void DFSUtil(int ncity) {

		visited[ncity] = true;
		count++;

		ArrayList<Integer> list = adjlist[ncity];

		if (list != null) {

			for (int j = 0; j < list.size(); j++) {
				if (!visited[list.get(j)]) {
					DFSUtil(list.get(j));
				}
			}
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String[] nmC_libC_road = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nmC_libC_road[0]);

			int m = Integer.parseInt(nmC_libC_road[1]);

			int c_lib = Integer.parseInt(nmC_libC_road[2]);

			int c_road = Integer.parseInt(nmC_libC_road[3]);

			int[][] cities = new int[m][2];
			int visited[] = new int[n + 1];
			int k = 1;

			for (int i = 0; i < m; i++) {
				String[] citiesRowItems = scanner.nextLine().split(" ");
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				for (int j = 0; j < 2; j++) {
					int citiesItem = Integer.parseInt(citiesRowItems[j]);
					cities[i][j] = citiesItem;

				}
				visited[cities[i][0]] = cities[i][1];
			}

			long result = roadsAndLibraries(n, c_lib, c_road, cities);

			System.out.println(result);
		}

		scanner.close();
	}
}