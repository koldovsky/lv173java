package com.softserveinc.ita.redplatform.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import 
 com.softserveinc.ita.redplatform.business.service.RealEstateAdminUserService;
import com.softserveinc.ita.redplatform.common.dto.RealEstateAdminUserDTO;

/**
 * The class RealEstateAdminUserRestController.
 * 
 * @author Ilona Yavorska
 */
@RestController
public class RealEstateAdminUserRestController {

    /** The admin service. */
    @Autowired
    private RealEstateAdminUserService adminService;

    /**
     * Registers the admin.
     *
     * @param dto
     *            the dto
     * @return the response entity
     */
    @RequestMapping(value = "/redadmin", method = RequestMethod.POST)
    public final ResponseEntity<RealEstateAdminUserDTO>
	    adminRegister(@RequestBody final RealEstateAdminUserDTO dto) {
	adminService.register(dto);
	return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Edits the admin.
     *
     * @param id
     *            the id
     * @param dto
     *            the dto
     * @return the response entity
     */
    @RequestMapping(value = "/redadmin/{id}", method = RequestMethod.POST)
    public final ResponseEntity<RealEstateAdminUserDTO> editAdmin(
	    @PathVariable final Long id,
	    @RequestBody final RealEstateAdminUserDTO dto) {
	adminService.update(dto);
	return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Get id of redadmin agency.
     * 
     * @return agencyID
     */
    @RequestMapping(value = "api/agencyId")
    public final long getAgencyId() {
	RealEstateAdminUserDTO redadmin =
		adminService.loadRealEstateAdminUserByName(SecurityContextHolder
			.getContext().getAuthentication().getName());
	return redadmin.getAgencyId();
    }

}
