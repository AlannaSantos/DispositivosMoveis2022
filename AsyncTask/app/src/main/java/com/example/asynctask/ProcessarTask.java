package com.example.asynctask;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

public class ProcessarTask extends AsyncTask<Void, Integer, String> {

    int i = 10;
    private Button btnProcessar;
    private TextView txtContador;

    public ProcessarTask(Button btnProcessar, TextView txtContador) {
        this.btnProcessar = btnProcessar;
        this.txtContador = txtContador;
    }

    @Override
    protected void onPreExecute() {
        btnProcessar.setEnabled(true);
    }

    @Override
    protected String doInBackground(Void... voids) {

        for (; i>=0; i--){
            publishProgress(i);
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "finalizado";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        txtContador.setText(String.valueOf(values[0]));
        btnProcessar.setEnabled(false);
    }

    @Override
    protected void onPostExecute(String s) {
        txtContador.setText(s);
        btnProcessar.setEnabled(true);
    }
}
