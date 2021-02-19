public class RomanToInteger {


        static String s = "III";
        static int romanValue = 0; //placeholder to hold roman numeral value
        static int result;

        //convert string to numerals
        public static void convertString(String s){
            for(int i = 0; i < s.length(); i++)
            {
                if(s.charAt(i) == 'I')
                {
                    romanValue++;
                }
                else if(s.charAt(i) == 'V')
                {
                    romanValue = romanValue + 5;
                }
            }

            result = romanValue;
        }

        

        public static void main(String[] args) {
            convertString(s);

            System.out.println("" + result);
        }



}
