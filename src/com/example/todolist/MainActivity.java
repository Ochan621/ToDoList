package com.example.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

    private ListView listView1;
	private int checkcount;
	public final static String EXTRA_MESSAGE = "com.example.todolist.ArchivedList.MESSAGE";
	public ListItems ListItems_data[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                
       ListItems ListItems_data[] = new ListItems[]
                {
                    new ListItems(null,"Go to Bank"),
                    new ListItems(null,"Buy Food"),
                    new ListItems(null,"Pay Tuition"),
                    new ListItems(null,"Finish Assignment"),
                    new ListItems(null,"Study")
                };
        ListItemsAdapter adapter = new ListItemsAdapter(this, 
                R.layout.listview_item_row, ListItems_data);
        
        listView1 = (ListView)findViewById(R.id.listView1);
        
        View header = (View)getLayoutInflater().inflate(R.layout.listview_header_row, null);
        listView1.addHeaderView(header);
        
        listView1.setAdapter(adapter);
           
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void sendMessage(View view){
    	//Button press
    	Intent intent = new Intent(this, ArchivedList.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);

    }

}
