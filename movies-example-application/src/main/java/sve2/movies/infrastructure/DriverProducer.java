package sve2.movies.infrastructure;

import org.jnosql.artemis.ConfigurationReader;
import org.jnosql.artemis.ConfigurationUnit;
import org.jnosql.diana.api.Settings;
import org.neo4j.driver.v1.AuthToken;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

@ApplicationScoped
public class DriverProducer {

    @Inject
    private ConfigurationReader configurationReader;

    @ConfigurationUnit
    @Produces
    public Driver getDriver(InjectionPoint injectionPoint) {
        Annotated annotated = injectionPoint.getAnnotated();
        ConfigurationUnit annotation = annotated.getAnnotation(ConfigurationUnit.class);

        Settings settings = configurationReader.read(annotation).getSettings();

        String url = settings.get("url").toString();
        String user = settings.get("admin").toString();
        String password = settings.get("password").toString();

        AuthToken basic = AuthTokens.basic(user, password);

        Driver driver = GraphDatabase.driver(url, basic);

        return driver;
    }
}
