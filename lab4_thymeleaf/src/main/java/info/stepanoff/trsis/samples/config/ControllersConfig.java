package info.stepanoff.trsis.samples.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ControllersConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/schools").setViewName("schools");//стартовая степанова
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/forbidden").setViewName("forbidden");
        registry.addViewController("/error").setViewName("error");
        //registry.addViewController("/").setViewName("schools"); что было
        registry.addViewController("/").setViewName("sample");// что стало

        //добавленные
        registry.addViewController("/sample").setViewName("sample");//моя стартовая
        registry.addViewController("/search").setViewName("search");
    }

}
