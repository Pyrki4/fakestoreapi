package com.fakestoreapi.config;

import org.aeonbits.owner.Config;

public interface TestConfig extends Config {

    @Key("base.url")
    String baseUrl();
}
