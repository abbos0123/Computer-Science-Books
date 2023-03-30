package uz.uniquecode.microseviceone.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author: Abbos Fayziboev
 * Date: 29/03/23
 * Email: abbosFayziboev@gmail.com
 */

@ConfigurationProperties("microservice-one")
@org.springframework.context.annotation.Configuration
public class Configuration {
    private String value;
    @Value("${microservice-one.username}")
    private String username;

    public String getValue() {
        return value + "  " + username;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
