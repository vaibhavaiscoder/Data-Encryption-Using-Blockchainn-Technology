package com.eagb.blockchainexample.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.eagb.blockchainexample.R;
import com.eagb.blockchainexample.databinding.FragmentMoreInfoBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MoreInfoFragment extends DialogFragment implements View.OnClickListener {

    private FragmentMoreInfoBinding viewBinding;

    private Context mContext;

    public MoreInfoFragment() {
        // Required empty public constructor
    }

    public static MoreInfoFragment newInstance() {
        return new MoreInfoFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        mContext = context.getApplicationContext();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewBinding = FragmentMoreInfoBinding.inflate(getLayoutInflater(), container, false);
        return viewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewBinding.btnClose.setOnClickListener(this);
        viewBinding.llCheckRepo.setOnClickListener(this);
        viewBinding.txtHeart.setOnClickListener(this);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
    }

    @Override
    public void onClick(@NonNull View view) {
        String url;

        if (R.id.btn_close == view.getId()) {
            dismiss();
        }  else if (R.id.ll_check_repo == view.getId()) {
            // Checking the official repo to fork
            url = "https://github.com/vaibhavaiscoder";
            openUrl(url);
        } else if (R.id.txt_heart == view.getId()) {
            // Showing an EasterEgg
            Toast.makeText(mContext, R.string.text_thank_you, Toast.LENGTH_SHORT).show();
        }
    }

    private void openUrl(@NonNull String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void onDetach() {
        super.onDetach();

        viewBinding = null;
        mContext = null;
    }
}
