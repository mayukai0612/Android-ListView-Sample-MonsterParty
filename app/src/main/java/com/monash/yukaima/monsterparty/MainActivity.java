package com.monash.yukaima.monsterparty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity { // Unique identifier for receiving activity result public static final int ADD_MONSTER_REQUEST = 1;
    public static final int ADD_MONSTER_REQUEST = 1;

    private ListView partyList;
    private MonsterAdapter adapter;
    private ArrayList<Monster> partyMonsters;
    /**
     * Called when the activity is first created. **/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
// Get the ListView associated with layout
        partyList = (ListView) findViewById(R.id.listView);
// / Create our adapter and associate ArrayList
        partyMonsters = new ArrayList<Monster>();
        adapter = new MonsterAdapter(this, partyMonsters);
// Associate adapter with ListView
        partyList.setAdapter(adapter);
// Update monster count
        updateMonsterCount(); }
    // Creates menu items for our AppBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    // AppBar handler for menu item selections
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {


            case R.id.action_add:
// Move to AddMonsterActivity and await result
                Intent i = new Intent(this, AddMonsterActivity.class); startActivityForResult(i, ADD_MONSTER_REQUEST);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        } }
// We override this method when we are expecting a result from any activity // launched from this class.
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data)
        {
        super.onActivityResult(requestCode, resultCode, data);
// See if the request matches add monster (defined at top of class)
        if (requestCode == ADD_MONSTER_REQUEST)
        { if (resultCode == RESULT_OK) {
// Grab the com.monash.yukaima.monsterparty.Monster object out of the intent
            Monster m = data.getParcelableExtra("result");
            partyMonsters.add(m);
// Update adapter and monster count
            adapter.notifyDataSetChanged();
            updateMonsterCount(); }
        } }
    private void updateMonsterCount() {
// Get total monster size
        int totalMonsters = partyMonsters.size();
// Update title to reflect number of monsters setTitle("Monsters: " + totalMonsters);
    } }