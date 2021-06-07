package com.msp.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_test() {
        //given
        String name="test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

        /*
        * assertThat 은 assertj라는 테스트검증 라이브러리의 검증 메소드. 검증하고 싶은 대상을 메소드 인자로 받음.
        * isEqualTo는 assertj의 동등 비교 메소드. 같을때만 성공.
        * */

    }
}
