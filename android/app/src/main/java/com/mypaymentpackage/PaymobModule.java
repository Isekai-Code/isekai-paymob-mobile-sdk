package com.mypaymentpackage;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.paymob.paymob_sdk.PaymobSdk;
import com.paymob.paymob_sdk.domain.model.CreditCard;
import com.paymob.paymob_sdk.domain.model.SavedCard;
import com.paymob.paymob_sdk.ui.PaymobSdkListener;

public class PaymobModule extends ReactContextBaseJavaModule implements PaymobSdkListener {

    private final ReactApplicationContext reactContext;

    public PaymobModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "PaymobModule";
    }

    @ReactMethod
    public void initializePaymob(String publicKey, String clientSecret, Promise promise) {
        SavedCard savedCard = new SavedCard(
            "**** **** **** 1234", 
            "SAVED_CARD_TOKEN", 
            CreditCard.VISA
        );
        PaymobSdk paymobSdk = new PaymobSdk.Builder(
            getCurrentActivity(),
            clientSecret,
            publicKey,
            this,
            savedCard
        ).build();

        promise.resolve(true);
    }

    @Override
    public void onSuccess() {
        // Handle success
    }

    @Override
    public void onFailure() {
        // Handle failure
    }

    @Override
    public void onPending() {
        // Handle pending
    }
}
