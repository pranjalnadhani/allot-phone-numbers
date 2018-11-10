package com.zyla.assignment;

import com.zyla.assignment.resources.PhoneNumberResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
        // TODO: application initialization
    }

    @Override
    public void run(final AllotPhoneNumbersConfiguration configuration,
                    final Environment environment) {
        PhoneNumberResource phoneNumberResource = new PhoneNumberResource();
        environment.jersey().register(phoneNumberResource);
    }
}
