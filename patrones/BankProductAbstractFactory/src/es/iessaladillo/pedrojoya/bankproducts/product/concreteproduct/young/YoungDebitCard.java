package es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.young;

import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.DebitCard;

public class YoungDebitCard extends DebitCard {

    private static final int COMMISION_PER_OPERATION = 0;

    public YoungDebitCard() {
        super(COMMISION_PER_OPERATION);
    }

    @Override
    public String printDescription() {
        return String.format("Young debit card with commision per operation %d€", getCommisionPerOperation());
    }

}
