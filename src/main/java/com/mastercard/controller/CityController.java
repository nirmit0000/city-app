package com.mastercard.controller;

import com.mastercard.errorhandler.ArgumentNotValidException;
import com.mastercard.service.ICityService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    ICityService cityService;

    @ApiOperation(value = "Check if cities are connected via Road")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully returned response")
    })
    @RequestMapping(value = "/connected", method = RequestMethod.GET)
    public boolean isCityConnected(@RequestParam String origin, @RequestParam String destination) throws Exception {
        if (StringUtils.isEmpty(origin) || StringUtils.isEmpty(destination)) {
            throw new ArgumentNotValidException("origin or destination is empty");
        }
        return cityService.isCityConnected(origin, destination);
    }

}
