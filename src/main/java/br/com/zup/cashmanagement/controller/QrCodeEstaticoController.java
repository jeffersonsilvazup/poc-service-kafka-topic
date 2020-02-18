package br.com.zup.cashmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.cashmanagement.forms.QrCodeEstatico;
import br.com.zup.cashmanagement.mappers.QrCodeMaper;
import br.com.zup.cashmanagement.models.QrCode;
import br.com.zup.cashmanagement.services.KafkaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/qrcode/estatico")
public class QrCodeEstaticoController {

    @Autowired
    private KafkaService<QrCode> kafkaService;
    
    @PostMapping
    public void createQrCode(@RequestBody QrCodeEstatico qrCode) {        
        kafkaService.send("qrcode-save", QrCodeMaper.qrCodeEstaticoToQrCode(qrCode));
    }   
}