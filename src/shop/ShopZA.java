package shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShopZA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] products = {"Молоко", "Хлеб", "Гречневая крупа"};
        double[] prices = {50, 14, 80};
        Map<String, Integer> basket = new HashMap<>();

        while (true) {
            System.out.println("Выберите товар и количество или введите \"end\":");
            String input = sc.nextLine();
            if (input.equals("end")) {
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("Некорректный ввод. Попробуйте еще раз.");
                continue;
            }
            try {
                int productIndex = Integer.parseInt(parts[0]) - 1;
                int quantity = Integer.parseInt(parts[1]);
                if (productIndex < 0 || productIndex >= products.length || quantity <= 0) {
                    System.out.println("Некорректный ввод. Попробуйте еще раз.");
                    continue;
                }
                String productName = products[productIndex];
                basket.put(productName, basket.getOrDefault(productName, 0) + quantity);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        }
        
        sc.close();
        

        System.out.println("Ваша корзина:");
        double total = 0;
        for (String productName : basket.keySet()) {
            int quantity = basket.get(productName);
            int productIndex = findProductIndex(productName, products);
            double price = prices[productIndex];
            double subtotal = quantity * price;
            total += subtotal;
            System.out.println(productName + " " + quantity + " шт " + price + " руб/шт " + subtotal + " руб в сумме");
        }
        System.out.println("Итого " + total + " руб");
        
    }

    private static int findProductIndex(String productName, String[] products) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].equals(productName)) {
                return i;
            }
        }
        return -1;
    }
}

