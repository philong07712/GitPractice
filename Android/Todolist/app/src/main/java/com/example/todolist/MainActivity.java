package com.example.todolist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String MYPREFERENCES = "TodoList";
    private final String LIST_SIZE = "arrayList_Size";
    private final String LIST_MESSAGE = "List_at_index";
    private ArrayList<String> arrayList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView list = findViewById(R.id.list_todo);
        // Load the preference to the list
        arrayList = loadPreferences();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.my_textview, arrayList);
        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                final String task = arrayAdapter.getItem(position);
                AlertDialog removeDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Are you sure want to remove this task ?")
                        .setNegativeButton("Cancel", null)
                        .setPositiveButton("Remove", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrayAdapter.remove(task);
                                savePreferences();
                            }
                        })
                        .create();
                removeDialog.show();
            }
        });

        // Create Button click
        findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                final EditText taskEditText = new EditText(MainActivity.this);
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Add a new task")
                        .setView(taskEditText)
                        .setMessage("What do you want to do next ?")
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Add the task to the list
                                String task = taskEditText.getText().toString();
                                arrayAdapter.add(task);
                                savePreferences();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();
            }
        });


    }

    private ArrayList<String> loadPreferences()
    {
        ArrayList<String> listSaved = new ArrayList<String>();
        SharedPreferences sharedPreferences = getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        int num = sharedPreferences.getInt(LIST_SIZE, 0);
        Toast.makeText(getApplicationContext(), Integer.toString(num), Toast.LENGTH_SHORT).show();
        for (int i = 0; i < num; i++)
        {
            String data = sharedPreferences.getString(LIST_MESSAGE + Integer.toString(i), "");
            listSaved.add(data);
        }
        return listSaved;
    }

    private void savePreferences()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(LIST_SIZE, arrayList.size());
        // Save the list to the preferences
        for (int i = 0; i < arrayList.size(); i++)
        {
            editor.remove(LIST_MESSAGE + Integer.toString(i));
            editor.putString(LIST_MESSAGE + Integer.toString(i), arrayList.get(i));
        }
        editor.commit();
        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
    }
}
