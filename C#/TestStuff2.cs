using System.Collections.Generic;
using System;

public class AlertService	
{
    private readonly AlertDAO storage = new AlertDAO();
    
    //constructor that accepts IAlertDAO
    public AlertService(IAlertDAO alert)
    {
        
    }
    
	
    //methods should use object passed through constructor
    public Guid RaiseAlert()
    {
        return this.storage.AddAlert(DateTime.Now);
    }
	
    public DateTime GetAlertTime(Guid id)
    {
        return this.storage.GetAlert(id);
    }	
}
	
//interface contains methods of AlertDAO
public interface IAlertDAO
{
    public Guid AddAlert(DateTime time);
    public DateTime GetAlert(Guid id);
}


//AlertDAO implements IAlertDAO
public class AlertDAO : IAlertDAO
{
    private readonly Dictionary<Guid, DateTime> alerts = new Dictionary<Guid, DateTime>();
	
    
    
    public Guid AddAlert(DateTime time)
    {
        Guid id = Guid.NewGuid();
        this.alerts.Add(id, time);
        return id;
    }
	
    public DateTime GetAlert(Guid id)
    {
        return this.alerts[id];
    }	
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



using System;

public class MergeNames
{
    public static string[] UniqueNames(string[] names1, string[] names2)
    {
        //declare i outside of array to keep track of mergedNames position
        int i;
        //length of to be created array
        int length = names1.Length + names2.Length;
        
        //create new array with both arrays contents
        string[] mergedNames = new string[length];
        //loop over both arrays
        for(i = 0; i < names1.Length; i++)
        {
            mergedNames[i] = names1[i];
        }
        for(int j = 0; j < names2.Length; j++)
        {
            mergedNames[i] = names2[j];
            //increment i so mergedNames place is incremented
            i++;
        }
        
        
        //loop over new array checking for duplicates
        for(int k = 0; k < mergedNames.Length; k++)
        {
            //check each index with every other index of the array for the same value
             if(mergedNames[0] = mergedNames[k])
             {
                 
             }
        }
        
        
        //return new merged array
        return mergedNames;
    }
    
    public static void Main(string[] args)
    {
        string[] names1 = new string[] {"Ava", "Emma", "Olivia"};
        string[] names2 = new string[] {"Olivia", "Sophia", "Emma"};
        Console.WriteLine(string.Join(", ", MergeNames.UniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}







/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//all test case passed
using System;
using System.Collections.Generic;
using System.Linq;

public class UniqueNumbers
{
    public static IEnumerable<int> FindUniqueNumbers(IEnumerable<int> numbers)
    {
        //use Linq library to query values in a set 
        IEnumerable<int> uniqueNumbs =
            //choose values
            from number in numbers
            //group values into set
            group numbers by number into grp
            //find values that only occur once
            where grp.Count() == 1
            //set values inside group to the previous conditional
            select grp.Key;
        
        //return set
        return uniqueNumbs;
    }

    public static void Main(string[] args)
    {
        int[] numbers = new int[] { 1, 2, 1, 3 };
        foreach (var number in FindUniqueNumbers(numbers))
            Console.WriteLine(number);
    }
}




/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//1 test case passed



using System;
using System.Collections.Generic;

public class WeightedAverage
{
    public static double Mean(IList<int> numbers, IList<int> weights)
    {
        int total = 0;
        int totalWeights = 0;
        
        
        
        
        //throw exception when array lengths are not equal
        if(numbers.Count != weights.Count)
        {
            throw new ArgumentException("Array lengths are not equal.");
        }
         
        
        for (int i = 0; i < numbers.Count; i++)
        {
            //throw exception when either argument is null
            if(numbers[i] == 0 || weights[i] == 0)
            {
                throw new ArgumentNullException("Null value found in input.");
            }
            
            
            
            
            
            //(number i * weight i + number i2 * weight i2 + ...)
            total += (numbers[i] * weights[i]);
            
            //(weight i + weight i2 + ...)
            totalWeights += weights[i];
        }

        
        //throw exception when trying to divide by 0
        if(totalWeights == 0)
        {
            throw new ArgumentException("Cannot divide by 0");
        }
        
        
        //cast return value to double
        return (double) (total / totalWeights);
    }

    public static void Main(string[] args)
    {
        int[] values = new int[] { 3, 6 };
        int[] weights = new int[] { 4, 2 };

        Console.WriteLine(WeightedAverage.Mean(values, weights));
    }
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





