package com.nsn.zerg.viper.webservice.rs;

import com.nsn.zerg.viper.entity.Admin;
import com.nsn.zerg.viper.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    @Produces({MediaType.TEXT_PLAIN})
    public String getAdmin(@PathParam("id") Long id)
    {
        Admin admin = adminService.getAdmin(id);
        logger.debug("entity: " + admin);
        return admin.toString();
    }

    @Inject
    public void setAdminService(AdminService adminService)
    {
        this.adminService = adminService;
    }

} // end class
