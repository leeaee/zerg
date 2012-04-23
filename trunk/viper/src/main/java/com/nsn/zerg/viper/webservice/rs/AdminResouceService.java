package com.nsn.zerg.viper.webservice.rs;

import com.nsn.zerg.viper.core.jersey.Jerseys;
import com.nsn.zerg.viper.entity.Admin;
import com.nsn.zerg.viper.exception.EntityNotFoundException;
import com.nsn.zerg.viper.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * User: YiLi
 * Date: 4/19/12
 * Time: 3:52 PM
 */
@Path("/admin")
public class AdminResouceService
{
    //Properties
    private static Logger logger = LoggerFactory.getLogger(AdminResouceService.class);

    private AdminService adminService;
    //Constructors

    //Methods
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Admin getAdmin(@PathParam("id") Long id)
    {
        logger.debug("get admin by @PathParam(\"id\"): {}", id);
        try
        {
            return adminService.getAdmin(id);
        }
        catch (EntityNotFoundException e)
        {
            throw Jerseys.buildException(404, e.getMessage());
        }
    }

    @DELETE
    @Produces({MediaType.TEXT_PLAIN})
    public String deleteAdmin(Long id)
    {
        logger.debug("delete admin by id: {}", id);
        adminService.deleteAdmin(id);
        return "delete admin by " + id + "successfully!";
    }

    @Inject
    public void setAdminService(AdminService adminService)
    {
        this.adminService = adminService;
    }

} // end class