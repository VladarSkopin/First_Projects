package BinaryTrees;
import java.util.Scanner;

public class TestingBST {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST<String> binaryTree1 = new BST<>();
        BST<Integer> binaryTree2 = new BST<>();
        BST<Double> binaryTree3 = new BST<>();


        /*
        System.out.println("What type of the input? 1 - String, 2 - int, 3 - double: ");
        int x;
        do {
            x = sc.nextInt();
            switch (x) {
                case 1:
                    binaryTree1 = new BST<String>();
                    break;
                case 2:
                    binaryTree2 = new BST<Integer>();
                    break;
                case 3:
                    binaryTree3 = new BST<Double>();
                    break;
                default:
                    System.out.println("Incorrect input. Try again");
                    break;
            }
        } while ((x != 1) && (x != 2) && (x != 3));
    */

        //System.out.println("Your input will be stored in three separate binary trees: String, int and double");

        System.out.println("What type of the input? 1 - String, 2 - int, 3 - double: ");

        try {
            int x;

            do {
                x = sc.nextInt();

                if ((x != 1) && (x != 2) && (x != 3)) {
                    System.out.println("Wrong input! Try again");
                }
            } while ((x != 1) && (x != 2) && (x != 3));

        String s;
        int ss;
        double sss;

        System.out.println("Insert new elements in the binary tree: (0 - to stop)");
            do {
                String test = sc.next();
            if (test.equals("0")) break;
            if (x == 1) {
                binaryTree1.insert(test);
            } else if (x == 2) {
                binaryTree2.insert(Integer.parseInt(test));
            } else if (x == 3) {
                binaryTree3.insert(Double.parseDouble(test));
            }
        } while (true);



        System.out.println("Ask which element is in the tree: ");

        String ask = sc.next();

        if (x == 1) {
            System.out.println(binaryTree1.search(ask));
        } else if (x == 2) {
            System.out.println(binaryTree2.search(Integer.parseInt(ask)));
        } else if (x == 3) {
            System.out.println(binaryTree3.search(Double.parseDouble(ask)));
        }


        System.out.println("Do you want to know the root of the tree? (Y / N) ");
        char rootKnown = sc.next().charAt(0);
        if (rootKnown == 'Y' || rootKnown == 'y') {
            if (x == 1)
            System.out.println("The root is: " + binaryTree1.getRoot());
            else if (x == 2)
                System.out.println("The root is: " + binaryTree2.getRoot());
            else if (x == 3)
                System.out.println("The root is: " + binaryTree3.getRoot());
        } else if (rootKnown == 'N' || rootKnown == 'n') {
            System.out.println("Ok. No harm in asking ^^");
        } else {
            System.out.println("Huh? o_0");
        }



        System.out.println("Do you want to clear the tree? (Y / N) ");
        char clearKnown = sc.next().charAt(0);

        switch (clearKnown) {
            case 'Y':
            case 'y':
                if (x == 1) {
                    binaryTree1.clear(); break;
                } else if (x == 2) {
                    binaryTree2.clear(); break;
                } else if (x == 3) {
                    binaryTree3.clear(); break;
                }
            case 'N':
            case 'n':
                System.out.println("Ok. Well at least I asked :-)"); break;
            default:
                System.out.println("WHAT? You must be crazy!");
        }


        System.out.println("Done.");

        }
        catch (Exception e) {
            System.out.println("Wrong input!");
        }
    }
}
