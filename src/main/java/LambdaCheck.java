interface Fun{

    public void add();

}



public class LambdaCheck {


    public static void main(String args[]){

       Fun fu=() -> System.out.println("working lambda");


       fu.add();


    }



}
