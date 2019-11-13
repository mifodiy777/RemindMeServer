package com.remindme.server;

import com.remindme.server.config.WebConfig;
import com.remindme.server.repository.RemindRepository;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER = "dispatcher";

    private RemindRepository repository;

    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

        ctx.register(WebConfig.class);

        servletContext.addListener(new ContextLoaderListener(ctx));

        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER, new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
