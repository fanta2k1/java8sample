package ramda;

import java.util.ArrayList;
import java.util.List;

public class Apple
{
    private String color;
    
    private int weight;
    
    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor( String color )
    {
        this.color = color;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight( int weight )
    {
        this.weight = weight;
    }
    
    public String toString() {
        return "Apple { color='" + color + "' , weight=" + weight + " }\n";
    }
    
    public static class AppleList {
        public static List<Apple> getAppleList() {
            List<Apple> appleList = new ArrayList<Apple>();
            
            appleList.add( new Apple( "red", 139 ) );
            appleList.add( new Apple( "red", 90 ) );
            appleList.add( new Apple( "green", 160 ) );
            appleList.add( new Apple( "green", 110 ) );
            appleList.add( new Apple( "yellow", 160 ) );
            
            return appleList;
        }
    }
}
