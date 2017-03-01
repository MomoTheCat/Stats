import com.google.inject.Guice;
import com.google.inject.Injector;
import configuration.MongoDbConnection;
import configuration.MyModule;
import configuration.YamlConfig;
import ratpack.server.RatpackServer;

import java.util.logging.Logger;

/**
 * Created by szymon on 01.03.2017.
 */
public class App {

    private static final Logger LOG = Logger.getLogger("App");


    public static void main(String[] args) throws Exception {

        Injector injector = Guice.createInjector(new MyModule());

        LOG.info("-----Loading YAML configuration file.-----");
        String mongoConf = YamlConfig.newInstance().getMongoSetup();
        String networkUri = YamlConfig.newInstance().getNetworkUri();

        LOG.info("-----Connection to database.-----");
        MongoDbConnection mongoDbConnection = MongoDbConnection.newInstance(mongoConf);
        mongoDbConnection.getNumberOfElements();

        DownloadData downloadData = new DownloadData(networkUri);

        LOG.info("-----Starting server.-----");
        RatpackServer.start(server -> server
                .handlers(chain -> chain
                        .get(ctx -> ctx.render("Hello World!"))
                        .get(":name", ctx -> ctx.render("Hello " + ctx.getPathTokens().get("name") + "!"))
                )
        );

    }


}
