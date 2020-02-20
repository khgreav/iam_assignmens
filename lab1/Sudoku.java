import java.util.Scanner;

/* author: xhanak34
 * IAM - assignment 1: sudoku
 */
public class Sudoku {

    public static class Square {
        public int x1, x2, y1, y2;

        public Square(int x, int y) {
            if (x >= 1 && x <= 3) {
                this.x1 = 0;
                this.x2 = 2;
            } else if (x >= 4 && x <= 6) {
                this.x1 = 3;
                this.x2 = 5;
            } else {
                this.x1 = 6;
                this.x2 = 8;
            }

            if (y >= 1 && y <= 3) {
                this.y1 = 0;
                this.y2 = 2;
            } else if (y >= 4 && y <= 6) {
                this.y1 = 3;
                this.y2 = 5;
            } else {
                this.y1 = 6;
                this.y2 = 8;
            }

        }
    }

    public static void main(String[] args) {

        int n = 9; //sudoku dimension
        int i = 0, j = 0, k = 0, l = 0, m = 0;
        int[][] c = new int[n][n]; //sudoku
        StringBuilder sb = new StringBuilder();

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) { //read stdin
            String[] tokens = in.nextLine().split(" ");
            c[Integer.parseInt(tokens[0])-1][Integer.parseInt(tokens[1])-1] = Integer.parseInt(tokens[2]);
        }

        for (i = 0; i < n; i++){
            for (j = 0; j < n; j++) {
                System.out.print(c[i][j]+" ");
            }
            System.out.print("\n");
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (c[i][j] != 0) { //existing number
                    sb.append(i+1).append(j+1).append(c[i][j]+" 0\n");
                    for (k = 0; k < n; k++) { //only one instance per row
                        if (k != j) {
                            sb.append("-"+(i+1)).append(j+1).append(c[i][j]+" -"+(i+1)).append(k+1).append(c[i][j]+" 0\n");
                        }
                    }

                    for (k = 0; k < n; k++) { //only one instance per column
                        if (k != i) {
                            sb.append("-"+(i+1)).append(j+1).append(c[i][j]+" -"+(k+1)).append(j+1).append(c[i][j]+" 0\n");
                        }
                    }

                    Square s = new Square(i+1, j+1);

                    for (k = s.x1; k <= s.x2; k++) { //only one instance per square
                        for (l = s.y1; l <= s.y2; l++) {
                            if (i == k && j == l) {
                                //skip
                            } else {
                                sb.append("-"+(i+1)).append(j+1).append(c[i][j]+ " -"+(k+1)).append(l+1).append(c[i][j]+" 0\n");
                            }
                        }
                    }
                } else { //number does not exist
                    for (k = 1; k <= n; k++) { //possible occurences
                        sb.append(i+1).append(j+1).append(k+" ");
                    }
                    sb.append("0\n");

                    for (k = 0; k < n; k++) { //possible occurence once per row
                        for (l = 1; l <= n; l++) {
                            if (k != j) {
                                sb.append("-" + (i + 1)).append((j + 1)).append(l + " -" + (i + 1)).append(k + 1).append(l + " 0\n");
                            }
                        }
                    }

                    for (k = 0; k < n; k++) { //possible occurence once per column
                        for (l = 1; l <= n; l++) {
                            if (k != i) {
                                sb.append("-" + (i + 1)).append((j + 1)).append(l + " -" + (k + 1)).append(j + 1).append(l + " 0\n");
                            }
                        }
                    }

                    Square s = new Square(i+1, j+1);

                    for (k = s.x1; k <= s.x2; k++) { //possible occurence once per square
                        for (l = s.y1; l <= s.y2; l++) {
                            for (m = 1; m <= n; m++) {
                                if (i == k && j == l) {
                                    //skip
                                } else {
                                    sb.append("-"+(i+1)).append(j+1).append(m+" -"+(k+1)).append(l+1).append(m+" 0\n");
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.print(sb.toString());
    }
}
