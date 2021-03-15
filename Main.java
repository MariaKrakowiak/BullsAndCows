package bullscows;

import java.security.SecureRandom;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input the length of the secret code:");
        Scanner sca = new Scanner(System.in);

        String size1 = sca.nextLine();
        if (size1.equals("0")) {
            System.out.println("Error: the length of the secret code can not be 0.");
            System.exit(0);
        }
        if (!size1.matches("[0-9]{1,}")) {
            System.out.println("Error: " + '"' + size1 + '"' + " isn't a valid number.");
            System.exit(0);
        } else {


            int size = Integer.parseInt(size1);

            System.out.println("Input the number of possible symbols in the code:");
            int symbol = sca.nextInt();
            if (symbol < size) {
                System.out.println("Error: it's not possible to generate a code with a length of " + size + " with " + symbol + " unique symbols.");
                System.exit(0);
            }

            if (symbol > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                System.exit(0);
            }

            if (size <= 10 && symbol <= 10) {
                String st = "*";
                System.out.println("The secret is prepared: " + st.repeat(size) + " (0-9).");
                System.out.println("Okay, let's start a game!");
                boolean choose = false;
                int i = 1;
                LinkedList<Integer> l = new LinkedList<>();
                int k;
                int j = 0;
                while (j < size && size <= 10) {
                    Random generator = new Random();
                    k = generator.nextInt(10);
                    if (!l.contains(k)) {
                        l.add(k);
                        j++;
                    } else {
                        continue;
                    }


                }
                String s = l.toString();
                String s1 = s.replace(" ", "");
                String s2 = s1.replace(",", "");
                String s3 = s2.replaceAll("[\\[\\]]", "");

                while (!choose) {
                    System.out.println("Turn " + i + ":");
                    Scanner scan = new Scanner(System.in);
                    String guess = scan.nextLine();


                    int bulls = 0;
                    int cows = 0;
                    int[] arr1 = new int[10];
                    int[] arr2 = new int[10];
                    for (int m = 0; m < s3.length(); m++) {
                        char c1 = s3.charAt(m);
                        char c2 = guess.charAt(m);

                        if (c1 == c2)
                            bulls++;
                        else {
                            arr1[c1 - '0']++;
                            arr2[c2 - '0']++;
                        }
                    }

                    for (int n = 0; n < 10; n++) {
                        cows += Math.min(arr1[n], arr2[n]);
                    }

                    System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s)");

                    i++;

                    if (bulls == size && cows == 0) {
                        choose = true;
                        System.out.println("Congratulations! You guessed the secret code.");
                        System.exit(0);
                    }
                }

            }
            if (size <= 36 && symbol >= 10) {

                String CHAR = "abcdefghijklmnopqrstuvwxyz";
                String NUMBER = "0123456789";
                String ALL = NUMBER + CHAR;
                String st = "*";
                String all = ALL.substring(0, symbol);
                String letters = "[a-z]";
                String digits = "[0-9]";
                String[] split1 = all.split(letters);
                String[] split2 = all.split(digits);
                String s4 = Arrays.toString(split2);
                String s5 = s4.replace(" ", "");
                String s6 = s5.replace(",", "");
                String s7 = s6.replaceAll("[\\[\\]]", "");
                String s8 = Arrays.toString(split1);
                String s9 = s8.replace(" ", "");
                String s10 = s9.replace(",", "");
                String s11 = s10.replaceAll("[\\[\\]]", "");

                char firstLetter = s7.charAt(0);
                char lastLetter = s7.charAt(s7.length() - 1);
                char firstDigit = s11.charAt(0);
                char lastDigit = s11.charAt(s11.length() - 1);

                String range = "(" + firstDigit + "-" + lastDigit + ", " + firstLetter + "-" + lastLetter + ").";

                System.out.println("The secret is prepared: " + st.repeat(size) + " " + range);
                System.out.println("Okay, let's start a game!");
                boolean choose = false;
                int i = 1;
                LinkedList<Integer> l = new LinkedList<>();
                int k;

                SecureRandom random = new SecureRandom();
                StringBuilder sb = new StringBuilder(size);
                for (int j = 0; j < size; j++) {
                    int rndCharAt = random.nextInt(ALL.length());
                    char rndChar = ALL.charAt(rndCharAt);

                    sb.append(rndChar);
                }

                String s = l.toString();
                String s1 = s.replace(" ", "");
                String s2 = s1.replace(",", "");
                String s3 = s2.replaceAll("[\\[\\]]", "");


                while (!choose) {
                    System.out.println("Turn " + i + ":");
                    Scanner scan = new Scanner(System.in);
                    String guess = scan.nextLine();


                    int bulls = 0;
                    int cows = 0;
                    int[] arr1 = new int[144];
                    int[] arr2 = new int[144];

                    for (int m = 0; m < sb.length(); m++) {
                        char c1 = sb.charAt(m);
                        char c2 = guess.charAt(m);

                        if (c1 == c2)
                            bulls++;
                        else {
                            arr1[c1]++;
                            arr2[c2]++;
                        }
                    }

                    for (int n = 0; n < sb.length(); n++) {
                        cows += Math.min(arr1[n], arr2[n]);
                    }

                    System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s)");

                    i++;

                    if (bulls == size && cows == 0) {
                        choose = true;
                        System.out.println("Congratulations! You guessed the secret code.");
                        System.exit(0);
                    }
                }


            }

        }
    }

}