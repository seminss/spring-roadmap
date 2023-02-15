package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller //사용자 요청이 진입하는 시점
@RequiredArgsConstructor //생성자 주입
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody //화면없이 문자 출력
    public String logDemo(HttpServletRequest request){ //java에서 제공하는 표준 서블릿 정보에 해당하는 request 정보를 받을 수 있다.

        String requestURL = request.getRequestURL().toString(); //고객이 어떤 url로 요청했는지 알 수 있다.
        myLogger.setRequestURL(requestURL); //[http://localhost:8080/log-demo] 출력하게 하기 위함
        myLogger.log("controller test");
        logDemoService.logic("testID");
        return "OK";
    }

}
