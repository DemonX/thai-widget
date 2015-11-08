/*
 * Copyright 2015 NECTEC
 * National Electronics and Computer Technology Center, Thailand
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
 */

package th.or.nectec.android.widget.thai.addresspicker.handler;

import th.or.nectec.android.widget.thai.OnAddressChangedListener;
import th.or.nectec.entity.thai.Address;

public interface AddressPickerInterface {

    void bringToRegionList();

    void bringToProvinceList(String region);

    void bringToDistrictList(String provinceCode);

    void bringToSubdistrictList(String districtCode);

    void bringAddressValueToAddressView(Address addressData);

    void setOnAddressChangedListener(OnAddressChangedListener addressChangedListener);

    void restoreAddressField(Address address);

}
