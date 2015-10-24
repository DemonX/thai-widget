/*
 * Copyright © 2015 NECTEC
 * National Electronics and Computer Technology Center, Thailand
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
 *
 *
 */

package th.or.nectec.android.widget.thai;

import android.widget.EditText;
import th.or.nectec.domain.thai.CitizenId;
import th.or.nectec.domain.thai.Id;

public class CitizenIdHandler extends AbstractIdHandler {

    private static final int MAX_LENGTH = 17;

    public CitizenIdHandler(EditText editText) {
        super(editText);
    }

    @Override
    protected int getMaxLenght() {
        return MAX_LENGTH;
    }

    @Override
    protected Id onCreateNewId(String id) {
        return new CitizenId(id);
    }
}