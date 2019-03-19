package es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct;

public abstract class Account extends Product {

    private final int commisionRate;

    public Account(int commisionRate) {
        this.commisionRate = commisionRate;
    }

    public int getCommisionRate() {
        return commisionRate;
    }

}
