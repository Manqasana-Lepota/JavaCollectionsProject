import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Collections {

    /*Creating object of a class Logger*/
    private static Logger logger = LogManager.getLogger(Collections.class.getName());

    public static void main(String[] args) throws Exception {
        /* declaring and assigning*/
        int highestUniqueNumber = 0;

        try {
            /* calling method*/
            maxUniqueNumber(highestUniqueNumber);

        } catch (InputMismatchException ex) {
            logger.error("Error occurred : " + ex);
        }

    }//end of main method


    public static void maxUniqueNumber(int highestUniqueNumber) throws Exception {

        /*declaring and assigning variables*/
        int numberArray, subArraySize, numberElements, currentNumber;
        char repeat = 0;
        String input;

        /*Creating the object of class Scanner,HashMap and interface Deque*/
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();

        /*
         prompt the user to enter the numberArray and subArraySize
         read the input numbers numberArray and subArraySize
         */
        System.out.println("Please enter integer number : ");
        numberArray = scanner.nextInt();

        System.out.println("Please enter your sub-array size : ");
        subArraySize = scanner.nextInt();

        /*assigning highest unique number*/
        highestUniqueNumber = map.size();

        /*Prompting the user to enter the elements in a deque*/
        System.out.println("Please add the elements in a deque : ");

        /*for loop*/
        for (int count = 0; count < numberArray; count++) {
            /*Removing currentNumber in a deque*/
            if (count >= subArraySize) {
                currentNumber = deque.remove();
                if (map.get(currentNumber) == 1) {
                    map.remove(currentNumber);
                } else {
                    map.put(currentNumber, map.get(currentNumber) - 1);
                }
            }
            /*Prompting the user to enter the elements in a deque and count the element*/
            System.out.println("Element " + (count + 1) + " :");

            /*read the input numbers*/
            numberElements = scanner.nextInt();

            /*Adding elements to the deque*/
            deque.add(numberElements);

            /*Add a new value*/
            map.merge(numberElements, 1, Integer::sum);

            /*assigning and calculating highest unique number*/
            highestUniqueNumber = Math.max(highestUniqueNumber, map.size());
        }
        //displaying using Logger
        logger.debug("Number Array : " + numberArray);
        logger.debug("SubArray size : " + subArraySize);
        logger.debug("Elements in a deque : " + deque);
        logger.debug("Highest unique number : " + highestUniqueNumber);

    }//end method maxUniqueNumber

}//end class






