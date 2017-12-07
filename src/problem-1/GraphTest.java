
public class GraphTest {


	static int[][] input = new int[][] { { 1, 0, 0, 1, }, { 1, 0, 1, 0, }, { 0, 0, 1, 0, },

	};

	static int m = 3;
	static int n = 4;

	static int islands = 0;


	// 0 - not visited, 1 = visited
	static int[][] input_visited = new int[][] { { 0, 0, 0, 0, }, { 0, 0, 0, 0, }, { 0, 0, 0, 0, },

	};

	public static void main(String[] args) {



		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 4; j++) {




				if (input_visited[i][j] == 1) {
					continue;
				}

				if (input[i][j] == 1) {
					islands++;
				}

				traverse(i, j);

			}
		}

	}

	static void traverse (int startI, int startJ) {
		int k1 = startI+1;
		int k2 = startJ;

		traverseInternal(startI+1, startJ);
		traverseInternal(startI+1, startJ+1);
		traverseInternal(startI+1, startJ+1);


	}

	static void traverseInternal (int k1, int k2) {
		if (input_visited[k1][k2] == 1 || input[k1][k2] == 0) {
			// do nothing
		}

		input_visited[k1][k2] = 1;
		traverse(k1, k2);


	}

}
