package com.app.sysConfig;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
 
/**
 */
@Configuration
public class LocalDateTimeSerializerConfig {
    @Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss}")
    private String localDateTimeFormatter;
 
    private String localDateFormatter="yyyy-MM-dd";
    
    private String localTimeFormatter="HH:mm:ss";
    
    @Bean
    public LocalDateTimeSerializer localDateTimeDeserializer() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(localDateTimeFormatter));
    }
    
    @Bean
    public LocalDateSerializer localDateDeserializer() {
        return new LocalDateSerializer(DateTimeFormatter.ofPattern(localDateFormatter));
    }
 
    @Bean
    public LocalTimeSerializer localTimeDeserializer() {
        return new LocalTimeSerializer(DateTimeFormatter.ofPattern(localTimeFormatter));
    }
   
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> 
        builder.serializerByType(LocalDateTime.class, localDateTimeDeserializer())
        .serializerByType(LocalDate.class, localDateDeserializer())
        .serializerByType(LocalTime.class, localTimeDeserializer());
    }
    
}
