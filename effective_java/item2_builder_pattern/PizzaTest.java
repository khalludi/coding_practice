package item2_builder_pattern;

import static item2_builder_pattern.Pizza.Topping.*;
import static item2_builder_pattern.NyPizza.Size.*;

public class PizzaTest {
  public static void main(String[] args) {
    NyPizza pizza = new NyPizza.Builder(SMALL)
            .addTopping(SAUSAGE).addTopping(ONION).build();
    Calzone calzone = new Calzone.Builder()
            .addTopping(HAM).sauceInside().build();
  } 
}
