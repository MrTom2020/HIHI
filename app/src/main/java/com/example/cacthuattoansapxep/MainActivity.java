package com.example.cacthuattoansapxep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn1,btn2,btn3,btn4,btn5;
    static String s3;
    static int n1 = 0,n2 = 0;
    static  List<Integer>  list= new ArrayList<>();
    ArrayList<Integer> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        themnut();
        themsk();
    }
    private void themnut()
    {
        btn1 = (Button)findViewById(R.id.button13);
        btn2 = (Button)findViewById(R.id.button14);
        btn3 = (Button)findViewById(R.id.button15);
        btn4 = (Button)findViewById(R.id.button16);
        btn5 = (Button)findViewById(R.id.button17);
        editText = (EditText)findViewById(R.id.editTextTextPersonName);
    }
    private void themsk()
    {

        btn1.setOnClickListener(new skcuatoi());
        btn2.setOnClickListener(new skcuatoi());
        btn3.setOnClickListener(new skcuatoi());
        btn4.setOnClickListener(new skcuatoi());
        btn5.setOnClickListener(new skcuatoi());

    }
    private class skcuatoi implements View.OnClickListener
    {
        String CHUOI,chuoi = "",s2 ="";



        @Override
        public void onClick(View v) {

            arrayList.clear();
            CHUOI = editText.getText().toString() + " ";
            if (editText.getText().length() != 0 || editText != null) {
                for (int i = 0; i < CHUOI.length(); i++) {
                    if (CHUOI.charAt(i) != ' ') {
                        chuoi += CHUOI.charAt(i);
                        //s2 += CHUOI;

                        //Toast.makeText(MainActivity.this,chuoi,Toast.LENGTH_SHORT).show();
                    } else if (CHUOI.charAt(i) == ' ')
                    {

                        arrayList.add(Integer.parseInt(chuoi));
                        chuoi = "";
                    }

                }
                if (v.equals(btn1)) {
                    s3 = "intertion Sort";
                    insertionSort(arrayList, arrayList.size());
                    Intent intent = new Intent(MainActivity.this, trangso2.class);
                    Bundle bundle = new Bundle();
                   bundle.putIntegerArrayList("is",arrayList);
                   intent.putExtra("hiep1",bundle);
                   startActivity(intent);

                    startActivity(intent);
                } else if (v.equals(btn2)) {
                    s3 = "Shell Sort";
                    shellsort(arrayList, arrayList.size());
                    Intent intent = new Intent(MainActivity.this, trangso2.class);
                    Bundle bundle = new Bundle();
                    bundle.putIntegerArrayList("is",arrayList);
                    intent.putExtra("hiep1",bundle);
                    startActivity(intent);
                } else if (v.equals(btn3)) {
                    s3 = "Quick Sort";
                    quicksort(arrayList, 0, arrayList.size() - 1);
                    Intent intent = new Intent(MainActivity.this, trangso2.class);
                    Bundle bundle = new Bundle();
                    bundle.putIntegerArrayList("is",arrayList);
                    intent.putExtra("hiep1",bundle);
                    startActivity(intent);
                }
                else if(v.equals(btn4))
                {
                    s3 = "MergeSort";
                   // Collections.shuffle(arrayList);
                    int ss = arrayList.size();


                    MergeSort ms = new MergeSort(arrayList);
                    ms.sortGivenArray();
                    Intent intent = new Intent(MainActivity.this, trangso2.class);
                    Bundle bundle = new Bundle();
                    bundle.putIntegerArrayList("is",arrayList);
                    intent.putExtra("hiep1",bundle);
                    startActivity(intent);
                }
                else if(v.equals(btn5))
                {
                    s3 ="Bubble sort";
                    bl(arrayList);
                    Intent intent = new Intent(MainActivity.this, trangso2.class);
                    Bundle bundle = new Bundle();
                    bundle.putIntegerArrayList("is",arrayList);
                    intent.putExtra("hiep1",bundle);
                    startActivity(intent);
                }


            }
        }
    }
    static public void insertionSort(ArrayList<Integer> arrayList ,int n)
    {
        int i,j,k;
        for(i = 1;i <n;++i)
        {
            k = arrayList.get(i);
            j = i;
            while ((j > 0&& arrayList.get(j - 1) > k))
            {
                arrayList.set(j,arrayList.get(j - 1));
                j--;
            }
            arrayList.set(j,k);
        }
    }
    public static void shellsort(ArrayList<Integer> arrayList2,int m)
    {
        int i,g,j,k;
        g = m/2;
        while (g >0)
        {

            for(i = 0,j = i + g; j < m;i++,j++)
            {
                if(arrayList2.get(i) > arrayList2.get(j))
                {
                    k = arrayList2.get(i);
                    arrayList2.set(i,arrayList2.get(j));
                    arrayList2.set(j,k);
                }
            }
            g/=2;
        }
    }
    static public void quicksort(ArrayList<Integer> arrayList3,int i,int j)
    {
        if(arrayList3.size() == 0 || arrayList3 == null)
        {
            return;
        }
        if(i > j)
        {
            return;
        }
        int giua = i +(j - i) / 2;
        int p = arrayList3.get(giua);
        int s = i, q = j;
        while (s <= q)
        {
            while ((arrayList3.get(s) < p))
            {
                s++;
            }
            while (arrayList3.get(q) > p)
            {
                q--;
            }
            if(s <=q)
            {
                int k = arrayList3.get(s);
                arrayList3.set(s,arrayList3.get(q));
                arrayList3.set(q,k);
                s++;q--;
            }
        }
        if(i <q)
        {
            quicksort(arrayList3,i,q);
        }
        if( j > s)
        {
            quicksort(arrayList3,s,j);
        }
    }
    public class MergeSort {
        private ArrayList<Integer> inputArray;

        public ArrayList<Integer> getSortedArray() {
            return inputArray;
        }

        public MergeSort(ArrayList<Integer> inputArray){
            this.inputArray = inputArray;
        }

        public void sortGivenArray(){
            divide(0, this.inputArray.size()-1);
        }

        public void divide(int startIndex,int endIndex){

            //Divide till you breakdown your list to single element
            if(startIndex<endIndex && (endIndex-startIndex)>=1){
                int mid = (endIndex + startIndex)/2;
                divide(startIndex, mid);
                divide(mid+1, endIndex);

                //merging Sorted array produce above into one sorted array
                merger(startIndex,mid,endIndex);
            }
        }

        public void merger(int startIndex,int midIndex,int endIndex){


            ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>();

            int leftIndex = startIndex;
            int rightIndex = midIndex+1;

            while(leftIndex<=midIndex && rightIndex<=endIndex){
                if(inputArray.get(leftIndex)<=inputArray.get(rightIndex)){
                    mergedSortedArray.add(inputArray.get(leftIndex));
                    leftIndex++;
                }else{
                    mergedSortedArray.add(inputArray.get(rightIndex));
                    rightIndex++;
                }
            }


            while(leftIndex<=midIndex){
                mergedSortedArray.add(inputArray.get(leftIndex));
                leftIndex++;
            }

            while(rightIndex<=endIndex){
                mergedSortedArray.add(inputArray.get(rightIndex));
                rightIndex++;
            }

            int i = 0;
            int j = startIndex;
            //Setting sorted array to original one
            while(i<mergedSortedArray.size()){
                inputArray.set(j, mergedSortedArray.get(i++));
                j++;
            }
        }
    }
   public void bl(ArrayList<Integer> arrayList)
   {
       int ss1 =0,ss2 = 0;
       for(int i = 0; i < arrayList.size();i++)
       {
           ss2 = i +1;
           for(int j = 1; j < arrayList.size() - i;j++)
           {
               int k = j -1;
               if(arrayList.get(k) > arrayList.get(j))
               {
                   ss1 =arrayList.get(k);
                   arrayList.set(k,arrayList.get(j));
                   arrayList.set(j,ss1);
               }
           }
       }
   }

}