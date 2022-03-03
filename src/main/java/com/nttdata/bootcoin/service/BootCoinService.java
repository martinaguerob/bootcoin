package com.nttdata.bootcoin.service;

import com.nttdata.bootcoin.entity.BootCoin;
import reactor.core.publisher.Mono;

public interface BootCoinService extends CrudService<BootCoin, String> {

    //Buscar según tipo de servicio
    Mono<BootCoin> findByServiceType(String serviceType);
}
