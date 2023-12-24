public class Block {
    private int previousHash;
    private String transaction;

    public Block(String transaction) {
        this.transaction = transaction;
        this.previousHash = 0; // Default value, can be improved for a real implementation
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
        // Simple hash calculation for educational purposes
        return (transaction + previousHash).hashCode();
    }
}