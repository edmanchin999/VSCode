#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <string.h>
void makeReservation();
void cancelReservation();
void viewAvailableRooms();

FILE *view;
FILE *enter;
FILE *fp;

struct BonanzaHotel
{
    char name[20];
    char roomID[20];
    char date[20];
    char time[20];
    int numberOfPeople[2];
    char roomType[20];

} hotel;

int main()
{
    int option;

    printf("         *********************************************************** \n");
    printf("                       BONANZA HOTEL RESERVATION SYSTEM              \n");
    printf("         *********************************************************** \n");
    printf("                                 MAIN MENU                           \n");
    printf("\n");
    printf("                                  WELCOME!                           \n");
    printf("         ----------------------------------------------------------- \n");
    printf("                                  OPTIONS                            \n");
    printf("\n                      [1] ADD ROOM RESERVATION                     \n");
    printf("\n                      [2] VIEW AVAILABLE ROOMS                     \n");
    printf("\n                      [3] DELETE ROOM RESERVATION                  \n");
    printf("\n                      [4] EXIT                                     \n");
    printf("\n                      ENTER OPTION:                                \n");
    printf("         ----------------------------------------------------------- \n");
    scanf("%d", &option);
    switch (option)
    {
    case 1:
        makeReservation();
        break;
    case 2:
        viewAvailableRooms();
        break;
    case 3:
        cancelReservation();
        break;
    case 4:
        printf("THANK YOU!");
        exit(0);
        break;
    default:
        printf("Invalid Option! Please enter a valid option number.\n");
        main();
        break;
    }
    return (0);
}

void makeReservation()
{
    printf("         *********************************************************** \n");
    printf("                                MAKE RESERVATION                     \n");
    printf("         *********************************************************** \n");
    printf("Details: \n");
    printf("Enter Your Name: \n");
    scanf("%s", hotel.name);
    printf("Enter Your Room Number: \n");
    scanf("%s", hotel.roomID);
    printf("Enter Check In Date: \n");
    scanf("%s", hotel.date);
    printf("Enter Check In Time: \n");
    scanf("%s", hotel.time);
    printf("Enter number of people: \n");
    scanf("%d", hotel.numberOfPeople);
    printf("Enter room type: \n");
    scanf("%s", hotel.roomType);

    enter = fopen("booking.txt", "a");

    fprintf(enter, "%s %s %s %s %d %s", hotel.name, hotel.roomID, hotel.date, hotel.time, hotel.numberOfPeople, hotel.roomType);
    fprintf(enter, "\n");
    printf("Reservation Successful ! \n");
    fclose(enter);
    main();
}

void cancelReservation()
{
    printf("         *********************************************************** \n");
    printf("                                CANCEL RESERVATION                   \n");
    printf("         *********************************************************** \n");
    int lno, ctr = 0;
    char ch;
    FILE *fptr1, *fptr2;
    char fname[100];
    char str[100], temp[] = "tmp.txt";

    fptr1 = fopen("booking.txt", "r");
    if (!fptr1)
    {
        printf(" File not found or unable to open the input file!!\n");
    }
    fptr2 = fopen(temp, "w"); // open the temporary file in write mode
    if (!fptr2)
    {
        printf("Unable to open a temporary file to write!!\n");
        fclose(fptr1);
    }
    printf(" Input the booking you want to remove : ");
    scanf("%d", &lno);
    lno++;
    // copy all contents to the temporary file except the specific line
    while (!feof(fptr1))
    {
        strcpy(str, "\0");
        fgets(str, 100, fptr1);
        if (!feof(fptr1))
        {
            ctr++;
            /* skip the line at given line number */
            if (ctr != lno)
            {
                fprintf(fptr2, "%s", str);
            }
        }
    }
    fclose(fptr1);
    fclose(fptr2);
    remove(fname);       // remove the original file
    rename(temp, fname); // rename the temporary file to original name
                         /*------ Read the file ----------------*/
    fptr1 = fopen(fname, "r");
    ch = fgetc(fptr1);
    printf("Now the remaining booking list is : \n", fname);
    while (ch != EOF)
    {
        printf("%c", ch);
        ch = fgetc(fptr1);
    }
    fclose(fptr1);
    /*------- End of reading ---------------*/
    main();
}

void viewAvailableRooms()
{

    printf("         *********************************************************** \n");
    printf("                              VIEW AVAILABLE BOOKING                   \n");
    printf("         *********************************************************** \n");
    enter = fopen("booking.txt", "r");

    while (fscanf(enter, "%s %s %s %s %d %s", hotel.name, hotel.roomID, hotel.date, hotel.time, hotel.numberOfPeople, hotel.roomType) != -1)
    {
        fgets(hotel.roomID, 255, (FILE *)enter);
        printf("%s %s %s %s %d %s", hotel.name, hotel.roomID, hotel.date, hotel.time, hotel.numberOfPeople, hotel.roomType);
    }
    main();
}