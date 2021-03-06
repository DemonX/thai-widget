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

package nectec.thai.widget.date;


import java.util.Calendar;

public interface DateView {
    void updateDate(int year, int month, int dayOfMonth);

    int getYear();

    int getMonth();

    int getDayOfMonth();

    void setMaxDate(int year, int month, int dayOfMonth);

    void setMinDate(int year, int month, int dayOfMonth);

    void setCallback(DatePickerCallback callback);

    interface DatePickerCallback {
        void onPicked(DateView view, Calendar calendar);

        void onCancel();
    }
}
