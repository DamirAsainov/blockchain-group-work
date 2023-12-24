public class Block {
    private int previousHash;
    private String transaction;

    public Block(String transaction) {
        this.transaction = transaction;
        this.previousHash = 0;
    }

    public int getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(int previousHash) {
        this.previousHash = previousHash;
    }

    public String getTransaction() {
        return transaction;
    }

    public int getBlockHash() {

        return (transaction + previousHash).hashCode();
    }
    public void display(){
        System.out.println("Block Hash: " + getBlockHash() +
                "\nEncrypted Transaction: " + getTransaction());
    }
}