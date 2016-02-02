package com.softserveinc.ita.redplatform.persistence.dao;

import java.util.List;

public interface GenericDao <E, N>{
    
    E findById(N id);

    void save(E entity);

    void remove(E entity);

    E update(E entity);

    List<E> findAll();
}
