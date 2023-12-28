import java.util.Scanner;

interface Part3{
    int singleOccurence(int[] array);
    int numberOnes(int number);
}

public class Applications implements Part3{

    public int singleOccurence(int[] array){
        int element = array[0];
        for (int i = 1; i < array.length; i++)
            element = element ^ array[i];
        return element;
    }

    public boolean found(int[] array, int number){
        for (int i=0; i< array.length; i++)
            if(number == array[i])
                return true;
        return false;
    }
    public void doubleOccurence(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = (sum ^ array[i]);
        }
        sum = (sum & -sum);
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & sum) > 0) {
                sum1 = (sum1 ^ array[i]);
            }
            else {
                sum2 = (sum2 ^ array[i]);
            }
        }
        System.out.println("There are two unique numbers: " + sum1 + " and " + sum2);
    }
    public int numberOnes(int number){
        int count = 0;
        while(number != 0)
        {
            if((number & 1) == 1)
                count++;
            number >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Applications program = new Applications();
        Scanner input = new Scanner(System.in);
        System.out.println("Choose one of the following operations:\n1) The single occurence in an array.\n2) Number of 1s.\n3)Exit.");
        int function = input.nextInt();
        while (function < 3 && function > 0){
            int answer = 0;
            switch (function){
                case 1:
                    System.out.print("Enter array size: ");
                    int size = input.nextInt();
                    System.out.print("Enter array elements: ");
                    int[] array = new int[size];
                    for (int i=0; i<size; i++)
                        array[i] = input.nextInt();
                    answer = program.singleOccurence(array);
                    if (program.found(array, answer))
                        System.out.println("The unique number is: " + answer);
                    else {
                        program.doubleOccurence(array);
                    }
                    break;
                case 2:
                    System.out.print("Enter number: ");
                    int number = input.nextInt();
                    answer = program.numberOnes(number);
                    System.out.println("Answer = " + answer);
                    break;
            }
            System.out.println("Choose one of the following operations:\n1) The single occurence in an array.\n2) Number of 1s.\n3)Exit.");
            function = input.nextInt();
        }
    }
}
