/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.rest;

import com.airhacks.models.User;
import com.airhacks.serviceImp.UserServiceImpl;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author william
 */
@Path("/users")
public class UserController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {

        UserServiceImpl serviceImpl = new UserServiceImpl();
        List<User> users = serviceImpl.getUsers();
        GenericEntity<List<User>> obj = new GenericEntity<List<User>>(users) {
        };
        return Response.ok().entity(obj).build();
    }

    @Path("/{userId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userId") String userId) {

        if (userId == null || userId.length() == 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        long userID = Long.parseLong(userId);
        UserServiceImpl service = new UserServiceImpl();
        User user = service.getUser(userID);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(user).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        UserServiceImpl serviceImpl = new UserServiceImpl();
        serviceImpl.saveUser(user);
        return Response.ok().build();
    }

    @Path("/{userId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("userId") String userId,User user) {

        return Response.ok().build();
    }

}
