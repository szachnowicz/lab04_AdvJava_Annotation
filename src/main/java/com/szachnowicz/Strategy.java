package com.szachnowicz;

import java.util.Random;

public class Strategy {

    public static void main(String[] args) {
        Random random = new Random();
        char[][] elo = new char[3][3];
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(elo.length));
        }

    }

    @Level(level = 0)
    public int[] veryBegginerMethod(char[][] board) {
        int[] move = new int[2];

        Random random = new Random();

        int row = random.nextInt(board.length);
        int col = random.nextInt(board.length);
        while (board[col][row] != '-') {
            row = random.nextInt(board.length);
            col = random.nextInt(board.length);
        }
        move[0] = col;
        move[1] = row;
        return move;
    }

    @Level(level = 1)
    public int[] begginerMethod(char[][] board) {
        int[] move = new int[2];

        Random random = new Random();

        int row = random.nextInt(board.length);
        int col = random.nextInt(board.length);
        while (board[col][row] != '-') {
            row = random.nextInt(board.length);
            col = random.nextInt(board.length);
        }
        move[0] = col;
        move[1] = row;
        return move;
    }

    @Level(level = 2)
    public int[] advancedMethod(char[][] board) {
        int[] move = new int[2];

        Random random = new Random();

        int row = random.nextInt(board.length);
        int col = random.nextInt(board.length);
        while (board[col][row] != '-') {
            row = random.nextInt(board.length);
            col = random.nextInt(board.length);
        }
        move[0] = col;
        move[1] = row;
        return move;
    }

    @Level(level = 3)
    public int[] expertMethod(char[][] board) {
        int[] move = new int[2];
        Random random = new Random();

        int row = random.nextInt(board.length);
        int col = random.nextInt(board.length);
        while (board[col][row] != '-') {
            row = random.nextInt(board.length);
            col = random.nextInt(board.length);
        }
        move[0] = col;
        move[1] = row;
        return move;
    }


}
