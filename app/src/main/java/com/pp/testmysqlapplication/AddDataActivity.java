package com.pp.testmysqlapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 1/3/2560.
 */

public class AddDataActivity extends AppCompatActivity{
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_add_data);

        final EditText newTodoListText = (EditText) findViewById(R.id.editTextAddTask);
        final Button newTodoListButton = (Button) findViewById(R.id.btnAddNewTask);
        newTodoListButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Todolist todoList = new Todolist();
                todoList.setTaskname(String.valueOf(newTodoListText.getText()));
                TodoListDAO todoListDAO = new TodoListDAO(getApplicationContext());
                todoListDAO.open();
                todoListDAO.add(todoList);
                todoListDAO.close();
                finish();
            }
        }));
    }

    }


}
