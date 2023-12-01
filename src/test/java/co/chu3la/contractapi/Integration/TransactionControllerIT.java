package co.chu3la.contractapi.Integration;



import co.chu3la.contractapi.entities.Transaction;
import co.chu3la.contractapi.service.TransactionService;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TransactionControllerIT extends AbstractContainerBaseTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    TransactionService transactionService;

    Transaction transaction;

    @BeforeEach
    public void setup() {
        transaction = new Transaction();
        transaction.setType("Bank Transaction");
        transaction.setDate(new Date());
        transaction.setAmount(1000.0);
        transaction.setCurrency("USD");
        transaction.setAccountNumber(123456789);
    }


    @DisplayName("JUnit Test for getting transaction by ID")
    @Test
    public void givenTransactionObject_whenFindById_thenTransactionObject() throws Exception {
        //given - precondition
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction);
        given(transactionService.findAllTransactions(String.valueOf(transaction.accountNumber()))).willReturn(transactions);

        //when - action or the behavior that we are going to test
        ResultActions resultActions = mockMvc.perform(get("/v1/api/account/{accountNumber}/transactions", transaction.accountNumber()));

        //then - verify output
        resultActions.andExpect(status().isNotFound())
                .andDo(print());

    }




}
