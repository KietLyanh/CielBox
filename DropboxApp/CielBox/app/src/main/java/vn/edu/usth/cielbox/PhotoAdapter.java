package vn.edu.usth.cielbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    private Context mcontect;
    private List<Uri> mListphoto;

    public PhotoAdapter(Context mcontect) {
        this.mcontect = mcontect;
    }

    public void setData(List<Uri> list) {
        this.mListphoto = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_gallery, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        Uri uri = mListphoto.get(position);
        if (uri == null) {
            return;
        }

        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(mcontect.getContentResolver(), uri);
            if (bitmap != null) {
                holder.imgPhoto.setImageBitmap(bitmap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        if (mListphoto != null) {
            return mListphoto.size();
        }
        return 0;
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgPhoto;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.imgphoto);
        }
    }
}
