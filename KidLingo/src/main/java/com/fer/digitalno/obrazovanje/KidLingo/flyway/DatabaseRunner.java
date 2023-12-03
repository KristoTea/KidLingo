package com.fer.digitalno.obrazovanje.KidLingo.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseRunner implements ApplicationRunner {
    Flyway flyway;

    @Autowired
    public DatabaseRunner(Flyway flyway) {
        this.flyway = flyway;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        flyway.clean();
        flyway.migrate();
    }
}
