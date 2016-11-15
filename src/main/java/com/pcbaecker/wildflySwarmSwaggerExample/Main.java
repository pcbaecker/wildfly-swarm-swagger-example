package com.pcbaecker.wildflySwarmSwaggerExample;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.logging.LoggingFraction;
import org.wildfly.swarm.swagger.SwaggerArchive;

/**
 * Created by wlw on 15.11.16.
 */
public class Main {

  public static void main(String[] args) throws Exception {
    Swarm swarm = new Swarm();

    // Create JAX-RS archive
    JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
    deployment.addPackages(true, Main.class.getPackage());
    deployment.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

    // Configure the swagger part of the archive
    SwaggerArchive archive = deployment.as(SwaggerArchive.class);
    archive.setTitle("Wildfly Swarm Swagger Example");
    archive.setVersion("1.0.0");
    archive.setContextRoot("myapi");
    archive.setPrettyPrint(true);
    archive.setContact("Philipp C. Baecker <pcbaecker@gmail.com>");
    archive.setResourcePackages("com.pcbaecker.wildflySwarmSwaggerExample.rfs");

    // Make the deployment use all dependencies
    deployment.addAllDependencies();

    // Start swarm
    swarm.fraction(LoggingFraction.createDefaultLoggingFraction())
        .start().deploy(deployment);
  }

}
