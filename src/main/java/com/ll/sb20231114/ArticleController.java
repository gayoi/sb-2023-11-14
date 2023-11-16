package com.ll.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {
    //private Article lastArticle; 새 게시물을 작성하면 기존꺼는 삭제 되기 때문에 배열로
    private List<Article> articles = new ArrayList<>(); // 3개 이상차면 오류나니까 이부분을 list 로 바꿔준다

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
        Article article = new Article(articles.size()+1, title,   body); // article <-함수 안에서 정의 된 변수는 지역변수이다

        Map<String, Object> rs = new LinkedHashMap<>(); // linkedhashMap은 내가 링크를 기억한다는 뜻
        rs.put("resultCode","S-1"); // 결과과 성공 살패로 나눠지는데 실패한 이유를 1,2,3, 성공한 이유를 1,2,,3 으로 나눠서 적는다
        rs.put("msg","%d번 게시물이 작성되었습니다".formatted(article.getId()));
        rs.put("data", article);

        articles.add(article);

        return rs;
    }
    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle(){
        return articles.getLast();
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles(){
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



