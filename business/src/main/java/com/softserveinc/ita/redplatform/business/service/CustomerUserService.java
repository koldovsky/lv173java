package com.softserveinc.ita.redplatform.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import com.softserveinc.ita.redplatform.common.dto.CustomerUserDTO;
import com.softserveinc.ita.redplatform.common.entity.CustomerUser;
import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.common.mapper.CustomerUserMapper;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;
import com.softserveinc.ita.redplatform.persistence.dao.CustomerUserDao;
import com.softserveinc.ita.redplatform.persistence.dao.GenericDao;

/**
 * Customer User Service.
 * 
 * @author Hryhorii Somyk
 */
public class CustomerUserService extends AbstractUserService {

    /**
     * Customer user dao.
     */
    @Autowired
    private CustomerUserDao customerUserDao;
    
    /**
     * Customer user mapper.
     */
    private CustomerUserMapper customerUsermapper;
    
    @Override
    protected User getUserEntity(final Object dto) {
	return customerUsermapper.toEntity((CustomerUserDTO) dto);
    }

    @Override
    protected GenericDao getDao() {
	return customerUserDao;
    }
    /**
     * load all customer users using predicate.
     * @param predicate predicate
     * @return customer user list
     */
    @Secured("ROLE_REDADMIN")
    public List<CustomerUser> loadCustomerUsers(
	    final DataTablePredicate predicate) {
	return customerUserDao.findAll(predicate);
    }
    
    /**
     * count all customer users.
     * @return count
     */
    @Secured("ROLE_REDADMIN")
    public long countAllCustomerUsers() {
	return customerUserDao.countAll();
    }
    
    /**
     * count all customer users using predicate.
     * @param predicate predicate
     * @return count
     */
    @Secured("ROLE_REDADMIN")
    public long countAllCustomerUsers(
	    final DataTablePredicate predicate) {
	return customerUserDao.countAll(predicate);
    }

}
