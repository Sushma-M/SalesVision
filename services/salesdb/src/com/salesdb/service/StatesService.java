/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.salesdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.salesdb.Customers;
import com.salesdb.States;

/**
 * Service object for domain model class States.
 *
 * @see {@link States}
 */
public interface StatesService {

    /**
     * Creates a new States.
     *
     * @param states The information of the created CompositeTable.
     * @return The created States.
     */
	States create(States states);


	/**
	 * Finds States by id.
	 *
	 * @param statesId The id of the wanted States.
	 * @return The found States. If no States is found, this method returns null.
	 */
	States getById(Integer statesId) throws EntityNotFoundException;


	/**
	 * Updates the information of a States.
	 *
	 * @param states The information of the updated States.
	 * @return The updated States.
     *
	 * @throws EntityNotFoundException if no States is found with given id.
	 */
	States update(States states) throws EntityNotFoundException;

    /**
	 * Deletes a States.
	 *
	 * @param statesId The id of the deleted States.
	 * @return The deleted States.
     *
	 * @throws EntityNotFoundException if no States is found with the given id.
	 */
	States delete(Integer statesId) throws EntityNotFoundException;

	/**
	 * Finds all States.
	 *
	 * @return A list of States.
	 */
    @Deprecated
	Page<States> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all States.
	 * @return A list of States.
	 */
    Page<States> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the States in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the States.
	 */
	long count(String query);

    /*
     * Returns associate states for given States id.
     *
     * @param id id value
     * @return Associate Customers instances.
     */
    Page<Customers> findAssociatedCustomerses(int id, Pageable pageable);

}

