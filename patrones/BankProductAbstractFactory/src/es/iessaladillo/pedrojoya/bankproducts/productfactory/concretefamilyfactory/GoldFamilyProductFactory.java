package es.iessaladillo.pedrojoya.bankproducts.productfactory.concretefamilyfactory;

import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.Account;
import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.CreditCard;
import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.DebitCard;
import es.iessaladillo.pedrojoya.bankproducts.productfactory.abstractproductfactory.FamilyProductFactory;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.gold.GoldAccount;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.gold.GoldCreditCard;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.gold.GoldDebitCard;

public class GoldFamilyProductFactory extends FamilyProductFactory {

    @Override
    public Account createAccount() {
        return new GoldAccount();
    }

    @Override
    public DebitCard createDebitCard() {
        return new GoldDebitCard();
    }

    @Override
    public CreditCard createCreditCard() {
        return new GoldCreditCard();
    }

}
