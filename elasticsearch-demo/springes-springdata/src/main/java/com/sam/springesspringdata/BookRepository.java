package com.sam.springesspringdata;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author yuqiufu
 * @desc spring data 操作 es
 * @since 2019-06-05
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    List<Book> findByBookNameLike(String bookName);

}
