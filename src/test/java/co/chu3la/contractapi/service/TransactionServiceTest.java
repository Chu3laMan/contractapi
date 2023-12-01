package co.chu3la.contractapi.service;



import co.chu3la.domain.Transaction;
import co.chu3la.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @Mock
    TransactionRepository transactionRepository;

    @InjectMocks
    TransactionService transactionService;

    private Transaction transaction;

    @BeforeEach
    public void setup() {
        transaction = new Transaction();
        transaction.setType("Bank Transaction");
        transaction.setDate(new Date());
        transaction.setAmount("1000");
        transaction.setCurrency("USD");
        transaction.setAccountNumber("123456789");
    }

    @DisplayName("JUnit test for Getting transaction by ID ")
    @Test
    public void givenTransactionObject_whhenFindById_thenTransactionObject() {
        //given - precondition
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction);

        BDDMockito.given(transactionService.getAllTransactions(transaction.accountNumber())).willReturn(transactions);

        //when - action or the behavior that we are going to test
        List<Transaction> foundTransaction = transactionRepository.findAllByAccountNumber(transaction.accountNumber());
        //then - verify output
        assertThat(transactions.size()).isNotNull();
    }

}
