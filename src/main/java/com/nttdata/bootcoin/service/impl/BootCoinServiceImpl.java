package com.nttdata.bootcoin.service.impl;

import com.nttdata.bootcoin.entity.BootCoin;
import com.nttdata.bootcoin.repository.BootCoinRepository;
import com.nttdata.bootcoin.service.BootCoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class BootCoinServiceImpl implements BootCoinService {

    @Autowired
    BootCoinRepository bootCoinRepository;

    @Override
    public Flux<BootCoin> findAll() {
        return bootCoinRepository.findAll();
    }

    @Override
    public Mono<BootCoin> save(BootCoin entity) {
        entity.setStatus(true);
        entity.setCreatedAt(new Date());
        return bootCoinRepository.save(entity);
    }

    @Override
    public Mono<BootCoin> update(BootCoin entity, String id) {
        return  bootCoinRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .flatMap(origin -> {
                    entity.setServiceType(entity.getServiceType()==null ? origin.getServiceType() : entity.getServiceType());
                    entity.setRate(entity.getRate()==null ? origin.getRate() : entity.getRate());
                    return bootCoinRepository.save(origin);
                });
    }

    @Override
    public Mono<BootCoin> deleteById(String id) {
        return bootCoinRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .flatMap(origin -> {
                    origin.setStatus(false);
                    return bootCoinRepository.save(origin);
                });
    }

    @Override
    public Mono<BootCoin> findByServiceType(String serviceType) {
        return bootCoinRepository.findByServiceType(serviceType);
    }
}
