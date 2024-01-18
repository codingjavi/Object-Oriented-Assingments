public class TestLine {
    public static void main(String[] args) {
        Line purple = new Line(1.35, 4.87, 2.56, 10.11, Color.PURPLE);

        Line pink = new Line(3.48, 9.12, 12.32, 18.32, Color.PINK);

        Line orange = new Line(2.54, 7.68, 9.14, 20.35, Color.ORANGE);

        Line magenta = new Line(5.38, 13.84, 17.38, 46.29, Color.MAGENTA);


        System.out.println(purple.toString() + " has length " + purple.Lenght());

        System.out.println(pink.toString() + " has length " + pink.Lenght());

        System.out.println(orange.toString() + " has length " + orange.Lenght());

        System.out.println(magenta.toString() + " has length " + magenta.Lenght());



    }
}
