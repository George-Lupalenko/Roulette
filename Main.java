import java.util.Scanner;

public class Main {
  static int balance = 1000;
 int betOnTheNumber;
 int betOnTheColor;
 int betOnEvenOdd;
    String[] allFlields = {"0", "32", "15", "19", "4", "21", "2", "25", "17", "34",
            "6", "27", "13", "36", "11", "30", "8", "23", "10", "5",
            "24", "16", "33", "1", "20", "14", "31", "9", "22", "18",
            "29", "7", "28", "12", "35", "3", "26"};

    int  resultNumber = (int) (Math.random() * 37);

    public static void main(String[] args) {
        System.out.println("Это приложение рулетка имитация рельного казино");
        System.out.println("Ваш баланс:"+balance);
        Main game = new Main();
//        game.CheckOutPutTest();
//        game.CheckEvenOddTest();
        game.newSesion();

    }

    public void newSesion() {
        resultNumber = (int) (Math.random() * 37);
        Scanner scan = new Scanner(System.in);
        System.out.print("Желаете поставить на число:");
        String numberBet = scan.nextLine();
        System.out.print("Желаете поставить на цвет:");
        String colorBet = scan.nextLine();
        System.out.print("Желаете поставить на чет/нечет:");
        String evenOddBet = scan.nextLine();
        if(yesOrNot(numberBet) && yesOrNot(colorBet) && yesOrNot(evenOddBet)){
            colorAndEvenOddBetNumber();
        }
        else if(yesOrNot(numberBet) && yesOrNot(colorBet) && !yesOrNot(evenOddBet)){
            numberAndColorBet();
        }
        else if(yesOrNot(numberBet) && !yesOrNot(colorBet) && yesOrNot(evenOddBet)){
            numberAndEvenOddBet();
        }
        else if(!yesOrNot(numberBet) && yesOrNot(colorBet) && yesOrNot(evenOddBet)){
            colorAndEvenOddBet();
        }
        else if (yesOrNot(evenOddBet)) {
            String evenOdd;
            String selectedEvenOrOdd = oddEvenBet();
            if(Integer.parseInt(allFlields[resultNumber])%2 == 0){
                evenOdd = "even";
            }
            else{
                evenOdd = "odd";
            }
            if(selectedEvenOrOdd.equals("odd") || selectedEvenOrOdd.equals("even")){
                checkWinnerEvenOdd(evenOdd , selectedEvenOrOdd);
            }
        }
        else if (yesOrNot(numberBet)) {
            int selectedNumber = numberBet();
            System.out.println("Выпало число " + allFlields[resultNumber]);
            checkWinnerNumber(selectedNumber, Integer.parseInt(allFlields[resultNumber]));
        } else if (yesOrNot(colorBet)) {
            String selectedColor = colorBet();
            String color ;
            if( resultNumber%2==0){
                color = "black";
            }
            else {
                color = "red";
            }
            if (selectedColor.equals("black")|| selectedColor.equals("red")) {
                System.out.println("Выпало число " + allFlields[resultNumber]);
                checkWinnerColor(selectedColor, color);
            }
            else {
                System.out.println("Вы указали не верный цыет укажите еще раз еще раз");
                colorBet();
            }
        }
        if(balance>0){
        System.out.println("Желаете вступить вследущую игру?");
        System.out.println("Ваш баланс: "+ balance);
        String userAnswerInput = scan.nextLine();
            if(yesOrNot(userAnswerInput)){
                newSesion();
            }
        }
    } public void checkWinnerColorEvenOdd(String selectedColor ,String color,String evenOdd,String selectedEvenOdd,int Number,int inputNumber) {
        if(Number == inputNumber && evenOdd.equals(selectedEvenOdd)&& color.equals(selectedColor)){
            System.out.println("Выпало число: " + allFlields[resultNumber]);
            System.out.println("You won " + (betOnTheNumber * 35  + betOnEvenOdd* 2 + betOnTheColor*2)+ " Congrats");
            balance = balance + betOnTheNumber * 35 + betOnEvenOdd * 2 +betOnTheColor*2 ;
            System.out.println("Ваш баланс: " + balance);

        }
        else if(color.equals(selectedColor) && evenOdd.equals(selectedEvenOdd)){
            checkWinnerColorEvenOdd(color , selectedColor ,evenOdd ,selectedEvenOdd);
            checkWinnerNumber(Number, inputNumber);

        }
        else if(Number == inputNumber && evenOdd.equals(selectedEvenOdd)){
            checkWinnerNumberEvenOdd(Number , inputNumber ,evenOdd,selectedEvenOdd);
            checkWinnerEvenOdd(color , selectedColor);

        }
        else if(Number == inputNumber && color.equals(selectedColor)){
            checkWinnerNumberColor(Number , inputNumber , color,selectedColor);
            checkWinnerEvenOdd(evenOdd , selectedEvenOdd);

        }
        else if(Number == inputNumber){
            checkWinnerNumber(Number, inputNumber);
            checkWinnerEvenOdd(color , selectedColor);
            checkWinnerEvenOdd(evenOdd , selectedEvenOdd);
        }
        else if(evenOdd.equals(selectedEvenOdd)){
            checkWinnerEvenOdd(evenOdd , selectedEvenOdd);
            checkWinnerNumber(Number ,inputNumber);
            checkWinnerEvenOdd(color , selectedColor);
        }
        else if(color.equals(selectedColor)){
            checkWinnerColor(color, selectedColor);
            checkWinnerEvenOdd(evenOdd , selectedEvenOdd);
            checkWinnerNumber(Number ,inputNumber);
        }
        else{
            System.out.println("Выпало число: " + allFlields[resultNumber]);
            System.out.println("Ни одна из ваших ствок не сыграла ,вы прогирали "+ (betOnEvenOdd + betOnTheNumber +betOnTheColor));
            System.out.println("Ваш баланс:" +( balance - (betOnEvenOdd + betOnTheNumber+betOnTheColor)));
        }
    }

