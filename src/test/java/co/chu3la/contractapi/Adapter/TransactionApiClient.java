package co.chu3la.contractapi.Adapter;

import co.chu3la.contractapi.entities.Transaction;
import co.chu3la.domain.Transaction;

import java.util.List;

public interface TransactionApiClient {

    public List<Transaction> getTransactionList(String numberAccount);

}
