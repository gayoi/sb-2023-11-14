package com.ll.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ArticleController {
    //private Article lastArticle; 새 게시물을 작성하면 기존꺼는 삭제 되기 때문에 배열로
    private Article[] articles = new Article[3]; // 리모콘 3개를 넣을 수 있다 0,1,2
    private int articleLastIndex = -1; //게시물이 하나도 없으면 오류가 난다

    @GetMapping("/article/write")
    String showWrite() {
        return "article/write"; // aritcle/write에 있는 폴더가 필요하다
    }


    @GetMapping("/article/doWrite")
    @ResponseBody
    Map<String, Object> doWrite(
            String title,
            String body
    ) {
        Article article = new Article(articleLastIndex+2, title,   body); // article <-함수 안에서 정의 된 변수는 지역변수이다

        Map<String, Object> rs = new HashMap<>();
        rs.put("msg","%d번 게시물이 작성되었습니다".formatted(article.getId()));
        rs.put("data", article);

        articles[++articleLastIndex] = article;

        return rs;
    }
    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle(){
        return articles[articleLastIndex];
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    Article[] getArticles(){
        return articles;
    }

}


@AllArgsConstructor // 모든 필드를 argument로 하는 ..?
@Getter // <- 얘가 필요하다 //getid,gettitle등등
class Article {
    private long id;
    private String title;
    private String body;
}



