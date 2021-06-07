package com.msp.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // 스프링 부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest // Web에 집중할 수 있는 어노테이션으로 @Service, @Component, @Repository등은 사용할수 없으나 @Controller는 사용할 수 있음.
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈을 주입받음.
    private MockMvc mvc;
    /*
    * 웹 API 테스트할 때 사용.
    * 스프링 MVC 테스트의 시작점
    * 이 클래스를 통해 HTTP GET, POST등에 대한 API테스트를 할 수 있음.
    * */

    @Test
    public void returnHello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))  // MockMvc를 통해 HTTP GET요청
                .andExpect(status().isOk())     // 요청에 대한 상태 검증
                .andExpect(content().string(hello));    // 응답 본문의 내용 검증.
    }

}
