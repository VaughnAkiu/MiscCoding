public class ReverseInteger
{
    static int input = 123;
    static int output = 0;

    //solution 1
    //convert int to string
    //store string into char array
    //reverse order of char array
    //convert char array into string
    //convert string into int
    public static int reverseInt(int input)
    {
        //convert int to string
        String s = String.valueOf(input);


        return output;
    }

    //solution 2
    //check value of int
    //if value is >9 then use a two char array
    //if value is > 99 then use 3 char array etc.
    //store each ones, tens, hundreds etc value in corresponding array
    public static void main(String[] args) {

        reverseInt(input);
        System.out.println(output);
    }
}
