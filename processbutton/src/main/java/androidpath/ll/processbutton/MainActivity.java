package androidpath.ll.processbutton;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static ProcessButton processButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        processButton = (ProcessButton) findViewById(R.id.ButtonLayout01);
        processButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                processButton.animation(); // Need to call this method for
                // animation and progression

                if (processButton.flg_frmwrk_mode == 1) {

                    // Start state. Call any method that you want to execute

                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            Toast.makeText(MainActivity.this,
                                    "Starting download", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    });
                    new DownLoadSigTask().execute();
                }
                if (processButton.flg_frmwrk_mode == 2) {

                    // Running state. Call any method that you want to execute

                    new DownLoadSigTask().cancel(true);
                    processButton.stop();
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            Toast.makeText(MainActivity.this,
                                    "Download stopped", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    });
                }
                if (processButton.flg_frmwrk_mode == 3) {

                    // End state. Call any method that you want to execute.

                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            Toast.makeText(MainActivity.this,
                                    "Download complete", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    });
                }
            }

        });
    }

    static class DownLoadSigTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(final String... args) {

            // Creating dummy task and updating progress

            for (int i = 0; i <= 100;) {
                try {
                    Thread.sleep(50);

                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                if (processButton.flg_frmwrk_mode == 2 &&i<=100){
                    i++;
                    publishProgress(i);
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {

            // publishing progress to progress arc

            processButton.cusView.setupprogress(progress[0]);
        }

    }

}