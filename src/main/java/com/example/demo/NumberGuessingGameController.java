package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Random;

public class NumberGuessingGameController {
    @FXML
    private TextField guessTextField;
    @FXML
    private Label feedbackLabel;
    @FXML
    private Label attemptsLabel;
    @FXML
    private Label scoreLabel;
    @FXML
    private Button playAgainButton;

    private int generatedNumber;
    private int attemptsLimit = 5;
    private int attempts = 0;
    private int score = 0;

    @FXML
    public void initialize() {
        playGame();
    }

    @FXML
    public void guess() {
        int userGuess = Integer.parseInt(guessTextField.getText());
        checkGuess(userGuess);
        guessTextField.clear();
        if (attempts == attemptsLimit || userGuess == generatedNumber) {
            playAgainButton.setVisible(true);
        }
    }

    @FXML
    public void playAgain() {
        playGame();
        feedbackLabel.setText("");
        attemptsLabel.setText("");
        scoreLabel.setText("");
        playAgainButton.setVisible(false);
    }

    private void playGame() {
        Random random = new Random();
        generatedNumber = random.nextInt(100) + 1;
        attempts = 0;
        //for admin
        System.out.println(generatedNumber);
    }

    private void checkGuess(int guess) {
        attempts++;
        if (guess == generatedNumber) {
            feedbackLabel.setText("Congratulations! You guessed the correct number: " + generatedNumber);
            score += attemptsLimit - attempts + 1;
        } else if (guess < generatedNumber) {
            feedbackLabel.setText("Too low! Try again.");
        } else {
            feedbackLabel.setText("Too high! Try again.");
        }
    }
}
