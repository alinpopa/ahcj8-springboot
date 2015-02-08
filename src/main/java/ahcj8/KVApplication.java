package ahcj8;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.JettyWebXmlConfiguration;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KVApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(KVApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean jerseyServlet(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/*");
        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
        return registration;
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer(){
        return new JettyEmbeddedServletContainerFactory(8081);
    }
}
