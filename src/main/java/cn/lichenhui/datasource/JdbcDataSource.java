package cn.lichenhui.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcDataSource extends DataSourceProperties {

	@Value("${spring.datasource.max-poolsize}")
	private int maximumPoolSize;

	@Value("${spring.datasource.connect-timeout-ms}")
	private long connectTimeout;

	@Value("${spring.datasource.validate-timeout-ms}")
	private long validateTimeout;

	@Bean
	public HikariConfig hikariConfig() {
		HikariConfig conf = new HikariConfig();
		conf.setJdbcUrl(getUrl());
		conf.setUsername(getUsername());
		conf.setPassword(getPassword());
		conf.setPoolName(getName());
		conf.setConnectionTimeout(connectTimeout);
		conf.setValidationTimeout(validateTimeout);
		conf.setMaximumPoolSize(maximumPoolSize);
		return conf;
	}

	@Bean
	public DataSource dataSource(HikariConfig conf) {
		return new HikariDataSource(conf);
	}

	@Bean
	public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
}
