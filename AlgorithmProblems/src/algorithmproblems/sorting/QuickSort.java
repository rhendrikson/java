/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.sorting;

import java.util.List;

public class QuickSort<T extends Comparable> {

    public void sort(List<T> data) {
        this.sort(data, 0, data.size() - 1);
    }
    
    private void sort(List<T> data, int startIndex, int endIndex) {
        int sortSize = endIndex - startIndex + 1;
        
        if (sortSize <= 1) return;
        
        if (sortSize == 2) {
            if (data.get(startIndex).compareTo(data.get(endIndex)) > 0) {
                this.swap(data, startIndex, endIndex);
            }
            return;
        }
        
        int middleIndex = startIndex + sortSize / 2;
        MinMedianMax minMedianMax = this.findMinMedianMax(data.get(startIndex), data.get(middleIndex), data.get(endIndex));
        
        if (sortSize == 3) {
            data.set(startIndex, minMedianMax.min);
            data.set(middleIndex, minMedianMax.median);
            data.set(endIndex, minMedianMax.max);
            return;
        }
        
        data.set(startIndex, minMedianMax.min);
        data.set(middleIndex, minMedianMax.max);
        int frontIndex = startIndex + 1;
        int backIndex = endIndex - 1;
        while (frontIndex < backIndex) {
            if (data.get(frontIndex).compareTo(minMedianMax.median) >= 0 &&
                data.get(backIndex).compareTo(minMedianMax.median) <= 0) {
                this.swap(data, frontIndex++, backIndex--);
            }
            
            if (data.get(frontIndex).compareTo(minMedianMax.median) < 0) frontIndex++;
            if (data.get(backIndex).compareTo(minMedianMax.median) > 0) backIndex--;
        }
        data.set(endIndex, data.get(frontIndex));
        data.set(frontIndex, minMedianMax.median);
        this.sort(data, startIndex, frontIndex - 1);
        this.sort(data, frontIndex + 1, endIndex);
    }
    
    private MinMedianMax findMinMedianMax(T element1, T element2, T element3) {
        MinMedianMax minMedianMax = new MinMedianMax(element1, element2, element3);
        
        if (element2.compareTo(minMedianMax.min) < 0) {
            minMedianMax.median = minMedianMax.min;
            minMedianMax.min = element2;
        }
        
        if (element3.compareTo(minMedianMax.median) < 0) {
            minMedianMax.max = minMedianMax.median;
            minMedianMax.median = element3;
            if (element3.compareTo(minMedianMax.min) < 0) {
                minMedianMax.median = minMedianMax.min;
                minMedianMax.min = element3;
            }
        }
        
        return minMedianMax;
    }

    private void swap(List<T> data, int frontIndex, int backIndex) {
        T temp = data.get(frontIndex);
        data.set(frontIndex, data.get(backIndex));
        data.set(backIndex, temp);
    }
    
    private class MinMedianMax {
        public T min;
        public T median;
        public T max;
        
        public MinMedianMax(T min, T median, T max) {
            this.min = min;
            this.median = median;
            this.max = max;
        }
    }
}
