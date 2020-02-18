package br.com.zup.cashmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.cashmanagement.models.QrCode;
import br.com.zup.cashmanagement.repositories.QrCodeRepository;

@RestController
@RequestMapping(path = "qrcode")
public class QrCodeController {

    @Autowired
    private QrCodeRepository repository;

    @GetMapping
    public List<QrCode> findAll() {
        return repository.findAll();
    }
    
}