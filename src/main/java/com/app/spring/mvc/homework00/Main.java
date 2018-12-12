package com.app.spring.mvc.homework00;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

public class Main {


    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            context.registerShutdownHook();
            startJetty(context);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // DO NOT FOCUS ON THIS
    // For embeddedJetty ONLY!
    private static void startJetty(ApplicationContext appContext) throws Exception {
        org.eclipse.jetty.server.Server server = appContext.getBean(org.eclipse.jetty.server.Server.class);
        server.setHandler(createHandler(createSpringContext(appContext)));
        server.start();
        server.join();
    }

    private static ServletContextHandler createHandler(WebApplicationContext context) {
        ServletContextHandler handler = new ServletContextHandler();
        handler.setErrorHandler(null);
        handler.setContextPath("/");
        handler.addServlet(new ServletHolder("mvc-dispatcher", new DispatcherServlet(context)), "/");
        handler.addEventListener(new ContextLoaderListener(context));
        return handler;
    }

    private static WebApplicationContext createSpringContext(ApplicationContext appContext) {
        XmlWebApplicationContext context = new XmlWebApplicationContext() {
            @Override
            protected Resource getResourceByPath(String path) {
                path = StringUtils.cleanPath(path);
                if (path.startsWith("/") || (path.indexOf(':') > 0)) {
                    return super.getResourceByPath(path);
                }
                String newFileName = new File(".").getAbsolutePath();
                newFileName = newFileName + "/" + path;
                return new FileSystemResource(newFileName);
            }

        };
        context.setConfigLocation("classpath:/applicationContext.xml");
        context.setParent(appContext);
        return context;
    }
}
