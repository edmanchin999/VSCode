import turtle  # import turtle
t = turtle.Turtle()  # initiate turtle for the whole function that can be used


def make_window():  # function for creating a window
    turtle.Screen()
    turtle.title("Mini Project")
    turtle.screensize(800, 600)
    turtle.bgcolor("grey")
    turtle.colormode(255)


def make_turtle():  # turtle fucntion
    t.shape = 'arrow'
    t.color = 'black'
    t.pensize = 1


def make_triangle():  # make triangle function
    turtle.title("Equilateral Triangle")
    for i in range(3):
        t.fd(100)
        t.right(120)


def make_star():  # make star function
    turtle.title("Star")
    for i in range(5):
        t.fd(150)
        t.right(144)


def make_RainbowStar():
    turtle.title("Rainbow Star")  # make rainbow start function
    t.pencolor("blue")
    t.fd(150)
    t.right(144)
    t.pencolor("red")
    t.fd(150)
    t.right(144)
    t.pencolor("orange")
    t.fd(150)
    t.right(144)
    t.pencolor("yellow")
    t.fd(150)
    t.right(144)
    t.pencolor("green")
    t.fd(150)
    t.right(144)
    t.pencolor("blue")


def make_spiral():  # make spiral function
    turtle.title("Spiral")
    for i in range(100):
        t.fd(7+i)
        t.right(30)


def make_dashSpiral():  # make dash spiral function
    turtle.title("Dash Spiral")
    for i in range(100):
        t.fd(5+i)
        t.right(30)
        t.penup()
        t.fd(5+i)
        t.pendown()


def make_snowFlake():  # function for the whole snowflake
    turtle.title("Snowflake")
    t.pencolor((0, 255, 255))

    def smallsnow(turtle, numberOfangle, length):  # loop for the small snow
        for i in range(0, numberOfangle):
            t.pendown()
            t.forward(length)
            t.penup()
            t.backward(length)
            t.left(360/numberOfangle)

    # recursive function from the small snow gradually change into big snow
    def repeatSmallSnow(turtle, numberOfangle, length, layer, f):

        if layer == 0:
            smallsnow(turtle, numberOfangle, f*4)
        else:
            for k in range(0, numberOfangle):
                t.pendown()
                t.forward(length)
                repeatSmallSnow(turtle, numberOfangle, f*length, layer - 1, f)
                t.penup()
                t.backward(length)
                t.left(360/numberOfangle)
    repeatSmallSnow(turtle, 5, 100, 4, 0.4)  # recursive with constant input


if __name__ == '__main__':  # this is the main function for running the codes
    print("Chin Jian Jie")
    print("A175894")
    print("Python Mini Project")
    make_window()
    make_turtle()
    for i in range(100):
        announcement = "Please select your favourite shape.\n1. Triangle\n2. Star\n3. Rainbow Star\n4. Spiral\n5. Dashed Spiral\n6. Snowflake\n7. Exit\n"
        pattern = input(announcement)
        if(pattern == '1'):
            t.reset()
            make_triangle()
        elif(pattern == '2'):
            t.reset()
            make_star()
        elif(pattern == '3'):
            t.reset()
            make_RainbowStar()
        elif(pattern == '4'):
            t.reset()
            make_spiral()
        elif(pattern == '5'):
            t.reset()
            make_dashSpiral()
        elif(pattern == '6'):
            t.reset()
            make_snowFlake()
        elif(pattern == '7'):
            break
    t.speed('fastest')
    turtle.mainloop()
