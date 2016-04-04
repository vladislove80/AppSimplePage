/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.com.appsimplepage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Image adapter class.
 * @version 2016.001
 *
 * Use Picasso 2.5.2
 * @link http://square.github.io/picasso/
 * Use ViewHolder inner class. Inflate different layout depending on screen size.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder>{

    private String[] mImagesURLs;
    private Context context; //[Comment] Wrong name

    /**
     * ImageAdapter constructor
     * @param context
     * @param mImagesURLs
     *
     * @see RecyclerView.Adapter
     */
    public ImageAdapter(Context context, String[] mImagesURLs){
        this.context = context;
        this.mImagesURLs = mImagesURLs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(context)
                .load(mImagesURLs[position])
                .placeholder(R.drawable.loading)
                .resize(360, 360)
                .error(R.drawable.not_found)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mImagesURLs.length;
    }

    /**
     * Inner class ViewHolder
     * @see ViewHolder
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.img_android);
        }
    }
}
