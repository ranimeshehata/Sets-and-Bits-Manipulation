import java.util.*;
public class SetOperations {
    public static int getBit(int number, int position) {
        return (number >> position) & 1;
    }

    public static int setBit(int number, int position) {
        number |= (1 << position);
        return number;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter elements of the Universe: ");
        String U = input.nextLine().replaceAll("[{}]", "");
        String[] s = U.split(", ");
        String[] arr = new String[s.length];
        List<String> universe = new ArrayList<>();

        System.arraycopy(s, 0, arr, 0, s.length);
        for (int i = 0; i < s.length; i++) {
            universe.add(String.valueOf(arr[i]));
        }
        System.out.print("Enter number of subsets: ");
        int nSubsets = input.nextInt();
        int[] subsetsIndex = new int[nSubsets];
        Arrays.fill(subsetsIndex, 0);
        for (int i = 0; i < nSubsets; i++) {
            System.out.print("Enter size of subset: " + (i + 1) + " ");
            int n = input.nextInt();
            System.out.print("Enter elements of subset: " + (i + 1) + " : ");
            int number = 0;
            int counter;
            for (int j = 0; j < n; j++) {
                String element = input.next();
                counter = 0;
                for (int k = 0; k < s.length; k++) {
                    if (!Objects.equals(element, universe.get(k)))
                        counter++;
                }
                if (counter != s.length) {
                    number = setBit(number, universe.indexOf(element));

                } else {
                    System.out.println("Element not found in U. Please, enter a valid one!");
                    j--;
                }
            }
            subsetsIndex[i] = number;
        }
        System.out.println("Which operation do you want to perform?\n1) Union of two sets.\n2) Intersection of two sets.\n3) Complement of a set.\n4) Difference between two sets.\n5) Cardinality of a set.\n6) Print a set.\n7) Add string to the set.\n8) Exit.");
        int operation = input.nextInt();
        int s1;
        int s2;
        while (operation < 8 && operation > 0) {
            switch (operation) {
                case 1:
                    System.out.println("Enter the order of TWO sets where the order of the UNIVERSAL set is ZERO : ");
                    s1 = input.nextInt();
                    s2 = input.nextInt();
                    if (s1 > subsetsIndex.length || s2 > subsetsIndex.length)
                        System.out.print("Operation invalid!");
                    else if (s1 == 0 || s2 == 0) {
                        for (int i = 0; i < s.length; i++)
                            System.out.print(universe.get(i) + " ");
                    } else {
                        int answer = subsetsIndex[s1 - 1] | subsetsIndex[s2 - 1];
                        for (int i = 0; i < s.length; i++) {
                            if (getBit(answer, i) == 1) {
                                System.out.print(universe.get(i) + " ");
                            }
                        }
                    }
                    System.out.print("\n");
                    break;

                case 2:
                    System.out.println("Enter the order of TWO sets where the order of the UNIVERSAL set is ZERO : ");
                    s1 = input.nextInt();
                    s2 = input.nextInt();
                    if (s1 > subsetsIndex.length || s2 > subsetsIndex.length)
                        System.out.print("Operation invalid!");
                    else if (s1 == 0 && s2 != 0) {
                        int answer = subsetsIndex[s2 - 1];
                        for (int i = 0; i < subsetsIndex[s2 - 1]; i++)
                            if (getBit(answer, i) == 1) {
                                System.out.print(universe.get(i) + " ");
                            }
                    } else if (s1 != 0 && s2 == 0) {
                        int answer = subsetsIndex[s1 - 1];
                        for (int i = 0; i < subsetsIndex[s1 - 1]; i++)
                            if (getBit(answer, i) == 1) {
                                System.out.print(universe.get(i) + " ");
                            }
                    } else if (s1 == 0) {
                        for (int i = 0; i < s.length; i++)
                            System.out.print(universe.get(i) + " ");
                    } else {
                        int answer = subsetsIndex[s1 - 1] & subsetsIndex[s2 - 1];
                        if (answer == 0)
                            System.out.print("No intersection!");
                        for (int i = 0; i < s.length; i++) {
                            if (getBit(answer, i) == 1)
                                System.out.print(universe.get(i) + " ");
                        }
                    }
                    System.out.print("\n");
                    break;

                case 3:
                    System.out.println("Enter the order of set where the order of the UNIVERSAL set is ZERO : ");
                    s1 = input.nextInt();
                    if (s1 > subsetsIndex.length)
                        System.out.print("Operation invalid!");
                    else if (s1 != 0) {
                        int answer = ~subsetsIndex[s1 - 1];
                        for (int i = 0; i < s.length; i++) {
                            if (getBit(answer, i) == 1)
                                System.out.print(universe.get(i) + " ");
                        }
                    } else
                        System.out.print("NULL");
                    System.out.print("\n");
                    break;

                case 4:
                    System.out.println("Enter the order of TWO sets where the order of the UNIVERSAL set is ZERO : ");
                    s1 = input.nextInt();
                    s2 = input.nextInt();
                    if (s1 > subsetsIndex.length || s2 > subsetsIndex.length)
                        System.out.print("Operation invalid!");
                    else if (s2 == 0)
                        System.out.print("NULL");
                    else if (s1 == 0) {
                        int answer = ~ subsetsIndex[s2-1];
                        for (int i = 0; i < s.length; i++) {
                            if (getBit(answer, i) == 1) {
                                System.out.print(universe.get(i) + " ");
                            }
                        }

                    } else {
                        int answer = subsetsIndex[s1 - 1] & ~subsetsIndex[s2 - 1];
                        for (int i = 0; i < s.length; i++) {
                            if (getBit(answer, i) == 1) {
                                System.out.print(universe.get(i) + " ");
                            }
                        }
                    }
                    System.out.print("\n");
                    break;

                case 5:
                    System.out.println("Enter the order of set where the order of the UNIVERSAL set is ZERO : ");
                    s1 = input.nextInt();
                    if (s1 > subsetsIndex.length)
                        System.out.print("Operation invalid!");
                    else if (s1 == 0)
                        System.out.print("Cardinality = " + s.length);
                    else {
                        int answer = subsetsIndex[s1 - 1];
                        int count = 0;
                        for (int i = 0; i < s.length; i++) {
                            if (getBit(answer, i) == 1)
                                count++;
                        }
                        System.out.print("Cardinality = " + count);
                    }
                    System.out.print("\n");
                    break;

                case 6:
                    System.out.println("Enter the order of set where the order of the UNIVERSAL set is ZERO : ");
                    s1 = input.nextInt();
                    if (s1 > subsetsIndex.length)
                        System.out.print("Operation invalid!");
                    else if (s1 == 0) {
                        System.out.print("{ ");
                        for (int i = 0; i < s.length-1; i++) {
                            System.out.print(universe.get(i) + ", ");
                        }
                        System.out.print(universe.get(s.length-1) + " }");
                    } else {
                        int answer = subsetsIndex[s1 - 1];
                        System.out.print("{ ");
                        for (int i = 0; i < s.length-1; i++) {
                            if (getBit(answer, i) == 1) {
                                System.out.print(universe.get(i) + " ");
                            }
                        }
                        if (getBit(answer, s.length-1) == 1)
                            System.out.print(universe.get(s.length-1));
                        System.out.print(" }");
                    }
                    System.out.print("\n");
                    break;

                case 7:
                   System.out.print("Enter the number of element(s) you want to add --> ");
                    int newSize = input.nextInt();
                    System.out.print("Enter the element(s) you want to add to the Universal --> ");
                    String[] newArray = new String[newSize];

                    for (int i = 0; i<newSize; i++){
                        newArray[i] = input.next();
                    }
                    for (int i = 0; i < newSize; i++) {
                        universe.add(newArray[i]);
                    }
                    newSize += s.length;
                    System.out.print("The new U is: ");
                    System.out.print("{");
                    for (int i = 0; i < newSize-1; i++) {
                        System.out.print(universe.get(i) + ", ");
                    }
                    System.out.print(universe.get(newSize-1) + " }");
                    System.out.print("\n");
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + operation);
            }
            System.out.println("*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
            System.out.println("Which operation do you want to perform?\n1) Union of two sets.\n2) Intersection of two sets.\n3) Complement of a set.\n4) Difference between two sets.\n5) Cardinality of a set.\n6) Print a set.\n7) Add string to the set.\n8) Exit.");
            operation = input.nextInt();


            }
        }
    }
