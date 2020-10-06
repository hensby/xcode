package antra;

public class isInteger {
    public static boolean isInteger( String input ) {
        try {
            Integer.parseInt( input );
            return true;
        }
        catch(NumberFormatException e ) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isInteger("1ww1111"));
        String str = "old ";
        System.out.println(str.concat("new"));
    }
}
