package es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.gold;

import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.DebitCard;

public class GoldDebitCard extends DebitCard {

    private static final int COMMISION_PER_OPERATION = 5;

    public GoldDebitCard() {
        super(COMMISION_PER_OPERATION);
    }

    @Override
    public String printDescription() {
        return String.format("Gold debit card with commision per operation %d€", getCommisionPerOperation());
    }

}
