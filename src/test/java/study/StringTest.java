package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    /**
     * 요구사항 1-1) "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스르를 구현한다.
     */

    @Test
    @DisplayName("요구사항 1-1 Test")
    public void split1comma2Test(){
        // given
        String test = "1,2";

        // when
        String[] resultArray = test.split(",");

        // then
        assertThat(resultArray).contains("1","2");
    }

    /**
     * 요구사항 1-2) "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     */
    @Test
    @DisplayName("요구사항 1-2 Test")
    public void split1Test(){

        // given
        String test = "1";

        // when
        String[] resultArray = test.split(",");

        // then
        assertThat(resultArray).containsExactly("1");
    }

    /**
     * 요구사항 2) "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
     */

    @Test
    @DisplayName("요구사항 2 Test")
    public void removeBracketTest(){

        // given
        String test = "(1,2)";

        // when
        String result = test.substring(1,4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    /**
     * 요구사항 3) "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
     */

    @Test
    @DisplayName("When using the charAt() method for the string \"abc\", an exception occurs when the position value deviates.")
    public void selectCharTest(){

        // given
        String test = "abc";

        // when
        int index = 4;

        // then
        assertThatThrownBy(()-> {
            Character[] chars = new Character[4];
            for (int i = 0; i < index; i++){
                chars[i] = test.charAt(i);
            }
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}