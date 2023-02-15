package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request")
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("["+uuid+"] "+"["+requestURL+"] "+"["+message+"]");
    }

    @PostConstruct //빈 관리 시작
    public void init(){
        uuid=UUID.randomUUID().toString(); //절대 겹치지 않는 고유한 id
        System.out.println("["+uuid+"] request scope bean create : "+this); //this: 주소
    }

    @PreDestroy //빈 관리 종료
    public void close(){
        System.out.println("["+uuid+"] request scope bean close : "+this); //this: 주소
    }
}
