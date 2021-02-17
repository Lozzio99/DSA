import java.util.List;

public class Block {
    private int previous_hash;
    private List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Block(int previous_hash, List<Transaction> transactions) {
        this.previous_hash = previous_hash;
        this.transactions = transactions;
    }

    public int getPrevious_hash() {
        return previous_hash;
    }

    public void setPrevious_hash(int previous_hash) {
        this.previous_hash = previous_hash;
    }

    @Override
    public int hashCode() {
        int result = previous_hash;
        result = 33 * result + (transactions != null ? transactions.hashCode() : 0);
        return result;
    }
}
