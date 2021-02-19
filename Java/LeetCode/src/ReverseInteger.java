public class ReverseInteger
{
    static int input = -123465;
    static int output = 0;
    static boolean wasNegative = false;

    //solution 1
    //check if int is negative value, if it is use special case conversion
    //convert int to string
    //store string into char array
    //reverse order of char array
    //convert char array into string
    //convert string into int
    public static int reverseInt(int input)
    {
        //check if int is negative value, if it is use special case conversion
        if(input < 0)
        {
            input = input * -1;
            wasNegative = true;
        }
        //convert int to string
        String s = String.valueOf(input);
        //store string in char array in reverse order
        char[] c = new char[s.length()];
        int charPosition = 0; //stores current position of char to help store in reverse order
        //loop starts at end of string
        for(int i = s.length() - 1; i >= 0; i--)
        {
            c[charPosition] = s.charAt(i);
            charPosition++;
        }
        //convert char array to string
        s = String.valueOf(c);

        //convert string to int
        output = Integer.parseInt(s);

        //check wasNegative, if true then convert to negative
        if(wasNegative)
        {
            output = output * -1;
        }

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
