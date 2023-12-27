
import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        Encryption encryption = new Encryption();
        KeyPair keyPair1 = encryption.generateKeyPair();
        System.out.println("Write word for future sign");
        String sign = sc.nextLine();
        Signature signature = new Signature("lol", keyPair1.getPrivateKey(), keyPair1.getModulus());
        System.out.println("Your sign word '" + sign + "' saved");
        while (!exit) {
            System.out.println("------------------Menu--------------------" +
                    "\n1. New block" +
                    "\n2. Search block by Hash" +
                    "\n3. List all blocks" +
                    "\n4. Quit");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    sc.nextLine();
                    System.out.println("Write data about a transaction: ");
                    String data = sc.nextLine();
                    System.out.println("Write sign word:");
                    sign = sc.nextLine();
                    if(signature.verify(sign, keyPair1.getPublicKey(), keyPair1.getModulus())) {
                        blockchain.addBlock(data);
                    } else{
                        System.out.println("Wrong sign!!!!");
                    }
                    break;
                case "2":
                    sc.nextLine();
                    System.out.println("Write hash: ");
                    Block block = blockchain.searchBlock(Integer.parseInt(sc.nextLine()));
                    block.display();
                    System.out.println("Write private key to decrypt ");
                    System.out.println(encryption.decrypt(block.getTransaction(),new BigInteger(sc.nextLine()),blockchain.getModulus()));
                    break;
                case "3":
                    blockchain.listBlocks();
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    System.out.println("Choose a valid option.");
                    break;

            }
        }
    }
}