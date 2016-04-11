package arq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import arq.config.RepositoryRestConfiguration;
import arq.controller.ExceptionController;

@Configuration
@EnableJpaRepositories
@Import(RepositoryRestConfiguration.class)
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableHypermediaSupport(type = { EnableHypermediaSupport.HypermediaType.HAL })
@ComponentScan
public class Application {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
    	LOGGER.info("arrancooooooo");
        SpringApplication.run(Application.class, args);
    }
    
}