package com.msp.domain;

import com.msp.domain.posts.Posts;
import com.msp.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest     // 별다른 설정 없이 @SpringBootTest를 사용할 경우 H2 DB를 자동으로 실행해줌.
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After  // Junit에서 단위테스트가 끝날때마다 수행되는 메소드를 지정. 보통 테스트간 데이터 침범을 막기위해 사용.
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void saveAndLoad() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // 테이블에 insert or update실행.
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("minsup109@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
