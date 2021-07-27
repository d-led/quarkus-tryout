package com.github.d.led.controllers;

import com.github.d.led.services.Maths;
import com.github.d.led.data.IntResult;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Tryout {

    private final Maths maths;

    @Inject
    public Tryout(Maths maths) {
        this.maths = maths;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/multiply")
    public IntResult multiply(
            @QueryParam("a") int a,
            @QueryParam("b") int b) {
        return IntResult.builder().result(maths.multiply(a, b)).build();
    }
}