    public void checkWinnerColorEvenOdd(String selectedColor ,String color, String evenOdd , String selectedEvenOdd) {
        if(color.equals(selectedColor) && evenOdd.equals(selectedEvenOdd)){
            System.out.println("Выпало число: " + allFlields[resultNumber]);
            System.out.println("You won " + (betOnTheColor * 2  + betOnEvenOdd* 2)+ " Congrats ");
            balance = balance+ betOnTheColor * 2 + betOnEvenOdd * 2 ;
            System.out.println("Ваш баланс: " + balance);

        }
        else if(color.equals(selectedColor)){
            checkWinnerColor(color, selectedColor);
            checkWinnerEvenOdd(evenOdd , selectedEvenOdd);
        }
        else if(evenOdd.equals(selectedEvenOdd)){
            checkWinnerEvenOdd(evenOdd , selectedEvenOdd);
            checkWinnerColor(color, selectedColor);
        }
        else{
            System.out.println("Выпало число: " + allFlields[resultNumber]);
            System.out.println("Ни одна из ваших ствок не сыграла ,вы прогирали "+ (betOnEvenOdd +betOnTheColor));
            System.out.println("Ваш баланс:" +( balance - (betOnEvenOdd + betOnTheColor)));
        }
    }
    public void checkWinnerNumberEvenOdd(int Number, int inputNumber , String evenOdd , String selectedEvenOdd) {
        if(Number == inputNumber && evenOdd.equals(selectedEvenOdd)){
            System.out.println("Выпало число: " + allFlields[resultNumber]);
            System.out.println("You won " + betOnTheNumber * 35  + betOnEvenOdd* 2+ " Congrats");
            balance = balance + betOnTheNumber * 35 + betOnEvenOdd * 2 ;
            System.out.println("Ваш баланс: " + balance);

        }
        else if(Number == inputNumber){
            checkWinnerNumber(Number, inputNumber);
            checkWinnerEvenOdd(evenOdd , selectedEvenOdd);
        }
        else if(evenOdd.equals(selectedEvenOdd)){
            checkWinnerEvenOdd(evenOdd , selectedEvenOdd);
            checkWinnerNumber(Number ,inputNumber);
        }
        else{
            System.out.println("Выпало число: " + allFlields[resultNumber]);
            System.out.println("Ни одна из ваших ствок не сыграла ,вы прогирали "+ (betOnEvenOdd + betOnTheNumber));
            System.out.println("Ваш баланс:" +( balance - (betOnEvenOdd + betOnTheNumber)));
        }
    }
    public void checkWinnerNumberColor(int Number, int inputNumber , String color , String selectedColor) {
        if(Number == inputNumber && color.equals(selectedColor)){
            System.out.println("Выпало число: " + allFlields[resultNumber]);
            System.out.println("You won " + (betOnTheNumber * 35  + betOnTheColor* 2)+ " Congrats");
            balance =  balance + betOnTheNumber * 35 + betOnTheColor * 2 ;
            System.out.println("Ваш баланс: " + balance);

        }
        else if(Number == inputNumber){
            checkWinnerNumber(Number, inputNumber);
            checkWinnerColor(color , selectedColor);
 }
        else if(color.equals(selectedColor)){
            checkWinnerColor(color , selectedColor);
            checkWinnerNumber(Number ,inputNumber);
        }
        else{
            System.out.println("Выпало число: " + allFlields[resultNumber]);
            System.out.println("Ни одна из ваших ствок не сыграла ,вы прогирали "+ (betOnTheColor + betOnTheNumber));
            System.out.println("Ваш баланс:" +( balance - (betOnTheColor + betOnTheNumber)));
        }
    }
    public void checkWinnerNumber(int Number, int inputNumber) {
        if (Number == inputNumber) {
            System.out.println("Выпало число: " + allFlields[resultNumber]);
            System.out.println("You won " + betOnTheNumber * 35 + " Congrats");
            balance = balance  + betOnTheNumber * 35;
            System.out.println("Ваш баланс: " + balance);
        } else {
            System.out.println("Выпало число: " + allFlields[resultNumber]);
            System.out.println("Вы проиграли " + betOnTheNumber );
            balance = balance-betOnTheNumber;
            System.out.println("Ваш баланс: " + (balance));
        }
    }
    public void checkWinnerColor(String color, String selectedColor) {
        if (color.equals(selectedColor)) {
            System.out.println("Выпало число: " + allFlields[resultNumber]);
            System.out.println("You won " + betOnTheColor * 2 + " Congrats");
            balance=balance+betOnTheColor*2;
            System.out.println("Ваш баланс: " + balance );
        } else {
            System.out.println("Выпало число: " + allFlields[resultNumber]);
            System.out.println("Вы проиграли " + betOnTheColor );
            balance = balance-betOnTheColor;
            System.out.println("Ваш баланc:" + (balance));
        }
    } public void checkWinnerEvenOdd(String evenOdd, String selectedEvenOrOdd) {
        if (evenOdd.equals(selectedEvenOrOdd)) {
            System.out.println("Выпало число: " + allFlields[resultNumber]);
            System.out.println("You won " + betOnEvenOdd * 2 + " Congrats");
            balance=balance+betOnEvenOdd*2;
            System.out.println("Ваш баланс: " + balance );
        } else {
            System.out.println("Выпало число: " + allFlields[resultNumber]);
            System.out.println("Вы проиграли " + betOnEvenOdd );
            balance = balance-betOnEvenOdd;
            System.out.println("Ваш баланc:" + (balance));
        }
    }

