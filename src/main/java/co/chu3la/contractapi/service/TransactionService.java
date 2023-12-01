package co.chu3la.contractapi.service;

import co.chu3la.contractapi.entities.Transaction;
import co.chu3la.contractapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Transactional
    public List<Transaction> findAllTransactions(String accountNumber) {
        return transactionRepository.findTransactionByAccountNumber(accountNumber);
    }

}
