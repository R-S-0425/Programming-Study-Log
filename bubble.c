#include <stdio.h>
#include <stdlib.h>

//入れ替え用のSWAP関数
void swap(int *x, int *y){
    int tmp = *x;
    *x = *y;
    *y = tmp;
}

//Bubble_Sort関数
void bubble_sort(int *arr, int size){
    //ソートを終えるのに必要な最大回数分
    for(int i = 0; i < size -1; i++){
        //隣同士の比較、末尾i個は確定している
        for(int j = 0; j < size -1 - i; j++){
            if(arr[j] > arr[j+1]){
                swap(&arr[j],&arr[j+1]);
            }
        }
    }
}

int main() {
    int size;
    printf("Enter Data Size: ");
    scanf("%d", &size);

    // メモリ確保 (malloc)
    int *arr = (int*)malloc(sizeof(int) * size);
    if (arr == NULL) return 1;

    printf("Enter %d numbers :\n", size);
    for (int i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }

    // ソート実行
    bubble_sort(arr, size);

    // 結果表示
    printf("--- Sorted Results  ---\n");
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    free(arr);
    return 0;
}