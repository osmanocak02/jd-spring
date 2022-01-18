package com.cybertek;

public class DataRepositoryImpl implements DataRepository{
    @Override
    public int[] findAll() {
        return new int[]{10, 20};
    }
}
