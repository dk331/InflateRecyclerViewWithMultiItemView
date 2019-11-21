package com.dhananjay.recyclerviewwithmultiitemview;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements OnRecordEventListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Multiple views");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // set adapter
        MultipleTypeAdapter adapter = new MultipleTypeAdapter(this, UserInfo.getInstance().doctorArrayList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRatingBarChange(int position, float value) {
        UserInfo.getInstance().doctorArrayList.get(position).setRating(value);
    }

    @Override
    public void onRadioCheckedChange(int position, boolean isChecked) {
        UserInfo.getInstance().doctorArrayList.get(position).setIsInPerson(isChecked ? 1 : 0);
    }
}
