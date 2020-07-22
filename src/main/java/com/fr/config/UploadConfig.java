package com.fr.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : hong.Four
 * @date : 2020-07-22 07:42
 **/
@Component
@ConfigurationProperties(prefix = "upload")
public class UploadConfig {
    private String baseUrl;
    private List<String> allowTypes;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<String> getAllowTypes() {
        return allowTypes;
    }

    public void setAllowTypes(List<String> allowTypes) {
        this.allowTypes = allowTypes;
    }

    @Override
    public String toString() {
        return "UploadConfig{" +
                "baseUrl='" + baseUrl + '\'' +
                ", allowTypes=" + allowTypes +
                '}';
    }
}
