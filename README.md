# WelcomeVideoPager
来自：https://codeload.github.com/linglongxin24/WelcomeVideoPager/zip/master


# 引入
## Step 1. Add the JitPack repository to your build file
  Add it in your root build.gradle at the end of repositories:

    allprojects {
      repositories {
        ...
        maven { url 'https://www.jitpack.io' }
      }
    }

## Step 2. Add the dependency
    dependencies {
            implementation 'com.github.sinothk:WelcomePager:1.x.1010'
    }

# 使用
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
            // 添加视频文件：guide_1、guide_2、guide_3
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
