import turtle  # import turtle
t = turtle.Turtle()  # initiate turtle for the whole function that can be used


def make_window():  # function for creating a window
    turtle.Screen()
    turtle.title("Mini Project")
    turtle.screensize(800, 600)
    turtle.bgcolor("light blue")


def make_turtle():  # turtle fucntion
    t.shape = 'arrow'
    t.color = 'black'
    t.pensize = 1


def snow():
    for i in range(0, 5):
        t.fd(100)
        t.backward(50)
        t.left(50)
        t.fd(50)
        t.backward(100)
        t.fd(50)
        t.left(90)
        t.fd(50)
        t.backward(100)
        t.fd(50)
        t.left(50)
        t.fd(50)


if __name__ == '__main__':
    make_window()
    make_turtle()
    snow()
    turtle.mainloop()
