package com.sam.springesspringdata.config;

import com.sam.springesspringdata.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author yuqiufu
 * @since 2019-06-05
 */
@Component
public interface EmployeeRepository extends ElasticsearchRepository<Employee,String> {

    /**
     * 查询雇员信息
     * @param id
     * @return
     */
    Employee queryEmployeeById(String id);

}
