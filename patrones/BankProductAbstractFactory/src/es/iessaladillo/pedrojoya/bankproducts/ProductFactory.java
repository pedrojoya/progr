package es.iessaladillo.pedrojoya.bankproducts;

import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.Account;
import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.CreditCard;
import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.DebitCard;
import es.iessaladillo.pedrojoya.bankproducts.productfactory.abstractproductfactory.FamilyProductFactory;
import es.iessaladillo.pedrojoya.bankproducts.productfactory.concretefamilyfactory.GoldFamilyProductFactory;
import es.iessaladillo.pedrojoya.bankproducts.productfactory.concretefamilyfactory.PlatinumFamilyProductFactory;
import es.iessaladillo.pedrojoya.bankproducts.productfactory.concretefamilyfactory.YoungFamilyProductFactory;

public class ProductFactory {

    private final YoungFamilyProductFactory youngFamilyProductFactory;
    private final PlatinumFamilyProductFactory platinumFamilyProductFactory;
    private final GoldFamilyProductFactory goldFamilyProductFactory;

    public ProductFactory(YoungFamilyProductFactory youngFamilyProductFactory, PlatinumFamilyProductFactory platinumFamilyProductFactory, GoldFamilyProductFactory goldFamilyProductFactory) {
        this.youngFamilyProductFactory = youngFamilyProductFactory;
        this.platinumFamilyProductFactory = platinumFamilyProductFactory;
        this.goldFamilyProductFactory = goldFamilyProductFactory;
    }

    Account contractAccount(int age, int salary) {
        FamilyProductFactory familyProductFactory = selectFamilyFactory(age, salary);
        return familyProductFactory.createAccount();
    }

    DebitCard contractDebitCard(int age, int salary) {
        FamilyProductFactory familyProductFactory = selectFamilyFactory(age, salary);
        return familyProductFactory.createDebitCard();
    }

    CreditCard contractCreditCard(int age, int salary) {
        FamilyProductFactory familyProductFactory = selectFamilyFactory(age, salary);
        return familyProductFactory.createCreditCard();
    }

    // Decides the family to use according to age and salary.
    private FamilyProductFactory selectFamilyFactory(int age, int salary) {
        FamilyProductFactory familyProductFactory;
        if (age < 21) {
            familyProductFactory = youngFamilyProductFactory;
        } else if (salary > 3000) {
            familyProductFactory = goldFamilyProductFactory;
        } else {
            familyProductFactory = platinumFamilyProductFactory;
        }
        return familyProductFactory;
    }

}
