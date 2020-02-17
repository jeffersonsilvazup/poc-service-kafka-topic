package br.com.zup.cashmanagement.models;

import java.math.BigDecimal;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Setter;

@DynamoDBTable(tableName = "QrCode")
@Setter
public class QrCode {


    private String id;
    private String url;
    private String alias;
    private BigDecimal valor;
    
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }


    @DynamoDBAttribute
    public String getUrl() {
        return url;
    }


    @DynamoDBAttribute
    public String getAlias() {
        return alias;
    }


    @DynamoDBAttribute
    public BigDecimal getValor() {
        return valor;
    }
    
}