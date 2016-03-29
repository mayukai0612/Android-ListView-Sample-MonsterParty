package com.monash.yukaima.monsterparty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AddMonsterActivity extends AppCompatActivity { ListView monsterAddList;
    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_add_monster);
// Get our ListView instance
        monsterAddList = (ListView) findViewById(R.id.listView);
// Create a MonsterAdapter and populate it with some default values
        ArrayList<Monster> monsters = new ArrayList<Monster>(); monsters.add(new Monster("Fairy", "Good", 1, 90)); monsters.add(new Monster("Druid", "Neutral", 1, 105)); monsters.add(new Monster("Devil", "Evil", 1, 110)); MonsterAdapter adapter = new MonsterAdapter(this, monsters);
// Set adapter to ListView
        monsterAddList.setAdapter(adapter);
// Add click listener for list items
        monsterAddList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> av, View v, int i, long l) {
// Get selected monster
                        Monster result = (Monster) monsterAddList.getAdapter().getItem(i);
// Return result to MainActivity and close this activity
                        Intent intent = new Intent(); intent.putExtra("result", result); setResult(RESULT_OK, intent); finish();
                    } });
    } }

