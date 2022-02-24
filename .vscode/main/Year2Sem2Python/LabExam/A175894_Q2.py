mylist = []
summation = 0


def sum_digits(n):
    s = 0
    while n:
        s += n % 10
        n //= 10
    return s


def letter(string):
    return string.replace(" ", "")


dict = {'a': 1,
        'b': 2,
        'c': 3,
        'd': 4,
        'e': 5,
        'f': 6,
        'g': 7,
        'h': 8,
        'i': 9,
        'j': 1,
        'k': 2,
        'l': 3,
        'm': 4,
        'n': 5,
        'o': 5,
        'p': 6,
        'q': 8,
        'r': 9,
        's': 1,
        't': 2,
        'u': 3,
        'v': 4,
        'w': 5,
        'x': 6,
        'y': 7,
        'z': 8,
        }

print("Your numerology of the name is " +
      str((int(sum([dict[x] for l in input("Type your name:").upper() if l in dict.keys()])) % 9) or 9))
