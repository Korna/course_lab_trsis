package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Sonad on 14.09.17.
 */
@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) throws Exception{
        SpringApplication app = new SpringApplicationBuilder(Application.class).build();
        app.run(args);
    }
}
