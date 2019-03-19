package es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct;

public abstract class CreditCard extends Product {

    private final int commisionPerOperation;
    private final int maxCredit;

    public CreditCard(int commisionPerOperation, int maxCredit) {
        this.commisionPerOperation = commisionPerOperation;
        this.maxCredit = maxCredit;
    }

    public int getCommisionPerOperation() {
        return commisionPerOperation;
    }

    public int getMaxCredit() {
        return maxCredit;
    }

}
