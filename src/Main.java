import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Block> blockchain = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        Date date = new Date();

        while (true) {
            System.out.println("Do you want to create a new block? (y / n): ");
            String choice = sc.next();

            if (choice.equals("y")) {
                sc.nextLine();
                System.out.println("Write a data about a transaction: ");
                String data = sc.nextLine();
                String[] transactions = {data};

                if (blockchain.isEmpty()) {
                    blockchain.add(new Block(0, transactions));
                } else {
                    blockchain.add(new Block(blockchain.get(blockchain.size() - 1).getBlockHash(), transactions));
                }
                System.out.println("The block was successfully added!");
                System.out.println();
            } else if (choice.equals("n")) {
                break;
            } else {
                System.out.println("Choose a valid option.");
            }
        }
    }
}