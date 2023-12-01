package co.chu3la.contractapi.Adapter;



import co.chu3la.contractapi.entities.Transaction;
import co.chu3la.contractapi.model.OBTransaction6;

import java.math.BigDecimal;
import java.util.Date;

public class OBTransactionAdapter {

    public Transaction adapt(OBTransaction6 obTransaction6) {
        Transaction transaction = new Transaction();

        transaction.setAccountNumber(obTransaction6.getAccountId());
        transaction.setType(String.valueOf(obTransaction6.getCreditDebitIndicator()));
        transaction.setCurrency(obTransaction6.getCurrencyExchange().getUnitCurrency());

        Long amount = Long.valueOf(obTransaction6.getAmount().getAmount());
        BigDecimal convertedAmount = BigDecimal.valueOf(amount);
        BigDecimal exchangeRate = obTransaction6.getCurrencyExchange().getExchangeRate();

        transaction.setAmount(Double.valueOf(String.valueOf(convertedAmount.multiply(exchangeRate))));

        transaction.setDate(new Date());
        return transaction;
    }

}
