public class RomanToInteger {


        String s = "III";
        int romanValue = 0; //placeholder to hold roman numeral value

        //char[] charArray = new char[s.length()];

        public int romanToInt(String s) {
            return 1;
        }
        /*
        //read given string into a character array
        public void stringToArray(String s){

            for(int i = 0; i < s.length(); i++)
            {
                charArray[i] = s.charAt(i);
            }
        }*/

        //convert string to numerals
        public void convertString(String s){
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
        }




        public static void main(String[] args) {
            System.out.println("hello");
            System.out.println("hello".charAt(1));
        }



}
