package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */

  public static Option<Integer> power(Integer i, Integer n) {
      if(i==0 && n!=0)
      {
        return Option.of(0);
      }

      else if(n==0)
      {
        return Option.of(1);
      }

      else
      {
        int result = 1;
        for(int j=0 ; j<n;j++)
        {
         result =result*i;
        }
        
        if(result==0)
        {
        return Option.none();
        }
        
        return Option.of(result);
        
      }

    
  }
}
