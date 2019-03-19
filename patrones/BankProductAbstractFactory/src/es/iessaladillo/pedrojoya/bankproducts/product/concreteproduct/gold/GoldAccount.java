package es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.gold;

import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.Account;

public class GoldAccount extends Account {

    private static final int COMMISION_RATE = 3;

    public GoldAccount() {
        super(COMMISION_RATE);
    }

    @Override
    public String printDescription() {
        return String.format("Gold account with commision rate %d%%", getCommisionRate());
    }

}
