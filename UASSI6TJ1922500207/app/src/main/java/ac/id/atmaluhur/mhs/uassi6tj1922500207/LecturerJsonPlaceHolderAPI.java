package ac.id.atmaluhur.mhs.uassi6tj1922500207;

import java.util.List;
import retrofit2.http.GET;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.QueryMap;

public interface LecturerJsonPlaceHolderAPI {
    @GET("lecturer.php")
    Call<List<LecturerPost>> getPosts(

    );
    @GET("lecturer.php")
    Call<List<LecturerPost>> getPosts(@QueryMap Map<String, String> parameters);
}
