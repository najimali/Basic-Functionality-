package com.example.nazi.practice.Examples;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.nazi.practice.R;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class AsyncTaskEx extends AppCompatActivity {
    private Button btnPlayMusic;
    private MediaPlayer mPlayer;
    private ProgressDialog prgDialog;
    private final int prg_bar_type=0;
    private final static String file_url="http://programmerguru.com/android-tutorial/wp-content/uploads/2014/01/jai_ho.mp3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aync_task_ex);

        btnPlayMusic = findViewById(R.id.btn_nprg_Dailog);
        btnPlayMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPlayMusic.setEnabled(false);
                File file=new File(Environment.getExternalStorageDirectory().getPath()+"/jai_ho.mp3");
                if(file.exists())
                {
                    Toast.makeText(getApplicationContext(),"File already exist under SD card, playing Music",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),
                            "File doesn't exist under SD Card, downloading Mp3 from Internet",Toast.LENGTH_SHORT).show();
                }
                new DownloadFromInternet().execute(file_url);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id)
        {
            case prg_bar_type:
                prgDialog=new ProgressDialog(this);
                prgDialog.setMessage("Downloading Mp3 file. Please wait...");
                prgDialog.setIndeterminate(true);
                prgDialog.setMax(100);
                prgDialog.setCancelable(false);//This method sets the property that the dialog can be cancelled or not
                prgDialog.show();
                return prgDialog;
                default:
                return null;
        }


    }
    /*three parameter in AsyncTask are <Params,Progress,Result>
    1.Params, the type of the parameters sent to the task upon execution.(Use in doInBackgorund)
    doInBackground - This step can also use publishProgress(Progress...)
    2.Progress, the type of the progress units published during the background computation.(Use in onProgressExecute)
    3.Result, the type of the result of the background computation.(Use in onPostExecute)*/


    class DownloadFromInternet extends AsyncTask<String,String,String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(prg_bar_type);
        }

        @Override
        protected String doInBackground(String... f_url) {
            int count;
            try {
                URL url=new URL(file_url);
                URLConnection connection =url.openConnection();
                connection.connect();
                int lengthOfFile = connection.getContentLength();
                InputStream inputStream = new BufferedInputStream(url.openStream(),10*1024);
                OutputStream outputStream=new FileOutputStream(Environment.getExternalStorageDirectory().getPath()+"/jai_ho.mp3");

                byte[] data = new byte[1024];
                long totalSize=0;
                while((count=inputStream.read(data))!= -1)
                {
                    totalSize+=count;
                    /*publishProgress(Progress... values)
                    This method can be invoked from doInBackground(Params...)
                    to publish updates on the UI thread while the background computation is still running.*/
                    publishProgress(" "+((totalSize*100)/lengthOfFile));
                    outputStream.write(data,0,count);
                    outputStream.flush();
                    outputStream.close();
                    inputStream.close();
                }


            }catch (Exception e)
            {
                Log.e("Error :", e.getMessage());
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(String... progress) {

            prgDialog.setProgress(Integer.parseInt(progress[0]));

        }

        @Override
        protected void onPostExecute(String file_url) {
            dismissDialog(prg_bar_type);
            Toast.makeText(getApplicationContext(),"Download complete, playing Music",Toast.LENGTH_SHORT).show();
            playMusic();

        }
    }
    protected void playMusic()
    {
        Uri myUri = Uri.parse("file:///sdcard/jai_ho.mp3");
        mPlayer = new MediaPlayer();
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try
        {
            mPlayer.setDataSource(getApplication(),myUri);
            mPlayer.prepare();
            mPlayer.start();
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                    btnPlayMusic.setEnabled(true);
                    Toast.makeText(getApplicationContext(),"Music completed playing",Toast.LENGTH_SHORT).show();

                }
            });
        }
        catch (IllegalArgumentException e) {

            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();

        } catch (SecurityException e) {

            Toast.makeText(getApplicationContext(), "URI cannot be accessed, permissed needed", Toast.LENGTH_LONG).show();

        } catch (IllegalStateException e) {

            Toast.makeText(getApplicationContext(), "Media Player is not in correct state", Toast.LENGTH_LONG).show();

        } catch (IOException e) {

            Toast.makeText(getApplicationContext(), "IO Error occured", Toast.LENGTH_LONG).show();

        }

    }








}
