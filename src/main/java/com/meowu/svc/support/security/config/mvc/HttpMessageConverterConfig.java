package com.meowu.svc.support.security.config.mvc;

import com.google.gson.Gson;
import com.meowu.starter.commons.domain.TypeAdapter;
import com.meowu.starter.commons.utils.GsonUtils;
import com.meowu.svc.support.commons.gson.adapter.DateTypeAdapter;
import com.meowu.svc.support.commons.gson.adapter.RecordStatusTypeAdapter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.nio.charset.StandardCharsets;

@Configuration
public class HttpMessageConverterConfig{

    @Bean
    public HttpMessageConverters gsonConverters(){
        // adapters
        TypeAdapter<?>[] adapters = new TypeAdapter[]{
            new DateTypeAdapter(), new RecordStatusTypeAdapter()
        };

        // gson creator
        Gson gson = GsonUtils.createGson(false, false, adapters);

        // gson convert
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setDefaultCharset(StandardCharsets.UTF_8);
        converter.setGson(gson);

        return new HttpMessageConverters(converter);
    }
}
