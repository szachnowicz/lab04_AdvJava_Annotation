package com.szachnowicz;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj level trudności : ");
        System.out.println("0 - bardzo  początkujacy");
        System.out.println("1 - początkujacy");
        System.out.println("2 - zaawansowany");
        System.out.println("3 - expert");
        int level = scanner.nextInt();
//        System.out.println("Wybrano " + level + " level ");


        ClassLoader classLoader = Main.class.getClassLoader();
        Class sttrategyClass = null;
        try {
            sttrategyClass = classLoader.loadClass("com.szachnowicz.Strategy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Method methodForStrategy = getMethodForStrategy(level, sttrategyClass);


        TicTacToe game = new TicTacToe();
        while (true)

        {
            System.out.println("Podaj kolumne ");
            int col = scanner.nextInt();
            System.out.println("Podaj rząd ");
            int row = scanner.nextInt();
            game.placeMark(col, row);

            // Lets print the board
            game.printBoard();

            // Did we have a winner?
            if (game.checkForWin()) {
                System.out.println("We have a winner! Congrats!");
                System.exit(0);
            } else if (game.isBoardFull()) {
                System.out.println("Appears we have a draw!");
                System.exit(0);
            }
            // No winner or draw, switch players to 'o'
            game.changePlayer();
            char[][] board = game.getBoard();
            int[] moves;
            try {
                Object invoke = methodForStrategy.invoke(sttrategyClass.newInstance(), new Object[]{board});
                moves = (int[]) invoke;
                game.placeMark(moves[0], moves[1]);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
            game.printBoard();
            game.changePlayer();

        }

    }

    private static Method getMethodForStrategy(int level, Class sttrategyClass) {
        Method[] methods = sttrategyClass.getMethods();
        for (Method method : methods) {
            for (Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation instanceof Level) {
                    {
                        if (((Level) annotation).level() == level) {

                            return method;
                        }

                    }

                }
            }
        }
        return null;
    }
}
