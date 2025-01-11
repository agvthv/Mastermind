# **Mastermind Game**

Welcome to **Mastermind**, the classic code-breaking game brought to life in Java! Whether you're playing solo or challenging a friend, this version of Mastermind ensures fun, strategic thinking, and a touch of randomness powered by the Random.org API.

---

## **How to Run the Project**
### **Prerequisites**
- **Java 17+**: Ensure you have Java Development Kit (JDK) installed.
- **Maven**: Used to build and run the project.
- A stable internet connection (for Random.org API).

### **Clone the Repository**
```bash
git clone <your-repository-url>
cd Mastermind
```
---
## **Project Overview**
The goal of this project was to implement a backend-focused version of Mastermind with a clean and modular design. This version includes features for both single-player and multiplayer modes, leveraging Java's object-oriented principles and the Random.org API to generate the secret pattern.

---
## **Features**
- 🎮 **Single-Player Mode**: Challenge yourself against the computer's randomly generated 4-digit secret pattern.
- 🤝 **Multiplayer Mode**: Take turns with a friend to guess the pattern. First one to crack the code wins!
- 🧩 **Feedback System**: Get detailed feedback after every guess, including:
  - Correct numbers in the correct positions.
  - Correct numbers but in incorrect positions.
- 🛠️ **Unit Tests**: Comprehensive tests to ensure functionality for:
  - Validating guesses.
  - Ensuring players to stock to the rules of the game

---
## Game Rules
A 4-digit secret pattern is randomly generated (digits range from 0 to 7).
Players take turns guessing the secret pattern.

#### After each guess:
You’ll receive feedback on how many digits are correct and in the correct position.
You’ll also be told how many digits are correct but in the wrong position.

#### The game ends when:
A player correctly guesses the secret pattern.
All attempts are exhausted (10 guesses in single-player, shared in multiplayer).


### Project Structure
```csv
src/
├── main/
│   ├── java/
│   │   ├── mastermind/
│   │   │   ├── Game/
│   │   │   │   ├── Game.java          # Abstract class for common game logic
│   │   │   │   ├── SingleGame.java    # Handles single-player mode
│   │   │   │   ├── MultiGame.java     # Handles multiplayer mode
│   │   │   │   ├── RandomApi.java     # Fetches random patterns using Random.org API
│   │   │   ├── Player/
│   │   │   │   ├── Player.java        # Abstract player class
│   │   │   │   ├── SinglePlayer.java  # Single player-specific implementation
│   │   │   │   ├── MultiPlayer.java   # Multi-player-specific implementation
│   │   │   ├── UI/
│   │   │   │   ├── Menu.java          # Handles game menus and transitions
│   │   │   │   ├── Main.java          # Entry point for the application
├── test/
│   ├── java/
│   │   ├── mastermind/
│   │   │   ├── Game/                  # Unit tests for game logic
│   │   │   ├── Player/                # Unit tests for player classes
```
