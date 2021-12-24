package com.testConfig;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import net.ttddyy.dsproxy.listener.ChainListener;
import net.ttddyy.dsproxy.listener.DataSourceQueryCountListener;
import net.ttddyy.dsproxy.listener.logging.SLF4JQueryLoggingListener;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@TestConfiguration
@PropertySource("classpath:application.properties")
public class SpringTestContext implements WebMvcConfigurer {

    @Bean
    public DataSource originalDataSource(@Value("${db.user}") String username,
                                         @Value("${db.password}") String password,
                                         @Value("${db.url}") String url,
                                         @Value("${db.driver}") String driverClassName,
                                         @Value("${hikari.config.pool.size}") int size,
                                         @Value("${hikari.config.life.time}") long time) {
        var config = new HikariConfig();
        config.setUsername(username);
        config.setPassword(password);
        config.setJdbcUrl(url);
        config.setDriverClassName(driverClassName);
        config.setMaximumPoolSize(size);
        config.setMaxLifetime(time);
        return new HikariDataSource(config);
    }

    @Bean
    public DataSource dataSource(DataSource originalDataSource) {
        ChainListener listener = new ChainListener();
        SLF4JQueryLoggingListener loggingListener = new SLF4JQueryLoggingListener();
        loggingListener.setQueryLogEntryCreator(new InlineQueryLogEntryCreator());
        listener.addListener(loggingListener);
        listener.addListener(new DataSourceQueryCountListener());
        return ProxyDataSourceBuilder
                .create(originalDataSource)
                .name("DS-Proxy")
                .listener(listener)
                .build();
    }
}
