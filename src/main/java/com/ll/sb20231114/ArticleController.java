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
    private Article [] articles = new Article[3];
    private

    @GetMapping("/article/write")
    String showWrite(){
        return "article/write"; // aritcle/write에 있는 폴더가 필요하다
    }



    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Map<String,Object>doWrite(
            String title,
            String body
    ){
        Article article = new Article(1,title,body);

        Map<String, Object> rs = new HashMap<>();
        rs.put("msg","1번 게시물이 작성되었습니다");
        rs.put("data", article);

        return rs;
    }

}

@AllArgsConstructor // 모든 필드를 argument로 하는 ..?
@Getter // <- 얘가 필요하다
class Article {
    private long id;
    private String title;
    private String body;
}

