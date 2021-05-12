package md.SpringREST.ecommerce.config;

import md.SpringREST.ecommerce.entity.Country;
import md.SpringREST.ecommerce.entity.Product;
import md.SpringREST.ecommerce.entity.ProductCategory;
import md.SpringREST.ecommerce.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Babin Sergiu
 */

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        HttpMethod[] theUnsupportedaction = {HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT};

        disableHttpMethonds(Product.class, config, theUnsupportedaction);
        disableHttpMethonds(ProductCategory.class, config, theUnsupportedaction);
        disableHttpMethonds(Country.class, config, theUnsupportedaction);
        disableHttpMethonds(State.class, config, theUnsupportedaction);

        expozeIds(config);
    }

    private void disableHttpMethonds(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedaction) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedaction)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedaction)));
    }

    private void expozeIds(RepositoryRestConfiguration configuration) {

        Set<EntityType<?>> entityTypes = entityManager.getMetamodel().getEntities();

        List<Class> entityClasses = new ArrayList<>();

        for (EntityType tempEntity : entityTypes) {
            entityClasses.add(tempEntity.getJavaType());
        }

        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        configuration.exposeIdsFor(domainTypes);
    }
}
