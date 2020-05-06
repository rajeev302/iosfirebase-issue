package com.example.iosfirebaseissue.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public List<Integer> cellCompete(int[] states, int days){
        List<Integer> newState = new ArrayList<>();
        int cellSize = states.length-1;
        for (int i = 0; i<=cellSize; i++){
            newState.add(states[i]);
        }
        while (days>0){
            for (int i=0;i<=cellSize;i++){
                if (i==0){
                    if (newState.get(i+1)!=0){
                        newState.set(i, 1);
                    } else {
                        newState.set(i, 0);
                    }
                } else if (i==cellSize){
                    if (newState.get(i-1)!=0){
                        newState.set(i, 1);
                    } else {
                        newState.set(i, 0);
                    }
                } else {
                    if (newState.get(i+1)==0 && newState.get(i-1)==0){
                        newState.set(i, 0);
                    } else if (newState.get(i+1)==1 && newState.get(i-1)==1){
                        newState.set(i,0);
                    } else {
                        newState.set(i, 1);
                    }
                }
            }
            days --;
        }
        return newState;
    }
}
