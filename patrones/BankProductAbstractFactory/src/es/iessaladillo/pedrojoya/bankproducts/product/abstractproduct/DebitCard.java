package es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct;

public abstract class DebitCard extends Product {

    private final int commisionPerOperation;

    public DebitCard(int commisionPerOperation) {
        this.commisionPerOperation = commisionPerOperation;
    }

    public int getCommisionPerOperation() {
        return commisionPerOperation;
    }

}
