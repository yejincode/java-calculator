package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetCollectionTest {

    // given
    private Set<Integer> numbers;
    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    /**
     * 요구사항 1) Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
     */

    @Test
    @DisplayName("요구사항 1 Test")
    public void setSizeTest(){

        // when
        int size = numbers.size();

        // then
        assertThat(size).isEqualTo(3);
    }

    /**
     * 요구사항 2)
     * Set의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지를 확인하는 학습테스트를 구현하려 한다.
     * 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
     * JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
     */

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("요구사항 2 Test")
    public void setContains123Test(int i){
        assertThat(numbers.contains(i)).isTrue();
    }

    /**
     * 요구사항 3)
     * 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다.
     * 입력 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
     */

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    @DisplayName("요구사항 3 Test")
    public void setContains12345Test(String input, String output){
        boolean contain = numbers.contains(Integer.valueOf(input));
        assertEquals(output,String.valueOf(contain));
    }


}
