package ramda.step7;
import java.util.ArrayList;
import java.util.List;

import ramda.Apple;

public class Main
{
    public static void main( String[] args ) {
        List<Apple> apples = Apple.AppleList.getAppleList();
        
        List<Apple> greenApples = 
            filter( apples, (Apple apple) -> "green".equals(apple.getColor()));
        System.out.println(greenApples);
        
        List<Apple> redApples = 
            filter( apples, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println(redApples);
                
        // 다른 속성의 필터링 조건의 추가
        List<Apple> haeavyApples = 
            filter( apples, (Apple apple) -> apple.getWeight() > 150);
        System.out.println(haeavyApples);
        
        // 복합 조건의 필터링 추가
        List<Apple> greenAndHaeavyApples = 
            filter( apples, (Apple apple) -> "green".equals(apple.getColor()) && apple.getWeight() > 150);
        System.out.println(greenAndHaeavyApples);
        
        // Apple 이외의 다른 타입 필터링
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add( 1 );
        numbers.add( 2 );
        numbers.add( 3 );
        numbers.add( 4 );
        numbers.add( 5 );
        numbers.add( 6 );
        numbers.add( 7 );
        
        List<Integer> evenNumbers = 
            filter( numbers, (Integer i) -> i % 2 == 0);
        System.out.println(evenNumbers);
    }
    
    /*
     * 추상화
     */
    public static <T> List<T> filter( List<T> inventory, Predicate<T> p ) {
        List<T> result = new ArrayList<>();
        for ( T t: inventory ) {
            if( p.test( t ) ) {
                result.add( t );
            }
        }
        return result;
    }
    
    /*
     * 알고리즘 패밀리 인터페이스
     */
    interface Predicate<T> {
        public boolean test( T t );
    }
}
