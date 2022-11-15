package bsu.rfe.group9.kondarevich;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {
        final int size = args.length;
        Vector<Food> breakfast = new Vector<Food>();

//        System.out.println(Cocktail.class.getName());
        try {
            for (int i = 0; i < size; ++i) {
                switch (args[i]) {
                    case "Coctail": {
                        try {
                            Cocktail coctail = null;
                            Class clazz = Class.forName(Cocktail.class.getName());
                            Class[] params = {String.class, String.class, String.class};
                            coctail = (Cocktail) clazz.getConstructor(params).newInstance("Coctail", args[++i], args[++i]);
                            //System.out.println(coctail.toString());
                            coctail.consum();
                            breakfast.add(coctail);
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                                 NoSuchMethodException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case "Cheese": {
                        Chees ch = new Chees("Cheese");
                        breakfast.add(ch);
                        ch.consum();
                        break;
                    }
                    case "Apple": {
                        Apple ap = new Apple("Apple", args[++i]);
                        breakfast.add(ap);
                        ap.consum();
                        break;
                    }
                    default: {
                        if (args[i].charAt(0) == '-') {
                            break;
                        }
                        throw new RuntimeException("Class " + args[i] + " not Found");
                    }
                }
            }
        } catch (RuntimeException error){
            System.out.println(error.toString());
        }


        System.out.println("Youre breakfast: ");
        for(Food f : breakfast){
            System.out.println(f.toString());
        }


        System.out.println("Enter Cocteail to Compare: ");

        String drink = console.nextLine();
        String fruit = console.nextLine();
        try {
            Cocktail ToCompear = null;
            Class clazz = Class.forName(Cocktail.class.getName());
            Class[] params = {String.class, String.class, String.class};
            ToCompear = (Cocktail) clazz.getConstructor(params).newInstance("Coctail", drink, fruit);
            Count(breakfast, ToCompear);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        if(IfCalories(args)) {
            System.out.println("Total calories is: " + Calculate(breakfast));
        }

        if(IfSorted(args)) {
            TreeSet<Food> sortBreakfast = new TreeSet<Food>(new Comparator<Food>() {
                @Override
                public int compare(Food i1, Food i2) {
                    if (i1.calculateCalories() > i2.calculateCalories()) {
                        return -1;
                    } else if (i1.calculateCalories() < i2.calculateCalories()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });

            sortBreakfast.addAll(breakfast);

            for(Food f : sortBreakfast){
                System.out.println(f);
            }

        }
    }

    static int Calculate(Vector<Food> breakfast){
        int caloris = 0;
        for(int i = 0; i < breakfast.size(); i++){
            try {
                Method method = breakfast.elementAt(i).getClass().getDeclaredMethod("calculateCalories");
                method.setAccessible(true);
                Object value = method.invoke(breakfast.elementAt(i));
                caloris += (int) value;
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return caloris;
    }

    static void Count(Vector<Food> breakfast, Cocktail ToCompear) {
        int counter = 0;
        for(int i = 0; i < breakfast.size(); i++){
            if(breakfast.elementAt(i).equals(ToCompear)){
                counter++;
            }
        }
        System.out.println("Num of same elements is/are: " + counter);
    }

    static boolean IfCalories(String[] arguments){
        for(String s : arguments){
            if(s.compareTo("-calories") == 0) {
                return true;
            }
        }
        return false;
    }

    static boolean IfSorted(String[] arguments){
        for(String s : arguments){
            if(s.compareTo("-sort") == 0) {
                return true;
            }
        }
        return false;
    }

}