package online.kakapapa;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tien.Chang
 */
@ConditionalOnClass(IdProperties.class)
@EnableConfigurationProperties(IdProperties.class)
@Configuration
public class IdGenerateAutoConfiguration {
    private final IdProperties properties;

    public IdGenerateAutoConfiguration(IdProperties properties) {
        this.properties = properties;
    }

    @Bean
    public IdGenerateService idGenerateService() {
        return new IdGenerateService(properties);
    }
}