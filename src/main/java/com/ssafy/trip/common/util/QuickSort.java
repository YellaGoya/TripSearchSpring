package com.ssafy.trip.common.util;

import java.util.List;

import com.ssafy.trip.attr.model.AttrDto;

public class QuickSort {
	public static void byName(List<AttrDto> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionName(list, low, high);
            byName(list, low, pivotIndex - 1);
            byName(list, pivotIndex + 1, high);
        }
	}
	
	public static void byAddr(List<AttrDto> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionAddr(list, low, high);
            byAddr(list, low, pivotIndex - 1);
            byAddr(list, pivotIndex + 1, high);
        }
	}
	
    private static int partitionName(List<AttrDto> list, int low, int high) {
        String pivot = list.get(high).getTitle();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).getTitle().compareTo(pivot) < 0) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, high);
        return i + 1;
    }
    
    private static int partitionAddr(List<AttrDto> list, int low, int high) {
        String pivot = list.get(high).getAddr();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).getAddr().compareTo(pivot) < 0) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, high);
        return i + 1;
    }
    
    private static void swap(List<AttrDto> list, int i, int j) {
    	AttrDto temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
