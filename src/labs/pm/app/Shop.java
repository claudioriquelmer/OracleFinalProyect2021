/*
 * Copyright (C) 2021 ClaudioNicolas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package labs.pm.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Locale;
import labs.pm.data.Drink;
import labs.pm.data.Food;
import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

/**
 * {@code Shop} class represents an application that manages Products
 *
 * @version 4.0
 * @author ClaudioNicolas
 */
public class Shop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProductManager pm = new ProductManager("en-GB");

        pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
//        pm.printProductReport(101);

        pm.reviewProduct(101, Rating.FOUR_STAR, "Nice hot cup of Tea");
        pm.reviewProduct(101, Rating.TWO_STAR, "Rather weak Tea");
        pm.reviewProduct(101, Rating.FOUR_STAR, "Fine Tea");
        pm.reviewProduct(101, Rating.FOUR_STAR, "Good Tea");
        pm.reviewProduct(101, Rating.FOUR_STAR, "Just add some lemon");
//       pm.printProductReport(101);

//       pm.changeLocale("es-CL");
        pm.createProduct(102, "Coffee", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        pm.reviewProduct(102, Rating.THREE_STAR, "Coffee was OK");
        pm.reviewProduct(102, Rating.ONE_STAR, "Where is the Milk?!");
        pm.reviewProduct(102, Rating.FIVE_STAR, "Is perfect with ten spoons of sugar!");
//        pm.printProductReport(102);

        pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.NOT_RATED, LocalDate.now().plusDays(2));
        pm.reviewProduct(103, Rating.FIVE_STAR, "Very nice Cake");
        pm.reviewProduct(103, Rating.FOUR_STAR, "It Good, But I´ve expected more chocolate");
        pm.reviewProduct(103, Rating.FIVE_STAR, "This Cake is Perfect!");
//       pm.printProductReport(103);

        Product p4 = pm.createProduct(104, "Cookie", BigDecimal.valueOf(2.99), Rating.NOT_RATED, LocalDate.now());
        p4 = pm.reviewProduct(p4, Rating.THREE_STAR, "Just another cookie");
        p4 = pm.reviewProduct(p4, Rating.THREE_STAR, "Ok");
//       pm.printProductReport(p4);

        Comparator<Product> ratingSorter = (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
        Comparator<Product> priceSorter = (p1, p2) -> p2.getPrice().compareTo(p1.getPrice());
        pm.printProducts(ratingSorter.thenComparing(priceSorter));
        pm.printProducts(priceSorter.thenComparing(priceSorter).reversed());

        /*      Product p2 = pm.createProduct(102, "Coffee", BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
        Product p3 = pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        Product p4 = pm.createProduct(105, "Cookie", BigDecimal.valueOf(3.99), Rating.TWO_STAR, LocalDate.now());
        Product p5 = p3.applyRating(Rating.THREE_STAR);
        Product p6 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR);
        Product p7 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        Product p8 = p4.applyRating(Rating.FIVE_STAR);
        Product p9 = p1.applyRating(Rating.TWO_STAR);
        
        //System.out.println(p6.equals(p7));
        //System.out.println(p3.getBestBefore());
        //System.out.println(p1.getBestBefore());
        
        //       p1.setId(101);
        //       p1.setName("Tea");
        //       p1.setPrice(BigDecimal.valueOf(1.99));

//        System.out.println(p1.getId() + " " + p1.getName() + " " + p1.getPrice() + " " + p1.getDiscount() + " " + p1.getRating().getStars());
//        System.out.println(p2.getId() + " " + p2.getName() + " " + p2.getPrice() + " " + p2.getDiscount() + " " + p2.getRating().getStars());
//        System.out.println(p3.getId() + " " + p3.getName() + " " + p3.getPrice() + " " + p3.getDiscount() + " " + p3.getRating().getStars());
//        System.out.println(p4.getId() + " " + p4.getName() + " " + p4.getPrice() + " " + p4.getDiscount() + " " + p4.getRating().getStars());
//        System.out.println(p5.getId() + " " + p5.getName() + " " + p5.getPrice() + " " + p5.getDiscount() + " " + p5.getRating().getStars());
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
        System.out.println(p7);
        System.out.println(p8);
        System.out.println(p9);
         */
    }

}
