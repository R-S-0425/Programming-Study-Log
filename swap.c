#include<stdio.h>

void swap(int *x, int *y){
    int temp = *x; //xが指している場所の値をtempに代入
    *x = *y;//yが指している場所の値をxが指している場所に代入
    *y = temp;//tempの値をyが指している場所に代入
}

int main(){
    int a = 10;
    int b = 20;

    printf("Before a = %d, b = %d\n", a, b);

    swap(&a,&b);

    printf("After a= %d, b = %d\n", a, b);

    return 0;
}