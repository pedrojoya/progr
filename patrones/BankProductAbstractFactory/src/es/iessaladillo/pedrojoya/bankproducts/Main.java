package es.iessaladillo.pedrojoya.bankproducts;

import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.Account;
import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.CreditCard;
import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.DebitCard;
import es.iessaladillo.pedrojoya.bankproducts.productfactory.concretefamilyfactory.GoldFamilyProductFactory;
import es.iessaladillo.pedrojoya.bankproducts.productfactory.concretefamilyfactory.PlatinumFamilyProductFactory;
import es.iessaladillo.pedrojoya.bankproducts.productfactory.concretefamilyfactory.YoungFamilyProductFactory;

public class Main {

    public static void main(String[] args) {
        ProductFactory productFactory = new ProductFactory(
                new YoungFamilyProductFactory(),
                new PlatinumFamilyProductFactory(),
                new GoldFamilyProductFactory());
        // Returns a YoungAccount
        Account account = productFactory.contractAccount(18, 2000);
        System.out.println(account.printDescription());
        // Returns a GoldCreditCard
        CreditCard creditCard = productFactory.contractCreditCard(45, 3500);
        System.out.println(creditCard.printDescription());
        // Returns a PlatinumDebitCard
        DebitCard debitCard = productFactory.contractDebitCard(45, 2000);
        System.out.println(debitCard.printDescription());
    }

}