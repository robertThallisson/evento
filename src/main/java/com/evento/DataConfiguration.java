package com.evento;

import javax.sql.DataSource;

import org.apache.catalina.mbeans.RoleMBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {

	private String baseDados = "evento";
	private String usuario = "postgres";
	private String senha = "robert";
	private String host = "localhost";
	private String porta = "5432";

	private String url = "jdbc:postgresql://" + host + ":" + porta + "/";

	private String urlH = "postgres://xiybjazidgkgvl:55b1edcb73c1a735455adcd7c93426b1573ac11ebbac8a38c21b873fdc945dfe@ec2-54-204-44-140.compute-1.amazonaws.com:5432/dbao9o4qkaieoh";
	private String  UsuarioH = "xiybjazidgkgvl";
	private String senhaH = "55b1edcb73c1a735455adcd7c93426b1573ac11ebbac8a38c21b873fdc945dfe";
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl(urlH);
		dataSource.setUsername(UsuarioH);
		dataSource.setPassword(senhaH);
		return dataSource;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.POSTGRESQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		adapter.setPrepareConnection(true);
		return adapter;
	}

}
