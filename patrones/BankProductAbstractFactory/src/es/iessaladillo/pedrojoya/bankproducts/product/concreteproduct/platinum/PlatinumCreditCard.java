package es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.platinum;

import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.CreditCard;

public class PlatinumCreditCard extends CreditCard {

    private static final int COMMISION_PER_OPERATION = 10;
    private static final int MAX_CREDIT = 2000;

    public PlatinumCreditCard() {
        super(COMMISION_PER_OPERATION, MAX_CREDIT);
    }

    @Override
    public String printDescription() {
        return String.format("Platinum credit card with commision per operation %d€ and max credit %d€", getCommisionPerOperation(), getMaxCredit());
    }

}
