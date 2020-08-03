
import java.util.*;
import java. lang. Math. *;
//puprose of this class is to make a certain pattern of circles according to 
//the provided level or n by the user
public class Fillcircle{
//base case that if n at a point reaches -1 break out of the loop
//0 would mean just a single circle is needed
//while going through recursion the circle would not mulitply nor would 
//be seperated instead would overlap

public static void fillCircle(double x, double y, double radius, int level){
    if(level==-1){          //to break the recursion
        return;
    }
    else if(level==0){
     StdDraw.circle(x,y,radius);     //simply make a big circle if n is a specific level
    }
   
    else{
        StdDraw.circle(x,y,radius);
        fillCircle(x+Math.PI,y+Math.PI,radius/3,level);
        fillCircle(x+Math.PI,y-Math.PI,radius/3,level);
        fillCircle(x-Math.PI,y+Math.PI,radius/3,level);
        fillCircle(x-Math.PI,y-Math.PI,radius/3,level);
         StdDraw.show(5);
        }
    }

 public static void main(String[] args){
    
     Fillcircle object=new Fillcircle();
        double x=0.5;
        double y=0.5;
        double r=0.5;
       
       Scanner scan = new Scanner(System.in);
       int n=0;
        while(n==-1){
         
        System.out.print("Enter the  number n: ");

        // This  reads the number provided 
         n = scan.nextInt();
        object.fillCircle(x,y,r,n);
    }
        

        // Closing Scanner after the use
        scan.close();
    
    
}}
