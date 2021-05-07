package md.SpringREST.ecommerce.config;

import md.SpringREST.ecommerce.entity.Product;
import md.SpringREST.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

/**
 * @author Babin Sergiu
 */

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        HttpMethod[] theUnsupportedaction = {HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT};

        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedaction)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedaction)));

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedaction)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedaction)));
    }
}
