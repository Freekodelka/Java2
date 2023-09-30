import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчество датарождения номертелефона пол");
        String input = scanner.nextLine();
        String[] data = input.split(" ");
        if (data.length != 6) {
            System.out.println("Ошибка: неверное количество данных");
            return;
        }
        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];
        String dateOfBirth = data[3];
        String phoneNumber = data[4];
        String gender = data[5];
        if (!gender.equals("f") && !gender.equals("m")) {
            System.out.println("Ошибка: неверный формат пола");
            return;
        }
        try {
            File file = new File(surname + ".txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(surname + name + patronymic + dateOfBirth + " " + phoneNumber + gender + "\n");
            writer.close();
            System.out.println("Данные успешно записаны в файл " + surname + ".txt");
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
