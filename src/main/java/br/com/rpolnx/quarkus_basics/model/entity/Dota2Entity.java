package br.com.rpolnx.quarkus_basics.model.entity;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@MongoEntity(collection = "dota-2")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Dota2Entity extends PanacheMongoEntity {
    private String category;
    private Object document;
}