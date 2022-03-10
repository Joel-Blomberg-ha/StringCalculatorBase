import java.util.Scanner;

public class StringCalculator {

    ConsolLogger logger;

    public StringCalculator(ConsolLogger consolLogger) {
        logger = consolLogger;
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter input:");
        String s = "";
        while(myObj.hasNext()){
         s = s + myObj.nextLine() + ",";
        }
        System.out.println("The result is" + new StringCalculator(new ConsolLogger()).Add(s));
    }


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
            if(Integer.parseInt(split[i]) >= 1000){
                logger.log(split[i]);
            }

            y = y + Integer.parseInt(split[i]);
        }

        return y;


    }

    static void checkS(int s) {
        if(s < 0){
            throw new StringCalcException("\n"+"“Negatives not allowed" + s);
        }
        else{
        }
    }
}
