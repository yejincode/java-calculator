package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    // 문자열에 숫자 이외의 값 혹은 음수가 있는지 확인하는 메소드 ->

    // 기본적으로 커스텀 구분자/ 일반 구분자 맞게 split한 후, 각 배열에 담긴 값을 검사해서 숫자 이와의 값, 음수가 있는지 검사한다.

    // 문자열에 커스텀 구분자가 있다면 구분자를 가져오고, 기본 문자열로 세팅하는 메소드
    // 정리된 문자열을 최종적으로 split 하고, 합을 구하는 메소드

    public static ArrayList<String> splitInput(String str){

        String clean_str = str;
        String delimiter = ",";
        ArrayList<String> splitList = new ArrayList<>();

        if (str.equals("")) {
            splitList.add("0");
        }else if (str.startsWith("//") || str.contains("\n")){
            int startIndex = str.indexOf("//");
            int endIndex = str.indexOf("\n");
            clean_str = str.replace("//","").replace("\n","");
            delimiter = str.substring(startIndex+2,endIndex);
            String[] splitArray = clean_str.split(delimiter);
            splitList.addAll(Arrays.asList(splitArray));
            splitList.remove(0);
        }else{
            String[] splitArray = str.split(":|,");
            splitList.addAll(Arrays.asList(splitArray));
        }
        return splitList;
    }

    public static ArrayList<Integer> validationInput(ArrayList<String> inputList) throws RuntimeException {
        ArrayList<Integer> numberList = new ArrayList<>();

        for (String value : inputList){
            try {
                numberList.add(Integer.parseInt(value));
            }catch (Exception e){
                throw new RuntimeException("숫자 이외의 값이 입력되었습니다.");
            }
        }

        for (Integer value: numberList){
            if (value < 0) throw new RuntimeException("음수가 입력되었습니다.");
        }

        return numberList;
    }

    public static int sumInput(ArrayList<Integer> numberList){
        int sum = 0;
        for (int value:numberList){
            sum +=value;
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(sumInput(validationInput(splitInput("1,2:3"))));
    }
}
