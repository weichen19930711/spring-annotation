package com.atguigu.service;

import com.atguigu.dao.BookDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

@Data
// @Service
public class BookService {

    @Qualifier("bookDao")
    // @Autowired(required = false)
    // @Autowired
    // @Resource(name = "bookDao_")
    @Inject
    private BookDao bookDao;

}
