package br.com.fiapfood.production.adapter.controller;

import br.com.fiapfood.production.domain.usecase.ProductionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class ProductionController {

    private final ProductionUseCase productionUseCase;


    @PostMapping
    public void send(){
        productionUseCase.publishMessage("1");
    }

    @PutMapping("/{orderId}")
    public void updateStatus(@PathVariable String orderId){

        productionUseCase.updateStatus(orderId);

    }

}
