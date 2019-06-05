package com.sam.springesjest;

import io.searchbox.annotations.JestId;
import lombok.Data;

/**
 * @author yuqiufu
 * @desc Jest练习
 * @since 2019-06-05
 */
@Data
public class Article {

    @JestId
    private Integer id;
    private String author;
    private String title;
    private String content;

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("{\"Article\":{");

        sb.append("\"id\":").append(id);
        sb.append(",\"author\":\"").append(author).append('\"');
        sb.append(",\"title\":\"").append(title).append('\"');
        sb.append(",\"content\":\"").append(content).append('\"');
        sb.append("}}");
        return sb.toString();
    }

}
