package es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.platinum;

import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.DebitCard;

public class PlatinumDebitCard extends DebitCard {

    private static final int COMMISION_PER_OPERATION = 0;

    public PlatinumDebitCard() {
        super(COMMISION_PER_OPERATION);
    }

    @Override
    public String printDescription() {
        return String.format("Platinum debit card with commision per operation %d€", getCommisionPerOperation());
    }

}
