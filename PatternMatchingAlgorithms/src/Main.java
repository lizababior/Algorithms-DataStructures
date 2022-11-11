public class Main {

    public static void main(String[] args) {
        String pattern = "xxx";
        String text = "abcdexxxxxxunbexxxke";


        Result resultBM = new BoyerMoore().searchBM(pattern, text);

        if (!resultBM.found) {
            System.out.println("Cannot find");
            return;
        }

        System.out.println(resultBM);

        Result resultRK = new RabinKarp().searchRK(pattern, text);

        if (!resultRK.found) {
            System.out.println("Cannot find");
            return;
        }

        System.out.println(resultRK);
    }
}
