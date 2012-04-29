package com.nsn.zerg.viper.webservice.rs;

import com.nsn.zerg.viper.core.jersey.Jerseys;
import com.nsn.zerg.viper.core.mapper.BeanMapper;
import com.nsn.zerg.viper.exception.EntityNotFoundException;
import com.nsn.zerg.viper.service.AdminService;
import com.nsn.zerg.viper.webservice.rs.dto.AdminDto;
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

    //Methods
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public AdminDto getAdmin(@PathParam("id") Long id)
    {
        logger.debug("get admin by @PathParam(\"id\"): {}", id);
        try
        {
            return BeanMapper.map(adminService.getAdmin(id), AdminDto.class);
        }
        catch (EntityNotFoundException e)
        {
            throw Jerseys.buildException(e.getStatus(), e.getMessage());
        }
        catch (RuntimeException e)
        {
            throw Jerseys.buildDefaultException(e);
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