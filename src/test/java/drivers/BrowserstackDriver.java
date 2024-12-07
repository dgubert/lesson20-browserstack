package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackCredentialsConfig;
import config.DriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    BrowserstackCredentialsConfig bsConfig = ConfigFactory.create(BrowserstackCredentialsConfig.class, System.getProperties());
    DriverConfig deiverConfig = ConfigFactory.create(DriverConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", bsConfig.bsUser());
        caps.setCapability("browserstack.key", bsConfig.bsKey());
        caps.setCapability("app", deiverConfig.app());
        caps.setCapability("device", deiverConfig.device());
        caps.setCapability("os_version", deiverConfig.osVersion());
        caps.setCapability("project", deiverConfig.project());
        caps.setCapability("build", deiverConfig.build());
        caps.setCapability("name", deiverConfig.name());

        try {
            return new RemoteWebDriver(
                    new URL(bsConfig.remoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}