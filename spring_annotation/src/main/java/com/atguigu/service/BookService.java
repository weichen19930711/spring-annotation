package com.atguigu.service;

import com.atguigu.dao.BookDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

@Data
@Service
public class BookService {

    @Qualifier("bookDao_")
    @Autowired(required = false)
    //@Resource
//    @Inject
    private BookDao bookDao;

}
