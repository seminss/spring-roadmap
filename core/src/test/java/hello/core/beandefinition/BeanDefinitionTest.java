package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 설정 메타 정보 확인")
    void findApplicationBean(){
        String[] beanDefinitionNames=ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition=ac.getBeanDefinition(beanDefinitionName);
            //내가 실제로 등록한 application bean만 나온다
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                System.out.println("beanDefinitionName = "+beanDefinitionName+" beanDefinition = "+beanDefinition);
            }
        }
    }
}
