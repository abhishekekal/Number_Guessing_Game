# Number Guessing Game

## Project Overview

The `Number Guessing Game` is a simple console-based game where players attempt to guess a randomly generated number within a set number of attempts based on their chosen difficulty level. The game is built in Java, demonstrating core concepts such as control flow, random number generation, and file I/O for high-score tracking.

## Environment

- **Language**: Java
- **Minimum Required Version**: JDK 8
- **Dependencies**: No external dependencies
- **Data Storage**: Local file for high-score data

## Project Structure

```plaintext
src/
├── game.java             // Main class controlling the game logic
├── HighScoreManager.java // Manages high-score data storage and retrieval
└── Level.java            // Enum defining difficulty levels and attempt limits
```

## Compilation and Execution

1. **Compilation**  
   Navigate to the `src` folder in your terminal and compile the project with:
   ```bash
   javac *.java
   ```

2. **Execution**  
   Once compiled, run the game with:
   
   ```bash
   java game
   ```

## Features

1. **Difficulty Levels**  
   Players can select from three difficulty levels:
   - **Easy**: 10 attempts
   - **Medium**: 5 attempts
   - **Hard**: 3 attempts

2. **Number Guessing**  
   At the start of each game, the system generates a random number between 1 and 100. The player tries to guess this number within the allowed attempts, receiving hints like "Too High" or "Too Low." On a correct guess, the game displays the number of attempts used and checks if a new high score was set.

3. **Hint System**  
   Midway through the allowed attempts, the game offers a hint to help the player narrow down the target range, including information about proximity and even/odd parity.

4. **Time Tracking**  
   The game tracks the completion time for each round and displays the elapsed time upon completion.

5. **High Score Management**  
   For each difficulty level, the game records the best score (least number of attempts) to a local file. It loads existing scores at startup to provide continuity across sessions.

6. **Replay Option**  
   At the end of each round, players can choose to play again or exit, allowing for multiple attempts within a single session.

## High Score File

High scores are stored in a `highscores.dat` file in key-value format (`difficulty = attempts`). This simple format allows for easy storage and retrieval of high scores across sessions.

This is a solution to a project challenge in [roadmap.sh](https://roadmap.sh/projects/number-guessing-game).
