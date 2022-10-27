package com.Swagger.Jersey.Config;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.Swagger.Jersey.Controller.EmployeeController;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//It indicates one or more @Bean methods and may be processed by the Spring container
//to generate bean definitions 
@Configuration
@EnableSwagger2
@ApplicationPath("/Emp")
@Primary
public class EmployeeConfig extends ResourceConfig implements SwaggerResourcesProvider{

	@Resource
    private InMemorySwaggerResourcesProvider inMemorySwaggerResourcesProvider;
	public EmployeeConfig() {

		this.registerEndpoints();

	}

	// in a constructor, the injection of the dependencies has not yet occurred
	// it gets executed after the spring bean is initialized.
	@PostConstruct
	public void init() {
		// Register components where DI is needed
		this.configureSwagger();
	}

	public void registerEndpoints() {
		this.register(EmployeeController.class);
	}

	private void configureSwagger() {
		// getting the resource of Path value in the form of swagger type json/yaml
		this.register(ApiListingResource.class);
		// provide the produces value in application/json ,application/xml
		this.register(SwaggerSerializers.class);

// BeanConfig to auto-scan all the REST resources so the documentation got generated automatically
		BeanConfig config = new BeanConfig();
		// config.setConfigId("springboot-jersey-swagger");
		config.setTitle("Spring Boot + Jersey + Swagger ");
		config.setVersion("v2");
		config.setContact("JerseyAdmin");
		config.setSchemes(new String[] { "http", "https" });
		config.setBasePath("Emp");
		config.setResourcePackage("com.Swagger.Jersey.Controller");
		config.setPrettyPrint(true);
		config.setScan(true);
	}
	
	@Override
	public List<SwaggerResource> get() {
		   SwaggerResource jerseySwaggerResource = new SwaggerResource();
	        jerseySwaggerResource.setLocation("/Emp/swagger.json");
	        jerseySwaggerResource.setSwaggerVersion("2.0");
	        jerseySwaggerResource.setName("Jersey");

	        return Stream.concat(Stream.of(jerseySwaggerResource),
	                inMemorySwaggerResourcesProvider.get().stream()).collect(Collectors.toList());
	    }

}
