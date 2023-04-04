package com.advancedjava.course.topic4.controllers;

import com.advancedjava.course.topic4.models.BootCamper;
import com.advancedjava.course.topic4.services.BootCamperService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class BootCampersController {
    private final BootCamperService bootCamperService;

    public BootCampersController(BootCamperService bootcamperService) {
        this.bootCamperService = bootcamperService;

        this.bootCamperService.add(new BootCamper("uno", Math.random()));
        this.bootCamperService.add(new BootCamper("dos", Math.random()));
        this.bootCamperService.add(new BootCamper("tres", Math.random()));
        this.bootCamperService.add(new BootCamper("cuatro", Math.random()));
        this.bootCamperService.add(new BootCamper("cinco", Math.random()));

    }

    @GET
    @Path("/bootcampers")
    @Produces("application/json")
    public List<BootCamper> findAll() {
        return bootCamperService.getAll();
    }

    @GET
    @Path("/bootcampers/{name}")
    @Produces("application/json")
    public BootCamper findByName(@PathParam("name") String name) {
        return bootCamperService.get(name);
    }


    @POST
    @Path("/bootcampers")
    @Produces("application/json")
    @Consumes("application/json")
    public Response saveBootCamper(BootCamper bootcamper) {
        bootCamperService.add(bootcamper);

        return Response.created(
                URI.create("/bootcampers/" + bootcamper.getName())
        ).build();
    }
}
