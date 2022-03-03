package com.nttdata.bootcoin.controller;

import com.nttdata.bootcoin.entity.BootCoin;
import com.nttdata.bootcoin.service.BootCoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bootcoin")
public class BootCoinController {

    @Autowired
    BootCoinService bootCoinService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<BootCoin> getBootCoin(){
        return bootCoinService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BootCoin> saveBootCoin(@RequestBody BootCoin bootCoin){
        return bootCoinService.save(bootCoin);
    }

    @GetMapping("type/{serviceType}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<BootCoin> getBootCoinByServiceType(@PathVariable String serviceType){
        return bootCoinService.findByServiceType(serviceType);
    }
}
