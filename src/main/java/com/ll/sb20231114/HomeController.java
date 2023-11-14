package com.ll.sb20231114;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")// spring 부트야 / 를 받으면 return 값을 출력해라
    @ResponseBody // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의미 애없으면 return 값이 나오지 않음
    String showMain() {
        return "안녕하세요";
    }

    @GetMapping("/about")
    @ResponseBody // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의미
    String showAbout() {
        return "개발자 커뮤니티";
    }

    @GetMapping("/calc")
    @ResponseBody // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의미
    String showCalc(int a, int b) {
        return "계산 결과 : %d".formatted(a+b);
    }

   @GetMapping("/calc2")
    @ResponseBody // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의미
    String showCalc2(Integer a,Integer b) {
        return "a : %d" + a + ", b : "+b;
    }
    @GetMapping("/calc3")
    @ResponseBody // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의미
    String showCalc3(
            @RequestParam(defaultValue = "0" ) int a,
            @RequestParam(defaultValue = "0" ) int b
    ) {

        return "계산 결과 : %d".formatted(a+b);
    }

    @GetMapping("/calc4")
    @ResponseBody // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의미
    String showCalc4(
            @RequestParam(defaultValue = "0" ) double a,
            @RequestParam(defaultValue = "0" ) double b
    ) {
        return "계산 결과 : %f".formatted(a+b);
    }

    @GetMapping("/calc5")
    @ResponseBody // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의미
    String showCalc5(
            @RequestParam(defaultValue = "0" ) String a,
            @RequestParam(defaultValue = "0" ) String b
    ) {

        return "계산 결과 : %s".formatted(a+b);
    }
}
