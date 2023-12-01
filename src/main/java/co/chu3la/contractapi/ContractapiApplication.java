package co.chu3la.contractapi;

import co.chu3la.contractapi.entities.Transaction;
import co.chu3la.contractapi.repository.TransactionRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Date;

@SpringBootApplication
public class ContractapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContractapiApplication.class, args);
	}

	@Profile("dev")
	@Bean
	public ApplicationRunner dataLoader(TransactionRepository repo) {
		return args -> {
			repo.deleteAll();
			repo.save(new Transaction(1,"Credit", new Date(),12345,"USD",55.00,"ABC","abc-logo.png"));
			repo.save(new Transaction(2,"Dedit", new Date(),12345,"USD",100.00,"ABC","abc-logo.png"));
			repo.save(new Transaction(3,"Dedit", new Date(),12345,"USD",350.00,"ABC","abc-logo.png"));
		};
	}

}
