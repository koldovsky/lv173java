package com.softserveinc.ita.redplatform.business.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    protected User getEntity(final Object dto) {
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

    /**
     * Checks if this customer is present in the system.
     * @param customerId customer Id
     * @return boolean true if it exists
     */
    @Secured("ROLE_REDADMIN")
    public boolean isCustomerIdPresent(final Long customerId) {
	return customerUserDao.findById(customerId) != null;
    }

    @Override
    protected CustomerUserDTO getUserDTO(final User user) {
	return customerUserMapper.toDto((CustomerUser) user);
    }
    /**
     * Get UserDTO by email.
     * @param email customer user email
     * @return customer user dto
     */
    @Secured("ROLE_REDADMIN")
    public CustomerUserDTO getUserDTOByEmail(final String email) {
	return customerUserMapper.toDto(
		customerUserDao.getCustomerUserByEmail(email));
    }
    
    /**
     * Get UserDTO be id.
     * @param id customer user id
     * @return csutomer user dto
     */
    @Secured("ROLE_REDADMIN")
    public CustomerUserDTO getUserDTOById(final Long id) {
	return customerUserMapper.toDto(customerUserDao.findById(id));
    }
    
    /**
     * Register new customer user.
     * @param customer user dto
     */
    @Transactional
    @Secured("ROLE_REDADMIN")
    public void register(final Object customer) {
	super.register(customer);
    }
    
    /**
     * Update new customer user.
     * @param customer user dto
     */
    @Transactional
    @Secured("ROLE_USER")
    public void update(final CustomerUserDTO customer) {
	customerUserDao.updateCustomerFields(
		customerUserMapper.toEntity(customer));
    }
    
    /**
     * Retrieve customer user dto by id.
     *
     * @param id
     *            the id
     * @return the customer user dto
     */
    @Transactional
    @Secured("ROLE_USER")
    public Object retrieve(final Long id) {
	return super.retrieve(id);
    }

}
