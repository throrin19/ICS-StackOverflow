package com.throrinstudio.android.common.libs.widgets.dialogs;

import java.io.Serializable;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.throrinstudio.android.common.libs.tasks.Step;
import com.throrinstudio.android.stackexchange.R;

/**
 * Represent a dialog with a title, a progress bar and a message.
 *
 * @author Castorflex
 */
public class LoadingDialog extends DialogFragment implements Serializable {
    private static final long serialVersionUID = 6013783098831545342L;

    private final static String KEY_TITLE = "key_title";
    private final static String KEY_MSG = "key_msg";
    private final static String KEY_DETERMINATE = "key_determinate";

    private ProgressBar mProgressBar;
    private LinearLayout mLinearLayoutBot;
    private TextView mTextViewCurrentStepNb;
    private TextView mTextViewCurrentStepName;
    private TextView mTextViewMaxStep;
    private boolean mIsDeterminate;

    /**
     * Ctor
     */
    public LoadingDialog() {
    }

    /**
     * Uses this to create your dialog. then use mDialog.show();
     *
     * @param title
     * @param msg
     * @return LoadingDialog
     */
    public static LoadingDialog newInstance(String title, String msg) {
        return newInstance(title, msg, false);
    }

    /**
     * Uses this to create your dialog. then use mDialog.show();
     *
     * @param title
     * @param msg
     * @param determinate : true if there is steps, etc, false instead
     * @return LoadingDialog
     */
    public static LoadingDialog newInstance(String title, String msg,
                                            boolean determinate) {
        LoadingDialog d = new LoadingDialog();
        Bundle args = new Bundle();
        args.putString(KEY_TITLE, title);
        args.putString(KEY_MSG, msg);
        args.putBoolean(KEY_DETERMINATE, determinate);
        d.setArguments(args);
        return d;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString(KEY_TITLE);
        String msg = getArguments().getString(KEY_MSG);
        mIsDeterminate = getArguments().getBoolean(KEY_DETERMINATE, false);

        ProgressDialog.Builder b = new ProgressDialog.Builder(getActivity());

        LayoutInflater inflater = (LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = null;
        if (!mIsDeterminate) {
            view = inflater
                    .inflate(R.layout.dialog_loading_layout_global, null);
        } else {
            view = inflater.inflate(R.layout.dialog_loading_layout_determinate,
                    null);
            mProgressBar = (ProgressBar) view
                    .findViewById(R.id.progressBar_loading_dialog_determinate);
            mTextViewCurrentStepName = (TextView) view
                    .findViewById(R.id.textView_loading_dialog_current_step_name);
            mTextViewCurrentStepNb = (TextView) view
                    .findViewById(R.id.textView_loading_dialog_current_step_nb);
            mTextViewMaxStep = (TextView) view
                    .findViewById(R.id.textView_loading_dialog_max_step);
            mLinearLayoutBot = (LinearLayout) view
                    .findViewById(R.id.linearLayout_loading_dialog_step_progress);
        }

        ((TextView) view.findViewById(R.id.textView_loading_dialog_desc))
                .setText(msg);
        if (title != null && title.length() > 0) {
            b.setTitle(title);
        }
        b.setCancelable(false);
        b.setView(view);
        return b.create();
    }

    /**
     * /!\ Must be called in UI thread
     *
     * @param step new step
     */
    public void setNewStep(Step step) {
        setNewStep(step, -1, -1);
    }

    /**
     * /!\ Must be called in UI thread
     *
     * @param step new step
     */
    public void setNewStep(Step step, int currentStep, int maxStep) {
        if (mIsDeterminate) {
            if (step != null) {
                if (step.getName() != null) {
                    mTextViewCurrentStepName.setText(step.getName() + "");
                    mTextViewCurrentStepName.setVisibility(View.VISIBLE);
                } else {
                    mTextViewCurrentStepName.setVisibility(View.INVISIBLE);
                }

                if (step.getNbIter() < 0 || currentStep < 0 || maxStep < 0) {
                    mProgressBar.setIndeterminate(true);
                } else {
                    mProgressBar.setIndeterminate(false);
                    mProgressBar.setMax(step.getNbIter());
                    mProgressBar.setProgress(0);
                }
                if (currentStep < 0 || maxStep < 0) {
                    mLinearLayoutBot.setVisibility(View.INVISIBLE);
                } else {
                    mTextViewCurrentStepNb.setText(currentStep + "");
                    mTextViewMaxStep.setText(maxStep + "");
                    mLinearLayoutBot.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    /**
     * /!\ must be called in UI thread
     *
     * @param progress
     */
    public void setProgress(int progress) {
        if (mProgressBar.isIndeterminate())
            mProgressBar.setIndeterminate(false);
        mProgressBar.setProgress(progress);
    }

}
