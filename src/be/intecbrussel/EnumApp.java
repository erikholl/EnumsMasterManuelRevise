package be.intecbrussel;

import java.util.Scanner;

public class EnumApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter amount for conversion to coins");
        int userAmount = scanner.nextInt();

        getAmountOfCoin(userAmount);
    }

    private static void getAmountOfCoin(int userAmount) {
        Coin[] allCoins = Coin.values(); // coin enum to array
        int amountOfCoin = 0;

        int modulo = 1;
        int i = allCoins.length - 1;
        do {
            if (userAmount == 0) {
                System.out.println("Zero? No coins!"); // throw message if zero

            } else {
                // calculate max of coin[i] in userAmount and what remains
                amountOfCoin = (int) Math.floor(userAmount / allCoins[i].getValue());
                modulo = userAmount % allCoins[i].getValue();

                if (amountOfCoin != 0) { // print only if amount of coins != 0
                    System.out.println(
                            "You need " + amountOfCoin + " " + allCoins[i] + " coin(s).");
                }

                userAmount = modulo; // set amount next iteration to remainder
                i--;
            }
        } while (i >= 0 && modulo != 0); // as long as modulo is not 0,
        // # coins to be calculated
    }
}

