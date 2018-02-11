package lucasfscr.com.signosapp;import android.app.Activity;import android.support.v7.app.AppCompatActivity;import android.os.Bundle;import android.view.View;import android.widget.Adapter;import android.widget.AdapterView;import android.widget.ArrayAdapter;import android.widget.ListView;import android.widget.Toast;import butterknife.BindView;import butterknife.ButterKnife;public class MainActivity extends Activity {    @BindView(R.id.listView)    ListView listView;    private String[] signos = {"Áries","Touro","Gêmeos","Câncer","Leio","Virgem","Libra",            "Escorpião","Sagitário","Capricórnio","Aquário","Peixes"};    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);        ButterKnife.bind(this);        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),                android.R.layout.simple_list_item_1,                android.R.id.text1,                signos                );        listView.setAdapter(adapter);        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {            @Override            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {                Toast.makeText(MainActivity.this, "Descricao item: " + i, Toast.LENGTH_SHORT).show();            }        });    }}