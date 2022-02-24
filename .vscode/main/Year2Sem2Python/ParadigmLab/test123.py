# Python 3 implementation of the approach

# Recursive function to print the
# desired numbers
def printNumbers(N):

    # Bool variable to track whether each digit
    # of the number fulfills the given condition
    flag = 1

    # Creating a copy of the number
    x = N

    # Checking if the number has a
    # positive value
    if (N > 0):

        # Loop to iterate through digits
        # of the number until every digit
        # fulfills the given condition
        while (x > 0 and flag == 1):

            # Get last digit
            digit = x % 10

            # Updating value of flag to be 0 if
            # the digit is neither 1 nor 3
            if (digit != 1 or digit != 3):
                flag = 0

            # Eliminate last digit
            x = x // 10

        # If N consists of digits 1 or 3 only
        if (flag == 1):
            print(N, end=" ")

        # Recursive call for the next number
        printNumbers(N - 1)


# Driver code
if __name__ == '__main__':
    N = 40
    printNumbers(N)

# This code is contributed by
# Surendra_Gangwar
