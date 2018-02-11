/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eoh.test.rest;

import eoh.test.eohejb.CicBean;
import eoh.test.cicjpa.Cic;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author hjd
 */
@Path("cic")
public class CicRest {
    
    @EJB
    CicBean cicBean;
    
    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCic(@QueryParam("id") Long id) {
        
        if(id == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("No parms provided").build();
        }
        
        Cic cic = cicBean.getCic(id);
        
        if(cic == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("No data found").build();
        } else {
            return Response.status(200).entity(cic).build();
        }
    }
    
    @POST
    @Path("post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCic(Cic cic) {
        if(cic == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Request Failed").build();
        }
        
        cic = cicBean.addCic(cic);
        
        if(cic == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Request Failed").build();
        } else {
            return Response.status(200).entity(cic).build();
        }
    }
}
