package com.throrinstudio.android.common.libs.widgets.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

import com.throrinstudio.android.common.modules.basic.AbstractBasicActivity;

/**
 * Shows an alert dialog with a title, a message and a OK button. The title can
 * be null.
 *
 * @author Castorflex
 */
public class ExceptionDialog extends DialogFragment implements
        android.content.DialogInterface.OnClickListener {
    private final static String KEY_TITLE = "key_title";
    private final static String KEY_MSG = "key_msg";

    private View.OnClickListener mListener;

    /**
     * Ctor
     *
     * @param title
     * @param msg
     */
    public ExceptionDialog() {
    }

    /**
     * Use it to create your new Exception dialog
     *
     * @param title
     * @param msg
     * @return the ExceptionDialog
     */
    public static ExceptionDialog newInstance(String title, String message) {
        return newInstance(null, title, message);
    }

    public static ExceptionDialog newInstance(
            AbstractBasicActivity activityToFinish, String title, String message) {
        ExceptionDialog f = new ExceptionDialog();
        Bundle args = new Bundle();
        args.putString(KEY_TITLE, title);
        args.putString(KEY_MSG, message);
        f.setArguments(args);
        return f;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString(KEY_TITLE);
        String msg = getArguments().getString(KEY_MSG);

        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        if (title != null && title.length() > 0) {
            b.setTitle(title);
        }
        b.setMessage(msg);
        b.setPositiveButton("OK", this);

        return b.create();

    }

    public void setOnClickListener(View.OnClickListener listener) {
        mListener = listener;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (mListener != null) {
            mListener.onClick(null);
        } else {
            if (getActivity() != null)
            	getActivity().finish();
            getDialog().dismiss();
        }
    }

}
