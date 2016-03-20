package com.softserveinc.ita.redplatform.web.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

/**
 * Provides an implementation of Jackson's, which
 * makes it aware of Hibernate's lazy collections,
 * which it prunes before rendering.
 * 
 */
@SuppressWarnings("serial")
public class HibernateAwareObjectMapper extends ObjectMapper {
    
    /**
     * register Hibernate4 module.
     */
    public HibernateAwareObjectMapper() {
        registerModule(new Hibernate4Module());
    }
}