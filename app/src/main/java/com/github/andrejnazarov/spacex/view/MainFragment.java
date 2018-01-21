package com.github.andrejnazarov.spacex.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.andrejnazarov.spacex.R;
import com.github.andrejnazarov.spacex.bean.LaunchItem;
import com.github.andrejnazarov.spacex.presenter.PagePresenter;
import com.github.andrejnazarov.spacex.presenter.PagePresenterImpl;

public class MainFragment extends Fragment implements View.OnClickListener, PageView {

    private static final String EXTRA_LAUNCH_ITEM = "extra_launch_item";

    private LaunchItem mLaunchItem;
    private ImageView mImageView;
    private TextView mTextView;
    private PagePresenter mPagePresenter;

    private OnFragmentInteractionListener mListener;

    public static MainFragment newInstance(LaunchItem item) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putParcelable(EXTRA_LAUNCH_ITEM, item);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mLaunchItem = getArguments().getParcelable(EXTRA_LAUNCH_ITEM);
        }
        mPagePresenter = new PagePresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mImageView = view.findViewById(R.id.image_view);
        mTextView = view.findViewById(R.id.text_view);
        mTextView.setText(mLaunchItem.toString());
        mPagePresenter.getBitmap(mLaunchItem.getLinks().getLinks().get(0));
        // TODO: 21.01.18 set data to views
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnFragmentInteractionListener) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            mListener.onFragmentInteraction("");
        }
    }

    @Override
    public void showImage(final Bitmap bitmap) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mImageView.setImageBitmap(bitmap);
            }
        });
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String url);
    }
}