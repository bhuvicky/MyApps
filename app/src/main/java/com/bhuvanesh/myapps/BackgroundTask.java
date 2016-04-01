package com.bhuvanesh.myapps;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import static java.lang.System.currentTimeMillis;

/**
 * Created by Lenovo on 30/03/2016.
 */
public class BackgroundTask extends AsyncTask<int[], Integer, Long> {

    long startTime, endTime;
    BenchmarkActivity context;
    ProgressDialog progress;
    int mProgressStatus = 0;
    private Handler mHandler;

    public BackgroundTask(BenchmarkActivity context) {
        mHandler = new Handler();
        this.context = context;;
    }

    @Override
    protected void onPreExecute() {
        progress=new ProgressDialog(context);
        progress.setMessage("Sorting in progress....");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setMax(100);
        progress.show();
    }

    @Override
    protected Long doInBackground(int[]... params) {
        /*new Thread(new Runnable() {
            public void run() {*/
                while (mProgressStatus < 100) {
                    mProgressStatus++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    publishProgress(mProgressStatus);
                }
                    // Update the progress bar
                    /*mHandler.post(new Runnable() {
                        public void run() {
                            progress.setProgress(mProgressStatus);
                        }
                    });
                }
            }
        }).start();*/

       /*startTime = currentTimeMillis();
        bubbleSort(params[0]);
        selectionSort(params[1]);
        insertionSort(params[2]);
        endTime = currentTimeMillis();*/
        return endTime - startTime;
    }



        @Override
        protected void onPostExecute(Long result) {
        super.onPostExecute(result);
        if (progress.isShowing())
            progress.dismiss();
        context.tvbubbleSortResult.setText("Sorting finished in " + String.valueOf(result) + "ms");
        }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progress.setProgress(values[0]);
    }


    public static void swap(int[] array, int index1, int index2) {
        int temp = 0;
        temp 		  = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public void bubbleSort(int[] array) {

        for(int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length-1; j++)
                if(array[j ] > array[j+1])
                    swap (array, j, j+1);
        }

       /* context.tvbubbleSortResult.setTextColor(Color.DKGRAY);*/
        /*context.tvbubbleSortResult.setText("Bubble Sort finished in " +(endTime - startTime)+ "ms");*/
    }

    public void selectionSort(int[] array) {
        int min = 0;

        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[min] > array[j])
                    min = j;
            if (i != min)
                swap(array, i, min);
        }

        /*context.tvSelecitonSortResult.setTextColor(Color.BLUE);*/
        /*context.tvSelecitonSortResult.setText("Seleciton Sort finished in "+(endTime - startTime)+"ms");*/
    }

    public void insertionSort(int[] array) {
        int value=0,hole=0,flag=0,j=0;


        for(int i=1;i<array.length;i++) {
            value=array[i];
            hole =i; flag=1;
            j=i;
            while(j > 0 && array[j - 1] > value) {
                array[hole--] = array[--j];
                flag=0;
            }
            if(flag==0)
                array[j]=value;
        }
       /* context.tvInsertionSortResult.setTextColor(Color.MAGENTA);*/
        /*context.tvInsertionSortResult.setText("Insertion Sort finished in "+(endTime - startTime)+"ms");*/
    }
}
