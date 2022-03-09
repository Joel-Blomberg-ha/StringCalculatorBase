public class StringCalculator {
    public int Add(String s){

        if (s == "") {
            return 0;
        }

        String delimiter = ",|\n";

        if (s.startsWith("//")) {
            delimiter = s.charAt(2) + "|\n";
            s = s.substring(4);
        }

        String[] split = s.split(delimiter);
        int y = 0;
        for (int i = 0; i < split.length; i++) {

            checkS(Integer.parseInt(split[i]));

            y = y + Integer.parseInt(split[i]);
        }

        return y;


    }

    static void checkS(int s) {
        if(s < 0){
            throw new StringCalcException("\n"+"“Negatives not allowed" + s);
        }
        else{
            System.out.println("good");
        }
    }
}
