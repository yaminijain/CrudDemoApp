package com.example.cruddemo;
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cruddemo.adapter.TaskAdapter
import com.example.cruddemo.model.Task
import com.example.helloworld.R

class MainActivityDemo : AppCompatActivity() {

    private lateinit var taskAdapter: TaskAdapter
    private lateinit var taskList: ArrayList<Task>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerViewTasks = findViewById<RecyclerView>(R.id.recyclerViewTasks)
        recyclerViewTasks.layoutManager = LinearLayoutManager(this)
        taskList = ArrayList()
        taskAdapter = TaskAdapter(this, taskList)
        recyclerViewTasks.adapter = taskAdapter

        val editTextTitle = findViewById<EditText>(R.id.editTextTitle)
        val editTextDescription = findViewById<EditText>(R.id.editTextDescription)
        val spinnerStatus = findViewById<Spinner>(R.id.spinnerStatus)
        val buttonCreateTask = findViewById<Button>(R.id.buttonCreateTask)

        buttonCreateTask.setOnClickListener {
            val title = editTextTitle.text.toString()
            val description = editTextDescription.text.toString()
            val status = spinnerStatus.selectedItem.toString()

            val task = Task(title, description, status)
            taskList.add(task)
            taskAdapter.notifyDataSetChanged()
        }
    }
}
