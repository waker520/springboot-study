package com.wangjc.bootlaunch.controller;

import com.wangjc.bootlaunch.exception.AjaxResponse;
import com.wangjc.bootlaunch.model.ArticleVO;
import com.wangjc.bootlaunch.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping(value = "/rest",produces = "application/json;charset=utf-8")
public class ArticleRestController {


    @Resource
    private ArticleRestService articleRestService;


    //@RequestMapping(value = "/article", method = RequestMethod.POST, produces = "application/json")
    @PostMapping(value = "/articles")
    public AjaxResponse saveArticle(@RequestBody ArticleVO article){

        System.out.println("saveArticle:{}"+article.toString());
        log.info("saveArticle:{}",article);
        log.info("articleRestService return :" + articleRestService.saveArticle(article));

        return AjaxResponse.success(article);
    }


    //@RequestMapping(value="/article/{id}",method = RequestMethod.DELETE,produces = "application/json")
    @DeleteMapping("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id){

        log.info("deleteArticle:{}",id);

        return AjaxResponse.success(id);
    }

    //@RequestMapping(value="/article/{id}" ,method = RequestMethod.PUT,produces="application/json")
    @PutMapping("/articles/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id,@RequestBody ArticleVO article){

        article.setId(id);

        log.info("updateArticle: {}",article);

        return AjaxResponse.success(article);
    }


    //@RequestMapping(value="/article/{id}" ,method = RequestMethod.GET,produces = "application/json")
    @GetMapping("/articles/{id}")
    public AjaxResponse getArticle(@PathVariable Long id) {
        ArticleVO article1 = new ArticleVO();

        article1 = ArticleVO.builder().id(id).author("wangjc")
                .content("springboot 实战")
                .title("学习")
                .createTime(new Date())
                .build();

        log.info("getArticle: {}",article1);

        return AjaxResponse.success(article1);
    }


}
