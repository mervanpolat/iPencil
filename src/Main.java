import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPencils;
        String currentPlayer;
        String opponentPlayer;

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

        // Asking the user to choose who will go first
        while (true) {
            System.out.println("Who will be the first (John, Jack):");
            currentPlayer = scanner.nextLine().trim();
            if ("John".equalsIgnoreCase(currentPlayer)) {
                opponentPlayer = "Jack";
                break;
            } else if ("Jack".equalsIgnoreCase(currentPlayer)) {
                opponentPlayer = "John";
                break;
            } else {
                System.out.println("Choose between 'John' and 'Jack'");
            }
        }

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
                pencilsTaken = botMove(numberOfPencils);
                System.out.println(pencilsTaken);
            } else {
                // Human player's turn
                while (true) {
                    String pencilsInput = scanner.nextLine();
                    try {
                        pencilsTaken = Integer.parseInt(pencilsInput);
                        if (pencilsTaken >= 1 && pencilsTaken <= 3) {
                            if (pencilsTaken <= numberOfPencils) {
                                break;
                            } else {
                                System.out.println("Too many pencils were taken");
                            }
                        } else {
                            System.out.println("Possible values: '1', '2' or '3'");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Possible values: '1', '2' or '3'");
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

    // Method to calculate the bot's move
    private static int botMove(int numberOfPencils) {
        // The bot's strategy to always leave a multiple of 4 pencils
        int pencilsToLeave = (numberOfPencils - 1) % 4;
        if (pencilsToLeave == 0) {
            // If we're in a losing position (a multiple of 4), take 1 pencil
            return 1;
        }
        return pencilsToLeave; // Otherwise, leave a multiple of 4
    }
}
