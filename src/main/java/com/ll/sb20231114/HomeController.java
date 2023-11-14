package com.ll.sb20231114;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/calc6")
    @ResponseBody // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의미
    int showCalc6(
            int a, int b
    ) {
        return a + b;
    }

    @GetMapping("/calc7")
    @ResponseBody // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의미
    boolean showCalc7(
            int a, int b
    ) {
        return a > b;
    }
    @GetMapping("/calc8")
    @ResponseBody
    Person showCalc8(
            String name, int age
    ) {
        return new Person(name, age);
    }

    @GetMapping("/calc9")
    @ResponseBody
    Person2 showCalc9(
            String name, int age
    ) {
        return new Person2(name, age);
    }

    @GetMapping("/calc10")
    @ResponseBody
    Map<String, Object> showCalc10(
            String name, int age
    ) {
        Map <String, Object> personMap = Map.of( //object까지 해놓으면 다 들어가다
                "name", name,
                "age", age

        );
        return personMap;
    }

    @GetMapping("/calc11")
    @ResponseBody
    List<Integer> showCalc11(
            String name, int age
    ) {
        List <Integer> nums = new ArrayList<>() {{
            add(10);
            add(-510);
            add(1010);

        }};
        return nums;
    } // list 데이터 계속 추가가능

    @GetMapping("/calc12")
    @ResponseBody
    int[] showCalc12() {
            int[] nums = new int[] {10,-510,1010};

        return nums;
    }

    @GetMapping("/calc13")
    @ResponseBody
    List<Person2> showCalc13(
            String name, int age
    ) {
       List<Person2> persons = new ArrayList<>() {{
           add(new Person2(name,age));
           add(new Person2(name+"!",age+1));
           add(new Person2(name+"!!",age+2));
       }};
        return persons;
    }

    @GetMapping("/calc14")
    @ResponseBody
    String showCalc14() {
        String html = "";

        html += "<div>";
        html += "<input type=\"text\" palcehoder=\"내용\">";
        html += "</div>"; // 자바에서는 하나의 문장을 이렇게 붙이는 것을 좋아하지 않는다

        return html;
    }

    @GetMapping("/calc15")
    @ResponseBody
    String showCalc15() {
        StringBuilder sb = new StringBuilder();

        sb.append("<div>");
        sb.append("<input type=\"text\" palcehoder=\"내용\">");
        sb.append("</div>");

        return sb.toString(); // 14보다 15처럼 하는게 낫다 문자의 불변성
    }

    @GetMapping("/calc16")
    @ResponseBody
    String showCalc16() {
        String html = "<div><input type=\"text\" palcehoder=\"내용\"></div>";

        return html;
    }

    @GetMapping("/calc17")
    @ResponseBody
    String showCalc17() {
        String html = """
                <div>
                    <input type="text" placeholder="내용"> 
                </div>
                """; // palceholder 내용이없을 때

        return html;
    }

    @GetMapping("/calc18")
    @ResponseBody
    String showCalc18() {
        String html = """
                <div>
                    <input type="text" placeholder="내용" value ="반가워요"> 
                </div>
                """; //value 는 값이 채워서 나온다

        return html;
    }

    @GetMapping("/calc19")
    @ResponseBody
    String showCalc19(
            @RequestParam(defaultValue = "") String subject,
            @RequestParam(defaultValue = "") String content
    ) {

        String html = """
                <div>
                    <input type="text" placeholder="제목" value="%s">
                </div>
                <div>
                    <input type="text" placeholder="내용" value="%s">
                </div>
                """.formatted(subject,content);

        return html;
    }
    @GetMapping("/calc20")
    String showCalc20() { // @Responesbody 뺴면 src/main/resources/templates/calc20.
        return "calc20";
    }
    @GetMapping("/calc21")
    String showCalc21(Model model) {
        model.addAttribute("v1", "안녕");
        model.addAttribute("v2", "반가워");
        return "calc21";
    }

    int num = 0; // 인스턴스 변수 // calc 안에 있을때는 지역변수
    @GetMapping("/calc22")
    @ResponseBody
    int showCalc22() {

        num++;
        return num;
    }

}

@AllArgsConstructor // 모든 필드를 argumnet 로 받는다
class Person{
    public String name;
    public int age;
}

@AllArgsConstructor // 모든 필드를 argumnet 로 받는다
class Person2{ // 얘로 private를 뚫어준다
    @Getter
    private String name;
    @Getter
    private int age;
}