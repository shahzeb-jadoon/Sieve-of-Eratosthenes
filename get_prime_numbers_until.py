from math import sqrt

def get_prime_numbers_until(target):
    """Implements the Sieve of Eratosthenes algorithm to find prime numbers
        up till user specified target value

       pre: target is an integer > 1
       post: Returns list of all prime numbers up till target (including target if it 
             is a prime number)
       """

    #Not an in-place algorithm
    #Create a list of size target
    #List starts at 0 because index values will match stored values
    #   making it easier to run this algorithm
    a_lst = [num for num in range(target + 1)]

    #Start at 2 because we will later scrap off the first 2 values
    for index in range(2, int(sqrt(target)) + 1):

        #If index value is 0, then its multiples have already
        #   been counted and made 0
        if a_lst[index] != 0:
            not_prime_index = index * index

            #Do this till target index is reached
            while not_prime_index <= target:
                a_lst[not_prime_index] = 0
                not_prime_index += index
    
    prime_lst = []

    #First 2 elements are scrapped off
    for prime in range(2, target + 1):

        #Copy over all elements that are not 0
        if a_lst[prime] != 0:
            prime_lst.append(a_lst[prime])

    return prime_lst


def main():
        target = 25
        print(get_prime_numbers_until(target))


if __name__ == '__main__':
    main()