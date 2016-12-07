package ramda.step4;
import java.util.ArrayList;
import java.util.List;

import ramda.Apple;

public class Main
{
    public static void main( String[] args ) {
        List<Apple> apples = Apple.AppleList.getAppleList();
        
        List<Apple> greenApples = filterApples( apples, new GreenApplePredicate() );
        System.out.println(greenApples);
        
        List<Apple> redApples = filterApples( apples, new RedApplePredicate() );
        System.out.println(redApples);
                
        // 다른 속성의 필터링 조건의 추가
        List<Apple> haeavyApples = filterApples( apples, new HeavyApplePredicate() );
        System.out.println(haeavyApples);
        
        // 복합 조건의 필터링 추가
        List<Apple> greenAndHaeavyApples = filterApples( apples, new GreenAndHeavyApplePredicate() );
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

    /*
     * 초록색 사과인지 boolean 값 리턴
     */
    static class GreenApplePredicate implements ApplePredicate{
        public boolean test(Apple apple){
            return "green".equals(apple.getColor());
        }
    }
    
    /*
     * 빨간색 사과인지 boolean 값 리턴
     */
    static class RedApplePredicate implements ApplePredicate{
        public boolean test(Apple apple){
            return "red".equals(apple.getColor());
        }
    }
    
    /*
     * 무거운 사과인지 boolean 값 리턴
     */
    static class HeavyApplePredicate implements ApplePredicate{
        public boolean test(Apple apple){
            return apple.getWeight() > 150; 
        }
    }

    /*
     * 빨갛고 무거운 사과인지 boolean 값 리턴
     */
    static class GreenAndHeavyApplePredicate implements ApplePredicate{
        public boolean test(Apple apple){
            return "green".equals(apple.getColor()) 
                    && apple.getWeight() > 150; 
        }
    }
}
