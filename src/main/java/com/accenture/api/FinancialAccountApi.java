/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.28).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.accenture.api;

import com.accenture.model.*;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-11-06T21:16:01.493Z")

@Validated
@Api(value = "financialAccount", description = "the financialAccount API")
@RequestMapping(value = "/accountManagement")
public interface FinancialAccountApi {

    @ApiOperation(value = "Creates a FinancialAccount", nickname = "createFinancialAccount", notes = "This operation creates a FinancialAccount entity.", response = FinancialAccountCreateEvent.class, tags={ "financialAccount", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = FinancialAccountCreateEvent.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/financialAccount",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    ResponseEntity<FinancialAccountCreateEvent> createFinancialAccount(
            @ApiParam(value = "The FinancialAccount to be created" ,required=true )
            @Valid @RequestBody FinancialAccount financialAccount
    );





    @ApiOperation(value = "Deletes a FinancialAccount", nickname = "deleteFinancialAccount", notes = "This operation deletes a FinancialAccount entity.", tags={ "financialAccount", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/financialAccount/{id}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteFinancialAccount(
            @ApiParam(value = "Identifier of the FinancialAccount",required=true)
            @PathVariable("id") String id
    );






    @ApiOperation(value = "Creates a FinancialAccount", nickname = "createFinancialAccount", notes = "This operation creates a FinancialAccount entity.", response = FinancialAccountCreateEvent.class, tags={ "financialAccount", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = FinancialAccountCreateEvent.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/api", method = RequestMethod.GET)
    ResponseEntity<FinancialAccountCreateEvent> createFinancial();

















    @ApiOperation(value = "List or find FinancialAccount objects", nickname = "listFinancialAccount", notes = "This operation list or find FinancialAccount entities", response = FinancialAccount.class, responseContainer = "List", tags={ "financialAccount", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = FinancialAccount.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/financialAccount",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.GET)
    ResponseEntity<List<FinancialAccount>> listFinancialAccount(
            @ApiParam(value = "Comma-separated properties to be provided in response")
            @Valid @RequestParam(value = "fields", required = false) String fields,
            @ApiParam(value = "Requested index for start of resources to be provided in response")
            @Valid @RequestParam(value = "offset", required = false) Integer offset,
            @ApiParam(value = "Requested number of resources to be provided in response")
            @Valid @RequestParam(value = "limit", required = false) Integer limit
    );


    @ApiOperation(value = "Updates partially a FinancialAccount", nickname = "patchFinancialAccount", notes = "This operation updates partially a FinancialAccount entity.", response = FinancialAccount.class, tags={ "financialAccount", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Updated", response = FinancialAccount.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/financialAccount/{id}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.PATCH)
    ResponseEntity<FinancialAccount> patchFinancialAccount(
            @ApiParam(value = "Identifier of the FinancialAccount",required=true)
            @PathVariable("id") String id,
            @ApiParam(value = "The FinancialAccount to be updated" ,required=true )
            @Valid @RequestBody FinancialAccountUpdate financialAccount
    );


    @ApiOperation(value = "Retrieves a FinancialAccount by ID", nickname = "retrieveFinancialAccount", notes = "This operation retrieves a FinancialAccount entity. Attribute selection is enabled for all first level attributes.", response = FinancialAccount.class, tags={ "financialAccount", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = FinancialAccount.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/financialAccount/{id}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.GET)
    ResponseEntity<FinancialAccount> retrieveFinancialAccount(
            @ApiParam(value = "Identifier of the FinancialAccount",required=true)
            @PathVariable("id") String id,
            @ApiParam(value = "Comma-separated properties to provide in response")
            @Valid @RequestParam(value = "fields", required = false) String fields
    );

}
