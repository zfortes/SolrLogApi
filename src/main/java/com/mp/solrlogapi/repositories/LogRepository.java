package com.mp.solrlogapi.repositories;

import com.mp.solrlogapi.entidies.Log;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface LogRepository extends SolrCrudRepository<Log, Long> {

}

