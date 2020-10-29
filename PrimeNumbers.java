import java.util.ArrayList;

public class PrimeNumbers {

    public static ArrayList<Integer> getPrimeNumbersUntil(int target) {
        /**
         * Implements the Sieve of Eratosthenes algorithm to find prime numbers
         *  up till user specified target value
         * 
         * @param  target is an integer > 1
         * @return ArrayList<Integer> containing all prime numbers up till target 
         *          (including target if it is a prime number)
         */

        //Not an in-place algorithm
        ArrayList<Integer> numList = new ArrayList<Integer>();

        //Create a list of size target
        //List starts at 0 because index values will match stored values
        //  making it easier to run this algorithm
        for (int num = 0; num < target + 1; num++) {
            numList.add(num);
        }

        //Start at 2 because we will later scrap off the first 2 values
        for (int index = 2; index < Math.sqrt(target) + 1; index++) {
            
            //If index value is 0, then its multiples have already
            //  been counted and made 0
            if (numList.get(index) != 0) {
                int not_prime_index = index * index;

                //Do this till target index is reached
                while (not_prime_index <= target) {
                    numList.set(not_prime_index, 0);
                    not_prime_index += index;
                }
            }
        }

        ArrayList<Integer> primeList = new ArrayList<Integer>();

        //First two elements are scrapped off
        for (int prime = 2; prime < target + 1; prime++) {
            
            //Copy over all elements that are not 0
            if (numList.get(prime) != 0) {
                primeList.add(numList.get(prime));
            }
        }

        return primeList;
    }

    public static void main(String [] args) {
        int target = 25;
        System.out.println(getPrimeNumbersUntil(target));
    }
}