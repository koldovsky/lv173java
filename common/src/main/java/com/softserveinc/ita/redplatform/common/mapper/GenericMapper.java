package com.softserveinc.ita.redplatform.common.mapper;

/**
 * Generic mapper interface.
 * 
 * @author Oleh Khimka.
 *         
 * @param <E> Type of Entity.
 * @param <V> Type of DTO.
 */
public interface GenericMapper<E, V> {
    
    /**
     * Map entity to DTO.
     * 
     * @param entity
     *            entity that be mapped.
     * @return dto.
     */
    V toDto(E entity);

    /**
     * Map DTO to entity.
     * @param dto
     *            dto that be mapped.
     * @return entity.
     */
    E toEntity(V dto);
}
