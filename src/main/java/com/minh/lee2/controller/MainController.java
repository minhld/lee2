package com.minh.lee2.controller;

import com.minh.lee2.model.CustomerOrder;
import com.minh.lee2.service.MainService;
import com.minh.lee2.model.SystemInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Profile("dev")
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
    public ResponseEntity<CustomerOrder> getCustomerOrder(@PathVariable Long id) {
        return ResponseEntity.ok(mainService.getCustomerOrder(id));
    }

}
