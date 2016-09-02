/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.salesdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.salesdb.Tasks;

/**
 * Service object for domain model class Tasks.
 *
 * @see {@link Tasks}
 */
public interface TasksService {

    /**
     * Creates a new Tasks.
     *
     * @param tasks The information of the created CompositeTable.
     * @return The created Tasks.
     */
	Tasks create(Tasks tasks);


	/**
	 * Finds Tasks by id.
	 *
	 * @param tasksId The id of the wanted Tasks.
	 * @return The found Tasks. If no Tasks is found, this method returns null.
	 */
	Tasks getById(Integer tasksId) throws EntityNotFoundException;


	/**
	 * Updates the information of a Tasks.
	 *
	 * @param tasks The information of the updated Tasks.
	 * @return The updated Tasks.
     *
	 * @throws EntityNotFoundException if no Tasks is found with given id.
	 */
	Tasks update(Tasks tasks) throws EntityNotFoundException;

    /**
	 * Deletes a Tasks.
	 *
	 * @param tasksId The id of the deleted Tasks.
	 * @return The deleted Tasks.
     *
	 * @throws EntityNotFoundException if no Tasks is found with the given id.
	 */
	Tasks delete(Integer tasksId) throws EntityNotFoundException;

	/**
	 * Finds all Tasks.
	 *
	 * @return A list of Tasks.
	 */
    @Deprecated
	Page<Tasks> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all Tasks.
	 * @return A list of Tasks.
	 */
    Page<Tasks> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Tasks in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the Tasks.
	 */
	long count(String query);


}

