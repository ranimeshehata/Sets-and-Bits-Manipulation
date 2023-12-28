import java.util.Scanner;

interface Part1 {
    int getBit(int number, int position);

    int setBit(int number, int position);

    int clearBit(int number, int position);
    int updateBit(int number, int position, int value);
}

public class BasicBitOperations implements Part1{

    public int getBit(int number, int position){
        return (number >> position)&1;
    }
    public int setBit(int number, int position)
    {
        number |= (1 << position);
        return number;
    }

    public int clearBit(int number, int position)
    {
        number &= ~(1 << position);
        return number;
    }

    public int updateBit(int number, int position, int value)
    {
        if(value == 1)
            return setBit(number , position);
        else
            return clearBit(number , position);
    }

    public static void main(String[] args) {
        BasicBitOperations program = new BasicBitOperations();
        Scanner input = new Scanner(System.in);
        System.out.println("Choose one of the following operations:\n1) getBit.\n2) setBit.\n3) clear Bit.\n4) updateBit.\n5) Exit");
        int function = input.nextInt();
        while (function < 5 && function > 0) {
        System.out.print("Enter number: ");
        int number = input.nextInt();
        System.out.print("Enter position: ");
        int position = input.nextInt();
        int answer = 0;
            switch (function) {
                case 1:
                    answer = program.getBit(number, position);
                    break;
                case 2:
                    answer = program.setBit(number, position);
                    break;
                case 3:
                    answer = program.clearBit(number, position);
                    break;
                case 4:
                    System.out.print("Enter value: ");
                    int value = input.nextInt();
                    answer = program.updateBit(number, position, value);
                    break;
            }
            System.out.println("Answer = " + answer);
            System.out.println("Choose one of the following operations:\n1) getBit.\n2) setBit.\n3) clear Bit.\n4) updateBit.\n5) Exit");
            function = input.nextInt();
        }
    }
}












