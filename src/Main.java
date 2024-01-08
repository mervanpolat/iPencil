import java.util.Scanner;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPencils;
        String currentPlayer;
        String opponentPlayer;
        int maxTake = 3; // Default maximum pencils that can be taken
        String difficulty; // Difficulty level

        // Asking the user for the initial number of pencils
        while (true) {
            System.out.println("How many pencils would you like to use:");
            String input = scanner.nextLine();
            try {
                numberOfPencils = Integer.parseInt(input);
                if (numberOfPencils > 0) {
                    break;
                } else {
                    System.out.println("The number of pencils should be positive");
                }
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
            }
        }

        // Asking for maximum number of pencils that can be taken
        System.out.println("Enter the maximum number of pencils that can be taken in one turn (Default is 3):");
        try {
            maxTake = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, continuing with default maximum of 3.");
        }

        // Asking the user to choose the difficulty level
        System.out.println("Choose the difficulty level (easy, medium, hard):");
        difficulty = scanner.nextLine().trim().toLowerCase();

        // Asking the user to enter their name
        System.out.println("Enter your name:");
        currentPlayer = scanner.nextLine().trim();
        opponentPlayer = "Jack"; // Default opponent name

        // Game loop
        while (numberOfPencils > 0) {
            // Displaying the current number of pencils
            System.out.println("|".repeat(numberOfPencils));
            // Announcing whose turn it is
            System.out.println(currentPlayer + "'s turn!");
            // Reading the player's input on how many pencils to take
            int pencilsTaken = 0;
            if ("Jack".equalsIgnoreCase(currentPlayer)) {
                // Jack is the bot
                pencilsTaken = botMove(numberOfPencils, maxTake, difficulty);
                System.out.println(pencilsTaken);
            } else {
                // Human player's turn
                while (true) {
                    String pencilsInput = scanner.nextLine();
                    try {
                        pencilsTaken = Integer.parseInt(pencilsInput);
                        if (pencilsTaken >= 1 && pencilsTaken <= maxTake) {
                            if (pencilsTaken <= numberOfPencils) {
                                break;
                            } else {
                                System.out.println("Too many pencils were taken");
                            }
                        } else {
                            System.out.println("Possible values: '1' to '" + maxTake + "'");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Possible values: '1' to '" + maxTake + "'");
                    }
                }
            }

            // Decrement the number of pencils
            numberOfPencils -= pencilsTaken;

            // Check for winner
            if (numberOfPencils == 0) {
                System.out.println(opponentPlayer + " won!");
                break;
            }

            // Switching turns
            String temp = currentPlayer;
            currentPlayer = opponentPlayer;
            opponentPlayer = temp;
        }

        scanner.close();
    }

    // Method to calculate the bot's move with difficulty
    private static int botMove(int numberOfPencils, int maxTake, String difficulty) {
        if ("easy".equals(difficulty)) {
            // Easy difficulty bot makes random moves
            return new Random().nextInt(Math.min(numberOfPencils, maxTake)) + 1;
        } else if ("hard".equals(difficulty)) {
            // Hard difficulty bot plays optimally
            int pencilsToLeave = (numberOfPencils - 1) % (maxTake + 1);
            return pencilsToLeave == 0 ? 1 : pencilsToLeave; // Leave a multiple of (maxTake+1) pencils
        } else {
            // Medium difficulty or unspecified, slightly less optimal moves
            return Math.max(1, (numberOfPencils - 1) % (maxTake + 1));
        }
    }
}
