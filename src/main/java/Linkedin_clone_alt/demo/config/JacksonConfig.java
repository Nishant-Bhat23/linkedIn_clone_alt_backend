package Linkedin_clone_alt.demo.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;

@Configuration
public class JacksonConfig {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer addMixIns() {
        return builder -> {
            builder.mixIn(ByteArrayInputStream.class, ByteArrayInputStreamMixin.class);
        };
    }
}
