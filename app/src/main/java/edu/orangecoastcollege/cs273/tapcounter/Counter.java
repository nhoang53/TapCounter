package edu.orangecoastcollege.cs273.tapcounter;

/**
 * Created by nhoang53 on 9/8/2016.
 */
public class Counter {
    private int mCount;

    public Counter(int mCount) {
        this.mCount = mCount;
    }

    public  Counter()
    {
        this.mCount = 0;
    }

    public int getmCount() {
        return mCount;
    }

    public void setmCount(int mCount) {
        this.mCount = mCount;
    }

    public void AddCount(){
        mCount++;
    }
}

