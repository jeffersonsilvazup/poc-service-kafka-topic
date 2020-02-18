package br.com.zup.cashmanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.cashmanagement.dto.QrCodeDinamicoDTO;
import br.com.zup.cashmanagement.forms.QrCodeDinamico;
import br.com.zup.cashmanagement.mappers.QrCodeMaper;
import br.com.zup.cashmanagement.models.QrCode;
import br.com.zup.cashmanagement.repositories.QrCodeRepository;
import br.com.zup.cashmanagement.services.KafkaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping(path = "/qrcode/dinamico")
public class QrCodeDinamicoController {

    @Autowired
    private QrCodeRepository repository;

    @Autowired
    private KafkaService<QrCode> kafkaService;

    @PostMapping
    public void postMethodName(@RequestBody QrCodeDinamico qrCodeDinamico) {
        kafkaService.send("qrcode-save", QrCodeMaper.qrCodeDinamicoToQrCode(qrCodeDinamico));
    }

    @GetMapping(value="{id}")
    public QrCodeDinamicoDTO getMethodName(@PathVariable String id) {
        return new QrCodeDinamicoDTO(repository.findById(id).get());
    }
    
    
}