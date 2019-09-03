package com.atguigu.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

//名称默认是 类名首字母小写 bookDao
@Data
@Repository
public class BookDao {

    private String label;

    public BookDao() {
        this.label = "111";
    }
}
