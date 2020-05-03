package com.github.resource.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.resource.pojo.CountryBO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 创建时间为 下午12:34 2020/5/3
 * 项目名称 spring-boot-resource
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
@RequiredArgsConstructor
public class ResourceController {

    @Value(value = "classpath:json/country.json")
    private Resource resource;

    private final ObjectMapper objectMapper;

    @GetMapping("all")
    public Map<String, Set<CountryBO>> getCountryAll() throws IOException {
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<Map<String, Set<CountryBO>>>() {
        });
    }

}
