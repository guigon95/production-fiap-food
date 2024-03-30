package br.com.fiapfood.production.adapter.controller;

import br.com.fiapfood.production.domain.usecase.ProductionUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/production")
public class ProductionController {

    private final ProductionUseCase productionUseCase;

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "4xx", description = "Invalid data", content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error", content = @Content) })
    @GetMapping("/{orderId}")
    public ResponseEntity<String> getOrder(@PathVariable Long orderId, HttpServletRequest request){

        var token = request.getHeader("Authorization");

        return ResponseEntity.ok(productionUseCase.findOrder(orderId, token));
    }

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "4xx", description = "Invalid data", content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error", content = @Content) })
    @PutMapping("/{orderId}")
    public void updateStatus(@PathVariable String orderId){

        productionUseCase.updateStatus(orderId);

    }

}
