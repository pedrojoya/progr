package es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.young;

import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.Account;

public class YoungAccount extends Account {

    private static final int COMMISION_RATE = 1;

    public YoungAccount() {
        super(COMMISION_RATE);
    }

    @Override
    public String printDescription() {
        return String.format("Young account with commision rate %d%%", getCommisionRate());
    }

}
