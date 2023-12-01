package co.chu3la.contractapi.dto;

import co.chu3la.contractapi.entities.Transaction;
import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Data
@Builder
public class TransactionDTO {
    private Long id;
    private String type;
    private Date date;
    private Integer accountNumber;
    private String currency;
    private Double amount;
    private String merchantName;
    private String merchantLogo;

    public static TransactionDTO apply(final Transaction tr) {
//        var transactionDTO = TransactionDTO.builder()
//                .id(tr.getId())
//                .type(tr.getType())
//                .accountNumber(tr.getAccountNumber())
//                .currency(tr.getCurrency())
//                .amount(tr.getAmount())
//                .merchantName(tr.getMerchantName())
//                .merchantLogo(tr.getMerchantLogo())
//                .build();
//        return transactionDTO;
        return null;
    }
}
