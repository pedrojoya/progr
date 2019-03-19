package es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.platinum;

import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.Account;

public class PlatinumAccount extends Account {

    private static final int COMMISION_RATE = 2;

    public PlatinumAccount() {
        super(COMMISION_RATE);
    }

    @Override
    public String printDescription() {
        return String.format("Platinum account with commision rate %d%%", getCommisionRate());
    }

}
