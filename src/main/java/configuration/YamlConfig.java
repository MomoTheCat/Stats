package configuration;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.logging.Logger;

/**
 * Created by szymon on 01.03.2017.
 */
public class YamlConfig {

    public static final String CONFIG_FILE_NAME = "app.yml";

    private static final Logger LOG = Logger.getLogger(String.valueOf(YamlConfig.class));

    private static YamlConfig yamlConfig;
    private YamlInfo yamlInfo;

    public static YamlConfig newInstance() {
        if (yamlConfig == null) {
            yamlConfig = new YamlConfig();
        }
        return yamlConfig;
    }

    public String getMongoSetup() {
        if (yamlInfo != null)
            return yamlInfo.getMongoUri();

        LOG.info("-----Can't find YAML configuration!!!-----");
        return "";
    }

    public String getNetworkUri() {
        if (yamlInfo != null)
            return yamlInfo.getNetworkUri();

        LOG.info("-----Can't find YAML configuration!!!-----");
        return "";
    }

    private YamlConfig() {

        InputStream input = this.getClass().getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);

        Yaml yaml = new Yaml();
        if (input != null) {
            yamlInfo = yaml.loadAs(input, YamlInfo.class);
        }
    }

    public static class YamlInfo {

        private String mongoUri;
        private String networkUri;

        public void setMongoUri(String mongoUri) {
            this.mongoUri = mongoUri;
        }

        public String getMongoUri() {
            return mongoUri;
        }

        public String getNetworkUri() {
            return networkUri;
        }

        public void setNetworkUri(String networkUri) {
            this.networkUri = networkUri;
        }
    }


}
