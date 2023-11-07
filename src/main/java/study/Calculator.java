package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static ArrayList<String> splitInput(String str){
        ArrayList<String> splitList = new ArrayList<>();

        if (str.equals("")) {
            splitList.add("0");
        }else if (str.startsWith("//") || str.contains("\n")){
            int startIndex = str.indexOf("//");
            int endIndex = str.indexOf("\n");
            String clean_str = str.replace("//","").replace("\n","");
            String delimiter = str.substring(startIndex+2,endIndex);
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
