package com.wangjc.bootlaunch.service;

import com.wangjc.bootlaunch.model.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleRestService {

    public String saveArticle( ArticleVO article) {

        log.info("saveArticle：{}",article);

        return  "测试";
    }
}
