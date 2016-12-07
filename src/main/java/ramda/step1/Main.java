package ramda.step1;

import java.util.ArrayList;
import java.util.List;

import ramda.Apple;

public class Main
{
    public static void main( String[] args ) {
        List<Apple> apples = Apple.AppleList.getAppleList();
        
        List<Apple> greenApples = filterGreenApples( apples );
        System.out.println(greenApples);
        
        // 다른 색깔 조건의 필터링 추가
        List<Apple> redApples = filterRedApples( apples );
        System.out.println(redApples);        
    }
    
    /*
     * 초록색 사과를 골라서 List로 리턴 한다.
     */
    public static List<Apple> filterGreenApples( List<Apple> inventory ) {
        List<Apple> result = new ArrayList<>();
        for ( Apple apple: inventory ){
            if ( "green".equals( apple.getColor() ) ) {
                result.add( apple );
            }
        }
        return result;
    }
    
    /*
     * 빨간색 사과를 골라서 List로 리턴 한다.
     */    
    public static List<Apple> filterRedApples( List<Apple> inventory ) {
        List<Apple> result = new ArrayList<>();
        for ( Apple apple: inventory ){
            if ( "red".equals( apple.getColor() ) ) {
                result.add( apple );
            }
        }
        return result;
    }
}
