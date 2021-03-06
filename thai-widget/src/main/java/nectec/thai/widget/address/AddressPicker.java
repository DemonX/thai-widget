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

package nectec.thai.widget.address;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Parcelable;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.util.AttributeSet;

import nectec.thai.address.Address;
import nectec.thai.widget.ViewUtils;
import nectec.thai.widget.address.repository.AddressRepositoryImpl;
import th.or.nectec.thai.widget.R;

public class AddressPicker extends AppCompatEditText implements AddressView {

    private Address address;
    private AddressRepositoryImpl addressRepository;
    private AddressPopup popup;
    private OnAddressChangedListener onAddressChangedListener;
    private final OnAddressChangedListener onPopupAddressChangedListener = new OnAddressChangedListener() {
        @Override
        public void onAddressChanged(Address address) {
            setAddressCode(address.getCode());
            if (onAddressChangedListener != null)
                onAddressChangedListener.onAddressChanged(address);
        }

        @Override
        public void onAddressCanceled() {
            emptyView();
            if (onAddressChangedListener != null)
                onAddressChangedListener.onAddressCanceled();
        }
    };

    public AddressPicker(Context context) {
        this(context, null);
    }

    public AddressPicker(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
    }

    public AddressPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        emptyView();
        if (TextUtils.isEmpty(getHint()))
            setHint(R.string.thwig_please_define_address);
        ViewUtils.updatePaddingRight(this);

        addressRepository = AddressRepositoryImpl.getInstance(context);
        popup = new AddressPickerDialog(context, onPopupAddressChangedListener);
    }

    private void emptyView() {
        address = null;
        setText(null);

    }

    public void setPopup(AddressPopup popup) {
        this.popup = popup;
        this.popup.setOnAddressChangedListener(onPopupAddressChangedListener);
    }

    @Override
    public boolean performClick() {
        popup.show(address);
        return true;
    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setFocusable(false);
        setLongClickable(false);
        setClickable(true);
    }

    @Override
    public Parcelable onSaveInstanceState() {
        if (address == null)
            return super.onSaveInstanceState();
        Parcelable parcelable = super.onSaveInstanceState();
        AddressSavedState savedState = new AddressSavedState(parcelable);
        savedState.addressCode = address.getCode();
        return savedState;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof AddressSavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        AddressSavedState ss = (AddressSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setAddressCode(ss.addressCode);
    }

    @Override
    public void setAddressCode(String addressCode) {
        address = addressRepository.findByCode(addressCode);
        if (address != null)
            setText(address.getName());
    }

    @Override
    public void setOnAddressChangedListener(OnAddressChangedListener onAddressChangedListener) {
        this.onAddressChangedListener = onAddressChangedListener;
    }

    @Override
    public Address getAddress() {
        return address;
    }
}
