#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <string.h>
#include<stdbool.h>

void makeReservation();
void deleteReservation();
void viewBookingDetails();
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
struct availability{
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
    printf("\n                      [2] VIEW BOOKING DETAILS                     \n");
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
        makeReservation();
        break;
    case 2:
        system("cls");
        viewBookingDetails();
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

void makeReservation()
{ 
    FILE *enter;
    int opt;
    enter = fopen("booking.txt", "a+");
    printf("         *********************************************************** \n");
    printf("                                MAKE RESERVATION                     \n");
    printf("         *********************************************************** \n");
    printf("Details: \n");

    printf("Enter Your Name: \n");
    scanf("%s", hotel.name);
    printf("Enter Check In Date: \n");
    scanf("%s", hotel.date);
    printf("Enter Check In Time: \n");
    scanf("%s", hotel.time);
    fflush(stdin); 
    printf("Enter number of people: \n");
    scanf("%d", &hotel.numberOfPeople);
    printf("\nType of Rooms - Single | Double | Deluxe\n");
    printf("Enter room type: \n");
    scanf("%s", hotel.roomType);

    printf("\nOPTIONS:");
    printf("\n[1] CONFIRM");
    printf("\n[2] CANCEL");
    printf("\n[3] BACK TO MAIN MENU\n");
    scanf("%d", &opt);
    switch(opt){
        case 1: 
                if(strcmp(hotel.roomType,"Single")==0){
                   strcpy(hotel.roomID, sing[s].roomID);
                   sing[s].avb = 1;
                   s++;
                }
                else if(strcmp(hotel.roomType,"Double")==0){
                   strcpy(hotel.roomID, doub[b].roomID);
                   doub[b].avb = 1;
                   b++;
                }
                else if(strcmp(hotel.roomType,"Deluxe")==0){
                   strcpy(hotel.roomID, dex[d].roomID);
                   dex[d].avb = 1;
                   d++;
                } 
                 fwrite(&hotel,sizeof(hotel),1,enter);
                 fflush(stdin);
                 printf("RESERVATION SUCCESSFUL ! \n\n\n");
                 fclose(enter);
                 main();
                 break;
        case 2:  system("cls");makeReservation();break;
        case 3:  system("cls");main();break;
        default: printf("Invalid Option! Please enter a valid option number.\n\n\n");
                 break;
    }
   
}

void deleteReservation()
{        
         printf("         *********************************************************** \n");
         printf("                                DELETE RESERVATION                   \n");
         printf("         *********************************************************** \n");
        int opt;
        FILE *enter;
        FILE *tmp;
	int i=1;
	char roomID[5];
        if((tmp=fopen("tmp.txt","w"))==NULL)
	        exit(0);
	        if((enter=fopen("booking.txt","r"))==NULL)
	        exit(0);
	        system("cls");
	        printf("Enter the RoomID:\n");
	        fflush(stdin);
	        scanf("%s",roomID);
        printf("\nOPTIONS:");
        printf("\n[1] CONFIRM");
        printf("\n[2] CANCEL");
        printf("\n[3] BACK TO MAIN MENU\n");
        scanf("%d", &opt);
        switch(opt){
        case 1: 
	        while(fread(&hotel,sizeof(hotel),1,enter)==1)
	        {
		     if(strcmp(hotel.roomID,roomID)==0){       
                           i=0;
			   for(i=0;i<10;i++){
                              if(strcmp(sing[i].roomID,roomID) == 0){
                              sing[i].avb = 0;
                              }
                    else if(strcmp(doub[i].roomID,roomID) == 0){
                              doub[i].avb = 0;
                      
                              }
                   else if(strcmp(dex[i].roomID,roomID) == 0){
                              dex[i].avb = 0;
                      
                    }
                         }
                    continue;
		 }
		     else
			fwrite(&hotel,sizeof(hotel),1,tmp);
	        }
	        if(i==1)
	        {       
		   printf("\nINVALID ROOM ID\n");
		   fclose(enter);
		   fclose(tmp);
		   main();
	         }  
	         fclose(enter);
	         fclose(tmp);
	         remove("booking.txt");
	         rename("tmp.txt","booking.txt");
	         printf("\nRESERVATION SUCCESSFULLY DELETED!\n\n\n");
	         fclose(enter);
	         fclose(tmp);
	         main();
                 break;
        case 2:  system("cls");deleteReservation();break;
        case 3:  system("cls");main();break;
        default: printf("Invalid Option! Please enter a valid option number.\n\n\n");
                 break;
    }
	
}
void viewBookingDetails()
{
    FILE *enter;
    int p=1;
    printf("         *********************************************************** \n");
    printf("                              VIEW BOOKING DETAILS                   \n");
    printf("         *********************************************************** \n");
    enter = fopen("booking.txt", "r+");

    
    while (fread(&hotel,sizeof(hotel),1,enter)==1)
    {
        printf("Details of Customer %d :",p++);
        printf("\n%s\n%s\n%s\n%s\n%d\n%s\n\n\n", hotel.name, hotel.roomID, hotel.date, hotel.time, hotel.numberOfPeople, hotel.roomType);
    }
   
    fclose(enter);
    main();
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
          for(i =0;i<10;i++){
             printf("%s : %d\n", sing[i].roomID, sing[i].avb);
          }
       }
   
       else if(strcmp(type,"Double")==0){
          for(i =0;i<10;i++){
              printf("%s : %d\n", doub[i].roomID, doub[i].avb);
          }
      }
       else if(strcmp(type,"Deluxe")==0){
          for(i =0;i<10;i++){
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
