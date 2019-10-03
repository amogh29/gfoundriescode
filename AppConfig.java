package com.gfndry.Oautt.config;

@Configuration
@ComponentScan(basePackages = "com.gfndry.Oautt")
@PropertySource(value = { "classpath:application.properties" })
public class AppConfig {

	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
