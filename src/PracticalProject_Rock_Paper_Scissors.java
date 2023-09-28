import java.util.Random;
import java.util.Scanner;

public class PracticalProject_Rock_Paper_Scissors {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int counterPlayerPoints = 0;
        int counterComputerPoints = 0;

        boolean finishedGame = false;

        System.out.println("Welcome to the game \"Rock-Paper-Scissors\"!");
        System.out.println("You may start your game in a moment! Just press \"Enter\"! \nIf you'd " +
                "like to end your game just type: \"F\" for \"Finished\"! Best of luck!");

        String start = scanner.nextLine();

        while (true) {
            System.out.print("Choose [r]ock, [p]aper or [s]cissors: ");

            String playerInput = scanner.nextLine();

            if (playerInput.equals("F")) {
                finishedGame = true;
                break;
            }

            if (playerInput.equals("r") || playerInput.equals("rock")) {
                playerInput = "Rock";
            } else if (playerInput.equals("p") || playerInput.equals("paper")) {
                playerInput = "Paper";
            } else if (playerInput.equals("s") || playerInput.equals("scissors")) {
                playerInput = "Scissors";
            } else {
                System.out.printf("Invalid input! Please enter [r]ock, [p]aper or [s]cissors%n%n");
                continue;
            }

            Random randomNumber = new Random();
            int randomNumberByComputer = randomNumber.nextInt(3);
            String computerMove = "";
            switch (randomNumberByComputer) {
                case 0:
                    computerMove = "Rock";
                    break;
                case 1:
                    computerMove = "Paper";
                    break;
                case 2:
                    computerMove = "Scissors";
                    break;
            }

            System.out.printf("The computer chose: %s.%n", computerMove);


            String playerMove = playerInput;
            if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                    (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                    (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
                counterPlayerPoints += 2;
                System.out.println("Luck is on your side. You win!");
            } else if ((playerMove.equals("Scissors") && computerMove.equals("Rock")) ||
                    (playerMove.equals("Rock") && computerMove.equals("Paper")) ||
                    (playerMove.equals("Paper") && computerMove.equals("Scissors"))) {
                counterComputerPoints += 2;
                System.out.println("Out of luck. Computer wins!");
            } else {
                counterPlayerPoints += 1;
                counterComputerPoints += 1;
                System.out.println("Draw. Better luck next time!");
            }

            System.out.printf("%nPlayer's points: %d%nComputer's points: %d%n%n", counterPlayerPoints, counterComputerPoints);
        }

        if (finishedGame) {
            System.out.println("See you soon! Bye :)");
        }
    }
}