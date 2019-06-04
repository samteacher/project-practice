package com.sam.elasticsearchdemo.springdata.repository;

import com.sam.elasticsearchdemo.springdata.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author yuqiufu
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    List<Book> findByBookNameLike(String bookName);

}
