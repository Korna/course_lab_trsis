package f_samp.spring.configuration;

        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Sonad on 20.09.17.
 */
@Configuration
public class ControllersConfiguration extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/Persons").setViewName("Persons");
     //   registry.addViewController("/Position").setViewName("position");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/forbidden").setViewName("forbidden");
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/").setViewName("Persons");
    }

}
