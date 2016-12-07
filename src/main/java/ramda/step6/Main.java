package ramda.step6;
import java.util.ArrayList;
import java.util.List;

import ramda.Apple;

public class Main
{
    public static void main( String[] args ) {
        List<Apple> apples = Apple.AppleList.getAppleList();
        
        List<Apple> greenApples = 
            filterApples( apples, (Apple apple) -> "green".equals(apple.getColor()));
        System.out.println(greenApples);
        
        List<Apple> redApples = 
            filterApples( apples, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println(redApples);
                
        // 다른 속성의 필터링 조건의 추가
        List<Apple> haeavyApples = 
            filterApples( apples, (Apple apple) -> apple.getWeight() > 150);
        System.out.println(haeavyApples);
        
        // 복합 조건의 필터링 추가
        List<Apple> greenAndHaeavyApples = 
            filterApples( apples, (Apple apple) -> "green".equals(apple.getColor()) && apple.getWeight() > 150);
        System.out.println(greenAndHaeavyApples);
    }
    
    /*
     * 여러 속성값을 비교하여 해당되는 사과를 골라서 List로 리턴 한다.
     */
    public static List<Apple> filterApples( List<Apple> inventory, ApplePredicate p ) {
        List<Apple> result = new ArrayList<>();
        for ( Apple apple: inventory ) {
            if( p.test( apple ) ) {
                result.add( apple );
            }
        }
        return result;
    }
    
    /*
     * 알고리즘 패밀리 인터페이스
     */
    interface ApplePredicate {
        public boolean test( Apple a );
    }
}
