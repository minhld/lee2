package com.minh.lee2;

import jakarta.servlet.ServletContext;
import com.minh.lee2.model.SystemInfo;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private final ServletContext servletContext;

    public MainService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public SystemInfo getSystemInfo() {
        return new SystemInfo(
                System.getProperty("java.version"),
                servletContext.getServerInfo(),
                new SystemInfo.SystemDetails(
                        System.getProperty("os.version"),
                        System.getProperty("os.name"),
                        System.getProperty("os.arch")
                )
        );
    }
}
