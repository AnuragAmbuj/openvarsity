package com.openvarsity.cms.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.openvarsity.cms.index.repo")
@ComponentScan(basePackages = {"com.openvarsity.cms.index"})
@EnableCaching
public class CMSConfig {

//    @Bean
//    public RestHighLevelClient restHighLevelClient(){
//        final ClientConfiguration clientConfiguration = getLocalESConfig();
//        return RestClients.create(clientConfiguration).rest();
//    }
//
//    public ClientConfiguration getLocalESConfig(){
//        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedToLocalhost()
//                .build();
//        return clientConfiguration;
//    }
//
//    private ClientConfiguration getRemoteESConfig() {
//        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("https://openvarsitymooc-course-search.es.ap-south-1.aws.elastic-cloud.com:9243")
//                .usingSsl()
//                .withBasicAuth("elastic","FpLgwJqYaFwKPCqJECj2gSPd")
//                .build();
//        return clientConfiguration;
//    }

//    @Bean
//    public ElasticsearchOperations elasticsearchTemplates(){
//        return new ElasticsearchRestTemplate(restHighLevelClient());
//    }
}
