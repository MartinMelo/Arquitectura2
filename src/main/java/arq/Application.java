package arq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableHypermediaSupport(type = { EnableHypermediaSupport.HypermediaType.HAL })
@SpringBootApplication
@EnableMongoRepositories
public class Application {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
    	LOGGER.info("Inicio la app");
        SpringApplication.run(Application.class, args);
    }
    
}