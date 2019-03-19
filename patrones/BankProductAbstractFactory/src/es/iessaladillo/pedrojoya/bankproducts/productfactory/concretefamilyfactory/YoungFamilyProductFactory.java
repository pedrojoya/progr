package es.iessaladillo.pedrojoya.bankproducts.productfactory.concretefamilyfactory;

import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.Account;
import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.CreditCard;
import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.DebitCard;
import es.iessaladillo.pedrojoya.bankproducts.productfactory.abstractproductfactory.FamilyProductFactory;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.young.YoungAccount;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.young.YoungCreditCard;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.young.YoungDebitCard;

public class YoungFamilyProductFactory extends FamilyProductFactory {

    @Override
    public Account createAccount() {
        return new YoungAccount();
    }

    @Override
    public DebitCard createDebitCard() {
        return new YoungDebitCard();
    }

    @Override
    public CreditCard createCreditCard() {
        return new YoungCreditCard();
    }

}
