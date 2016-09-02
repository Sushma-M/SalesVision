/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.salesdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.salesdb.FollowUps;
import com.salesdb.service.FollowUpsService;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class FollowUps.
 * @see FollowUps
 */
@RestController("salesdb.FollowUpsController")
@Api(value = "FollowUpsController", description = "Exposes APIs to work with FollowUps resource.")
@RequestMapping("/salesdb/FollowUps")
public class FollowUpsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FollowUpsController.class);

    @Autowired
    @Qualifier("salesdb.FollowUpsService")
    private FollowUpsService followUpsService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Creates a new FollowUps instance.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public FollowUps createFollowUps(@RequestBody FollowUps followups) {
        LOGGER.debug("Create FollowUps with information: {}", followups);
        followups = followUpsService.create(followups);
        LOGGER.debug("Created FollowUps with information: {}", followups);
        return followups;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the FollowUps instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public FollowUps getFollowUps(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting FollowUps with id: {}", id);
        FollowUps foundFollowUps = followUpsService.getById(id);
        LOGGER.debug("FollowUps details with id: {}", foundFollowUps);
        return foundFollowUps;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the FollowUps instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public FollowUps editFollowUps(@PathVariable(value = "id") Integer id, @RequestBody FollowUps followups) throws EntityNotFoundException {
        LOGGER.debug("Editing FollowUps with id: {}", followups.getId());
        followups.setId(id);
        followups = followUpsService.update(followups);
        LOGGER.debug("FollowUps details with id: {}", followups);
        return followups;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the FollowUps instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteFollowUps(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting FollowUps with id: {}", id);
        FollowUps deletedFollowUps = followUpsService.delete(id);
        return deletedFollowUps != null;
    }

    /**
     * @deprecated Use {@link #findFollowUps(String, Pageable)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of FollowUps instances matching the search criteria.")
    public Page<FollowUps> findFollowUps(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering FollowUps list");
        return followUpsService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of FollowUps instances matching the search criteria.")
    public Page<FollowUps> findFollowUps(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering FollowUps list");
        return followUpsService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportFollowUps(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return followUpsService.export(exportType, query, pageable);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the total count of FollowUps instances.")
    public Long countFollowUps(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting FollowUps");
        return followUpsService.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service FollowUpsService instance
	 */
    protected void setFollowUpsService(FollowUpsService service) {
        this.followUpsService = service;
    }
}
