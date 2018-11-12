package com.zyla.assignment;

import com.zyla.assignment.mapper.JsonProcessingExceptionMapper;
import com.zyla.assignment.resources.PhoneNumberResource;
import com.zyla.assignment.service.PhoneNumberService;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class AllotPhoneNumbersApplication extends Application<AllotPhoneNumbersConfiguration> {

    public static void main(final String[] args) throws Exception {
        new AllotPhoneNumbersApplication().run(args);
    }

    @Override
    public String getName() {
        return "AllotPhoneNumbers";
    }

    @Override
    public void initialize(final Bootstrap<AllotPhoneNumbersConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<AllotPhoneNumbersConfiguration>() {
            @Override
            public PooledDataSourceFactory getDataSourceFactory(AllotPhoneNumbersConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(final AllotPhoneNumbersConfiguration configuration,
                    final Environment environment) {

        // Set up DB
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "sqlite");

        // Add resources
        environment.jersey().register(new PhoneNumberResource(jdbi.onDemand(PhoneNumberService.class)));

        // Exception Mappers
        environment.jersey().register(new JsonProcessingExceptionMapper(environment.metrics()));
    }
}
