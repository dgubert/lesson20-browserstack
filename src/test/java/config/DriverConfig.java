package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:env.properties",
        "classpath:${env}.properties"
})
public interface DriverConfig extends Config {

    @Key("app")
    String app();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();
}