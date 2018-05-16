package audora;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.audora.security.TokenFilter;

@SpringBootApplication
public class Configuracao {
	
	@Bean
	public FilterRegistrationBean filtroJwt(){
		 FilterRegistrationBean frb = new  FilterRegistrationBean();
		 frb.setFilter(new TokenFilter());
		 frb.addUrlPatterns("/admin/*");		 
		 return frb;
		
	}
	
	 public static void main(String[] args) throws Exception {
		    SpringApplication.run(Configuracao.class, args);
		  }
	 
	 @Bean
	 public DataSource dataSoucer() {

		DriverManagerDataSource dataSourcer = new DriverManagerDataSource();
		dataSourcer.setDriverClassName("com.mysql.jdbvc.driver");
		dataSourcer.setUrl("jdbc/mysql://localhost:3306/audora");
		dataSourcer.setUsername("root");
		dataSourcer.setPassword("root");

		return dataSourcer;
	}

}
