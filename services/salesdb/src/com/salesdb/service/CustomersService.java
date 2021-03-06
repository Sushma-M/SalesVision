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
import com.salesdb.Leads;

/**
 * Service object for domain model class Customers.
 *
 * @see {@link Customers}
 */
public interface CustomersService {

    /**
     * Creates a new Customers.
     *
     * @param customers The information of the created CompositeTable.
     * @return The created Customers.
     */
	Customers create(Customers customers);


	/**
	 * Finds Customers by id.
	 *
	 * @param customersId The id of the wanted Customers.
	 * @return The found Customers. If no Customers is found, this method returns null.
	 */
	Customers getById(Integer customersId) throws EntityNotFoundException;


	/**
	 * Updates the information of a Customers.
	 *
	 * @param customers The information of the updated Customers.
	 * @return The updated Customers.
     *
	 * @throws EntityNotFoundException if no Customers is found with given id.
	 */
	Customers update(Customers customers) throws EntityNotFoundException;

    /**
	 * Deletes a Customers.
	 *
	 * @param customersId The id of the deleted Customers.
	 * @return The deleted Customers.
     *
	 * @throws EntityNotFoundException if no Customers is found with the given id.
	 */
	Customers delete(Integer customersId) throws EntityNotFoundException;

	/**
	 * Finds all Customers.
	 *
	 * @return A list of Customers.
	 */
    @Deprecated
	Page<Customers> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all Customers.
	 * @return A list of Customers.
	 */
    Page<Customers> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Customers in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the Customers.
	 */
	long count(String query);

    /*
     * Returns associate customers for given Customers id.
     *
     * @param id id value
     * @return Associate Leads instances.
     */
    Page<Leads> findAssociatedLeadses(int id, Pageable pageable);

}

