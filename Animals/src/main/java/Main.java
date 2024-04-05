import controller.UserInterface;
import model.AnimalType;

public class Main {
    private static final String TITLE = "Реестр домашних животных";

    public static void main(String[] args) {
        System.out.println(TITLE);
        new UserInterface().process();
    }


}
