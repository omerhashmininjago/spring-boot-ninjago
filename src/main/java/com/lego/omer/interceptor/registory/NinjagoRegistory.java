package com.lego.omer.interceptor.registory;

import com.lego.omer.interceptor.NinjagoHttpsInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * All custom interceptors need to be registered with the InterceptorRegistory
 */
@Component
public class NinjagoRegistory implements WebMvcConfigurer {

    @Autowired
    NinjagoHttpsInterceptor ninjagoHttpsInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ninjagoHttpsInterceptor);
    }
}
