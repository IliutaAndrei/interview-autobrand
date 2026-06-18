package org.iliuta;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //System.out.println(firstProblem(9));
        //System.out.println(Arrays.toString(fifthProblem(new int[]{1,5,3,7}, 8)));
        //System.out.println(sixthProblem("aabb"));
        //System.out.println(thirdProblem(6));
        //System.out.println(tenProblem(new int[] {5}));
        //System.out.println(eightProblem("abcd"));
        fourthProblem("aabb");
    }

    public static void fourthProblem(String str) {
        StringBuilder result = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();

        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            char next = 0;
            if (i + 1 < str.length()) {
                next = str.charAt(i + 1);
            }
            if (current == next) {
                count++;
            } else {
                int length = count;
                String character = String.valueOf(current);
                if (map.containsKey(character)) {
                    int actualLength = map.get(character);
                    if (actualLength < length) {
                        map.put(character, length);
                    }
                } else {
                    map.put(character, length);
                }

                count = 1;
            }
        }
        int max = 0;
        for (String s : map.keySet()) {
            if (map.get(s) > max) {
                max = map.get(s);
            }
        }

        System.out.println(max);
    }

    public static boolean secondProblem(int number) {
        String str = String.valueOf(number);

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == c && i != j) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int thirdProblem(int num) {
        int result = sumOfDigits(num);
        while (result > 10) {
            result = sumOfDigits(result);
        }
        return result;
    }

    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static int[] fifthProblem(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff) && i != map.get(diff)) {
                return new int[] {i, map.get(diff)};
            }
        }

        return new int[] {};
    }

    public static char sixthProblem(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0 ) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '0';
    }

    public static int tenProblem(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public static String eightProblem(String str) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
           char current = str.charAt(i);
           char next = 0;
           if (i + 1 < str.length()) {
               next = str.charAt(i + 1);
           }
           if (current == next) {
               count++;
           } else {
               result.append(current).append(count);
               count = 1;
           }

        }

        return result.toString().length() < str.length() ? result.toString() : str;
    }



}


