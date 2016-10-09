package org.darebeat.demo.sorts;

/**
 * Created by darebeat on 10/8/16.
 */
public class Sorts<T extends Comparable> {
    /**
     * 希尔排序
     * @param data
     * @return
     */
    public T[] shellSort(T[] data){
        int j = 0;

        // 从n/2开始选择步长,每轮插排后减少步长,直到步长为1
        for(int gap = data.length/2;gap>0;gap /= 2){
            T tmp = null;

            // 步长为gap的插入排序
            for (int i = gap;i<data.length;i++){
                tmp = data[i];
                // 找到合适的插入点
                for (j=i;j>=gap && tmp.compareTo(data[j-gap])<0;j-=gap){
                    data[j] = data[j-gap];
                }
                data[j] = tmp;
            }
        }

        return data;
    }

    /**
     * 插入排序
     * @param data
     * @return
     */
    public T[] insertSort(T[] data){
        int i,j;
        T tmp;
        // 从前到后遍历插入新元素的适当位置,比新元素大的都后移一位
        for(i=1;i<data.length;i++){
            tmp=data[i];
            for(j=i;j>0 && data[j-1].compareTo(tmp)>0;j--)
                data[j] = data[j-1];
            data[j] = tmp;
        }
        return data;
    }

    /**
     * 选择排序
     * @param data
     * @return
     */
    public T[] selectSort(T[] data){
        T tmp;
        int minIndex;

        for (int i = 0; i < data.length; i++) {
            minIndex = i;
            // 在剩余无序序列中找到一个最小的
            for (int j = i; j < data.length; j++) {
                if (data[minIndex].compareTo(data[j]) > 0)
                    minIndex = j;
            }
            // 将这个最小的交换到无序序列的首部
            if (minIndex != i) {
                swap(data,i,minIndex);
            }
        }
        return data;
    }

    /**
     * 归并排序-合并排序数组
     * @param a
     * @param tmpArray
     * @param leftPos
     * @param rightPos
     * @param rightEnd
     */
    private void merge(T[] a, T[] tmpArray, int leftPos, int rightPos, int rightEnd){
        int leftEnd=rightPos-1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos +1;

        // 将两个有序数组的元素比较大小后合并成一个数组，存入一个临时数组中
        while(leftPos<=leftEnd && rightPos<=rightEnd){
            if(a[leftPos].compareTo(a[rightPos])<0)
                tmpArray[tmpPos++]=a[leftPos++];
            else
                tmpArray[tmpPos++]=a[rightPos++];
        }
        // 如果左半部分没有合并完（说明右半部分的数较小），将其合并进去
        while(leftPos<=leftEnd){
            tmpArray[tmpPos++]=a[leftPos++];
        }
        // 如果右半部分没有合并完（说明左半部分的数较小），将其合并进去
        while(rightPos<=rightEnd){
            tmpArray[tmpPos++]=a[rightPos++];
        }
        // 将这个临时数组拷贝回原数组
        for(int i = 0;i<numElements;i++,rightEnd--){
            a[rightEnd]=tmpArray[rightEnd];
        }
    }

    /**
     * 归并排序
     * @param array
     * @param tmp
     * @param left
     * @param right
     * @return
     */
    private T[] sort(T[] array, T[] tmp, int left, int right){
        if(left<right){
            // 计算二分中点位置
            int center = (left+right)/2;
            // 将左半部分排序
            sort(array,tmp,left,center);
            // 将右半部分排序
            sort(array,tmp,center+1,right);
            // 将左右两半部分合并
            merge(array,tmp,left,center+1,right);
        }
        return array;
    }

    public T[] mergeSort(T[] a){
        T[] tmp = (T[]) new Comparable[a.length];
        return sort(a,tmp,0,a.length-1);
    }

    public T[] quickSort(T[] a){
        return _sort(a,0,a.length);
    }

    private T[] _sort(T[] a, int left, int right) {
        if (left == right - 1) return null;
        //Partition into two part first
        int k = partition(a,left,right);

        //Recurse on front part
        _sort(a,left,k);
        _sort(a,k,right);
        return a;
    }

    private int partition(T[] a, int left, int right) {
        T p = a[left];
        int i = left;
        int j = right;

        // 先找到右边第一个小于枢纽值的数
        do {
            j--;
        }while (a[j].compareTo(p) > 0 && j > i);

        while (i < j){
            // 将右边那个小于枢纽值的数和左边那个大于枢纽值的数交换（第一次交换的是枢纽值本身）
            swap(a,i,j);

            // 找到下一对可以交换的元素
            do {
                i++;
            }while (a[i].compareTo(p) < 0 );
            do{
                j--;
            }while(a[j].compareTo(p) > 0);
        }

        //Elements before j+1 are partitioned, so we need to partition next part start from j+1
        return j+1;
    }

    private void swap(T[] a, int i, int j) {
        T tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }

    /**
     * 冒泡排序
     * @param a
     * @return
     */
    public T[] bulbleSort(T[] a){
        for (int i = a.length-1;i>0;i--){
            for (int j = 0;j<i;j++){
                if (a[j].compareTo(a[j+1])>0){
                    swap(a,j,j+1);
                }
            }
        }
        return a;
    }

    /**
     * 交换排序
     * @param a
     * @return
     */
    public T[] changeSort(T[] a){
        for (int i=0;i<a.length;i++){
            for (int j = i+1;j<a.length;j++){
                if (a[i].compareTo(a[j])>0){
                    swap(a,i,j);
                }
            }
        }
        return a;
    }
}
