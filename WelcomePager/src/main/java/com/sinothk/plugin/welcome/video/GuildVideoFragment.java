package com.sinothk.plugin.welcome.video;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

/**
 * Created by 梁玉涛 on 2016-11-10.
 */

public class GuildVideoFragment extends Fragment {

    private CustomVideoView customVideoView;

    private GuildVideoFragment() {
    }

    public static Fragment getInstance(int videoResId) {
        Fragment fragment = new GuildVideoFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("videoResId", videoResId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        customVideoView = new CustomVideoView(getContext());

        assert getArguments() != null;
        int videoResId = getArguments().getInt("videoResId");

        /*播放视频**/
        Uri uri = Uri.parse("android.resource://" + Objects.requireNonNull(getActivity()).getPackageName() + "/" + videoResId);
        customVideoView.playVideo(uri);
        return customVideoView;
    }

    /**
     * 记得在销毁的时候让播放的视频终止
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (customVideoView != null) {
            customVideoView.stopPlayback();
        }
    }
}
