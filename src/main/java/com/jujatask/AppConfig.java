//package com.jujatask;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
///**
// * Created by Oleg on 12.03.2018.
// */
//@Configuration
//@PropertySource("classpath:config.properties")
//@EnableTransactionManagement
//@EnableAutoConfiguration
//public class AppConfig {
//    @Value("${hibernate.dialect}")
//    private String sqlDialect;
//
//    @Value("${hbm2ddl.auto}")
//    private String hbm2dllAuto;
//
////    @Bean
////    public LocalContainerEntityManagerFactoryBean entityManagerFactory
////            (DataSource dataSource, JpaVendorAdapter jpaVendeorAdapter) {
////        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
////
////        entityManagerFactory.setDataSource(dataSource);
////        entityManagerFactory.setJpaVendorAdapter(jpaVendeorAdapter);
////        entityManagerFactory.setJpaProperties(additionalProperties());
////        entityManagerFactory.setPackagesToScan("com.jujatask");
////
////
////        return entityManagerFactory;
////    }
////
////    @Bean
////    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
////        return new JpaTransactionManager(emf);
////    }
////
////
////    @Bean
////    public JpaVendorAdapter jpaVendorAdapter() {
////        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//////        adapter.setShowSql(true);
////        adapter.setShowSql(false);
////        adapter.setDatabasePlatform(sqlDialect);
////
////        return adapter;
////    }
////
////    @Bean
////    public UrlBasedViewResolver setupViewResolver() {
////        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
////        resolver.setPrefix("/WEB-INF/pages/");
////        resolver.setSuffix(".jsp");
////        resolver.setViewClass(JstlView.class);
////
////
////        return resolver;
////    }
////
////
////
////
////    private Properties additionalProperties() {
////        Properties properties = new Properties();
////        properties.setProperty("hibernate.hbm2ddl.auto", hbm2dllAuto);
////        return properties;
////    }
//}
