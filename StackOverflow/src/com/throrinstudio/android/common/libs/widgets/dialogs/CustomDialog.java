package com.throrinstudio.android.common.libs.widgets.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.throrinstudio.android.common.libs.widgets.adapters.MenuItemAdapter;
import com.throrinstudio.android.stackexchange.R;

public class CustomDialog extends DialogFragment {

    private String mTitle;
    private String mContent;
    private String mPositiveLabel;
    private String mNegativeLabel;
    private Drawable mIconTitle;
    private View mView;
    private boolean mKeyboard;
    private boolean mRemovePadding = false;

    private OnClickListener mNegativeListener;
    private OnClickListener mPositiveListener;

    private MenuItemAdapter mAdapter;
    private DialogInterface.OnClickListener mListListener;
    private OnResumeListener mResumeListener;
    private OnDismissListener mOnDismissListener;
    private OnShowListener mShowListener;
	private OnCancelListener mOnCancelListener;

    private CustomDialog(Context ctx, String title, Drawable icon, int LayoutView) {
        super();
        mKeyboard = false;
        mTitle = title;
        mIconTitle = icon;

        mNegativeListener = new OnClickListener() {
            @Override
            public void onClick(Dialog dialog) {
                dialog.dismiss();
            }
        };
        mPositiveListener = new OnClickListener() {
            @Override
            public void onClick(Dialog dialog) {
                dialog.dismiss();
            }
        };

        mPositiveLabel = ctx.getString(R.string.global_submit);
        mNegativeLabel = ctx.getString(R.string.global_cancel);


        LayoutInflater inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mView = inflater.inflate(LayoutView, null);
    }

    private CustomDialog(Context ctx, String title, String content) {
    	super();
        mTitle = title;
        mContent = content;
        mKeyboard = false;
        mNegativeListener = new OnClickListener() {
            @Override
            public void onClick(Dialog dialog) {
                dialog.dismiss();
            }
        };
        mPositiveListener = new OnClickListener() {
            @Override
            public void onClick(Dialog dialog) {
                dialog.dismiss();
            }
        };

        mPositiveLabel = ctx.getString(R.string.global_submit);
        mNegativeLabel = ctx.getString(R.string.global_cancel);
    }

    private CustomDialog(Context ctx, String title, Drawable icon, View LayoutView) {
        super();
        mKeyboard = false;
        mTitle = title;
        mIconTitle = icon;

        mNegativeListener = new OnClickListener() {
            @Override
            public void onClick(Dialog dialog) {
                dialog.dismiss();
            }
        };
        mPositiveListener = new OnClickListener() {
            @Override
            public void onClick(Dialog dialog) {
                dialog.dismiss();
            }
        };

        mPositiveLabel = ctx.getString(R.string.global_submit);
        mNegativeLabel = ctx.getString(R.string.global_cancel);

        mView = LayoutView;
    }

    private CustomDialog(Context ctx, String title, MenuItemAdapter adapter, DialogInterface.OnClickListener listener) {
        super();
        mKeyboard = false;
        mTitle = title;
        mAdapter = adapter;
        mListListener = listener;
    }

    public void setKeyboardVisible(boolean visible) {
        mKeyboard = visible;
    }

    public static CustomDialog newInstance(Context ctx, String title, int viewLayout) {
        return newInstance(ctx, title, null, viewLayout);
    }

    public static CustomDialog newInstance(Context ctx, String title, Drawable img, int viewLayout) {
        CustomDialog i = new CustomDialog(ctx, title, img, viewLayout);

        return i;
    }

    public static CustomDialog newInstance(Context ctx, String title, String content) {
        CustomDialog i = new CustomDialog(ctx, title, content);

        return i;
    }

    public static CustomDialog newInstance(Context ctx, String title, View viewLayout) {
        return newInstance(ctx, title, null, viewLayout);
    }

    public static CustomDialog newInstance(Context ctx, String title, Drawable img, View viewLayout) {
        CustomDialog i = new CustomDialog(ctx, title, img, viewLayout);

        return i;
    }

    public static CustomDialog newInstance(Context ctx, String title, MenuItemAdapter adapter, DialogInterface.OnClickListener listener) {
        CustomDialog i = new CustomDialog(ctx, title, adapter, listener);
        return i;
    }

    public View getCustomView() {
        return mView;
    }

    public void setPositiveLabel(String label) {
        mPositiveLabel = label;
    }

