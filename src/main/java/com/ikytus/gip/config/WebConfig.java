package com.ikytus.gip.config;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.github.mxab.thymeleaf.extras.dataattribute.dialect.DataAttributeDialect;
import com.ikytus.gip.repository.converter.CursoConverter;
import com.ikytus.gip.repository.converter.IesConverter;
import com.ikytus.gip.repository.converter.ProfessorConverter;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

	
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return (container ->
		container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"),
							new ErrorPage(HttpStatus.FORBIDDEN, "/403"),
							new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500")));
	}
	
	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		conversionService.addConverter(new IesConverter());
		conversionService.addConverter(new CursoConverter());
		conversionService.addConverter(new ProfessorConverter());

		return conversionService;
	}
	
	@Bean
	public DomainClassConverter<FormattingConversionService> domainClassConverter(){
		return new DomainClassConverter<FormattingConversionService>(mvcConversionService());
	}
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/gip");
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
		
	@Bean
	public ViewResolver jasperReportsViewResolver(DataSource datasource) {
		JasperReportsViewResolver resolver = new JasperReportsViewResolver();
		resolver.setPrefix("classpath:/relatorios/");
		resolver.setSuffix(".jasper");
		resolver.setViewNames("relatorio_*");
		resolver.setViewClass(JasperReportsMultiFormatView.class);
		resolver.setJdbcDataSource(datasource);
		resolver.setOrder(0);
		return resolver;
	}
	
	@Bean
	public TemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setEnableSpringELCompiler(true);
		engine.setTemplateResolver(templateResolver());
		engine.addDialect(new LayoutDialect());
		engine.addDialect(new DataAttributeDialect());
		engine.addDialect(new SpringSecurityDialect());
		return engine;
	}
	
	private ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setApplicationContext(applicationContext);
		resolver.setPrefix("classpath:/templates/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode(TemplateMode.HTML);
		return resolver;
	}
		
}