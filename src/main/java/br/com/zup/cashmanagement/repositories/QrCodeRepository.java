package br.com.zup.cashmanagement.repositories;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.com.zup.cashmanagement.models.QrCode;

@EnableScan
public interface QrCodeRepository extends CrudRepository<QrCode, String> {

    
    List<QrCode> findAll();

}