    public boolean yesOrNot(String answer) {
        return answer.equals("yes");
    }
    public void colorAndEvenOddBetNumber(){
        int selectedNumber = numberBet();
        String selectedEvenOrOdd = oddEvenBet();
        String selectedColor = colorBet();
        String color ;
        String evenOdd;
        if( resultNumber%2==0){
            color = "black";
        }
        else if(allFlields[resultNumber].equals("0")){
            color = "green";
        }
        else{
            color = "red";
        }

        if(Integer.parseInt(allFlields[resultNumber])%2 == 0){
            evenOdd = "even";
        }
        else{
            evenOdd = "odd";
        }
        checkWinnerColorEvenOdd(selectedEvenOrOdd , evenOdd,selectedColor, color , selectedNumber ,Integer.parseInt(allFlields[resultNumber]) );
    }
    public void numberAndColorBet(){
        int selectedNumber = numberBet();
        String selectedColor = colorBet();
        String color ;
        if( resultNumber%2==0){
            color = "black";
        }
        else if(allFlields[resultNumber].equals("0")){
            color = "green";
        }
        else{
            color = "red";
        }
        checkWinnerNumberColor(selectedNumber, Integer.parseInt(allFlields[resultNumber]),selectedColor, color);
    }
    public void numberAndEvenOddBet(){
        int selectedNumber = numberBet();
        String selectedEvenOrOdd = oddEvenBet();
        String evenOdd;
        if(Integer.parseInt(allFlields[resultNumber])%2 == 0){
            evenOdd = "even";
        }
        else{
            evenOdd = "odd";
        }
        if(selectedEvenOrOdd.equals("odd") || selectedEvenOrOdd.equals("even")) {
            checkWinnerNumberEvenOdd(selectedNumber, Integer.parseInt(allFlields[resultNumber]), selectedEvenOrOdd, evenOdd);
        }
    }
    public void colorAndEvenOddBet(){
        String selectedEvenOrOdd = oddEvenBet();
        String selectedColor = colorBet();
        String color ;
        String evenOdd;
        if( resultNumber%2==0){
            color = "black";
        }
        else if(allFlields[resultNumber].equals("0")){
            color = "green";
        }
        else{
            color = "red";
        }

        if(Integer.parseInt(allFlields[resultNumber])%2 == 0){
            evenOdd = "even";
        }
        else{
            evenOdd = "odd";
        }
        checkWinnerColorEvenOdd(selectedColor, color, evenOdd,selectedEvenOrOdd);
    }

