package com.pp.testmysqlapplication;

/**
 * Created by Administrator on 2/3/2560.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ASUS on 2/16/2017.
 */

public class MyListView extends BaseAdapter {

    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<Todolist> myTodoList;

    public MyListView(Activity activity, ArrayList<Todolist> myTodoList) {
        this.myTodoList = myTodoList;
        this.activity = activity;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myTodoList.size();
    }

    @Override
    public Todolist getItem(int position) {
        return myTodoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myTodoList.get(position).getTaskid();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        v = inflater.inflate(R.layout.my_list_layout, null);
        TextView textView = (TextView) v.findViewById(R.id.TodoListview);
        Todolist todoList = myTodoList.get(position);
        textView.setText(todoList.getTaskname());
        return v;
    }
}