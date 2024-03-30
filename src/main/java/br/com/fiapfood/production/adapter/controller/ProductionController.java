package br.com.fiapfood.production.adapter.controller;

import br.com.fiapfood.production.domain.usecase.ProductionUseCase;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class ProductionController {

    private final ProductionUseCase productionUseCase;

    @GetMapping("/{orderId}")
    public ResponseEntity<String> getOrder(@PathVariable Long orderId, HttpServletRequest request){

        var token = request.getHeader("Authorization");

        return ResponseEntity.ok(productionUseCase.findOrder(orderId, token));
    }

    @PostMapping
    public void send(){
        productionUseCase.publishMessage("1");
    }

    @PutMapping("/{orderId}")
    public void updateStatus(@PathVariable String orderId){

        productionUseCase.updateStatus(orderId);

    }

}
