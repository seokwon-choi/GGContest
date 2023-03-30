package digico.com.GGcontestb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class MultiPartResoloverConfig {

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(-1); 
        multipartResolver.setMaxInMemorySize(160000000); //memoery size
        return multipartResolver;
    }
    
}
