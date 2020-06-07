package main.Exercises;

import java.awt.*;

public class deneme {
    {
        color="red";
    }
    String color="green";
    String type;

    deneme(String color,String type){
        System.out.println("The car is a "+color+" "+type);
    }
    void drive(){
        String greeting=null;
        System.out.println(greeting+"gshgfkluh;oij");
    }

    public static void main(String[] args) {
        deneme myCar= new deneme("silver","sedan");
        myCar.drive();
        System.out.println(myCar.color);
    }


}
