package com.hui.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/* 1-3-3 编写配置读取config */
@Configuration
@ConfigurationProperties(prefix = "count.ip")
public class IpCountConfig {

    /**
     * 日志显示周期
     */
    private Long cycle = 5L;
    /**
     * 是否周期内重置数据
     */
    private Boolean cycleReset = false;
    /**
     * 日志输出模式 detail:详细模式 simple:极简模式
     */
    private String model = LogEnum.DETAIL.value;

    public enum LogEnum {
        DETAIL("detail"),
        SIMPLE("simple");
        private String value;

        LogEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Long getCycle() {
        return cycle;
    }

    public void setCycle(Long cycle) {
        this.cycle = cycle;
    }

    public Boolean getCycleReset() {
        return cycleReset;
    }

    public void setCycleReset(Boolean cycleReset) {
        this.cycleReset = cycleReset;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "IpCountConfig{" +
                "cycle=" + cycle +
                ", cycleReset=" + cycleReset +
                ", model='" + model + '\'' +
                '}';
    }
}
