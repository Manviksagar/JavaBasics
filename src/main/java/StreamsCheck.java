import java.util.Arrays;
import java.util.List;

public class StreamsCheck {


    public static void main(String args[]){

        List<Integer> ls = Arrays.asList(20,30,40,37,60);

       //ls.stream().filter(n ->n%2==0).forEach(n -> System.out.println(n));
        ls.stream().filter(n ->n%2==0).forEach(System.out::println);


    }


}
