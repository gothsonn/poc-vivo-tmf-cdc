package com.accenture.api;

import com.accenture.model.FinancialAccount;
import com.accenture.model.FinancialAccountUpdate;
import com.accenture.model.FinancialAccountCreate;
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
public class FinancialAccountApiController implements FinancialAccountApi {

    private static final Logger log = LoggerFactory.getLogger(FinancialAccountApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public FinancialAccountApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<FinancialAccount> createFinancialAccount(@ApiParam(value = "The FinancialAccount to be created" ,required=true )  @Valid @RequestBody FinancialAccountCreate financialAccount) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<FinancialAccount>(objectMapper.readValue("{\"empty\": false}", FinancialAccount.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<FinancialAccount>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<FinancialAccount>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteFinancialAccount(@ApiParam(value = "Identifier of the FinancialAccount",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<FinancialAccount>> listFinancialAccount(@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<FinancialAccount>>(objectMapper.readValue("{}", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<FinancialAccount>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<FinancialAccount>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<FinancialAccount> patchFinancialAccount(@ApiParam(value = "Identifier of the FinancialAccount",required=true) @PathVariable("id") String id,@ApiParam(value = "The FinancialAccount to be updated" ,required=true )  @Valid @RequestBody FinancialAccountUpdate financialAccount) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<FinancialAccount>(objectMapper.readValue("{\"empty\": false}", FinancialAccount.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<FinancialAccount>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<FinancialAccount>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<FinancialAccount> retrieveFinancialAccount(@ApiParam(value = "Identifier of the FinancialAccount",required=true) @PathVariable("id") String id,@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<FinancialAccount>(objectMapper.readValue("{\"empty\": false}", FinancialAccount.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<FinancialAccount>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<FinancialAccount>(HttpStatus.NOT_IMPLEMENTED);
    }

}
