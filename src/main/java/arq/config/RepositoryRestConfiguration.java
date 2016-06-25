package arq.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import arq.domain.Price;
import arq.domain.Shop;

@Configuration
public class RepositoryRestConfiguration extends RepositoryRestMvcConfiguration {
    @Value("${rest.base_path}")
    private String base_path;

    @Override
    protected void configureRepositoryRestConfiguration(org.springframework.data.rest.core.config.RepositoryRestConfiguration config) {
        config.exposeIdsFor(Shop.class);
        config.exposeIdsFor(Price.class);
        config.setBasePath(this.base_path);
    }
}
