package com.example.last_project.conn;

public class PDFDownload extends Thread{
//    String File_Name = "확장자를 포함한 파일명";
//    String File_extend = "확장자명";
//
//    String fileURL = "웹서버 쪽 파일이 있는 경로"; // URL
//    String Save_Path;
//    String Save_folder = "/mydown";
//
//    ProgressBar loadingBar;
//  //  DownloadThread dThread;
//
//    String ServerUrl;
//        String LocalPath;
//
//    public PDFDownload(String serverUrl, String localPath) {
//        ServerUrl = serverUrl;
//        LocalPath = localPath;
//    }
//
//    @Override
//    public void run() {
//        super.run();
//        URL imgurl;
//        int Read;
//        try {
//            imgurl = new URL(ServerUrl);
//            HttpURLConnection conn = (HttpURLConnection) imgurl
//                    .openConnection();
//            int len = conn.getContentLength();
//            byte[] tmpByte = new byte[len];
//            InputStream is = conn.getInputStream();
//            File file = new File(LocalPath);
//            FileOutputStream fos = new FileOutputStream(file);
//            for (;;) {
//                Read = is.read(tmpByte);
//                if (Read <= 0) {
//                    break;
//                }
//                fos.write(tmpByte, 0, Read);
//            }
//            is.close();
//            fos.close();
//            conn.disconnect();
//
//        } catch (MalformedURLException e) {
//            Log.e("ERROR1", e.getMessage());
//        } catch (IOException e) {
//            Log.e("ERROR2", e.getMessage());
//            e.printStackTrace();
//        }
//        mAfterDown.sendEmptyMessage(0);
//    }
//
//    Handler mAfterDown = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            // TODO Auto-generated method stub
//            loadingBar.setVisibility(View.GONE);
//            // 파일 다운로드 종료 후 다운받은 파일을 실행시킨다.
//            showDownloadFile();
//        }
//
//    };
}
