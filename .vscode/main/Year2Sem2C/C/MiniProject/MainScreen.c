#include <stdio.h>
#include<conio.h>
#include <stdlib.h>
#include <string.h>
#include<stdbool.h>  

void addReservation();
void deleteReservation();
void viewRooms();

int r = 0;
int s = 0;
int b = 0;
int d = 0;
struct availability{
   char roomID[5];
   bool avb;
};
struct availability sing[3];
struct availability doub[3];
struct availability dex[3];


struct addReservation{
   char cust_Name [20];
   char checkIn_Date[15];
   char checkIn_Time[15];
   char roomType[7];
   char roomID[5];
   int no_People;
};
struct addReservation rsv[3];



int main (){
    strcpy(sing[0].roomID, "S001");
    strcpy(sing[1].roomID, "S002");
    strcpy(sing[2].roomID, "S003");
    strcpy(doub[0].roomID, "B001");
    strcpy(doub[1].roomID, "B002");
    strcpy(doub[2].roomID, "B003");
    strcpy(dex[0].roomID, "D001");
    strcpy(dex[1].roomID, "D002");
    strcpy(dex[2].roomID, "D003");
    //system("cls");
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
    scanf("%d",&option);
    switch(option){
        case 1: system("cls");
                addReservation();
                break;
        case 2: system("cls");viewRooms();break;
        case 3: system("cls");
                deleteReservation();
                break;
        case 4: printf("THANK YOU!");
                exit(0);
                break;
        default: printf("Invalid Option! Please enter a valid option number.\n");
                 main();
                 break;
    }
    return(0);

}




void addReservation(){
    
    int opt;
    printf("         *********************************************************** \n");
    printf("                                MAKE RESERVATION                     \n");
    printf("         *********************************************************** \n");
    fflush(stdin); 
    if(r !=3){
    printf("DETAILS:");
    printf("\nENTER YOUR NAME: ");
    fgets(rsv[r].cust_Name, sizeof(rsv[r].cust_Name),stdin);
    
    printf("ENTER NUMBER OF PEOPLE: ");
    scanf("%d", &rsv[r].no_People); 
    fflush(stdin); 

    printf("ENTER CHECK_IN DATE: ");
    fgets(rsv[r].checkIn_Date, sizeof(rsv[r].checkIn_Date),stdin);
    
    printf("ENTER CHECK_IN TIME: ");
    fgets(rsv[r].checkIn_Time, sizeof(rsv[r].checkIn_Time),stdin);

    printf("ENTER ROOMTYPE: ");
    fgets(rsv[r].roomType, sizeof(rsv[r].roomType),stdin);
    
   
    //printf("ENTER ROOMID: ");
    //fgets(rsv[r].roomID, sizeof(rsv[r].roomID),stdin);
    
    
    }
    else
      printf("Reservations are full");
    
    printf("\nOPTIONS:");
    printf("\n[1] CONFIRM");
    printf("\n[2] CANCEL");
    printf("\n[3] BACK TO MAIN MENU\n");
    scanf("%d", &opt);
    switch(opt){
        case 1: printf("\nRESERVATION CONFIRMED:\n");
                if(strcmp(rsv[r].roomType,"Single")==0){
                   printf("Room ID: %s", sing[s].roomID);
                   sing[s].avb = 1;
                   s++;
                }
                else if(strcmp(rsv[r].roomType,"Double")==0){
                   printf("Room ID: %s", doub[b].roomID);
                   doub[b].avb = 1;
                   b++;
                }
                else if(strcmp(rsv[r].roomType,"Deluxe")==0){
                   printf("Room ID: %s", dex[d].roomID);
                   dex[d].avb = 1;
                   d++;
                }
                printf("\nName: %s", rsv[r].cust_Name);
                printf("Date: %s", rsv[r].checkIn_Date);
                printf("Time: %s", rsv[r].checkIn_Time);
                printf("People: %d\n", rsv[r].no_People);
                printf("Room Type: %s\n", rsv[r].roomType);
                r++;
                main();
                break;
        case 2: system("cls");addReservation();break;
        case 3: system("cls");main();break;
        default: printf("Invalid Option! Please enter a valid option number.\n");
                 break;
    }
    
}


void deleteReservation(){
    int opt;
    int value;
    int pt;
    int i;
    char id[5];
    printf("         *********************************************************** \n");
    printf("                                DELETE RESERVATION                   \n");
    printf("         *********************************************************** \n");
    fflush(stdin); 
    printf("ENTER ROOM ID:");
    scanf("%s", &id);
    
    
    
    printf("\nOPTIONS:");
    printf("\n[1] CONFIRM");
    printf("\n[2] CANCEL");
    printf("\n[3] BACK TO MAIN MENU\n");
    scanf("%d", &opt);
    switch(opt){
        case 1: for(i=0;i<3;i++){
                   if(strcmp(sing[i].roomID,id) == 0){
                      sing[i].avb = 0;
                      printf("Reservation Successfully Deleted!\n");
                   }
                   else if(strcmp(doub[i].roomID,id) == 0){
                      doub[i].avb = 0;
                      printf("Reservation Successfully Deleted!\n");
                   }
                   else if(strcmp(dex[i].roomID,id) == 0){
                      dex[i].avb = 0;
                      printf("Reservation Successfully Deleted!\n");
                   }
                }
                //system("cls");
                main();
                break;
        case 2: system("cls");deleteReservation();break;
        case 3: system("cls");main();break;
        default: printf("Invalid Option! Please enter a valid option number.\n");
                 break;
    }
    
}


void viewRooms(){
    int opt;
    int i;
    char type[7];
    printf("         *********************************************************** \n");
    printf("                              VIEW AVAILABLE ROOMS                   \n");
    printf("         *********************************************************** \n");
    fflush(stdin); 
    printf("ENTER ROOMTYPE: ");
    fgets(type, sizeof(type),stdin);

 
       if(strcmp(type,"Single")==0){
          for(i =0;i<3;i++){
             printf("%s : %d\n", sing[i].roomID, sing[i].avb);
          }
       }
   
       else if(strcmp(type,"Double")==0){
          for(i =0;i<3;i++){
              printf("%s : %d\n", doub[i].roomID, doub[i].avb);
          }
      }
       else if(strcmp(type,"Deluxe")==0){
          for(i =0;i<3;i++){
           printf("%s : %d\n", dex[i].roomID, dex[i].avb);
         }
      }
       else
          printf("Enter A Valid Room Type\n");

       printf("\n[0]:Available\n[1]:Unavailable \n");
       printf("\nOPTIONS:");
       printf("\n[1] BACK TO MAIN MENU\n");
       scanf("%d", &opt);
       switch(opt){
          case 1: system("cls");main();break;
          default: printf("Invalid Option! Please enter a valid option number.\n");
                   break;
       }




}
