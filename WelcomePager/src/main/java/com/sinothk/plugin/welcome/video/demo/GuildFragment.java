//package com.sinothk.plugin.welcome.video.demo;
//
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//import com.sinothk.plugin.welcome.video.CustomVideoView;
//
///**
// * Created by yuandl on 2016-11-10.
// */
//
//public class GuildFragment extends Fragment {
//
//    private CustomVideoView customVideoView;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        customVideoView = new CustomVideoView(getContext());
//        /**获取参数，根据不同的参数播放不同的视频**/
//        int index = getArguments().getInt("index");
//        Uri uri;
//        if (index == 1) {
//            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_1);
//        } else if (index == 2) {
//            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_2);
//        } else {
//            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_3);
//        }
//        /**播放视频**/
//        customVideoView.playVideo(uri);
//        return customVideoView;
//    }
//
//    /**
//     * 记得在销毁的时候让播放的视频终止
//     */
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        if (customVideoView != null) {
//            customVideoView.stopPlayback();
//        }
//    }
//}
