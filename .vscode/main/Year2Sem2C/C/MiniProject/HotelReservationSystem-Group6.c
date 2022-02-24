#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

void addReservation();
void deleteReservation();
void viewReservationDetails();
void viewRooms();

struct BonanzaHotel
{
    char name[20];
    char roomID[5];
    char date[20];
    char time[20];
    int numberOfPeople;
    char roomType[10];

} hotel;

int s = 0;
int b = 0;
int d = 0;
struct availability
{
    char roomID[5];
    bool avb;
};
struct availability sing[10];
struct availability doub[10];
struct availability dex[10];

int main()
{
    strcpy(sing[0].roomID, "S001");
    strcpy(sing[1].roomID, "S002");
    strcpy(sing[2].roomID, "S003");
    strcpy(sing[3].roomID, "S004");
    strcpy(sing[4].roomID, "S005");
    strcpy(sing[5].roomID, "S006");
    strcpy(sing[6].roomID, "S007");
    strcpy(sing[7].roomID, "S008");
    strcpy(sing[8].roomID, "S009");
    strcpy(sing[9].roomID, "S010");

    strcpy(doub[0].roomID, "B001");
    strcpy(doub[1].roomID, "B002");
    strcpy(doub[2].roomID, "B003");
    strcpy(doub[3].roomID, "B004");
    strcpy(doub[4].roomID, "B005");
    strcpy(doub[5].roomID, "B006");
    strcpy(doub[6].roomID, "B007");
    strcpy(doub[7].roomID, "B008");
    strcpy(doub[8].roomID, "B009");
    strcpy(doub[9].roomID, "B010");

    strcpy(dex[0].roomID, "D001");
    strcpy(dex[1].roomID, "D002");
    strcpy(dex[2].roomID, "D003");
    strcpy(dex[3].roomID, "D004");
    strcpy(dex[4].roomID, "D005");
    strcpy(dex[5].roomID, "D006");
    strcpy(dex[6].roomID, "D007");
    strcpy(dex[7].roomID, "D008");
    strcpy(dex[8].roomID, "D009");
    strcpy(dex[9].roomID, "D010");

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
    printf("\n                      [2] VIEW RESERVATION DETAILS                 \n");
    printf("\n                      [3] VIEW AVAILABLE ROOMS                     \n");
    printf("\n                      [4] DELETE ROOM RESERVATION                  \n");
    printf("\n                      [5] EXIT                                     \n");
    printf("\n                      ENTER OPTION:                                \n");
    printf("         ----------------------------------------------------------- \n");
    scanf("%d", &option);
    switch (option)
    {
    case 1:
        system("cls");
        addReservation();
        break;
    case 2:
        system("cls");
        viewReservationDetails();
        break;
    case 3:
        system("cls");
        viewRooms();
        break;
    case 4:
        system("cls");
        deleteReservation();
        break;
    case 5:
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
//reference is used for this function
void addReservation()
{
    FILE *enter;
    int opt;
    enter = fopen("booking.txt", "a+");
    printf("         *********************************************************** \n");
    printf("                              ADD ROOM RESERVATION                   \n");
    printf("         *********************************************************** \n");
    printf("\t DETAILS: \n");

    printf("\t ENTER YOUR NAME: ");
    scanf("%s", hotel.name);
    printf("\t ENTER CHECK-IN DATE: ");
    scanf("%s", hotel.date);
    printf("\t ENTER CHECK-IN TIME: ");
    scanf("%s", hotel.time);
    fflush(stdin);
    printf("\t ENTER NUMBER OF PEOPLE: ");
    scanf("%d", &hotel.numberOfPeople);
    printf("\n\t TYPE OF ROOMS - Single | Double | Deluxe\n");
    printf("\t ENTER ROOM TYPE: ");
    scanf("%s", hotel.roomType);

    printf("         ----------------------------------------------------------- \n");
    printf("\n\t OPTIONS:");
    printf("\n\t [1] CONFIRM");
    printf("\n\t [2] CANCEL");
    printf("\n\t [3] BACK TO MAIN MENU\n");
    printf("\n\t ENTER OPTION: ");
    scanf("%d", &opt);
    switch (opt)
    {
    case 1:
        if (strcmp(hotel.roomType, "Single") == 0)
        {
            strcpy(hotel.roomID, sing[s].roomID);
            sing[s].avb = 1;
            s++;
            fwrite(&hotel, sizeof(hotel), 1, enter);
            fflush(stdin);
            printf("\n\t RESERVATION SUCCESSFUL ! \n\n\n");
            fclose(enter);
        }
        else if (strcmp(hotel.roomType, "Double") == 0)
        {
            strcpy(hotel.roomID, doub[b].roomID);
            doub[b].avb = 1;
            b++;
            fwrite(&hotel, sizeof(hotel), 1, enter);
            fflush(stdin);
            printf("\n\t RESERVATION SUCCESSFUL ! \n\n\n");
            fclose(enter);
        }
        else if (strcmp(hotel.roomType, "Deluxe") == 0)
        {
            strcpy(hotel.roomID, dex[d].roomID);
            dex[d].avb = 1;
            d++;
            fwrite(&hotel, sizeof(hotel), 1, enter);
            fflush(stdin);
            printf("\n\t RESERVATION SUCCESSFUL ! \n\n\n");
            fclose(enter);
        }
        else
        {
            fclose(enter);
            printf("\n\t NOT A VALID ROOM. RESERVATION UNSUCCESSFUL!\n\n\n");
        }

        main();
        break;
    case 2:
        fclose(enter);
        system("cls");
        addReservation();
        break;
    case 3:
        fclose(enter);
        system("cls");
        main();
        break;
    default:
        fclose(enter);
        printf("\n\t Invalid Option! Please enter a valid option number.\n\n\n");
        main();
        break;
    }
}

void deleteReservation()
{
    printf("         *********************************************************** \n");
    printf("                           DELETE ROOM RESERVATION                   \n");
    printf("         *********************************************************** \n");
    int opt;
    FILE *enter;
    FILE *tmp;
    int i = 1;
    int j;
    char roomID[5];
    if ((tmp = fopen("tmp.txt", "w")) == NULL)
        exit(0);
    if ((enter = fopen("booking.txt", "r")) == NULL)
        exit(0);
    printf("\n\t ENTER ROOM ID: ");
    fflush(stdin);
    scanf("%s", roomID);
    printf("         ----------------------------------------------------------- \n");
    printf("\n\t OPTIONS:");
    printf("\n\t [1] CONFIRM");
    printf("\n\t [2] CANCEL");
    printf("\n\t [3] BACK TO MAIN MENU\n");
    printf("\n\t ENTER OPTION: ");
    scanf("%d", &opt);
    switch (opt)
    {
    case 1:
        while (fread(&hotel, sizeof(hotel), 1, enter) == 1)
        {
            if (strcmp(hotel.roomID, roomID) == 0)
            {
                i = 0;
                for (j = 0; j < 10; j++)
                {
                    if (strcmp(sing[j].roomID, roomID) == 0)
                    {
                        sing[j].avb = 0;
                    }
                    else if (strcmp(doub[j].roomID, roomID) == 0)
                    {
                        doub[j].avb = 0;
                    }
                    else if (strcmp(dex[j].roomID, roomID) == 0)
                    {
                        dex[j].avb = 0;
                    }
                }
                continue;
            }
            else
                fwrite(&hotel, sizeof(hotel), 1, tmp);
        }
        if (i == 1)
        {
            printf("\n\t INVALID ROOM ID\n\n\n");
            fclose(enter);
            fclose(tmp);
            main();
        }
        fclose(enter);
        fclose(tmp);
        remove("booking.txt");
        rename("tmp.txt", "booking.txt");
        printf("\n\tRESERVATION SUCCESSFULLY DELETED!\n\n\n");
        fclose(enter);
        fclose(tmp);
        main();
        break;
    case 2:
        fclose(enter);
        fclose(tmp);
        system("cls");
        deleteReservation();
        break;
    case 3:
        fclose(enter);
        fclose(tmp);
        system("cls");
        main();
        break;
    default:
        fclose(enter);
        fclose(tmp);
        printf("\n\t Invalid Option! Please enter a valid option number.\n\n\n");
        main();
        break;
    }
}
//reference is used for this function
void viewReservationDetails()
{
    int opt;
    FILE *enter;
    int p = 1;
    printf("         *********************************************************** \n");
    printf("                            VIEW RESERVATION DETAILS                 \n");
    printf("         *********************************************************** \n");
    enter = fopen("booking.txt", "r+");

    while (fread(&hotel, sizeof(hotel), 1, enter) == 1)
    {
        printf("\n\t DETAILS OF CUSTOMER: %d :", p++);
        printf("\n\t ROOM ID:%s\n\t NAME:%s\n\t CHECK-IN DATE:%s\n\t CHECK-IN TIME:%s\n\t NUMBER OF PEOPLE:%d\n\t ROOM TYPE: %s\n", hotel.roomID, hotel.name, hotel.date, hotel.time, hotel.numberOfPeople, hotel.roomType);
    }
    fclose(enter);
    printf("         ----------------------------------------------------------- \n");
    printf("\n\t OPTIONS: ");
    printf("\n\t [1] BACK TO MAIN MENU\n");
    printf("\n\t ENTER OPTION: ");
    scanf("%d", &opt);
    switch (opt)
    {
    case 1:
        fclose(enter);
        system("cls");
        main();
        break;
    default:
        fclose(enter);
        printf("\n\t Invalid Option! Please enter a valid option number.\n");
        viewReservationDetails();
        break;
    }
}

void viewRooms()
{
    int opt;
    int i;
    char type[7];
    printf("         *********************************************************** \n");
    printf("                              VIEW AVAILABLE ROOMS                   \n");
    printf("         *********************************************************** \n");
    fflush(stdin);
    printf("\n\t ENTER ROOMTYPE: ");
    fgets(type, sizeof(type), stdin);

    if (strcmp(type, "Single") == 0)
    {
        for (i = 0; i < 10; i++)
        {
            printf("\t %s : %d\n", sing[i].roomID, sing[i].avb);
        }
    }

    else if (strcmp(type, "Double") == 0)
    {
        for (i = 0; i < 10; i++)
        {
            printf("\t %s : %d\n", doub[i].roomID, doub[i].avb);
        }
    }
    else if (strcmp(type, "Deluxe") == 0)
    {
        for (i = 0; i < 10; i++)
        {
            printf("\t %s : %d\n", dex[i].roomID, dex[i].avb);
        }
    }
    else
    {
        printf("\t Enter A Valid Room Type\n");
        viewRooms();
    }
    printf("\n\t [0]:Available\n\t [1]:Unavailable \n");
    printf("\n\t OPTIONS:");
    printf("\n\t [1] BACK TO MAIN MENU\n");
    printf("\n\t ENTER OPTION: ");
    scanf("%d", &opt);
    switch (opt)
    {
    case 1:
        system("cls");
        main();
        break;
    default:
        printf("\n\t Invalid Option! Please enter a valid option number.\n");
        viewRooms();
        break;
    }
}
