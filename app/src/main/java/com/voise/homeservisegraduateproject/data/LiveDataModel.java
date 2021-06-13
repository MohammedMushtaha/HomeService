package com.voise.homeservisegraduateproject.data;

import android.app.Activity;

public class LiveDataModel<T> {
    private T data;
    private Observer<T> observer;

    public void setValue(T data) {
        this.data = data;
        if (observer != null) {
            observer.onChanged(this.data);

        }
    }

    public T getValue() {
        return data;
    }

    public void observe(Activity activity, Observer<T> observer) {
        this.observer = observer;

    }

    public interface Observer<D> {
        public void onChanged(D d);

    }
}
