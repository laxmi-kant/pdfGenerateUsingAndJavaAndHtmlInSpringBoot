package com.base.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.hibernate.AnnotationException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.base.model.Phone;
import org.hibernate.cfg.Environment;


public class HibernateUtils {
	private static StandardServiceRegistry registry;
	   private static SessionFactory sessionFactory;

	   public static SessionFactory getSessionFactory() {
	      if (sessionFactory == null) {
	         try {

	            // Create registry builder
	            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

	            // Hibernate settings equivalent to hibernate.cfg.xml's properties
	            Map<String, String> settings = new HashMap<>();
	            settings.put(Environment.DRIVER, "org.postgresql.Driver");
	            settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/BORAJI");
	            settings.put(Environment.USER, "postgres");
	            settings.put(Environment.PASS, "admin");
	            settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
	            Properties prop= new Properties();
				prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/Test");
				prop.setProperty("hibernate.connection.username", "root");
				prop.setProperty("hibernate.connection.password", "root");
				prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
				
	            // Apply settings
	            registryBuilder.applySettings(prop);

	            // Create registry
	            registry = registryBuilder.build();

	            // Create MetadataSources
	            MetadataSources sources = new MetadataSources(registry);

	            // Create Metadata
	            Metadata metadata = sources.getMetadataBuilder().build();

	            // Create SessionFactory
	            sessionFactory = metadata.getSessionFactoryBuilder().build();

	         } catch (Exception e) {
	            e.printStackTrace();
	            if (registry != null) {
	               StandardServiceRegistryBuilder.destroy(registry);
	            }
	         }
	      }
	      return sessionFactory;
	   }

	   public static void shutdown() {
	      if (registry != null) {
	         StandardServiceRegistryBuilder.destroy(registry);
	      }
	   }
}
