public class Queens {

    public static void main(String[] args) {
        int n = 8; //number of queens
        int a = 1; //variable used to populate chessboard tiles
        int i = 0, j = 0, k = 0; //rows, columns, cases
        int[][] c = new int[n][n]; //chessboard
        StringBuilder sb = new StringBuilder(); //output buffer

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                c[i][j] = a++; //populate chessboard tiles with identifiers
            }
        }

        sb.append("p cnf "+n+" "+n*n+"\n"); //sat cnf header

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                sb.append(c[i][j]+" "); //there is a queen in each row and column
            }
            sb.append("0\n");

            for (j = 0; j < n; j++) {
                for (k = 0; k < n; k++) {
                    if (k != j) { //only one queen per row
                        sb.append("-"+c[i][j]+" "+"-"+c[i][k]);
                        sb.append(" 0\n");
                    }
                    
                    if (k != i) { //only one queen per column
                        sb.append("-"+c[i][j]+" "+"-"+c[k][j]);
                        sb.append(" 0\n");
                    }
                }

                for (k = 1; k < n; k++) {
                    if ((i + k < n) && (j + k < n)) { //only one queen per main diagonal SE
                        sb.append("-"+c[i][j]+" "+"-"+c[i+k][j+k]);
                        sb.append(" 0\n");
                    }

                    if ((i - k >= 0) && (j - k >= 0)) { //only one queen per main diagonal NW
                        sb.append("-"+c[i][j]+" "+"-"+c[i-k][j-k]);
                        sb.append(" 0\n");
                    }

                    if ((i + k < n) && (j - k >= 0)) { //only one queen per antidiagonal SW
                        sb.append("-"+c[i][j]+" "+"-"+c[i+k][j-k]);
                        sb.append(" 0\n");
                    }

                    if ((i - k >= 0) && (j + k < n)) { //only one queen per antidiagonal NE
                        sb.append("-"+c[i][j]+" "+"-"+c[i-k][j+k]);
                        sb.append(" 0\n");
                    }
                }
            }
        }
        
        System.out.print(sb.toString());
    }
}
