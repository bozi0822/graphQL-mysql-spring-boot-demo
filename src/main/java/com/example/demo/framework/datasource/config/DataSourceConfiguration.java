package com.example.demo.framework.datasource.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.example.demo.framework.datasource.core.DynamicDataSource;
import com.example.demo.framework.datasource.enums.DataSourcesType;
import com.example.demo.framework.datasource.properties.DataSourceProperties;
import com.google.common.collect.Maps;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author Ng
 * 数据源配置类
 */
@Configuration
public class DataSourceConfiguration {

	/**
	 * 主库
	 */
	@Bean
	@ConfigurationProperties("spring.datasource.druid.master")
	public DataSource masterDataSource(DataSourceProperties dataSourceProperties) {
		return dataSourceProperties.setDataSource(DruidDataSourceBuilder.create().build());
	}


	/**
	 * 从库
	 * ConditionalOnProperty 是否开启数据源开关---若不开启 默认适用默认数据源
	 */
//	@Bean
//	@ConditionalOnProperty(prefix = "spring.datasource.druid.slave", name = "enable", havingValue = "true")
//	@ConfigurationProperties("spring.datasource.druid.slave")
//	public DataSource slaveDataSource(DataSourceProperties dataSourceProperties) {
//		return dataSourceProperties.setDataSource(DruidDataSourceBuilder.create().build());
//	}

	/**
	 * 设置数据源
	 */
	@Bean(name = "dynamicDataSource")
	@Primary
	public DynamicDataSource dynamicDataSource(DataSource masterDataSource, DataSource slaveDataSource) {
		Map<Object,Object> targetDataSources = Maps.newHashMap();
		DynamicDataSource dynamicDataSource = DynamicDataSource.build();
		targetDataSources.put(DataSourcesType.MASTER.name(),masterDataSource);
//		targetDataSources.put(DataSourcesType.SLAVE.name(),slaveDataSource);
		//默认数据源配置 DefaultTargetDataSource
		dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
		//额外数据源配置 TargetDataSources
		dynamicDataSource.setTargetDataSources(targetDataSources);
		dynamicDataSource.afterPropertiesSet();
		return dynamicDataSource;
	}

}