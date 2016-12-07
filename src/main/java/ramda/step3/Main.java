package ramda.step3;
import java.util.ArrayList;
import java.util.List;

import ramda.Apple;

public class Main
{
    public static void main( String[] args ) {
        List<Apple> apples = Apple.AppleList.getAppleList();
        
        List<Apple> greenApples = filterApples( apples, "green", 0, true );
        System.out.println(greenApples);
        
        List<Apple> redApples = filterApples( apples, "red", 0, true );
        System.out.println(redApples);
                
        // 다른 속성의 필터링 조건의 추가
        List<Apple> haeavyApples = filterApples( apples, "", 150, false );
        System.out.println(haeavyApples);
    }
    
    /*
     * 여러 속성값을 비교하여 해당되는 사과를 골라서 List로 리턴 한다.
     */
    public static List<Apple> filterApples( List<Apple> inventory, String color, int weight, boolean flag ) {
        List<Apple> result = new ArrayList<>();
        for ( Apple apple: inventory ){
            if ( (flag && color.equals( apple.getColor() ) || (!flag && apple.getWeight() > weight ) ) ) {
                result.add( apple );
            }
        }
        return result;
    }
}
