package com.mp.solrlogapi.entidies;

import java.sql.Timestamp;



import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;


@Getter
@Setter
@SolrDocument(solrCoreName = "log")
public class Log {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Indexed(name = "id", type = "long")
    @Field
    private String id;


//    @Indexed(name = "metodo", type = "string")
    @NotNull
    @Field
    private String metodo;

}