package ramda.step2;

import java.util.ArrayList;
import java.util.List;

import ramda.Apple;

public class Main
{
    public static void main( String[] args ) {
        List<Apple> apples = Apple.AppleList.getAppleList();
        
        List<Apple> greenApples = filterApplesByColor( apples, "green" );
        System.out.println(greenApples);
        
        List<Apple> redApples = filterApplesByColor( apples, "red" );
        System.out.println(redApples);
                
        // 다른 속성의 필터링 조건의 추가
        List<Apple> haeavyApples = filterApplesByWeight( apples, 150 );
        System.out.println(haeavyApples);
    }
    
    /*
     * 파라미터로 받은 색의 사과를 골라서 List로 리턴 한다.
     */
    public static List<Apple> filterApplesByColor( List<Apple> inventory, String color ) {
        List<Apple> result = new ArrayList<>();
        for ( Apple apple: inventory ){
            if ( color.equals( apple.getColor() ) ) {
                result.add( apple );
            }
        }
        return result;
    }
    
    /*
     * 파라미터로 받은 무게보다 무거운 사과를 골라서 List로 리턴 한다.
     */
    public static List<Apple> filterApplesByWeight( List<Apple> inventory, int weight ) {
        List<Apple> result = new ArrayList<>();
        for ( Apple apple: inventory ){
            if ( apple.getWeight() > weight ) {
                result.add( apple );
            }
        }
        return result;
    }
}
