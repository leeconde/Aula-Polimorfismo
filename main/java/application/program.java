package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.println("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product # " + i + " data: ");
            System.out.println("Common, used or imported?");
            char type = sc.next().charAt(0);
            System.out.println("Name: ");
            String name = sc.next();
            System.out.println("Price: ");
            Double price = sc.nextDouble();

            switch (type) {
                case 'c':
                    Product p = new Product(name, price);
                    list.add(p);
                    break;
                case 'u':
                    System.out.println("Manufacture date: ");
                    String date = sc.next();
                    UsedProduct up = new UsedProduct(date, name, price);
                    list.add(up);
                    break;
                case 'i':
                    System.out.println("Customs fee: ");
                    Double customsFee = sc.nextDouble();
                    ImportedProduct ip = new ImportedProduct(customsFee, name, price);
                    list.add(ip);
                    break;
                default:
                    throw new IllegalStateException("Invalid type");
            }
        }
        sc.close();

        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product p : list) {
            System.out.println(p.priceTag());
        }

    }

}
