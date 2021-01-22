import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'perfectTeam' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING skills as parameter.
     */

    public static int perfectTeam(String skills) {

        //number of teams that can be formed
        int result = 0;
        //number of iterations in the loop (length of input string) with constraint 5<=n<=5*10^5
        int n;
        if(skills.length() < 5){n = 5;}
        else if(skills.length() > 500000){n = 500000;}
        else{n = skills.length();}
        //int n = skills.length();
        //store values
        int storeP = 0;
        int storeC = 0;
        int storeM = 0;
        int storeB = 0;
        int storeZ = 0;
        //store array used to hold each store value in to iterate and find lowest stored
        int[] storeArray = new int[5];
        //find lowest stored value
        int lowestStored = 0;
        
        
        
        
        //iterate over string with for loop
        //use if statements to check for each respective character p c m b z
        //increment a "store integer" for each respective character
        
        for(int i = 0; i < n; i++)
        {
            if(skills.charAt(i) == 'p'){storeP++;}
            else if(skills.charAt(i) == 'c'){storeC++;}
            else if(skills.charAt(i) == 'm'){storeM++;}
            else if(skills.charAt(i) == 'b'){storeB++;}
            else if(skills.charAt(i) == 'z'){storeZ++;}
        }
        
        //fill storeArray[]
        storeArray[0] = storeP;
        storeArray[1] = storeC;
        storeArray[2] = storeM;
        storeArray[3] = storeB;
        storeArray[4] = storeZ;
        
        //create for loop to compare each value of storeArray with itself and other values
        //could be implemented more efficiently by not checking with itself, also by only checking values that havent been checked already
        for(int i = 0; i < storeArray.length; i++)
        {
            if(storeArray[0] < storeArray[i]){lowestStored = storeP;}
            if(storeArray[1] < storeArray[i]){lowestStored = storeC;}
            if(storeArray[2] < storeArray[i]){lowestStored = storeM;}
            if(storeArray[3] < storeArray[i]){lowestStored = storeB;}
            if(storeArray[4] < storeArray[i]){lowestStored = storeZ;}
        }
        //loop does not check for the case where all stores are equal
        //we can set lowestStored to any of the store values if this is the case
        //if lowestStored has the initial value of 0 then change it to one of the store values
        //if(lowestStored == 0){lowestStored = storeP;}
        if(storeArray[0] == storeArray[1] && storeArray[0] == storeArray[2] && storeArray[0] == storeArray[3] && storeArray[0] == storeArray[4])
        {
            lowestStored = storeP;
        }

        /*
        //compare the store integers for the lowest respective value btwn
        
        //set value of lowestStored to first checked store
        lowestStored = storeP;
        //find lowest respective value between store integers
        
        //check if lowest stored is storeP
        if(storeP > storeC){lowestStored = storeC;}
        else if(storeP > storeM){lowestStored = storeM;}
        else if (storeP > storeB){lowestStored = storeB;}
        else if (storeP > storeZ){lowestStored = storeZ;}
        //if lowest stored is not storeP check storeC
        else if(lowestStored != storeP)
        {
            if(storeC > storeM){lowestStored = storeM;}
            else if(storeC > storeB){lowestStored = storeB;}
            else if(storeC > storeZ){lowestStored = storeZ;}
            else if(lowestStored != storeC)
        }*/
        
        
        
        
        //set result to the lowest stored
        result = lowestStored;
        return result;
        
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String skills = bufferedReader.readLine();

        int result = Result.perfectTeam(skills);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
