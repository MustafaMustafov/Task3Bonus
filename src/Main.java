import java.util.Scanner;

public class Main {
    public static boolean checkColumns(char[][] matrix) {
        String[] ifNumbersInColumnsEquals = new String[3];
        int flag = 0;
        boolean ifAnyEquals;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[j - 1][i] == matrix[j][i]) {
                    flag++;
                }
            }
            if (flag == 2) {
                ifNumbersInColumnsEquals[i] = "Equals";
            }
            flag = 0;
        }
        ifAnyEquals = ifNumbersInColumnsEquals[0] == "Equals" || ifNumbersInColumnsEquals[1] == "Equals" || ifNumbersInColumnsEquals[2] == "Equals";
        return ifAnyEquals;
    }

    public static boolean checkRows(char[][] matrix) {
        String[] ifNumbersInRowsEquals = new String[3];
        int flag = 0;
        boolean ifAnyEquals;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[i][j - 1] == matrix[i][j]) {
                    flag++;
                }
            }
            if (flag == 2) {
                ifNumbersInRowsEquals[i] = "Equals";
            }
            flag = 0;
        }
        ifAnyEquals = ifNumbersInRowsEquals[0] == "Equals" || ifNumbersInRowsEquals[1] == "Equals" || ifNumbersInRowsEquals[2] == "Equals";
        return ifAnyEquals;
    }

    public static boolean checkDiagonals(char[][] matrix) {
        boolean ifAnyEquals;
        ifAnyEquals = (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]) || (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0]);
        return ifAnyEquals;
    }

    public static void playGame() {
        Scanner scan = new Scanner(System.in);
        char[][] matrix = {{'.', '.', '.'}, {'.', '.', '.'}, {'.', '.', '.'}};
        int a, b, br = 0, countO = 0, countX = 0;
        boolean checkColumns, checkRows, checkDiagonals, winner = true;
        System.out.println("Sea chess");

        while (winner) {
            br++;
            System.out.println("Player 1 input coordinates to put 'o' : ");
            a = scan.nextInt();
            b = scan.nextInt();

            if (a > 2 || b > 2) {
                System.out.println("Enter numbers from 0-2");
                br--;
                continue;
            }
            if (matrix[a][b] != '.') {
                System.out.println("Please choose another coordinates");
                continue;
            }
            matrix[a][b] = 'o';
            countO++;
            for (char[] chars : matrix) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(chars[j] + " ");
                }
                System.out.println();
            }
            if (br > 2) {
                checkColumns = checkColumns(matrix);
                checkRows = checkRows(matrix);
                checkDiagonals = checkDiagonals(matrix);
                if (checkColumns || checkRows || checkDiagonals) {
                    if (countX > countO) {
                        System.out.println("Player 2 wins! ");
                    } else {
                        System.out.println("Player 1 wins!");
                    }
                    winner = false;
                }
            }
            System.out.println("Player 2 input coordinates to put 'x' : ");
            a = scan.nextInt();
            b = scan.nextInt();
            if (a > 2 || b > 2) {
                System.out.println("Enter numbers from 0-2");
                br--;
            }
            if (matrix[a][b] != '.') {
                System.out.println("Please choose another coordinates");
                continue;
            }
            matrix[a][b] = 'x';
            countX++;
            for (char[] chars : matrix) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(chars[j] + " ");
                }
                System.out.println();
            }
            if (br > 2) {
                checkColumns = checkColumns(matrix);
                checkRows = checkRows(matrix);
                checkDiagonals = checkDiagonals(matrix);
                if (checkColumns || checkRows || checkDiagonals) {
                    if (countX > countO) {
                        System.out.println("Player 2 wins! ");
                    } else {
                        System.out.println("Player 1 wins!");
                    }
                    winner = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        playGame();
    }
}