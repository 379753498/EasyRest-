package com.testpro.easyrest.Core.imp;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import com.testpro.easyrest.Config.EasyRestConfig;
import com.testpro.easyrest.Core.Interface.InitialConfiguration;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component
@Slf4j
/**
 *初始化config配置接口实现
 */
public class InitialConfigurationImp implements InitialConfiguration {

    EasyRestConfig easyrestConfig;



    @Override
    public void InitialConfiguration() {

        ClassPathResource resource = new ClassPathResource("application.properties");
        Properties properties = new Properties();
        try {
            properties.load(resource.getStream());
            String baseurl = properties.getProperty("easyrest.restassured.baseurl");
            if (!StrUtil.isEmpty(baseurl))
            {
                RestAssured.baseURI=baseurl;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        RestAssured.given().config(RestAssured.config().logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)));
    }
}
