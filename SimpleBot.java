import java.util.Scanner;

public class SimpleBot {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        greeting();
        guessAge();
        countUserInput();
        test();

        System.out.println("Congratulations, have a nice day!");
    }

    static void greeting() {
        System.out.println("My name is Markiz. \nI was made in 1993.\nWhat is your name?");
        String name = sc.next();
        System.out.println("What a great name, " + name + "!");
    }
    static void guessAge() {
        System.out.println("Let me guess your age." +
                "\nEnter remainders of dividing your age by 3, 5, and 7: ");
        int remainder1 = sc.nextInt();
        int remainder2 = sc.nextInt();
        int remainder3 = sc.nextInt();
        int age = (remainder1 * 70 + remainder2 * 21 + remainder3 * 15) % 105;
        System.out.println("Your age is " + age + ". That's a good time to start programming!");
    }
    static void countUserInput() {
        System.out.println("Now I will prove to you that I can count to any number you want. Enter a number here: ");

        int number = sc.nextInt();
        for (int i = 1; i <= number; i ++) {
            System.out.println(i + "!");
        }
    }

    static void test() {
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods?\n" +
                "1. To repeat a statement multiple times.\n" +
                "2. To decompose a program into several small subroutines.\n" +
                "3. To determine the execution time of a program.\n" +
                "4. To interrupt the execution of a program.");
        int answer = sc.nextInt();
        while (answer != 2) {
            System.out.println("Please, try again.");
            answer = sc.nextInt();
        }

    }
}
