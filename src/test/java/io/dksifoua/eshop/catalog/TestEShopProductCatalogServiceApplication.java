package io.dksifoua.eshop.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestEShopProductCatalogServiceApplication {

    @Bean
    @ServiceConnection
    MongoDBContainer mongoDbContainer() {
        DockerImageName dockerImageName = DockerImageName
                .parse("mongodb/mongodb-community-server:latest")
                .asCompatibleSubstituteFor("mongo");
        return new MongoDBContainer(dockerImageName);
    }

    public static void main(String[] args) {
        SpringApplication
                .from(EShopProductCatalogServiceApplication::main)
                .with(TestEShopProductCatalogServiceApplication.class).run(args);
    }

}
