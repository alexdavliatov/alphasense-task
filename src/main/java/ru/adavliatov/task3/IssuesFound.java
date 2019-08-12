package ru.adavliatov.task3;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

public class IssuesFound {

  public static abstract class Digest {
    //`byte[]` usage as a map key-inappropriate:
    //array hash is calculated based on Object.hashCode() and doesn't depend on elements
    //2 arrays doesn't equal to each other.
    private Map<byte[], byte[]> cache = new HashMap<>();

    public byte[] digest(byte[] input) {
      byte[] result = cache.get(input);
      if (result == null) {
        //cache is neither final, nor volatile% so changes from one thread may be not seen in another
        synchronized (cache) {
          result = cache.get(input);
          if (result == null) {
            try {
              result = doDigest(input);
              cache.put(input, result);
              //It's pointless exception catching
            } catch (RuntimeException ex) {
              //Logger is created each time. Actually, this logging is useless
              LoggerFactory.getLogger("Digest").error("Unable to make digest");
              throw ex;
            }
          }
        }
      }
      return result;
    }

    protected abstract byte[] doDigest(byte[] input);
  }
}
