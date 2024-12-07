package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})
public interface BrowserstackCredentialsConfig extends Config {

    @Key("browserstack.user")
    String bsUser();

    @Key("browserstack.key")
    String bsKey();

    @Key("remoteUrl")
    String remoteUrl();
}
