# Insertion Sort 
插入排序，在有序序列中，插入一个数值后依然有序。

 ![Insertion Sort](/docs/image/sort/InsertionSort.gif)

## 算法
场景：已有无序序列C，包含n个数值，对C进行排序，排序后数值由大到小排列。

1. 依次取第i(2...n)位数值v
1. 取得之后值后，依次和第j(1...i-1)位数值d进行比较
1. 当v<=d时，将j...i-1位数据后移一位，d值写入j位置，否则继续判断