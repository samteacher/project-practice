package com.sam.springesjest;

import com.sam.springesjest.entity.User;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.*;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.mapping.GetMapping;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringesJestApplicationTests {

    private static String indexName = "yu";
    private static String typeName = "news";


    @Autowired
    JestClient jestClient;

    /**
     * 创建索引
     *
     * @return
     * @throws Exception
     */
    @Test
    public void createIndex() throws Exception {
        JestResult jr = jestClient.execute(new CreateIndex.Builder(indexName).build());
        System.out.println(jr.isSucceeded());
    }

    /**
     * 新增数据
     *
     * @return
     * @throws Exception
     */
    @Test
    public void insert() throws Exception {
        User user = new User(1L, "张三", 20, "张三是个Java开发工程师", "2018-4-25 11:07:42");
        Index index = new Index.Builder(user).index(indexName).type(typeName).build();
        try {
            JestResult jr = jestClient.execute(index);
            System.out.println(jr.isSucceeded());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询数据
     *
     * @return
     * @throws Exception
     */
    @Test
    public void getIndexMapping() throws Exception {
        GetMapping getMapping = new GetMapping.Builder().addIndex(indexName).addType(typeName).build();
        JestResult jr = jestClient.execute(getMapping);
        System.out.println(jr.getJsonString());
    }

    /**
     * 向ElasticSearch中批量新增
     */
    @Test
    public void insertBatch() {
        List<Object> objs = new ArrayList<Object>();
        objs.add(new User(1L, "张三三", 20, "张三是个Java开发工程师", "2018-4-25 11:07:42"));
        objs.add(new User(2L, "李四四", 24, "李四是个测试工程师", "1980-2-15 19:01:32"));
        objs.add(new User(3L, "王五五", 25, "王五是个运维工程师", "2018-4-24 06:11:32"));
        boolean result = false;
        try {
            Bulk.Builder bulk = new Bulk.Builder().defaultIndex(indexName).defaultType(typeName);
            for (Object obj : objs) {
                Index index = new Index.Builder(obj).build();
                bulk.addAction(index);
            }
            BulkResult br = jestClient.execute(bulk.build());
            result = br.isSucceeded();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("批量新增:" + result);
    }

    /**
     * 全文搜索
     *
     * @param indexName
     * @param typeName
     * @param query
     * @return
     * @throws Exception
     */
    public static String search(JestClient jestClient, String indexName, String typeName, String query) throws Exception {
        Search search = new Search.Builder(query).addIndex(indexName).addType(typeName).build();
        JestResult jr = jestClient.execute(search);
        System.out.println("--++" + jr.getJsonString());
        System.out.println("--" + jr.getSourceAsObject(User.class));
        return jr.getSourceAsString();
    }

    /**
     * 分页带条件搜索
     */
    @Test
    public void serach1() {
        String query = "工程师";
        try {
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(QueryBuilders.queryStringQuery(query));
            //分页设置
            searchSourceBuilder.from(0).size(2);
            System.out.println("全文搜索查询语句:" + searchSourceBuilder.toString());
            System.out.println("全文搜索返回结果:" + search(jestClient, indexName, typeName, searchSourceBuilder.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 精确搜索(在指定的属性上精确查询)
     */
    @Test
    public void serach2() {
        try {
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(QueryBuilders.termQuery("age", 24));
            System.out.println("精确搜索查询语句:" + searchSourceBuilder.toString());
            System.out.println("精确搜索返回结果:" + search(jestClient, indexName, typeName, searchSourceBuilder.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 区间搜索
     */
    @Test
    public void serach3() {
        String createtm = "createtm";
        String from = "2019-06-01 05:11:32";
        String to = "2019-06-21 19:11:32";

        try {
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(QueryBuilders.rangeQuery(createtm).gte(from).lte(to));
            System.out.println("区间搜索语句:" + searchSourceBuilder.toString());
            System.out.println("区间搜索返回结果:" + search(jestClient, indexName, typeName, searchSourceBuilder.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除索引
     *
     * @return
     * @throws Exception
     */
    @Test
    public void deleteIndex() throws Exception {
        JestResult jr = jestClient.execute(new DeleteIndex.Builder(indexName).build());
        System.out.println(jr.isSucceeded());
    }

    /**
     * 删除单条数据,  这个id必须是主键才能被删除
     *
     * @return
     * @throws Exception
     */
    @Test
    public void deleteData() throws Exception {
        String id = "1";
        DocumentResult dr = jestClient.execute(new Delete.Builder(id).index(indexName).type(typeName).build());
        System.out.println(dr.isSucceeded());
    }

}
