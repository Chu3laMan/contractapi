package co.chu3la.contractapi.controller;

import co.chu3la.contractapi.dto.TransactionDTO;
import co.chu3la.contractapi.entities.Transaction;
import co.chu3la.contractapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RequestMapping("/api/v1")
@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/{accountNumber}")
    public ResponseEntity<List<TransactionDTO>> findAllByAccountNumber(@PathVariable("accountNumber") final String accountNumber) throws Exception {
        var list = transactionService.findAllTransactions(accountNumber)
                .stream().map(this::map)
                .collect(toList());

        if (list.isEmpty()){
            return  notFound().build();
        }
        return ok(list);
    }

    @GetMapping("home")
    public String home() {
        return "Hello World!";
    }

    private TransactionDTO map(final Transaction tr) {
        return TransactionDTO.apply(tr);
    }

}
