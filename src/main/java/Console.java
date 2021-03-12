import java.util.Scanner;

public class Console {

        public static void print(String output, Object... args) {
            System.out.printf(output, args);
        }

        public static void println(String output, Object... args) {
            print(output + "\n", args);
        }

        public static String getStringInput(String prompt) {
            Scanner scanner = new Scanner(System.in);
            println(prompt);
            String userInput = scanner.nextLine();
            return userInput;
        }

        public static Double getDoubleInput(String prompt) {
            Scanner scanner = new Scanner(System.in);
            println(prompt);
            Double userInput = scanner.nextDouble();
            return userInput;
        }

    public void displayUserNamePrompt(){
        Console.println("--------------------------------");
        Console.println("|   Welcome to ZCW ATM User!   |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("| Please enter your user name: |");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

    public void displayUserPasswordPrompt(String userName){
        Console.println("--------------------------------");
        Console.println("|   Welcome to ZCW ATM User!   |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("  Welcome %s                    ",userName);
        Console.println("| Please enter your password:  |");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

    public void displaySelectAccountScreen(){
        Console.println("--------------------------------");
        Console.println("|   Welcome to ZCW ATM User!   |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("|    Please enter a number:    |");
        Console.println("|    1. Savings Account        |");
        Console.println("|    2. Checking Account       |");
        Console.println("|    3. Investment Account     |");
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

    public void displayAccountOptionsScreen(){
        Console.println("--------------------------------");
        Console.println("|   Welcome to ZCW ATM User!   |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("|    Please enter a number:    |");
        Console.println("|    1. Check Balance          |");
        Console.println("|    2. Withdraw               |");
        Console.println("|    3. Deposit                |");
        Console.println("|    4. Transfer               |");
        Console.println("|    5. Open New Account       |");
        Console.println("|    6. Close Account          |");
        Console.println("|    7. Print Trans. History   |");
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

}
