package ru.store.store_thing.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
public class HibernateConfig {

    @Bean
    public DataSource dataSource(@Value("${spring.datasource.driver-class-name}") String driver,
                                          @Value("${spring.datasource.url}") String url,
                                          @Value("${spring.datasource.username}") String username,
                                          @Value("${spring.datasource.password}") String password) {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory(@Value("${spring.h2.console.enabled}") String enabled,
                                                  @Value("${spring.jpa.hibernate.ddl-auto}") String ddlAuto,
                                                  @Value("${spring.jpa.show-sql}") String showSql,
                                                  @Qualifier("dataSource") DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("ru.job4j.job4j_shop_kotlin.model");
        Properties cfg = new Properties();
        cfg.setProperty("spring.h2.console.enabled", enabled);
        cfg.setProperty("spring.jpa.hibernate.ddl-auto", ddlAuto);
        cfg.setProperty("spring.jpa.show-sql", showSql);
        sessionFactory.setHibernateProperties(cfg);
        return sessionFactory;
    }
}
