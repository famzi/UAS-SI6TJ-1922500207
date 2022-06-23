package ac.id.atmaluhur.mhs.uassi6tj1922500207;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private LecturerJsonPlaceHolderAPI jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_lecturer_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.18/campuss/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(LecturerJsonPlaceHolderAPI.class);
        getPosts();
    }

    public void btn_tambah(View View){
        Intent i = new Intent(MainActivity.this, ELecturerActivity.class);
        startActivity(i);
    }

    private void getPosts() {
        Map<String, String> parameters = new HashMap<>();
        Call<List<LecturerPost>> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<LecturerPost>>() {
            @Override
            public void onResponse(Call<List<LecturerPost>> call, Response<List<LecturerPost>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: "+ response.code());
                    return;
                }
                List<LecturerPost> posts = response.body();
                for (LecturerPost post : posts) {
                    String content = "";
                    content += "nidn: " + post.getnidn() + "\n";
                    content += "nama_dosen: " + post.getnama_dosen() + "\n";
                    content += "jabatan: " + post.getjabatan() + "\n";
                    content += "gol_pang: " + post.getgol_pang() + "\n";
                    content += "keahlian: " + post.getkeahlian() + "\n";
                    content += "program_studi: " + post.getprogram_studi() + "\n\n";
                    textViewResult.append(content);
                }
            }
            @Override
            public void onFailure(Call<List<LecturerPost>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}