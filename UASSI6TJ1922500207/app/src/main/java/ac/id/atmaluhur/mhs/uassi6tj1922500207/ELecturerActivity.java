package ac.id.atmaluhur.mhs.uassi6tj1922500207;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;

    public class ELecturerActivity extends AppCompatActivity{
    private EditText txtNidn, txtNama_dosen, txtJabtan, txtGol_pang, txtbidangkeahlian, txtProgram_studi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electurer);

        txtNidn = (EditText) findViewById(R.id.et_nidn);
        txtNama_dosen = (EditText) findViewById(R.id.et_nama_dosen);
        txtJabtan = (EditText) findViewById(R.id.et_jabatan);
        txtGol_pang = (EditText) findViewById(R.id.et_golonganpangkat);
        txtbidangkeahlian = (EditText) findViewById(R.id.et_bidangkeahlian);
        txtProgram_studi = (EditText) findViewById(R.id.et_programstudi);
    }

    public void kembalidashbord(View View){
        Intent i = new Intent(ELecturerActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void simpandata(View View) {
        final String Nidn=txtNidn.getText().toString().trim();
        final String Nama_dosen=txtNama_dosen.getText().toString().trim();
        final String Jabatan=txtJabtan.getText().toString().trim();
        final String Gol_pang=txtGol_pang.getText().toString().trim();
        final String Keahlian=txtbidangkeahlian.getText().toString().trim();
        final String Program_studi= txtProgram_studi.getText().toString().trim();

        class simpandata extends AsyncTask<Void, Void,String> {
            ProgressDialog load;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                load = ProgressDialog.show(
                        ELecturerActivity.this, "Add ...", "Wait..",
                        false, false );
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put("nidn", Nidn);
                params.put("nama_dosen", Nama_dosen);
                params.put("jabatan", Jabatan);
                params.put("gol_pang", Gol_pang);
                params.put("keahlian", Keahlian);
                params.put("program_studi", Program_studi);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest( "http://192.168.1.18/campuss/tambah_lecturer.php", params);
                return res;

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                load.dismiss();
                Toast.makeText(ELecturerActivity.this, s, Toast.LENGTH_LONG).show();
            }
        }

        simpandata tb = new simpandata();
        tb.execute();
    }
}