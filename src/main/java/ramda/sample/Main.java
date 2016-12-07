package ramda.sample;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main
{
    public static void main( String[] args ) {
        List<Map<String, String>> articles = getArticles();        
        
        List<Map<String, String>> notices = 
            filter( articles, (Map<String, String> map) -> map.containsValue( "notice" ) );
        System.out.println(notices);
        
        List<Map<String, String>> newses = 
            filter( articles, (Map<String, String> map) -> map.containsValue( "news" ) );
        System.out.println(newses);
        
        List<Map<String, String>> events = 
            filter( articles, (Map<String, String> map) -> map.containsValue( "event" ) );
        System.out.println(events);

        List<Map<String, String>> notices2 = new ArrayList<Map<String, String>>();
        List<Map<String, String>> newses2 = new ArrayList<Map<String, String>>();
        List<Map<String, String>> events2 = new ArrayList<Map<String, String>>();
        
        for (Map<String, String> map: articles) {
            if ( map.containsValue( "notice" ) ) {
                notices2.add( map );
            } else if ( map.containsValue( "news" ) ) {
                newses2.add( map );
            } else if ( map.containsValue( "event" ) ) {
                events2.add( map );
            }
        }

        System.out.println(notices2);
        System.out.println(newses2);
        System.out.println(events2);
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
    
    private static List<Map<String, String>> getArticles() {
        List<Map<String, String>> articles = new ArrayList<Map<String, String>>();
        
        Map<String, String> article1 = new HashMap<String, String>();
        article1.put( "title", "공지사항1" );
        article1.put( "flag", "notice" );
        articles.add( article1 );
        
        Map<String, String> article2 = new HashMap<String, String>();
        article2.put( "title", "공지사항2" );
        article2.put( "flag", "notice" );
        articles.add( article2 );
        
        Map<String, String> article3 = new HashMap<String, String>();
        article3.put( "title", "뉴스1" );
        article3.put( "flag", "news" );
        articles.add( article3 );
        
        Map<String, String> article4 = new HashMap<String, String>();
        article4.put( "title", "뉴스2" );
        article4.put( "flag", "news" );
        articles.add( article4 );
        
        Map<String, String> article5 = new HashMap<String, String>();
        article5.put( "title", "이벤트1" );
        article5.put( "flag", "event" );
        articles.add( article5 );
        
        Map<String, String> article6 = new HashMap<String, String>();
        article6.put( "title", "이벤트2" );
        article6.put( "flag", "event" );
        articles.add( article6 );
        
        System.out.println( articles );
        return articles;
    }
    
    /*
     * 알고리즘 패밀리 인터페이스
     */
    interface Predicate<T> {
        public boolean test( T t );
    }
}
