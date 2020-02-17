package br.com.zup.cashmanagement.consumers;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zup.cashmanagement.models.QrCode;
import br.com.zup.cashmanagement.repositories.QrCodeRepository;

@Component
public class QrCodeConsumer{

    @Autowired
    private QrCodeRepository repository;

    @KafkaListener(topics = "qrcode-save", groupId = "group_id")
    public void consume(ConsumerRecord<String,QrCode> consumerRecord){
        repository.save(consumerRecord.value());
    }
    
}