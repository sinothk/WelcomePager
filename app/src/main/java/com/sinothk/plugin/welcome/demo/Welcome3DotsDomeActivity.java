package com.sinothk.plugin.welcome.demo;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.sinothk.plugin.welcome.video.GuildVideoFragment;
import com.sinothk.plugin.welcome.video.Welcome3DotsActivity;
import java.util.ArrayList;
import java.util.List;

public class Welcome3DotsDomeActivity extends Welcome3DotsActivity {

    @Override
    protected List<Fragment> initWelcomeData() {
        List<Fragment> fs = new ArrayList<>();
        fs.add(GuildVideoFragment.getInstance(R.raw.guide_1));
        fs.add(GuildVideoFragment.getInstance(R.raw.guide_2));
        fs.add(GuildVideoFragment.getInstance(R.raw.guide_3));
        return fs;
    }

    @Override
    protected View.OnClickListener getStartBtnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome3DotsDomeActivity.this, Welcome3DotsDemoMainActivity.class));
                finish();
            }
        };
    }
}
