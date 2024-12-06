package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources({
        "classpath:android.properties"
})

public interface DriverConfig extends Config {

    @Key("browserstack.user")
    String bsUser();

    @Key("browserstack.key")
    String bsKey();

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

    @Key("remoteUrl")
    String remoteUrl();
}