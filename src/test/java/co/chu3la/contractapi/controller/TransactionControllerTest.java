package co.chu3la.contractapi.controller;


import co.chu3la.contractapi.Integration.AbstractContainerBaseTest;
import co.chu3la.contractapi.entities.Transaction;
import co.chu3la.contractapi.service.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@ContextConfiguration
public class TransactionControllerTest extends AbstractContainerBaseTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TransactionService transactionService;

    @Autowired
    ObjectMapper mapperObject;

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
