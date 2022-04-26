package com.android.s19110159;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class SourceLoader extends AsyncTaskLoader<String> {

    private String queryString;
    private String transferProtocol;
    Context conText;

    public SourceLoader(@NonNull Context context, String queryString, String transferProtocol) {
        super(context);
        conText = context;
        this.queryString = queryString;
        this.transferProtocol = transferProtocol;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return com.android.s19110159.NetworkUtils.getSourceCode(conText, queryString, transferProtocol);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
