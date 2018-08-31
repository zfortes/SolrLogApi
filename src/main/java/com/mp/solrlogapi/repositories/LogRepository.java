package com.mp.solrlogapi.repositories;

import com.mp.solrlogapi.entidies.Log;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

//@Repository
public interface LogRepository extends SolrCrudRepository<Log, String> {
    Iterable<Log> findLogByMetodo(String metodo);
}

