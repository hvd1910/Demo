package com.example.demo;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
public class BaiToanDemo {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập chuỗi: ");
            String input = scanner.nextLine();

            System.out.println("Số lượng chữ cái có dấu: " + countVietnameseCharacters(input));
        }

        public static int countVietnameseCharacters(String input) {
            // Sử dụng Map để tra cứu nhanh các quy tắc Telex
            Map<String, Boolean> telexRules = new HashMap<>();
            telexRules.put("aw", true);
            telexRules.put("aa", true);
            telexRules.put("dd", true);
            telexRules.put("ee", true);
            telexRules.put("oo", true);
            telexRules.put("ow", true);
            telexRules.put("w", true);

            int count = 0;
            int n = input.length();

            for (int i = 0; i < n; i++) {
                // Kiểm tra ký tự đơn ('w' là ký tự có dấu trong Tiếng Việt)
                if (telexRules.containsKey(String.valueOf(input.charAt(i)))) {
                    count++;
                }
                // Kiểm tra cặp ký tự (chỉ có 2 ký tự liên tiếp)
                if (i < n - 1 && telexRules.containsKey(input.substring(i, i + 2))) {
                    count++;
                    i++; // Bỏ qua ký tự tiếp theo vì đã xử lý cặp ký tự
                }
            }

            return count;
        }


}
