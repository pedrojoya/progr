package es.iessaladillo.pedrojoya.bankproducts;

import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.Account;
import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.CreditCard;
import es.iessaladillo.pedrojoya.bankproducts.product.abstractproduct.DebitCard;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.gold.GoldAccount;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.gold.GoldCreditCard;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.gold.GoldDebitCard;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.platinum.PlatinumAccount;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.platinum.PlatinumCreditCard;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.platinum.PlatinumDebitCard;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.young.YoungAccount;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.young.YoungCreditCard;
import es.iessaladillo.pedrojoya.bankproducts.product.concreteproduct.young.YoungDebitCard;
import es.iessaladillo.pedrojoya.bankproducts.productfactory.concretefamilyfactory.GoldFamilyProductFactory;
import es.iessaladillo.pedrojoya.bankproducts.productfactory.concretefamilyfactory.PlatinumFamilyProductFactory;
import es.iessaladillo.pedrojoya.bankproducts.productfactory.concretefamilyfactory.YoungFamilyProductFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductFactoryTest {

    private static final int YOUNG_AGE_LIMIT = 20;
    private static final int NORMAL_SALARY_LIMIT = 3000;

    private ProductFactory productFactory;

    @Before
    public void setUp() {
        productFactory = new ProductFactory(new YoungFamilyProductFactory(), new PlatinumFamilyProductFactory(), new GoldFamilyProductFactory());
    }

    // contractAccount

    @Test
    public void shouldYoungNormalSalaryContractYoungAccount() {
        Account product = productFactory.contractAccount(YOUNG_AGE_LIMIT, NORMAL_SALARY_LIMIT);
        assertTrue(product instanceof YoungAccount);
    }

    @Test
    public void shouldYoungWealthySalaryContractYoungAccount() {
        Account product = productFactory.contractAccount(YOUNG_AGE_LIMIT, NORMAL_SALARY_LIMIT + 1);
        assertTrue(product instanceof YoungAccount);
    }

    @Test
    public void shouldAdultNormalSalaryContractPlatinumAccount() {
        Account product = productFactory.contractAccount(YOUNG_AGE_LIMIT + 1, NORMAL_SALARY_LIMIT);
        assertTrue(product instanceof PlatinumAccount);
    }

    @Test
    public void shouldAdultWealthySalaryContractGoldAccount() {
        Account product = productFactory.contractAccount(YOUNG_AGE_LIMIT + 1, NORMAL_SALARY_LIMIT + 1);
        assertTrue(product instanceof GoldAccount);
    }

    // contractDebitCard

    @Test
    public void shouldYoungNormalSalaryContractYoungDebitCard() {
        DebitCard product = productFactory.contractDebitCard(YOUNG_AGE_LIMIT, NORMAL_SALARY_LIMIT);
        assertTrue(product instanceof YoungDebitCard);
    }

    @Test
    public void shouldYoungWealthySalaryContractYoungDebitCard() {
        DebitCard product = productFactory.contractDebitCard(YOUNG_AGE_LIMIT, NORMAL_SALARY_LIMIT + 1);
        assertTrue(product instanceof YoungDebitCard);
    }

    @Test
    public void shouldAdultNormalSalaryContractPlatinumDebitCard() {
        DebitCard product = productFactory.contractDebitCard(YOUNG_AGE_LIMIT + 1, NORMAL_SALARY_LIMIT);
        assertTrue(product instanceof PlatinumDebitCard);
    }

    @Test
    public void shouldAdultWealthySalaryContractGoldDebitCard() {
        DebitCard product = productFactory.contractDebitCard(YOUNG_AGE_LIMIT + 1, NORMAL_SALARY_LIMIT + 1);
        assertTrue(product instanceof GoldDebitCard);
    }

    // contractCreditCard

    @Test
    public void shouldYoungNormalSalaryContractYoungCreditCard() {
        CreditCard product = productFactory.contractCreditCard(YOUNG_AGE_LIMIT, NORMAL_SALARY_LIMIT);
        assertTrue(product instanceof YoungCreditCard);
    }

    @Test
    public void shouldYoungWealthySalaryContractYoungCreditCard() {
        CreditCard product = productFactory.contractCreditCard(YOUNG_AGE_LIMIT, NORMAL_SALARY_LIMIT + 1);
        assertTrue(product instanceof YoungCreditCard);
    }

    @Test
    public void shouldAdultNormalSalaryContractPlatinumCreditCard() {
        CreditCard product = productFactory.contractCreditCard(YOUNG_AGE_LIMIT + 1, NORMAL_SALARY_LIMIT);
        assertTrue(product instanceof PlatinumCreditCard);
    }

    @Test
    public void shouldAdultWealthySalaryContractGoldCreditCard() {
        CreditCard product = productFactory.contractCreditCard(YOUNG_AGE_LIMIT + 1, NORMAL_SALARY_LIMIT + 1);
        assertTrue(product instanceof GoldCreditCard);
    }

}