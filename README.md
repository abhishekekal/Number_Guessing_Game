# Number Guessing Game 🎲  

The **Number Guessing Game** is a simple and engaging console-based game where players try to guess a randomly generated number within a limited number of attempts, based on the chosen difficulty level. This project demonstrates core Java programming concepts like control flow, random number generation, and file I/O for high-score management.  

---

### Features ✨

- **Difficulty Levels**  
  Players can select from three difficulty levels:  
  - **Easy**: 10 attempts  
  - **Medium**: 5 attempts  
  - **Hard**: 3 attempts  

- **Number Guessing**  
  - Random number between 1 and 100 is generated at the start of each game.  
  - Feedback is provided for each guess (`Too High`, `Too Low`).  

- **Hint System**  
  - A hint is provided midway through the attempts to help narrow down the range.  

- **Time Tracking**  
  - Completion time for each round is recorded and displayed upon completion.  

- **High Score Management**  
  - Records the least number of attempts for each difficulty level in a local file (`highscores.dat`).  
  - Loads and displays high scores at the start of the game.  

- **Replay Option**  
  - Players can replay or exit after each round.  

---

## Project Structure 📂  

```plaintext  
src/  
├── game.java             // Main class controlling the game logic  
├── HighScoreManager.java // Manages high-score data storage and retrieval  
└── Level.java            // Enum defining difficulty levels and attempt limits
``` 
## Environment 🛠️
**Language: Java**
**Minimum Required Version: JDK 8**
**Dependencies: No external dependencies**
**Data Storage: Local file (highscores.dat) for high-score data**



### Getting Started 🚀
🖥️ Compilation
  1. Open a terminal and navigate to the src folder.
  2. Compile the Java files using:
     ``` javac *.java ```

 
 
### How to Play 🎮
1. Start the game by selecting a difficulty level.
2. Guess the number based on the hints provided.
3. Try to guess the number within the allotted attempts.
4. View your completion time and check if you've set a new high score!
5. Choose to replay or exit.

   
### High Score File 📈
The high scores are stored in a local file named highscores.dat in key-value format:
```
difficulty = attempts
```  
For example:
```
Easy = 4  
Medium = 3  
Hard = 2  
This file ensures high scores persist across game sessions.
````

### Contact 📧
For feedback, suggestions, or inquiries:

Email: ekalabhishek4@gmail.com


