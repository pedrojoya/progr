package es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.gold;

import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.CreditCard;

public class GoldCreditCard extends CreditCard {

    private static final int COMMISION_PER_OPERATION = 20;
    private static final int MAX_CREDIT = 4000;

    public GoldCreditCard() {
        super(COMMISION_PER_OPERATION, MAX_CREDIT);
    }

    @Override
    public String printDescription() {
        return String.format("Gold credit card with commision per operation %d€ and max credit %d€", getCommisionPerOperation(), getMaxCredit());
    }

}
