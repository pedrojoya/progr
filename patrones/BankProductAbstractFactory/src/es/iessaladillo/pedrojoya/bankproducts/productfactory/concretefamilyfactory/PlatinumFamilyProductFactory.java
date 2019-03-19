package es.iessaladillo.pedrojoya.bankproducts.productfactory.concretefamilyfactory;

import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.Account;
import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.CreditCard;
import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.DebitCard;
import es.iessaladillo.pedrojoya.bankproducts.productfactory.abstractproductfactory.FamilyProductFactory;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.platinum.PlatinumAccount;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.platinum.PlatinumCreditCard;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.platinum.PlatinumDebitCard;

public class PlatinumFamilyProductFactory extends FamilyProductFactory {

    @Override
    public Account createAccount() {
        return new PlatinumAccount();
    }

    @Override
    public DebitCard createDebitCard() {
        return new PlatinumDebitCard();
    }

    @Override
    public CreditCard createCreditCard() {
        return new PlatinumCreditCard();
    }

}
