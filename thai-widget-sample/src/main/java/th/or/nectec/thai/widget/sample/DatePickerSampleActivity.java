/*
 * Copyright (c) 2016 NECTEC
 *   National Electronics and Computer Technology Center, Thailand
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package th.or.nectec.thai.widget.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Calendar;
import nectec.thai.date.DatePrinter;
import nectec.thai.widget.date.DatePicker;
import nectec.thai.widget.date.DatePickerDialog;
import nectec.thai.widget.date.DateView;

public class DatePickerSampleActivity extends AppCompatActivity {

    private final DateView.DatePickerCallback datePickerCallback = new DateView.DatePickerCallback() {
        @Override public void onPicked(DateView view, Calendar calendar) {
            Button button = (Button) findViewById(R.id.button);
            button.setText(DatePrinter.print(calendar));
        }

        @Override public void onCancel() {
            if (BuildConfig.DEBUG) Toast.makeText(DatePickerSampleActivity.this, "onCancle", Toast.LENGTH_SHORT).show();
        }
    };

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_date_picker);

        DatePicker datePicker = (DatePicker) findViewById(R.id.date_picker);
        datePicker.setPopupTitle("ระบุ วัน/เดือน/ปี เกิด");
        datePicker.setUndefinedAsDefault();
        Toast.makeText(this, datePicker.getCalendar() + "", Toast.LENGTH_SHORT).show();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(DatePickerSampleActivity.this, datePickerCallback);
                dialog.setMinDateIsToday();
                dialog.setMaxDate(2021,0,5);
                dialog.show();
//                dialog.updateDate();
            }
        });

        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override public void onDateChanged(Calendar calendar) {
                Toast.makeText(DatePickerSampleActivity.this,
                        calendar == null ? "undefined" : calendar.getTime().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
