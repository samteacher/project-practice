package com.sam.elasticsearchdemo.springdata.entity;


import lombok.Data;

/**
 * @author yuqiufu
 */
@Data
public class Book {

    private Integer id;

    private String bookName;

    private String author;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{\"Book\":{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"bookName\":\"")
                .append(bookName).append('\"');
        sb.append(",\"author\":\"")
                .append(author).append('\"');
        sb.append("}}");
        return sb.toString();
    }

}
