package br.com.zup.cashmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.cashmanagement.models.QrCode;
import br.com.zup.cashmanagement.repositories.QrCodeRepository;
import br.com.zup.cashmanagement.services.KafkaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/qrcode")
public class QrCodeController {

    @Autowired
    private QrCodeRepository repository;

    @Autowired
    private KafkaService<QrCode> kafkaService;
    
    @GetMapping
    public List<QrCode> findAll() {
        return repository.findAll();
    }
    
    @PostMapping
    public void createQrCode(@RequestBody QrCode qrCode) {        
        kafkaService.send("qrcode-save", qrCode);
    }   
}