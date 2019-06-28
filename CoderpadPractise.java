import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
//  @Test
// public void solutionTest(){
//   Map<String, Set<String>> friends = getFriends(employeesInput, friendshipsInput);
//   Assert.assertEquals(5, friends.size());
//   Assert.assertEquals(new HashSet<>(Arrays.asList("2","3")), friends.get("1"));
//   Assert.assertEquals(new HashSet<>(Arrays.asList("1", "4")), friends.get("2"));
//   Assert.assertEquals(new HashSet<>(Arrays.asList("1")), friends.get("3"));

// }

/* 
Suppose you are creating an internal networking site for your company.

You have two data sets to work with. The first data set is the employees at your company, and the second is all the pairs of employees who are virtually friends so far. It does not matter which employee's ID is in which column, the friendships are bidirectional. To get started, you need to represent each data set in code.

Furthermore, you want to know who’s friends with whom. You need to implement a function that, given the employees and friendships as parameters, returns this data in the form of an adjacency list representation. This is a mapping of each employee ID to a list of his/her friends on the site.

So, there are two parameters - the employees and the friendships.  Here's one possible example of the employees input array and the friendships input array:

 String[] employeesInput = {
      "1,Richard,Engineering",
      "2,Erlich,HR",
      "3,Monica,Business",
      "4,Dinesh,Engineering",
      "6,Carla,Engineering"
    };


    String[] friendshipsInput = {
      "1,2",
      "1,3",
      "2,4"
    };

And this would be considered an acceptable form of output for the adjacency list:

# 1: 2, 3
# 2: 1, 4
# 3: 1
# 4: 2
# 6: None
 */

// silly errors missing (), not deleting unused code, not making signature change to all places
// not to be confused with scala code, review code with bit more presence

// Not remembering iterating map, map update values & was not sure if map values get updates in function. Dont remember how to initialize set
// go through map methods again & make note

// Testing : remember unit testing & have template for copy
public class Solution{
  static void updateFriend(Map<String, Set<String>> friends, String friend1, String friend2){
      if(friends.containsKey(friend1) && friends.get(friend1) != null){
        friends.get(friend1).add(friend2);
        //Set<String> fValue = friends.get(friend1);
        //fValue.add(friend2);
        //friends.put(friend1, fValue);
      }else{
        Set<String> fValue = new HashSet<>();
        fValue.add(friend2);
        friends.put(friend1, fValue);
      }
  }
  
  static Map<String, Set<String>> getFriends(String[] employees, String[] friendsInput){
    Map<String, Set<String>> friends = new HashMap<String, Set<String>>();
    
    for(String employee: employees){
      friends.putIfAbsent(employee.split(",")[0].trim(), null);
    }
    
    for(String relation: friendsInput){
      String[] relationSplit = relation.split(",");
      String friend1 = relationSplit[0].trim();
      String friend2 = relationSplit[1].trim();
      updateFriend(friends, friend1, friend2);
      updateFriend(friends, friend2, friend1);
    }
    return friends;
  }
  
  @Test
  public void solutionTest(){
     String[] employeesInput = {
      "1,Richard,Engineering",
      "2,Erlich,HR",
      "3,Monica,Business",
      "4,Dinesh,Engineering",
      "6,Carla,Engineering"
    };


    String[] friendshipsInput = {
      "1,2",
      "1,3",
      "2,4"
    };
    
    Map<String, Set<String>> friends = getFriends(employeesInput, friendshipsInput);
    Assert.assertEquals(5, friends.size());
    Assert.assertEquals(new HashSet<>(Arrays.asList("2","3")), friends.get("1"));
    Assert.assertEquals(new HashSet<>(Arrays.asList("1", "4")), friends.get("2"));
    Assert.assertEquals(new HashSet<>(Arrays.asList("1")), friends.get("3"));
    Assert.assertEquals(new HashSet<>(Arrays.asList("2")), friends.get("4"));
    Assert.assertEquals(null, friends.get("6"));
  }
  
  
  public static void main(String args[]){
    // JUnitCore.main("Solution");
    
    String[] employeesInput = {
      "1,Richard,Engineering",
      "2,Erlich,HR",
      "3,Monica,Business",
      "4,Dinesh,Engineering",
      "6,Carla,Engineering"
    };


    String[] friendshipsInput = {
      "1,2",
      "1,3",
      "2,4"
    };
    getFriends(employeesInput, friendshipsInput).
      forEach((k,v) -> System.out.println(k+"--"+v));
  }
}
