package com.yanggaofeng20190713.view;

import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.yanggaofeng20190713.R;
import com.yanggaofeng20190713.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.iv_image)
    SimpleDraweeView ivImage;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.tv_progress)
    TextView tvProgress;
    @BindView(R.id.btn_download)
    Button btnDownload;
    @BindView(R.id.btn_pause)
    Button btnPause;
    @BindView(R.id.btn_continue)
    Button btnContinue;
    private String loadUrl;  //下载图片地址
    private String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "用户头像.jpg";
    private DownLoadFile downLoadFile;

    @Override
    protected void initData() {
        downLoadFile = new DownLoadFile(this, loadUrl, filePath, 3);
    }

    @Override
    protected void initView() {
        loadUrl = SPUtils.getInstance().getString("loadUrl", "");
        System.out.println(loadUrl);
    }

    /**
     * butterknife点击事件
     *
     * @param view
     */
    @OnClick({R.id.btn_continue, R.id.btn_pause, R.id.btn_download})
    public void clickListener(View view) {
        switch (view.getId()) {
            case R.id.btn_download:
//                downLoadFile.downLoad(); //下载
                break;
            case R.id.btn_pause:
//                downLoadFile.pause();  //暂停
                break;
            case R.id.btn_continue:
//                downLoadFile.continues();  //继续下载
                break;
        }
    }

    @Override

    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void destoryData() {

    }
}
