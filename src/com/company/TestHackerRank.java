package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class TestHackerRank {
  public static void main(String[] args) {
    var blackips = List.of("111.*.255", "12.");
    var req = List.of("121.3.5.255", "12.13.5.255", "111.3.5.255", "121.3.5.255");

    var result = Result.validateRequests(blackips, req);

    System.out.println(result);
  }
}

class Result {

  /*
   * Complete the 'fizzBuzz' function below.
   *
   * The function accepts INTEGER n as parameter.
   */

  public static List<Integer> validateRequests(List<String> blacklisted_ips, List<String> requests) {

    Map<String, Integer> countMap = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < requests.size(); i++) {
      String ip = requests.get(i);
      boolean matches = false;
      for (int x = 0; x < blacklisted_ips.size(); x++) {
        String reg = blacklisted_ips.get(x);
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(ip);
        if (matcher.find()) {
          matches = true;
          break;
        } else {
          Integer count = countMap.get(ip);
          if (count == null) {
            countMap.put(ip, i);
          } else if (i - count <= 5 ){
            matches = true;
            countMap.put(ip, i);
            break;
          } else {
            countMap.put(ip, i);
          }

        }
      }

      if (matches) {
        result.add(1);
      } else {
        result.add(0);
      }
    }

    return result;
  }

}
