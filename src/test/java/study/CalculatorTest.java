package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3","1,2:3","//;\n1;2;3"})
    @DisplayName("입력 받은 String을 구분자 혹은 커스텀 구분자를 사용하여 split하고 ArrayList<String>으로 반환한다.")
    public void testSplitInput(String str){
        assertEquals(new ArrayList<>(Arrays.asList("1", "2", "3")),Calculator.splitInput(str));
    }

    @Test
    @DisplayName("입력 받은 ArrayList<String>의 요소에 숫자 이외의 값 혹은 음수가 있으면 RuntimeException을 throw 한다.")
    public void testValidationInput(){
        ArrayList<String> koreanList = new ArrayList<>(Arrays.asList("가","나","다"));
        ArrayList<String> minusList = new ArrayList<>(Arrays.asList("1","-2","3"));
        ArrayList<String> numberList = new ArrayList<>(Arrays.asList("1","2","3"));

        assertThrows(RuntimeException.class,()->Calculator.validationInput(koreanList));
        assertThrows(RuntimeException.class,()->Calculator.validationInput(minusList));
        assertEquals(new ArrayList<>(Arrays.asList("1","2","3")),numberList);
    }

    @Test
    @DisplayName("입력 받은 ArrayList<Integer>의 값들을 더한 값을 반환한다.")
    public void testSumInput(){
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3));
        assertEquals(6,Calculator.sumInput(numberList));
    }
}

