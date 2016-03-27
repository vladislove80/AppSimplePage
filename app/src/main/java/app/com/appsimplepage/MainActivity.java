/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.com.appsimplepage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * MainActivity
 *
 * Use library: junit, appcompat-v7:23.2.0, design:23.2.0, recyclerview-v7:23.2.0, cardview-v7:23.2.0, picasso:2.5.2
 * @author  Ulianytskyi Vladyslav
 * @version 2016.001
 * @since   2016-03-24
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * String array that contains different images URLs to download in horizontal recyclerview
     */
    private final String mImageUrls[] = {
            "http://ukryama.info/uploads/images/00/10/37/2015/05/08/be2118.jpg",
            "http://photo.guru.ua/photo/76133/807/14382.jpg",
            "http://i.obozrevatel.ua/5/1346646/526030.jpg",
            "http://autonews.autoua.net/media/uploads/raznoe/bpicturepicture_5181829558892_82920.jpg",
            "http://cdn.autocentre.ua/images/stories/october13/m/jami.jpg",
            "http://photo.guru.ua/photo/76133/807/14371.jpg",
            "http://photo.guru.ua/photo/76133/807/14369.jpg",
            "http://photo.guru.ua/photo/76133/807/14357.jpg",
            "http://photo.guru.ua/photo/76133/807/14355.jpg"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_HOME_AS_UP);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        TextView utilityTextView = (TextView) findViewById(R.id.utility);
        utilityTextView.setOnClickListener(this);

        TextView statusTextView = (TextView) findViewById(R.id.status);
        statusTextView.setText(R.string.status);
        statusTextView.setOnClickListener(this);

        TextView createTextView = (TextView) findViewById(R.id.create);
        createTextView.setOnClickListener(this);

        TextView createDateTextView = (TextView) findViewById(R.id.creation_date);
        createDateTextView.setText(R.string.create_date);
        createDateTextView.setOnClickListener(this);

        TextView registrationTextView = (TextView) findViewById(R.id.registration);
        registrationTextView.setOnClickListener(this);

        TextView registrationDateTextView = (TextView) findViewById(R.id.registration_date);
        registrationDateTextView.setText(R.string.registration_date);
        registrationDateTextView.setOnClickListener(this);

        TextView solveTextView = (TextView) findViewById(R.id.solve);
        solveTextView.setOnClickListener(this);

        TextView solveDateTextView = (TextView) findViewById(R.id.solve_date);
        solveDateTextView.setText(R.string.solve_date);
        solveDateTextView.setOnClickListener(this);

        TextView responsibleTextView = (TextView) findViewById(R.id.responsible);
        responsibleTextView.setOnClickListener(this);

        TextView responsibleDepTextView = (TextView) findViewById(R.id.responsible_department);
        responsibleDepTextView.setText(R.string.responsibleDepartment);
        responsibleDepTextView.setOnClickListener(this);

        TextView descriptionTextView = (TextView) findViewById(R.id.description);
        descriptionTextView.setText(R.string.description);
        descriptionTextView.setOnClickListener(this);

        initViews();
    }

    /**
     * Get images in horizontal RecyclerView from URLs in String array.
     * @see ImageAdapter
     */
    private void initViews() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        ImageAdapter adapter = new ImageAdapter(getApplicationContext(), mImageUrls);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(getApplicationContext(),"ActionBar home button", Toast.LENGTH_SHORT).show();
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String controlName = "";
        switch (v.getId()){
            case R.id.utility:
                controlName = "Підприємство";
                break;
            case R.id.status:
                controlName = "Статус";
                break;
            case R.id.create:
                controlName = "Створено";
                break;
            case R.id.creation_date:
                controlName = "Дата створення";
                break;
            case R.id.registration:
                controlName = "Реєстрація";
                break;
            case R.id.registration_date:
                controlName = "Дата реєстрації";
                break;
            case R.id.solve:
                controlName = "Вірішити до";
                break;
            case R.id.solve_date:
                controlName = "Кінцева дата вирішення";
                break;
            case R.id.responsible:
                controlName = "Відповідальний";
                break;
            case R.id.responsible_department:
                controlName = "Назва вдповідального відомства";
                break;
            case R.id.description:
                controlName = "Опис";
                break;
        }
        if(!controlName.equals("")) {
            Toast.makeText(getApplicationContext(), controlName, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        Toast s = Toast.makeText(getBaseContext(), "Exit", Toast.LENGTH_LONG);
        s.show();
    }

}
