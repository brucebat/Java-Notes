package problem54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/5/2 22:26
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (null == matrix || 0 == matrix.length || 0 == matrix[0].length) {
            return new ArrayList<>();
        }
        // 这道题从思路上和正常的一维问题不同，在矩阵中标识是否访问过可以使用
        // 矩阵中每个对应点位的true或者false来进行标识。同时在进行标识转向时
        // ，可以使用+1或者-1来标识方向为前或者后，左或者右。
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        // 这里进行这样初始化的原因在于遍历的过程是从行开始，然后在按照列进行的
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        int row = 0, column = 0;
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            nums.add(matrix[row][column]);
            visited[row][column] = true;
            // 进行下一个行进方向计算
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return nums;
    }
}
