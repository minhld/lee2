package com.minh.lee2.controller;

import com.minh.lee2.model.Customer;
import com.minh.lee2.model.CustomerOrder;
import com.minh.lee2.service.MainService;
import com.minh.lee2.model.SystemInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @Operation(
            summary = "Get system information",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "System information",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = SystemInfo.class)
                    )
            )
    )
    @GetMapping(path = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SystemInfo> info() {
        return ResponseEntity.ok(mainService.getSystemInfo());
    }

    @GetMapping(path = "/customer-order/{id}")
    public ResponseEntity<CustomerOrder> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(mainService.getCustomerOrder(id));
    }
}
