package co.chu3la.contractapi.Repository;


import co.chu3la.contractapi.Integration.AbstractContainerBaseTest;
import co.chu3la.contractapi.entities.Transaction;
import co.chu3la.contractapi.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TransactionRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    TransactionRepository transactionRepository;

    Transaction transaction;

    @BeforeEach
    public void setup() {
        transaction = new Transaction();
        transaction.setType("Bank Transaction");
        transaction.setDate(new Date());
        transaction.setAmount(Double.valueOf("1000"));
        transaction.setCurrency("USD");
        transaction.setAccountNumber(Integer.valueOf("123456789"));
    }


    @DisplayName("JUnit Test for getting transaction by ID")
    @Test
    public void givenTransactionObject_whenFindById_thenTransactionObject() {
        //when - action or the behavior that we are going to test
        List<Transaction> transactions = transactionRepository.findTransactionByAccountNumber(String.valueOf(transaction.accountNumber()));
        //then - verify output
        assertEquals(transactions.size(), 0);
    }


}
