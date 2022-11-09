package com.accenture.api;

import com.accenture.model.BillingCycleSpecification;
import com.accenture.model.BillingCycleSpecificationCreate;
import com.accenture.model.BillingCycleSpecificationUpdate;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-11-06T21:16:01.493Z")

@Controller
public class BillingCycleSpecificationApiController implements BillingCycleSpecificationApi {

    private static final Logger log = LoggerFactory.getLogger(BillingCycleSpecificationApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BillingCycleSpecificationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<BillingCycleSpecification> createBillingCycleSpecification(@ApiParam(value = "The BillingCycleSpecification to be created" ,required=true )  @Valid @RequestBody BillingCycleSpecificationCreate billingCycleSpecification) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BillingCycleSpecification>(objectMapper.readValue("{\"empty\": false}", BillingCycleSpecification.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BillingCycleSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BillingCycleSpecification>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteBillingCycleSpecification(@ApiParam(value = "Identifier of the BillingCycleSpecification",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<BillingCycleSpecification>> listBillingCycleSpecification(@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<BillingCycleSpecification>>(objectMapper.readValue("{}", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<BillingCycleSpecification>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<BillingCycleSpecification>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BillingCycleSpecification> patchBillingCycleSpecification(@ApiParam(value = "Identifier of the BillingCycleSpecification",required=true) @PathVariable("id") String id,@ApiParam(value = "The BillingCycleSpecification to be updated" ,required=true )  @Valid @RequestBody BillingCycleSpecificationUpdate billingCycleSpecification) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BillingCycleSpecification>(objectMapper.readValue("{\"empty\": false}", BillingCycleSpecification.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BillingCycleSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BillingCycleSpecification>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BillingCycleSpecification> retrieveBillingCycleSpecification(@ApiParam(value = "Identifier of the BillingCycleSpecification",required=true) @PathVariable("id") String id,@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BillingCycleSpecification>(objectMapper.readValue("{\"empty\": false}", BillingCycleSpecification.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BillingCycleSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BillingCycleSpecification>(HttpStatus.NOT_IMPLEMENTED);
    }

}
