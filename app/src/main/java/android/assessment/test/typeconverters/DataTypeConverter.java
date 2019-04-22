package android.assessment.test.typeconverters;

import android.arch.persistence.room.TypeConverter;
import android.assessment.test.models.MediaMetadata;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class DataTypeConverter {
    @TypeConverter
    public static String[] fromString(String value) {
        Type listType = new TypeToken<MediaMetadata[]>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromListToInteger(MediaMetadata[] list) {
        return new Gson().toJson(list);
    }

}
