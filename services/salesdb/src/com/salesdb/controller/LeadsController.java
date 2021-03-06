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
import com.salesdb.Leads;
import com.salesdb.Quotes;
import com.salesdb.service.LeadsService;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Leads.
 * @see Leads
 */
@RestController("salesdb.LeadsController")
@Api(value = "LeadsController", description = "Exposes APIs to work with Leads resource.")
@RequestMapping("/salesdb/Leads")
public class LeadsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeadsController.class);

    @Autowired
    @Qualifier("salesdb.LeadsService")
    private LeadsService leadsService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Creates a new Leads instance.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Leads createLeads(@RequestBody Leads leads) {
        LOGGER.debug("Create Leads with information: {}", leads);
        leads = leadsService.create(leads);
        LOGGER.debug("Created Leads with information: {}", leads);
        return leads;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the Leads instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Leads getLeads(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Leads with id: {}", id);
        Leads foundLeads = leadsService.getById(id);
        LOGGER.debug("Leads details with id: {}", foundLeads);
        return foundLeads;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the Leads instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Leads editLeads(@PathVariable(value = "id") Integer id, @RequestBody Leads leads) throws EntityNotFoundException {
        LOGGER.debug("Editing Leads with id: {}", leads.getId());
        leads.setId(id);
        leads = leadsService.update(leads);
        LOGGER.debug("Leads details with id: {}", leads);
        return leads;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the Leads instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteLeads(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Leads with id: {}", id);
        Leads deletedLeads = leadsService.delete(id);
        return deletedLeads != null;
    }

    /**
     * @deprecated Use {@link #findLeads(String, Pageable)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Leads instances matching the search criteria.")
    public Page<Leads> findLeads(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Leads list");
        return leadsService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Leads instances matching the search criteria.")
    public Page<Leads> findLeads(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Leads list");
        return leadsService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportLeads(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return leadsService.export(exportType, query, pageable);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the total count of Leads instances.")
    public Long countLeads(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Leads");
        return leadsService.count(query);
    }

    @RequestMapping(value = "/{id:.+}/quoteses", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the quoteses instance associated with the given id.")
    public Page<Quotes> findAssociatedQuoteses(@PathVariable("id") Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated quoteses");
        return leadsService.findAssociatedQuoteses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LeadsService instance
	 */
    protected void setLeadsService(LeadsService service) {
        this.leadsService = service;
    }
}
