package com.pcbaecker.wildflySwarmSwaggerExample.rfs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by wlw on 15.11.16.
 */

@Path("example")
@Api(value = "example")
public class ExampleRfs {

  @GET
  @Path("test")
  @Produces(MediaType.APPLICATION_JSON)
  @ApiOperation(value = "test")
  public Response test() {
    return Response.status(200).entity("Hello World!").build();
  }

}
