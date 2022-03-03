package com.nttdata.bootcoin.repository;

import com.nttdata.bootcoin.entity.BootCoin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface BootCoinRepository extends ReactiveMongoRepository<BootCoin, String> {
    Mono<BootCoin>findByServiceType(String serviceType);
}
