/*
    Decorator Design pattern
*/
package coffeedecorator;


abstract class Coffee{ 
    protected float price;
    
    public Coffee(){
        this.price = price;
    }
    
    public Coffee(float price){
        this.price = price;
    }
    
    public void totalPrice(){
        System.out.println("The total price is: $" + price);
    }
}

class DarkRoast extends Coffee{
   
    public DarkRoast(float price){
        super(price + (float)1.15);
    }
 
}

class HouseBlend extends Coffee{

    public HouseBlend(float price) {
        super(price + (float)1.20);
    }
}

class Decaf extends Coffee{

    public Decaf(float price) {
        super(price + (float)1.10);
    }
}

class Espresso extends Coffee{

    public Espresso(float price) {
        super(price + (float)2.00);
    }
}

abstract class addition extends Coffee{
    private Coffee coffee;

    public addition(float price) {
        super(price);
    }
}

class SteamedMilk extends addition{

    public SteamedMilk(Coffee coffee) {
        super((float)0.30 + coffee.price);
    }
}

class SoyMilk extends addition{

    public SoyMilk(Coffee coffee) {
        super((float)0.15 + coffee.price);
    }
}

class Mocha extends addition{

    public Mocha(Coffee coffee) {
        super((float)0.20 + coffee.price);
    }
}

class WhippedCream extends addition{
    public WhippedCream(Coffee coffee) {
        super((float)0.10 + coffee.price);
    }
}

public class CoffeeDecorator {

    public static void main(String[] args) {
        
        Coffee c = new Espresso(0);
        c = new Mocha(c);
        c = new Mocha(c);
        c = new SoyMilk(c);
        c = new WhippedCream(c);
      
        c.totalPrice();
  
    }
    
}
