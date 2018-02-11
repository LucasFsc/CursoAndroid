package lucasfscr.com.listall;import android.app.Activity;import android.database.Cursor;import android.database.sqlite.SQLiteDatabase;import android.support.v7.app.AppCompatActivity;import android.os.Bundle;import android.view.View;import android.widget.AdapterView;import android.widget.ArrayAdapter;import android.widget.Button;import android.widget.EditText;import android.widget.ListView;import android.widget.Toast;import java.util.ArrayList;import butterknife.BindView;import butterknife.ButterKnife;public class MainActivity extends Activity {    @BindView(R.id.editTextTaskName)    EditText editTextName;    @BindView(R.id.buttonAdd)    Button buttonAdd;    @BindView(R.id.listViewTasks)    ListView listViewTasks;    SQLiteDatabase sqLiteDatabase;    private ArrayAdapter<String> adapterItens;    private ArrayList<String> arrayListItens;    private ArrayList<Integer> arrayListIndex;    @Override    protected void onCreate(final Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);        ButterKnife.bind(this);        try {            //database            intanceOrCreateDatabase();            buttonAdd.setOnClickListener(new View.OnClickListener() {                @Override                public void onClick(View view) {                    String textWroted = editTextName.getText().toString();                    saveTasks(textWroted);                }            });            listViewTasks.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {                @Override                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {                    deleteTask(arrayListIndex.get(i));                    return false;                }            });            recoverTasks();        }catch (Exception e){            e.printStackTrace();        }    }    private void intanceOrCreateDatabase() {        sqLiteDatabase = openOrCreateDatabase("taskApp", MODE_PRIVATE, null);        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS TASKS(ID INTEGER PRIMARY KEY AUTOINCREMENT, TASK VARCHAR)");    }    private void saveTasks(String textWroted){        try {            if (textWroted.equals("")) {                Toast.makeText(this, "Text field cannot be null", Toast.LENGTH_SHORT).show();            } else {                sqLiteDatabase.execSQL("INSERT INTO TASKS (TASK) VALUES('" + textWroted + "')");                Toast.makeText(this, "Task saved", Toast.LENGTH_SHORT).show();                editTextName.setText("");                recoverTasks();            }        }catch (Exception e){            e.printStackTrace();        }    }    private void deleteTask(int ID){        try{            sqLiteDatabase.execSQL("DELETE FROM TASKS WHERE ID="+ID);            recoverTasks();            Toast.makeText(this, "Task deleted", Toast.LENGTH_SHORT).show();        }catch (Exception e){            e.printStackTrace();        }    }    private void recoverTasks(){        try{            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM TASKS ORDER BY ID DESC", null);            int indexColumnID = cursor.getColumnIndex("ID");            int indexColumnTASK = cursor.getColumnIndex("TASK");            arrayListItens = new ArrayList<>();            arrayListIndex = new ArrayList<>();            adapterItens = new ArrayAdapter<String>(getApplicationContext(),            android.R.layout.simple_list_item_1,                    arrayListItens            );            listViewTasks.setAdapter(adapterItens);            cursor.moveToFirst();            while(cursor != null){                arrayListItens.add(cursor.getString(indexColumnTASK));                arrayListIndex.add(Integer.parseInt(cursor.getString(indexColumnID)));                cursor.moveToNext();            }        }catch (Exception e){            e.printStackTrace();        }    }}