package es.iessaladillo.pedrojoya.bankproducts.productfactory.abstractproductfactory;

import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.Account;
import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.CreditCard;
import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.DebitCard;

public abstract class FamilyProductFactory {

    public abstract Account createAccount();
    public abstract DebitCard createDebitCard();
    public abstract CreditCard createCreditCard();

}
