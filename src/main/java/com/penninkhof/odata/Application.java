package com.penninkhof.odata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.penninkhof.odata.entities.Shoebox;
import com.penninkhof.odata.repository.ShoeboxRepository;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	static ShoeboxRepository repository;
	private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(final ShoeboxRepository repository) {
		this.repository = repository;
	    return new CommandLineRunner() {
			public void run(String... args) throws Exception {
				if (repository.count() == 0) {
					log.info("Database is still empty. Adding some sample records");
					repository.save(new Shoebox(1, "tvanschaik@roc-dev.com", "Thomas"));
					repository.save(new Shoebox(2, "sdinkelaar@roc-dev.com", "Stephan"));
					repository.save(new Shoebox(3, "rhuseni@roc-dev.com", "Rifati"));
					repository.save(new Shoebox(4, "skaddouri@roc-dev.com", "Soufyane"));
					repository.save(new Shoebox(5, "dwezeman@roc-dev.com", "Daniel"));
					
					
				}
	        }
	    };
	}
	
	public static String getEmail(long barcode) {
		return repository.findOne(barcode).getEmail();
	}
	
	

}