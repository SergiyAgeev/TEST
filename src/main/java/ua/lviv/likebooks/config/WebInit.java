package ua.lviv.likebooks.config;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.thymeleaf.Thymeleaf;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInit implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ThymeleafConfig.class);
//        DispatcherServlet dispatcherServlet = ;//??
        ServletRegistration.Dynamic registration = servletContext
                .addServlet("dispatcherServlet", new DispatcherServlet(context));
        registration.addMapping("/");
        registration.setLoadOnStartup(1);
    }
}
