package com.softserveinc.ita.redplatform.persistence.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAgency;
import com.softserveinc.ita.redplatform.persistence.dao.RealEstateAdminUserDao;

/**
 * The class JPARealEstateAdminDao.
 * 
 * @author Hryhorii Somyk
 */
@Repository
public class JPARealEstateAdminUserDao 
		extends JPAGenericDao<RealEstateAdminUser, Long> 
		implements RealEstateAdminUserDao {

	@Override
	@SuppressWarnings("unchecked")
	public final List<RealEstateAdminUser> 
	findAdminsByCompany(final String companyName) {
		return (List<RealEstateAdminUser>) getEntityManager()
				.createQuery("from " + RealEstateAdminUser.class.getName()
						+ " as user where user.id in (select redadmin.id from "
						+ RealEstateAdminUser.class.getName()
						+ " as redadmin inner join redadmin.agency"
						+ " as agency where agency.name=:companyName))")
				.setParameter("companyName", companyName).getResultList();
	}

	@Override
	public final RealEstateAgency findAgencyByEmail(final String email) {
	    return (RealEstateAgency) getEntityManager().createQuery(
		    "select agency from " + RealEstateAdminUser.class.getName()
		    + " where email=:email").setParameter("email", email)
		    .getSingleResult();
	}
}
