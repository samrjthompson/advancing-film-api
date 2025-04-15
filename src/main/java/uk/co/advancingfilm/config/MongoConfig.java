package uk.co.advancingfilm.config;

import com.mongodb.WriteConcern;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@Configuration
public class MongoConfig implements InitializingBean {

    private final MappingMongoConverter mappingMongoConverter;

    public MongoConfig(@Lazy MappingMongoConverter mappingMongoConverter) {
        this.mappingMongoConverter = mappingMongoConverter;
    }

    // Remove _class field from data
    @Override
    public void afterPropertiesSet() {
        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
    }

    @Bean
    MongoTemplate mongoTemplate(MongoDatabaseFactory factory) {
        MongoTemplate mongoTemplate = new MongoTemplate(factory, mappingMongoConverter);
        mongoTemplate.setWriteConcern(WriteConcern.ACKNOWLEDGED);

        return mongoTemplate;
    }
}
