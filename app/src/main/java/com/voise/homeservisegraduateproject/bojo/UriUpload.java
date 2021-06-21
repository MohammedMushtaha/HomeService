package com.voise.homeservisegraduateproject.bojo;

import android.net.Uri;

import java.util.ArrayList;

public class UriUpload {
   private ArrayList<Uri> uris ;

    public UriUpload(ArrayList<Uri> uris) {
        this.uris = uris;
    }

    public ArrayList<Uri> getUris() {
        return uris;
    }

    public void setUris(ArrayList<Uri> uris) {
        this.uris = uris;
    }
}
