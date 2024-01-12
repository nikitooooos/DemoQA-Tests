package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface TestConfig extends Config{

    @Key("browserName")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String getBaseUrl();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();
}