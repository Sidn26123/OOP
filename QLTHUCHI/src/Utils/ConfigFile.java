package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConfigFile {
    public String getDB() {
        // String filePath = "src\\Utils\\config.txt"; // Đặt đường dẫn đến file của bạn

        // try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        //     String line;
        //     while ((line = br.readLine()) != null) {
        //         String[] parts = line.split(":"); // Tách dòng thành cặp "attr" và "value"
        //         System.out.println(parts[0] + " " + parts[1]);
        //         if (parts.length == 2) {
        //             String attr = parts[0].trim();
        //             String value = parts[1].trim();
        //             if (attr ==  "DB"){
        //                 System.out.println(value +  "a");
        //                 return value;
        //             }
        //         } else {
        //             // Xử lý trường hợp dòng không hợp lệ (nếu có)
        //             System.out.println("Invalid line: " + line);
        //         }
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // return "";
        return "MySQL";
    }
}
