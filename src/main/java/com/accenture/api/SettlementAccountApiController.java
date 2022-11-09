package com.accenture.api;

import com.accenture.model.SettlementAccount;
import com.accenture.model.SettlementAccountCreate;
import com.accenture.model.SettlementAccountUpdate;
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
public class SettlementAccountApiController implements SettlementAccountApi {

    private static final Logger log = LoggerFactory.getLogger(SettlementAccountApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SettlementAccountApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<SettlementAccount> createSettlementAccount(@ApiParam(value = "The SettlementAccount to be created" ,required=true )  @Valid @RequestBody SettlementAccountCreate settlementAccount) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SettlementAccount>(objectMapper.readValue("{\"empty\": false}", SettlementAccount.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SettlementAccount>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SettlementAccount>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteSettlementAccount(@ApiParam(value = "Identifier of the SettlementAccount",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<SettlementAccount>> listSettlementAccount(@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<SettlementAccount>>(objectMapper.readValue("{}", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<SettlementAccount>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<SettlementAccount>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SettlementAccount> patchSettlementAccount(@ApiParam(value = "Identifier of the SettlementAccount",required=true) @PathVariable("id") String id,@ApiParam(value = "The SettlementAccount to be updated" ,required=true )  @Valid @RequestBody SettlementAccountUpdate settlementAccount) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SettlementAccount>(objectMapper.readValue("{\"empty\": false}", SettlementAccount.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SettlementAccount>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SettlementAccount>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SettlementAccount> retrieveSettlementAccount(@ApiParam(value = "Identifier of the SettlementAccount",required=true) @PathVariable("id") String id,@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SettlementAccount>(objectMapper.readValue("{\"empty\": false}", SettlementAccount.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SettlementAccount>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SettlementAccount>(HttpStatus.NOT_IMPLEMENTED);
    }

}
