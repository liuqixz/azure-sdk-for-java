package com.microsoft.windowsazure.services.blob;

import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;

import com.microsoft.windowsazure.common.Configuration;

public abstract class IntegrationTestBase {
    protected static Configuration createConfiguration() {
        Configuration config = new Configuration();
        Map<String, String> env = System.getenv();

        // Storage emulator support
        //setConfigValue(config, env, BlobConfiguration.ACCOUNT_NAME, "devstoreaccount1");
        //setConfigValue(config, env, BlobConfiguration.ACCOUNT_KEY, "Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq/K1SZFPTOtr/KBHBeksoGMGw==");
        //setConfigValue(config, env, BlobConfiguration.URL, "http://127.0.0.1:10000/devstoreaccount1");

        // Storage account support
        setConfigValue(config, env, BlobConfiguration.ACCOUNT_NAME, "onesdktest");
        setConfigValue(config, env, BlobConfiguration.ACCOUNT_KEY, "X7jm3ar3rLmrNx4RUnX1/Blf01zdwreldbJNX+bnfmCQD//kR4qcJO+Amc8mS+4+l9L5i2cP215YccjpDogTOQ==");
        setConfigValue(config, env, BlobConfiguration.URL, "http://onesdktest.blob.core.windows.net");

        // when mock running
        // config.setProperty("serviceBus.uri", "http://localhost:8086");
        // config.setProperty("wrapClient.uri",
        // "http://localhost:8081/WRAPv0.9");

        return config;
    }

    private static void setConfigValue(Configuration config, Map<String, String> props, String key, String defaultValue) {
        String value = props.get(key);
        if (value == null)
            value = defaultValue;

        config.setProperty(key, value);
    }

    @BeforeClass
    public static void initializeSystem() {
        System.out.println("initialize");
        // System.setProperty("http.proxyHost", "itgproxy");
        // System.setProperty("http.proxyPort", "80");
        // System.setProperty("http.keepAlive", "false");
    }

    @Before
    public void initialize() throws Exception {
        System.out.println("initialize");
        // System.setProperty("http.proxyHost", "itgproxy");
        // System.setProperty("http.proxyPort", "80");
        // System.setProperty("http.keepAlive", "false");
    }
}
