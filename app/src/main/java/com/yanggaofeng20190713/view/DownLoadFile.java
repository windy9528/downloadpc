package com.yanggaofeng20190713.view;

import android.content.Context;

/**
 * date:2019/7/13
 * name:windy
 * function:
 */
public class DownLoadFile {

    //线程状态
    private static final String THREAD_INIT = "1";
    private static final String THREAD_ING = "2";
    private static final String THREAD_PAUSE = "3";

    private String loadUrl;  //下载地址
    private String filePath;  //存储地址
    private int threadCount = 4; //线程数量

    private int fileLength;  //文件总长度
    //使用volatile  防止多线程不安全
    private volatile int currLength;  //当前总共现在的大小
    private volatile int runningThreadCount; //当前在运行的线程数
    private Thread[] threads; //
    private String threadState = THREAD_INIT; //线程状态  默认为初始化

    private Context context;
    private DownLoadListener downLoadListener;

    public void setDownLoadListener(DownLoadListener downLoadListener) {
        this.downLoadListener = downLoadListener;
    }

    public interface DownLoadListener {
        //当前下载的百分比
        void getProgress(int progress);

        //下载完成
        void onComplete();

        //下载失败 (异常。。)
        void onFail();
    }

    public DownLoadFile(Context context, String loadUrl, String filePath, int threadCount) {

    }
}
