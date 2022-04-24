package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.concurrent.CompletableFuture;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
    CompletableFuture<Option<Ceo>> result = new CompletableFuture<>();
    for(int i=0;i<ceos.size();i++)
    {
      if(ceos.get(i).id.equals(ceo_id))
      {
        result.complete(Option.of(ceos.get(i)));
        return result;
      }
      
    }
    result.complete(Option.none());
    return result;
  }

  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {

    CompletableFuture<Option<Enterprise>> result = new CompletableFuture<>();
    for(int i=0;i<enterprises.size();i++)
    {
      if(enterprises.get(i).ceo_id.equals(ceo_id))
      {
        result.complete(Option.of(enterprises.get(i)));
        return result;
      }
      
    }
    result.complete(Option.none());
    return result;
  }

  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
    CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> result = new CompletableFuture<>();
    for(int i=0;i<ceos.size();i++)
    {
      if(ceos.get(i).id.equals(ceo_id))
      {
        for(int j=0;j<enterprises.size();j++)
        {
          if(enterprises.get(j).ceo_id.equals(ceo_id))
          {
            result.complete(Tuple.of(Option.of(ceos.get(i)),Option.of(enterprises.get(j))));
            return result; 
          }
          else if(j==enterprises.size()-1) {
            result.complete(Tuple.of(Option.of(ceos.get(i)),Option.none()));
            return result;             
          }
        }
      }
      else if(i==(ceos.size()-1))
      {
        for(int j=0;j<enterprises.size();)
        {
          if(enterprises.get(j).ceo_id.equals(ceo_id))
          {
            result.complete(Tuple.of(Option.none(),Option.of(enterprises.get(j))));
            return result; 
          }
          else {
            result.complete(Tuple.of(Option.none(),Option.none()));
            return result;             
          }
        }        
      }
      
    }
    return result;
  }

}
