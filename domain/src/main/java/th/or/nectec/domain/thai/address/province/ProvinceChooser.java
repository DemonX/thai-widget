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

package th.or.nectec.domain.thai.address.province;

import java.util.List;

import th.or.nectec.entity.ThaiAddress;

/**
 * Created by N. Choatravee on 5/11/2558.
 */
public class ProvinceChooser {
    private final ProvinceRepository provinceRepository;
    private final ProvincePresenter provincePresenter;

    public ProvinceChooser(ProvinceRepository regionRepository, ProvincePresenter regionPresenter) {
        this.provinceRepository = regionRepository;
        this.provincePresenter = regionPresenter;
    }

    public void showProvinceListByRegion(String region) {
        List<ThaiAddress> allProvinceList = provinceRepository.findByRegion(region);
        if (allProvinceList != null) {
            provincePresenter.showProvinceList(allProvinceList);
        } else {
            provincePresenter.showNotFoundProvince();
        }
    }
}
