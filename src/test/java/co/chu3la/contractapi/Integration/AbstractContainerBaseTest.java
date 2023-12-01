package co.chu3la.contractapi.Integration;


import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

public class AbstractContainerBaseTest {

    static final MySQLContainer mySQL;

    static {
        mySQL = new MySQLContainer("mysql:latest")
                .withUsername("root")
                .withPassword("aze102030.")
                .withDatabaseName("aze102030.");
        
        mySQL.start();
    }

    @DynamicPropertySource
    public static void dynamicPropertySource(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySQL::getJdbcUrl);
        registry.add("spring.datasource.username", mySQL::getUsername);
        registry.add("spring.datasource.password", mySQL::getPassword);

    }

}
