public class RomanToInteger {


        static String s = "XXIV";
        static int romanValue = 0; //placeholder to hold roman numeral value
        static int result;

        //convert string to numerals
        //check special cases
        //such as IV, IX, XL, etc...
        //check next character as well, if combination of these values then adjust to corresponding value
        public static void convertString(String s){
            for(int i = 0; i < s.length(); i++)
            {
                //check for special cases
                if(s.charAt(i) == 'I')
                {
                    //special case 1
                    //make sure not checking a null value
                    if(i+1 < s.length() & s.charAt(i+1) == 'V') {
                        romanValue = romanValue + 4;
                        i++; //increment past the next character since we are accounting for it here
                    }
                    //special case 2
                    else if (i+1 < s.length() & s.charAt(i+1) == 'X')
                    {
                        romanValue = romanValue + 9;
                        i++;
                    }
                    else{romanValue++;} //there is no special case
                }
                //no special cases for V
                else if(s.charAt(i) == 'V')
                {
                    romanValue = romanValue + 5;
                }
                //check special cases for XL and XC
                else if(s.charAt(i) == 'X')
                {
                    romanValue = romanValue + 10;
                }
                else if(s.charAt(i) == 'L')
                {
                    romanValue = romanValue + 50;
                }
            }
            result = romanValue;
        }



        //make test cases eventually
        public static void main(String[] args) {
            convertString(s);

            System.out.println("" + result);
        }



}
