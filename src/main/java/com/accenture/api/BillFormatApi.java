/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.28).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.accenture.api;

import com.accenture.model.BillFormat;
import com.accenture.model.BillFormatCreate;
import com.accenture.model.BillFormatUpdate;
import com.accenture.model.Error;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-11-06T21:16:01.493Z")

@Validated
@Api(value = "billFormat", description = "the billFormat API")
@RequestMapping(value = "/tmf-api/accountManagement/v4/")
public interface BillFormatApi {

    @ApiOperation(value = "Creates a BillFormat", nickname = "createBillFormat", notes = "This operation creates a BillFormat entity.", response = BillFormat.class, tags={ "billFormat", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = BillFormat.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/billFormat",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    ResponseEntity<BillFormat> createBillFormat(@ApiParam(value = "The BillFormat to be created" ,required=true )  @Valid @RequestBody BillFormatCreate billFormat);


    @ApiOperation(value = "Deletes a BillFormat", nickname = "deleteBillFormat", notes = "This operation deletes a BillFormat entity.", tags={ "billFormat", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/billFormat/{id}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteBillFormat(@ApiParam(value = "Identifier of the BillFormat",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "List or find BillFormat objects", nickname = "listBillFormat", notes = "This operation list or find BillFormat entities", response = BillFormat.class, responseContainer = "List", tags={ "billFormat", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = BillFormat.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/billFormat",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.GET)
    ResponseEntity<List<BillFormat>> listBillFormat(@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit);


    @ApiOperation(value = "Updates partially a BillFormat", nickname = "patchBillFormat", notes = "This operation updates partially a BillFormat entity.", response = BillFormat.class, tags={ "billFormat", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Updated", response = BillFormat.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/billFormat/{id}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.PATCH)
    ResponseEntity<BillFormat> patchBillFormat(@ApiParam(value = "Identifier of the BillFormat",required=true) @PathVariable("id") String id,@ApiParam(value = "The BillFormat to be updated" ,required=true )  @Valid @RequestBody BillFormatUpdate billFormat);


    @ApiOperation(value = "Retrieves a BillFormat by ID", nickname = "retrieveBillFormat", notes = "This operation retrieves a BillFormat entity. Attribute selection is enabled for all first level attributes.", response = BillFormat.class, tags={ "billFormat", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = BillFormat.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/billFormat/{id}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.GET)
    ResponseEntity<BillFormat> retrieveBillFormat(@ApiParam(value = "Identifier of the BillFormat",required=true) @PathVariable("id") String id,@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields);

}
