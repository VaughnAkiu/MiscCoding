using System;
/*
Write a program that takes input of a number N and returns the sum of the natural numbers below N which are also multiples of 3 or 5.

For example, if we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
*/


public class Test
{

    //main function to take input and print output
    public static void Main()
    {
        string input = Console.ReadLine();
        
        //convert string input to int  
        int intput = Int32.Parse(input);  

        
        int result = MagicFunction(intput);
        
      
        Console.WriteLine(result);
    }


    //function to take input N and return sum of natural numbers below N which are also multiples of 3, or 5
    public static int MagicFunction(int n)
    {
        int result = 0;
        //array placeholder
        int z = 0;
        //array to store summable numbers
        int[] array = new int[n];

        //find all natural numbers below n (loop over 1 - n)
        for (int i = 1; i < n; i++)
        {
            //find multiples of 3 or 5 and add to array
            if (i % 3 == 0 || i % 5 == 0)
            {
                array[z] = i;
                z++;
            }

        }


        //add found numbers together
        for (int i = 0; i < array.Length; i++)
        {
                result += array[i];
        }

        //return result
        return result;
    }

}
/*
If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.

Not all numbers produce palindromes so quickly. For example,

349 + 943 = 1292,
1292 + 2921 = 4213
4213 + 3124 = 7337

That is, 349 took three iterations to arrive at a palindrome.

Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome. Due to the theoretical nature of these numbers, and for the purpose of this problem, we shall assume that a number cannot form a palindrome (a word/number that reads the same both forwards and backwards) until proven otherwise. In addition you are given that for every number below ten-thousand, it will either (i) become a palindrome in at least one but less than thirty iterations, or, (ii) no one, with all the computing power that exists, has managed so far to map it to a palindrome.

Write a method that outputs "True" if an integer, N, can produce a palindrome in 0 < x < 30 iterations and "False" if it cannot along with the number that the loop ended on (either the palindrome or the number at the end of 30 iterations).  For example, if the input is 5, the method would produce "True 11".
*/


using System;

public class Test
{
    public static void Main()
    {
        //input is less than 10k
        string input = Console.ReadLine();
        int n = Convert.ToInt32(input);
        
        string result = MagicFunction(n);
        Console.WriteLine(result);
    }

    //reverse int
    public static int ReverseInt(int input)
    {
        //store reversed result
        int result = 0;


        while(input > 0)
        {
            //convert the last digit of input into a singular digit
            int digit = input % 10;
            //convert the digit into the correct position
            result = result * 10 + digit;
            //reduce input digits by 1
            input = input / 10;
        }


        return result;
    }

    //determine if palindromic
    public static bool IsPalindromic(int input)
    {
        bool result;
        int reverse = ReverseInt(input);


        //compare the original with reverse if they are equal, then return true, else false
        if(input == reverse)
        {
            result = true;
        }
        else
        {
            result = false;
        }


        return result;
    }

    public static string MagicFunction(int input)
    {
        //result output string
        string result = "";
        //counter for current iteration
        int iteration = 1;
        //store the current iteration's palindrome
        int palindromeValue = 0;



        //loop while iteration is less than 30
        while(iteration < 30)
        {
            //add input and reversed input
            palindromeValue = input + ReverseInt(input);

            //check if current iteration is a palindrome
            if (IsPalindromic(palindromeValue))
            {
                result = "True " + palindromeValue;
                return result;
            }
            else
            {
                iteration++;
                //set input to current iteration's palindrome
                input = palindromeValue;
            }
        }

        //case where iteration has reached 30
        result = "False " + palindromeValue;



        return result;
    }

}

/*
Find the minimum cost path in a given matrix[][] of integers, from (0,0) to (m, n).

Each value inside of the matrix represents the cost to travel through that cell, and the total cost is the sum of all the cells travelled through.

There are three directions of traversal: down, right, diagonally down-right. All costs are positive integers.

Example: What is the cost of going to (2, 2) of the following matrix?

[[ 1, 2, 6 ],
[7, 8, 2],
[1, 4, 3]]

The path goes from (0,0), to (0, 1), to (1, 2), to (2, 2), with a total cost of 8. (1+2+2+3)

A starting code snippet has been provided so you do not need to worry about input processing.
*/


using System;

public class Test
{
    // Modify this function, and add other helper functions as required
    public static int MinCost(int[,] matrix, int m, int n) 
    {
        return -1;
    }
    
    // Do not modify code below this point
    public static void Main()
    {
        string input = Console.ReadLine();
        string nextLine;
        while((nextLine = Console.ReadLine()) != null) {
            input += Environment.NewLine + nextLine;
        }
        ArgSetup(input, out int[,] matrix, out int m, out int n);
        Console.WriteLine(MinCost(matrix, m, n));
    }

    private static void ArgSetup(string input, out int[,] matrix, out int m, out int n)
    {
        string[] inParams = input.Split(new string[] { Environment.NewLine }, StringSplitOptions.None);
        string[] indexParams = inParams[0].Split(' ');
        m = int.Parse(indexParams[0]);
        n = int.Parse(indexParams[1]);

        int colLength = inParams[1].Split(' ').Length;

        matrix = new int[inParams.Length - 1, colLength];

        for (int i = 1; i < inParams.Length; i++)
        {
            string[] rowParams = inParams[i].Split(' ');
            for (int j=0; j < rowParams.Length; j++)
            {
                matrix[i - 1, j] = int.Parse(rowParams[j]);
            }
        }
    }
}



