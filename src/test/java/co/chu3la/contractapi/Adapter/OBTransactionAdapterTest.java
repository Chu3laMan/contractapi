package co.chu3la.contractapi.Adapter;

import co.chu3la.contractapi.model.OBActiveOrHistoricCurrencyAndAmount9;
import co.chu3la.contractapi.model.OBCreditDebitCode1;
import co.chu3la.contractapi.model.OBCurrencyExchange5;
import co.chu3la.contractapi.model.OBTransaction6;
import java.time.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.Assert.assertThrows;

public class OBTransactionAdapterTest {

    private OBTransactionAdapter obTransactionAdapter;

    @BeforeEach
    public void setUp() {
        obTransactionAdapter = new OBTransactionAdapter();
    }


    public OBTransaction6 sampleOBTransaction6() {
        OBTransaction6 obTransaction6 = new OBTransaction6();
        obTransaction6.setAccountId("123456789");
        obTransaction6.setCreditDebitIndicator(OBCreditDebitCode1.CREDIT);
        obTransaction6.setCurrencyExchange(new OBCurrencyExchange5());
        BigDecimal exchangeRate = obTransaction6.getCurrencyExchange().getExchangeRate();
        obTransaction6.setAmount(new OBActiveOrHistoricCurrencyAndAmount9().amount("100.00").currency("USD"));
        LocalDateTime dateTime = LocalDateTime.now();
        obTransaction6.setValueDateTime(OffsetDateTime.of(dateTime, ZoneOffset.UTC));
        return  obTransaction6;
    }

    @Test
    public void testNullAmount() {
        OBTransaction6 transaction = sampleOBTransaction6();
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            obTransactionAdapter.adapt(transaction);
        });
    }



}
