package ee.itcollege.weblist.configuration;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class HibernateConfiguration {
	
    @Bean
    public DataSource getDataSource() throws PropertyVetoException {
    	
    	return new LoggedDataSource();
    	
    /*    ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setMaxPoolSize(10);
        ds.setMaxPoolSize(2);
        ds.setJdbcUrl("jdbc:h2:~/db/test");
        ds.setDriverClass("org.h2.Driver");
        return ds;*/
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(getDataSource());
        emf.setPackagesToScan(new String[]{"ee.itcollege.weblist.entity"});
        HibernateJpaVendorAdapter hibernateAdapter = new HibernateJpaVendorAdapter();
        hibernateAdapter.setGenerateDdl(true);
        emf.setJpaVendorAdapter(hibernateAdapter);
        return emf;
    }
    
    @Bean
    public DataSourceTransactionManager txManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(getDataSource());
    }
    
    @Bean
    public JpaTransactionManager transactionManager() throws PropertyVetoException {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }
    
    
}
