public class Program {

    public static void main(String[] args) {
        Frame frame = new Frame("Login",
                new HorizontalLayout(
                        new VerticalLayout(
                                new Rectangle(new Text("User")),
                                new Rectangle(new Text("Password")),
                                new HorizontalLayout(
                                        new Rectangle(new Text("Ok")),
                                        new Rectangle(new Text("Cancel"))
                                )
                        ),
                        new Frame("Help",
                                new VerticalLayout(
                                        new Text("Please enter login"),
                                        new Text("  and password"),
                                        new Text("Then press Ok button")
                                )
                        )
                )
        );
        char[][] result = frame.calculate();
        print(result);
    }

    static void print(char[][] array) {
        if (array == null) {
            System.out.println("имя рамки длиннее её содержимого");
            return;
        }
        for (char[] chars : array) {
            for (char aChar : chars) {
                System.out.print(aChar);
                if (aChar == '\u0000') System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
