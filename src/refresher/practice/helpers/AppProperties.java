package refresher.practice.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by clif on 1/13/17.
 */
public class AppProperties {

    /**
     * Return reference to values in properties file.
     *
     * @return Properties object.
     * @throws IOException Thrown if file not found.
     */
    public Properties getPropValues() throws IOException {

        InputStream inputStream = null;
        Properties prop = null;

        try {
            prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new IOException(propFileName + "' not found in the classpath");
            }

        } catch (Exception e) {
            throw e;
        } finally {
            inputStream.close();
        }

        return prop;
    }
}
