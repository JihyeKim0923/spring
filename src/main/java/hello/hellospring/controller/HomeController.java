package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    // 주소창에 /가 들어오면 home.html을 반환
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