    public void setNegativeLabel(String label) {
        mNegativeLabel = label;
    }

    public void setView(View view) {
        mView = view;
    }

    public void setPositiveListener(OnClickListener listener) {
        mPositiveListener = listener;
    }

    public void setNegativeListener(OnClickListener listener) {
        mNegativeListener = listener;
    }

    public void setPositiveButton(String label, OnClickListener listener) {
        mPositiveLabel = label;
        mPositiveListener = listener;
    }

    public void setNegativeButton(String label, OnClickListener listener) {
        mNegativeLabel = label;
        mNegativeListener = listener;
    }

    public void setTitle(String title) {
        mTitle = title;
        if (getDialog() != null) {
            getDialog().setTitle(mTitle);
        }
    }

    public void removePadding() {
        mRemovePadding = true;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder b = null;

        if (mView != null) {
            b = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.AppTheme));
        } else {
            b = new AlertDialog.Builder(getActivity());
        }
        b.setTitle(mTitle);

        if (mAdapter == null) {
            b.setPositiveButton(mPositiveLabel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            b.setNegativeButton(mNegativeLabel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            if (mView != null)
                b.setView(mView);
            else
                b.setMessage(mContent);
        } else {
            b.setAdapter(mAdapter, mListListener);
        }

        if (mIconTitle != null) {
            b.setIcon(mIconTitle);
        }

        b.setCancelable(false);


        AlertDialog a = b.create();
        a.setCanceledOnTouchOutside(false);

        return a;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (mKeyboard)
            getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

        if (mRemovePadding && mView != null) {
            ViewGroup parent = (ViewGroup) mView.getParent();
            parent.setPadding(0, 0, 0, 0);
            parent.invalidate();
        }

        if (mAdapter == null) {
            final AlertDialog alertDialog = (AlertDialog) getDialog();
            Button okButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);

            if (okButton != null) {
                okButton.setText(mPositiveLabel);
                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mPositiveListener != null)
                            mPositiveListener.onClick(alertDialog);
                        else
                            performOkButtonAction();

                    }
                });
            }

            Button cancelButton = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
            if (cancelButton != null) {
                cancelButton.setText(mNegativeLabel);
                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mNegativeListener != null)
                            mNegativeListener.onClick(alertDialog);
                        else
                            performCancelButtonAction();
                    }
                });
            }

        }

        if (mResumeListener != null) {
            mResumeListener.onResume(getDialog());
        }
    }
    
    

	@Override
	public void dismiss() {
		if(mOnDismissListener != null)
			mOnDismissListener.onDismiss(getDialog());

		super.dismiss();
	}
	

	@Override
	public void show(FragmentManager manager, String tag) {
		if(mShowListener != null){
			mShowListener.onShow(getDialog());
		}
		
		super.show(manager, tag);
	}


	@Override
	public int show(FragmentTransaction transaction, String tag) {
		if(mShowListener != null){
			mShowListener.onShow(getDialog());
		}
		
		return super.show(transaction, tag);
	}
	

	@Override
	public void onCancel(DialogInterface dialog) {
		
		if(mOnCancelListener != null)
			mOnCancelListener.onCancel(dialog);
		if(mOnDismissListener != null)
			mOnDismissListener.onDismiss(getDialog());
		
		super.onCancel(dialog);
	}

	private void performOkButtonAction() {
        // Do your stuff here
    }

    private void performCancelButtonAction() {

    }

    public void setOnResume(OnResumeListener l) {
        mResumeListener = l;
    }
    
    public void setOnDismissListener(OnDismissListener l){
    	mOnDismissListener = l;
    }
    
    public void setOnShowListener(OnShowListener l){
    	mShowListener = l;
    }
    
    public void setOnCancelListener(OnCancelListener l){
    	mOnCancelListener = l;
    }

    public Button getButton(int buttonPositive) {
        if (getDialog() != null) {
            return ((AlertDialog) getDialog()).getButton(buttonPositive);
        }
        return null;
    }

    public interface OnClickListener {
        public void onClick(Dialog d);
    }

    public interface OnResumeListener {
        public void onResume(Dialog d);
    }
    
    public interface OnDismissListener {
    	public void onDismiss(Dialog d);
    }

    public interface OnShowListener {
    	public void onShow(Dialog d);
    }
    
    public interface OnCancelListener {
    	public void onCancel(DialogInterface d);
    }
}
