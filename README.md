# Pencil Game Bot

This project contains a simple Java console application that simulates a pencil-taking game. The game is played with an arbitrary number of pencils, and players take turns taking 1, 2, or 3 pencils until no pencils are left. The player who takes the last pencil loses the game. The bot (Jack) is programmed to follow a winning strategy whenever possible.

## Game Rules

- The game starts with a number of pencils determined by the user.
- Two players take turns; each player can take 1, 2, or 3 pencils on their turn.
- The player forced to take the last pencil loses the game.
- If the bot starts in a winning position, it will always win by following a specific strategy.

## Strategy

The bot's strategy is to always leave a multiple of 4 pencils to the opponent. If the bot finds itself in a position where the number of pencils is already a multiple of 4, it will take 1 pencil in the hope that the opponent makes a mistake.

## Installation

To run this game, you will need a Java Runtime Environment (JRE) installed on your machine.

1. Clone this repository to your local machine.
2. Navigate to the directory containing the project files.
3. Compile the Java code using `javac Main.java`.
4. Run the compiled code with `java Main`.

## Usage

When you run the program, it will prompt you for the initial number of pencils and who will take the first turn. Input the number of pencils and the chosen player's name when prompted.

## Contributing

Contributions to this project are welcome. To contribute:

1. Fork the repository.
2. Create a new branch for your feature (`git checkout -b feature/fooBar`).
3. Commit your changes (`git commit -am 'Add some fooBar'`).
4. Push to the branch (`git push origin feature/fooBar`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments

- This project is created for educational purposes as part of a computer science study program.
- Special thanks to the Technical University of Vienna for the inspiration.
