package com.msp.web;

import com.msp.config.auth.LoginUser;
import com.msp.config.auth.dto.SessionUser;
import com.msp.domain.user.User;
import com.msp.service.posts.PostsService;
import com.msp.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) { // Model은 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음.
                                       // findAllDesc()로 가져온 결과를 posts로 index.mustach에 전달.
        model.addAttribute("posts", postsService.findAllDesc());

//        SessionUser user = (SessionUser) httpSession.getAttribute("user"); // @LoginUser를 사용하므로써 필요없어짐.
        if(user != null){
            model.addAttribute("userName", user.getName());
        }

        return "index";  // 머스태치 스타터가 view파일의 경로와 확장자를 자동으로 지정.
                         // src/main/resources/templates/index.mustache
    }

    @GetMapping("/posts/save")
    public String postSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
