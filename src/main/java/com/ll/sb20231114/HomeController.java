package com.ll.sb20231114;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")// spring 부트야 / 를 받으면 return 값을 출력해라
    @ResponseBody // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의미 애없으면 return 값이 나오지 않음
    String showMain() {
        return "안녕하세요";
    }

    @GetMapping("/about")
    @ResponseBody // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의
    String showAbout() {
        return "개발자 커뮤니티";
    }
}
