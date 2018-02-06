package ua.lviv.likebooks.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("ua.lviv.likebooks.dao")
@PropertySource("classpath:db.properties")
public class DataConfig {

    @Autowired
   private Environment env;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setPassword(env.getProperty("db.password"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setUrl(env.getProperty("db.url"));
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter vendorAdapter(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setDatabase(Database.MYSQL);
        return vendorAdapter;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory (){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJpaVendorAdapter(vendorAdapter());
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(env.getProperty("db.packageToScan"));
        Properties properties = new Properties();
        properties.put(env.getProperty("db.hibernate.hbm"),env.getProperty("db.hibernate.hbm.value"));
        factoryBean.setJpaProperties(properties);
        return factoryBean;
    }
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
