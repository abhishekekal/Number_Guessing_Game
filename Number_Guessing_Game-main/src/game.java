import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class game {

    public static void main(String[] args) {
        HighScoreManager.loadHighScores();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            start(scanner);
            System.out.print("Would you like to play again (Y/N)? ");
            String next = scanner.next();
            if (!next.equalsIgnoreCase("Y")) {
                scanner.close();
                System.out.println("Thank you for playing! Goodbye...");
                break;
            }
            clearScreen();
        }
        scanner.close();
    }

    private static void start(Scanner scanner) {
        Level level = chooseLevel(scanner);
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;

        clearScreen();
        System.out.println("Great! You have selected the " + level.getName() + " difficulty level.");
        System.out.println("You have " + level.getChances() + " chances to guess the correct number.");
        System.out.println("Let's start the game!\n");

        runGameLoop(scanner, level, targetNumber);
    }

    private static void runGameLoop(Scanner scanner, Level level, int targetNumber) {
        int chances = level.getChances();
        boolean hasGuessedCorrectly = false;
        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= chances; i++) {
            System.out.print("Make your guess: ");
            int guess = Integer.parseInt(scanner.next());

            if (guess == targetNumber) {
                System.out.println("Congratulations! You've guessed the correct number in " + i + " attempts.");
                hasGuessedCorrectly = true;
                HighScoreManager.updateHighScores(level.getName(), i);
                break;
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try a smaller number.");
            } else {
                System.out.println("Too low! Try a larger number.");
            }

            if (i == chances / 2){
                giveHint(targetNumber, guess);
            }

            if (i == chances) {
                System.out.println("You've used all your chances. The correct number was " + targetNumber + ".");
            }
        }

        long endTime = System.currentTimeMillis();
        double timeTaken = (endTime - startTime) / 1000.0;
        System.out.printf("You %s the game in %.2f seconds.\n", hasGuessedCorrectly ? "completed" : "failed to complete", timeTaken);
    }

    private static Level chooseLevel(Scanner scanner) {
        Level level;
        while (true) {
            showMenus();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            Optional<Level> selectedLevel  = Level.getLevelById(choice);

            if (selectedLevel.isPresent()){
                level = selectedLevel.get();
                break;
            }
            System.out.println("Invalid choice. Please select a valid difficulty level.\n");
        }
        return level;
    }


    private static void giveHint(int targetNumber, int guess) {
        if (Math.abs(targetNumber - guess) >20){
            System.out.println("Hint: You're far off! Try a much " + (guess > targetNumber ? "smaller" : "larger") + "number.");
        }else if (Math.abs(targetNumber - guess) > 10){
            System.out.println("Hint: You're getting closer! The number is " + (guess > targetNumber ? "smaller" : "larger") + ".");
        }else {
            System.out.println("Hint: You're very close! Keep going!");
        }

        System.out.println("Hint: The number is " + (targetNumber % 2 == 0 ? "even" : "odd") + ".");
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void showMenus() {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.\n");

        System.out.println("Please select the difficulty level:");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)\n");
    }
}

