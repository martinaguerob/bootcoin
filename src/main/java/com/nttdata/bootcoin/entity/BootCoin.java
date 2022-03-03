package com.nttdata.bootcoin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "bootcoin")
public class BootCoin {

    @Id
    private String id;
    private String serviceType; // Buys, Sale
    private Double rate; // tasa de compra o venta
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date createdAt;
    private Boolean status;

}
