import java.util.Arrays;

/**
 * Created by Administrator on 2017/7/1 0001.
 */
public class Matrix {
    private final int center;
    private final int sum;
    private int matrix[][];
    private int x1, x2;
    private int n = 0;
    private int count = 0;

    public Matrix(int n) {

        this.n = n;
        matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = -1;
            }
        }
        center = (int) ((Math.pow(n, 2) + 1) / 2);
        sum = (int) (Math.pow(n, 3) + n) / 2;
    }


    public void remove(int value, int x, int y) {
        if (x > 0 && x < n &&
                y > 0 && y < n) {
            matrix[y][x] = -1;
        }
    }

    /**
     * @param line
     * @return 1 pass 0 验证失败 -1 位数不够
     */

    public int checkLine(int line) {

        int s = 0;
        for (int i = 0; i < matrix[line].length; i++) {
            if (matrix[line][i] == -1) {
                return -1;
            }
            s += matrix[line][i];
        }
        if (s == sum) {
            return 1;
        } else {
            return 0;
        }
    }


    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }

    public boolean checkAll() {
        for (int i = 0; i < matrix.length; i++) {
            int s = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                s += matrix[i][j];
            }
            if (s != sum) {
                return false;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int s = 0;
            for (int j = 0; j < matrix.length; j++) {
                s += matrix[j][i];
            }

            if (s != sum) {
                return false;
            }
        }

        int s = 0;
        for (int i = 0; i < n; i++) {
            s += matrix[n - 1 - i][i];
        }
        if (s != sum) {
            return false;
        }
        return true;
    }

    public void pushValue(int value, int line, int col) throws Exception {


        if (matrix[line][col] == -1) {
            matrix[line][col] = value;
        } else {
            Exception e = new Exception();
            throw e;
        }

    }

    public void remove(int y, int x) {

        matrix[y][x] = -1;
    }

    public int getVale(int y, int x) {

        return matrix[y][x];
    }
}
