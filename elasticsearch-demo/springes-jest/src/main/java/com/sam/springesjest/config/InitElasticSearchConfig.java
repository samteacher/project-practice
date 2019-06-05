package com.sam.springesjest.config;

import com.google.gson.GsonBuilder;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

/**
 * 初始化es链接
 *
 * @author yuqiufu
 * @since 2019-06-05
 */
public class InitElasticSearchConfig {

    private JestClient client;

    public JestClient getClient() {
        return client;
    }

    public InitElasticSearchConfig(String esUrl) {
        client = getClientConfig(esUrl);
    }

    public JestClient getClientConfig(String esUrl) {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder(esUrl)
                .gson(new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create())
                .multiThreaded(true)
                .readTimeout(10000)
                .build());
        JestClient client = factory.getObject();
        return client;
    }

}