    public String oddEvenBet(){
        Scanner strScan = new Scanner(System.in);
        System.out.println("Select even or odd:");
        String selectedEvenOrOdd = strScan.nextLine();
        if(selectedEvenOrOdd.equals("odd") || selectedEvenOrOdd.equals("even")){
            getBetOnEvenOdd();
        }
        else{
            System.out.println("Не верный параметр попробуйте еще раз");
            oddEvenBet();
        }
        return selectedEvenOrOdd;
    }
    public int numberBet(){
        Scanner intScan = new Scanner(System.in);
        System.out.println("Select number:");
        int selectedNumber = intScan.nextInt();
        if (selectedNumber > 36 || selectedNumber < 0) {
            System.out.println("Вы указали не верное числобвведите еще раз");
            numberBet();
        }else{
            getBetOnTheNumber();
        }
        return selectedNumber;
    }
    public String colorBet(){
        Scanner strScan = new Scanner(System.in);
        System.out.println("Select color:");
        String selectedColor = strScan.nextLine();
        if (selectedColor.equals("black")|| selectedColor.equals("red")) {
            getBetOnTheColor();
        } else {
            System.out.println("Вы указали не верный цвет попробуйте еще раз еще раз");
            colorBet();
        }
        return selectedColor;
    }
    public void getBetOnEvenOdd(){
        Scanner EOBScan = new Scanner(System.in);
        System.out.println("Select bet on even or odd:");
        betOnEvenOdd = EOBScan.nextInt();
        if(betOnEvenOdd>balance){
            System.out.println("You don't have enogth ");
            getBetOnEvenOdd();
        }
    }
    public void getBetOnTheNumber(){
        Scanner NScan = new Scanner(System.in);
        System.out.println("Select bet on Number:");
        betOnTheNumber = NScan.nextInt();
        if(betOnTheNumber>balance){
            System.out.println("You don't have enogth ");
            getBetOnTheNumber();
    }
}
    public void getBetOnTheColor(){
        Scanner CScan = new Scanner(System.in);
        System.out.println("Select bet on Color:");
        betOnTheColor = CScan.nextInt();
        if(betOnTheColor>balance){
            System.out.println("You don't have enogth ");
            getBetOnTheColor();
        }
    }
//    public void CheckOutPutTest(){
//        System.out.println(allFlields[resultNumber]);
//    }
//    public void CheckEvenOddTest(){
//
//        String evenOdd;
//        if(Integer.parseInt(allFlields[resultNumber])%2 == 0){
//            evenOdd = "even";
//        }
//        else{
//            evenOdd = "odd";
//        }
//        System.out.println(evenOdd);
//    }

}
