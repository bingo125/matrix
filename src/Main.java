import java.util.TreeSet;

public class Main {

    private final int n;
    private int center = 0;
    private int sum = 0;
    private TreeSet<Integer> set;
    private  Matrix matrix;
    public Main(int n) {
        center = (int) ((Math.pow(n, 2) + 1) / 2);
        sum = (int) (Math.pow(n, 3) + n) / 2;
        set = new TreeSet<>();
        this.n = n ;
        for (int i = 1; i < 2 * center; i++) {
            set.add(i);
        }

        matrix = new Matrix(n);
        for (int i = 0; i < n; i++) {
            int num = center -n / 2 + i;

            try {
                matrix.pushValue(num, i, i);
                removeTree(num);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        run(0, 1);
    }

    private void restoreVale(int line, int col) {
        int value = matrix.getVale(line, col);
        matrix.remove(line, col);
        set.add(value);
    }

    private boolean run(int line , int  col ) {


        if (line == col) {
            if(line <  n -1){
                col ++;
            }else{
                if(matrix.checkAll()){
                    System.out.println(matrix);
                }else{
                    restoreVale(line,col );
                    return false;
                }
            }
        }



        for (int i = 1; i < 2*center -1; i++) {
            int nextL = line;
            int nextC  = col;
            if (set.contains(i)) {
                set.remove(i);

                try {
                    matrix.pushValue(i, line, col);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (col == n -1) {
                    if (matrix.checkLine(line)
                            == 1) {
                        nextL++;
                        nextC = 0;
                    } else {
                        restoreVale(line, col);
                        continue;
                    }
                }else{
                    nextC ++;
                }

                run(nextL, nextC);
                restoreVale(line, col );
            }
        }
        return false;
    }

    private void putTree(int x) {
        set.add(x);
    }

    private void removeTree(int x) {
        set.remove(x);
    }


    public int getCenter() {
        return center;
    }

    public int getSum() {
        return sum;
    }


    public static void main(String[] args) {

        Main m = new Main(3);
        System.out.println(m.getCenter());
        System.out.println(m.getSum());

    }
}
