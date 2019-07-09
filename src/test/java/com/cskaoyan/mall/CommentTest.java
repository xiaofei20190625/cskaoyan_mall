package com.cskaoyan.mall;

import com.cskaoyan.mall.admin.mapper.CommentMapper;
import com.cskaoyan.mall.admin.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTest {
    @Autowired
    CommentService commentService;
    @Autowired
    CommentMapper commentMapper;
    @Test
    public void test() {
        int delete = commentMapper.deleteByPrimaryKey(1000);
        System.out.println(delete);
    }

}
