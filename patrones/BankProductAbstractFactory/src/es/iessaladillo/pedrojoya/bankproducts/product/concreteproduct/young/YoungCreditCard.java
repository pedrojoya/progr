package es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.young;

import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.CreditCard;

public class YoungCreditCard extends CreditCard {

    private static final int COMMISION_PER_OPERATION = 0;
    private static final int MAX_CREDIT = 600;

    public YoungCreditCard() {
        super(COMMISION_PER_OPERATION, MAX_CREDIT);
    }

    @Override
    public String printDescription() {
        return String.format("Young credit card with commision per operation %d€ and max credit %d€", getCommisionPerOperation(), getMaxCredit());
    }

}
