package org.tyaa.solid.d;

import java.util.List;

public class UniSort {
    public static void sort(List items, ICompareRule rule) {
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < items.size() - 1; i++) {
                // Compare
                if (rule.compare(items.get(i), items.get(i + 1)) > 0) {
                    // Swap
                    Object temp = items.get(i);
                    items.set(i, items.get(i + 1));
                    items.set(i + 1, temp);
                    sorted = false;
                }
            }
        } while (!sorted);
    }

    // Choose any sort approach from suggested:
    // https://stackabuse.com/sorting-algorithms-in-java/
    // then change method's name 'quickSort'
    public static void quickSort(List items, ICompareRule rule) {

        int n = items.size();

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Object key = items.get(i);
                int j = i;
                while (j >= gap && rule.compare(key, items.get(j - gap)) > 0) {
                    items.set(j, items.get(j - gap));
                    j -= gap;
                }
                items.set(j, key);
            }
        }
    }
}

