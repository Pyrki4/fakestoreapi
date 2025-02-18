package com.fakestoreapi.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ConfigFromSources extends Config {

    @Key("base.url")
    String getBaseUrl();
}
