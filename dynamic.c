#include <stdio.h>
#include <stdlib.h> 

int main() {
    int size;//配列の個数
    int *arr;

    printf("Enter array size:");
    scanf("%d",&size);

    //メモリの確保
    arr = (int*)malloc(sizeof(int) *size); //int型のサイズ(4byte)を配列の個数分用意

    //確保失敗時の処理
    if (arr == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }

    for (int i = 0; i < size; i++) {
        arr[i] = i * 10; // 配列に0, 10, 20... を代入
        printf("arr[%d] = %d\n", i, arr[i]);
    }

    // 4. メモリの解放 (free)
    free(arr);
    
    printf("Memory freed successfully\n");

    return 0;
}