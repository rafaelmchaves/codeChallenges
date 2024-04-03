package robots;


/**
 * Given two inputs,
 * <p>
 * First input is the location map, a 2D array
 * <p>
 * | O | E | E | E | X |
 * | E | O | X | X | X |
 * | E | E | E | E | E |
 * | X | E | O | E | E |
 * | X | E | X | E | X |
 * <p>
 * O = Robot, E = Empty, X = blocker
 * <p>
 * Second input is the query. It’s a 1D array consisting of distance to the closest blocker in the order from left, top, bottom and right
 * [2, 2, 4, 1] -> This means distance of 2 to the left blocker, 2 to the top blocker, 4 to the bottom blocker and 1 to the right blocker
 * <p>
 * map boundary is also considered blocker, meaning if the robot hits the boundary it also means it’s hitting the blocker.
 * <p>
 * Task: Write a function that takes these two inputs and returns the index of the robots (if any) that matches the query that we’re looking for.
 * Answer: [[1, 1]]
 * <p>
 * Time-Complexity: O(n * k * (n + k))
 **/
public class Robots {

    public static void main(String[] args) {
        char[][] matrix = {
                {'O', 'E', 'E', 'E', 'X'},
                {'E', 'O', 'X', 'X', 'X'},
                {'E', 'E', 'E', 'E', 'E'},
                {'X', 'E', 'O', 'E', 'E'},
                {'X', 'E', 'X', 'E', 'X'}
        };

        testSolution(matrix, new int[] {2,2,4,1});

        testSolution(matrix, new int[] {2,2,1,3});
    }

    private static void testSolution(char[][] matrix, int[] query) {
        int[] result = solution(matrix, query);
        if (result != null) {
            System.out.println("(" + result[0] + ", " + result[1] + ")");
        } else {
            System.out.println("Solution was not found");
        }
    }

//    O(xSize * ySize)
    static int[] solution(char[][] matrix, int[] query) {

        int xSize = matrix[0].length;
        int ySize = matrix.length;

        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                if (matrix[i][j] == 'O') {
                    int left = j - query[0];
                    int top = i - query[1];
                    int bottom = i + query[2];
                    int right = j + query[3];

                   if (
                       (left >= -1 && (left == -1 || matrix[i][left] == 'X'))
                       && (top >= -1 && (top == -1 || matrix[top][j] == 'X'))
                       && (right <= xSize + 1 && (right == xSize  || matrix[i][right] == 'X'))
                       && (bottom <= ySize + 1 && (bottom == ySize || matrix[bottom][j] == 'X'))
                   ) {
                       return new int[] {i, j};
                   }
                }
            }
        }

        return null;
    }
    
}
