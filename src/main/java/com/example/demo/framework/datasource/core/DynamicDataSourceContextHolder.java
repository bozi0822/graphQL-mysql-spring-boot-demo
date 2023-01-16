package com.example.demo.framework.datasource.core;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Ng
 * 数据源切换处理
 */
@Slf4j
public class DynamicDataSourceContextHolder {

	/**
	 * 此类提供线程局部变量。这些变量不同于它们的正常对应关系是每个线程访问一个线程(通过get、set方法),有自己的独立初始化变量的副本。
	 */
	private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

	/**
	 * 设置当前线程的数据源变量
	 */
	public static void setDataSourceType(String dataSourceType) {
		log.info("DynamicDataSourceContextHolder change datasource:{}",dataSourceType);
		CONTEXT_HOLDER.set(dataSourceType);
	}

	/**
	 * 获取当前线程的数据源变量
	 */
	public static String getDataSourceType() {
		return CONTEXT_HOLDER.get();
	}

	/**
	 * 删除与当前线程绑定的数据源变量
	 */
	public static void removeDataSourceType() {
		CONTEXT_HOLDER.remove();
	}

}