#include <stdio.h>
#include <string.h> 
#include <stdlib.h>

struct Hero {
    char name[50];
    int hp;
    int attack;
};

int main() {
  
    struct Hero *h_ptr;

   h_ptr = (struct Hero*)malloc(sizeof(struct Hero));

   if(h_ptr ==NULL) return 1;


    strcpy(h_ptr->name, "Minato"); 
    h_ptr->hp = 200;
    h_ptr->attack = 100;
    
    printf("Name:%s, HP:%d, Attack:%d\n",h_ptr->name,h_ptr->hp,h_ptr->attack);

    free(h_ptr);
    return 0;
}