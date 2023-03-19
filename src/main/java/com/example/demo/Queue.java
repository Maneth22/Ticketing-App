package com.example.demo;

public class Queue {
    //Variable Declaration
    int[] queueArray;
    int Front;
    int Rear;
    int Capacity;
    int Count;

    public Queue(int size){
        queueArray=new int[size];
        Capacity=size;
        Count=0;
        Front=0;
        Rear=-1;
    }
    public boolean isEmpty(){
        return (Count==0);
    }
    public boolean isFull(){
        return (Rear==Capacity-1);
    }

    public void enqueue(int Num){
        if (isFull()){
            System.out.println("is full");
        }
        else {
            Rear=(Rear+1) % Capacity;
            queueArray[Rear]=Num;
            Count++;
            String StrNum= String.valueOf(Num);
            System.out.println(StrNum+" Inserted");
        }
    }

    public void dequeue(){
        int frontValue = queueArray[Front];
        if (isEmpty()){
            System.out.println("The Queue is empty");
        }
        else {
            Front=(Front+1)% Capacity;
            String StrFront= String.valueOf(frontValue);
            Count--;
            System.out.println(StrFront+" Removed");
        }
    }

    public int peek(){
        if (isEmpty()){
            System.out.println("The Queue is Empty");
            System.exit(-1);
        }
        return queueArray[Front];
    }

    public int size(){
        return Count;
    }

}
