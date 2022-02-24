#include <stdio.h>

//method definition to view avalaible rooms
void viewAvailableRooms(){
    char roomType[20];
    int roomFound =0;
    char buffer[20];
    
    FILE *fp;
    
    printf("\nEnter Room Type: ");
    scanf("%s", hotel.roomType);   
  
    fp = fopen("hotelnew.txt","r");	
    while(fscanf(fp,"%s %s %s",hotel.name,hotel.room) != -1){	
    fgets(h.bf, 255, (FILE*)fp);
    if(strcmp(hotel.roomID, roomType) == 0){
                     roomFound = 1;
                    printf("\n Room is found!");
                    printf("\n Name  is %s",hotel.name);
                    printf("\n Room number is %s",hotel.room);
      }
    }
    if(roomFound == 0){
         printf("\nRoom %s is not found!\n", roomType);
      }
   fclose(fp);
}