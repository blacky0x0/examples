package com.example;

import org.jooq.util.GenerationTool;
import org.jooq.util.jaxb.*;

public class JooqGenerator {

    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration()
                .withJdbc(new Jdbc()
                        .withDriver("org.postgresql.Driver")
                        .withUrl("jdbc:postgresql:library")
                        .withUser("postgres")
                        .withPassword("postgres"))
                .withGenerator(new Generator()
                        .withDatabase(new Database()
                                .withName("org.jooq.util.postgres.PostgresDatabase")
                                .withIncludes(".*")
                                .withExcludes("")
                                .withInputSchema("public"))
                        .withTarget(new Target()
                                .withPackageName("com.example.entity.postgres")
                                .withDirectory("src/generated"))
                        .withGenerate(new Generate()
                                .withDaos(true)
                                .withPojos(true)
                                .withSpringAnnotations(true)
                                .withValidationAnnotations(true)));

        GenerationTool.generate(configuration);
    }

}
