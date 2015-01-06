package com.springapp.mvc;

        import javax.sql.DataSource;

        import com.springapp.mvc.UserDAO;
        import com.springapp.mvc.UserDAOImpl;

        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.jdbc.datasource.DriverManagerDataSource;
        import org.springframework.web.servlet.ViewResolver;
        import org.springframework.web.servlet.config.annotation.EnableWebMvc;
        import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
        import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.springapp.mvc")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://mysql.agh.edu.pl:3306/kyrcz3");
        dataSource.setUsername("kyrcz3");
        dataSource.setPassword("cv35Kb4o");

        return dataSource;
    }

    @Bean
    public UserDAO getUserDAO() {
        return new UserDAOImpl(getDataSource());
    }
}
