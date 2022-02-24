class User:
    def people(self, first_name, last_name):
        self.first_name = first_name
        self.last_name = last_name

    def describe_user(self):
        print("The first name is "+self.first_name.title())
        print("The last name is "+self.last_name.title())

    def greet_user(self):
        print("Good morning"+" "+self.first_name.title() +
              " "+self.last_name.title()+"!")
