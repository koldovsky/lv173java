package com.softserveinc.ita.redplatform.business.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

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
@Service
public class CustomerUserService extends AbstractUserService {

    /**
     * Customer user dao.
     */
    @Autowired
    private CustomerUserDao customerUserDao;

    /**
     * Customer user mapper.
     */
    @Autowired
    private CustomerUserMapper customerUserMapper;

    @Override
    protected User getUserEntity(final Object dto) {
	return customerUserMapper.toEntity((CustomerUserDTO) dto);
    }

    @Override
    protected GenericDao getDao() {
	return customerUserDao;
    }

    /**
     * load all customer users using predicate.
     * 
     * @param predicate
     *            predicate
     * @return customer user list
     */
    @Secured("ROLE_REDADMIN")
    public List<CustomerUserDTO>
	    loadCustomerUsers(final DataTablePredicate predicate) {
	List<CustomerUserDTO> list = new LinkedList<CustomerUserDTO>();
	for (CustomerUser user : customerUserDao.findAll(predicate)) {
	    list.add(customerUserMapper.toDto(user));
	}
	return list;
    }

    /**
     * count all customer users.
     * 
     * @return count
     */
    @Secured("ROLE_REDADMIN")
    public long countAllCustomerUsers() {
	return customerUserDao.countAll();
    }

    /**
     * count all customer users using predicate.
     * 
     * @param predicate
     *            predicate
     * @return count
     */
    @Secured("ROLE_REDADMIN")
    public long countAllCustomerUsers(final DataTablePredicate predicate) {
	return customerUserDao.countAll(predicate);
    }

}
