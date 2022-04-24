package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {
    
    List<Double> results = new ArrayList<Double>();

    for(int i=0;i<input.size();i++)
    {
      results.add(Math.pow(((input.get(i)*2)+3),5));
    }
    return results;
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {

    List<String> result = new ArrayList<String>();

    if(!(input.isEmpty()))
    {
      for(int i=0;i<input.size();i++)
      {
        if(input.get(i).equals(""))
        {
          return input;
        }
        else{
        String str=input.get(i).substring(0, 1).toUpperCase() + input.get(i).substring(1);
        result.add(str+str);
        }
      } 
      return result;      
    }

    return input;
  }

}
