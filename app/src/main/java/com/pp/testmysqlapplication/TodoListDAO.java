package com.pp.testmysqlapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;


/**
 * Created by Administrator on 1/3/2560.
 */

public class TodoListDAO {
    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public TodoListDAO (Context context){
        //get context and sent to helper
        dbHelper = new DbHelper(context);
    }
//open database


    public void open(){
        database =dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }

    public ArrayList<Todolist> getAlltodoList(){
        ArrayList<Todolist> todoList = new ArrayList<~>();
        Cursor cursor = database.rawQuery("SELECT * FROM tbtodo_list;",null);
        cursor.moveToFirst();

        Todolist todoList1;

        while (!cursor.isAfterLast()){

            todoList1 = new Todolist();
            todoList1.setTaskid(cursor.getInt(0));
            todoList1.setTaskname(cursor.getString(1));

            todoList.add(todoList1);
            cursor.moveToNext();
        }
        cursor.close();
        return todoList;
    }


    public void add(Todolist todoList) {
        Todolist newTodoList = new Todolist();
        newTodoList = todoList;

        ContentValues values = new ContentValues();
        values.put("taskname", newTodoList.getTaskname());
        this.database.insert("tbtodo_list", null, values);
        Log.d("Todo List Demo ::", "Add OK");
    }
}


