package com.ll.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {


    @GetMapping("/article/write")
    String showWrite() {
        return "article/write"; // aritcle/write에 있는 폴더가 필요하다
    }

    @GetMapping("/article/doWrite")
    @ResponseBody
    String doWrite(
            String title,
            String body
    ) {
        return "게시물이 작성되었습니다.";
    }



}


@AllArgsConstructor // 모든 필드를 argument로 하는 ..?
@Getter // <- 얘가 필요하다
class Article {
    private long id;
    private String title;
    private String body;
}



