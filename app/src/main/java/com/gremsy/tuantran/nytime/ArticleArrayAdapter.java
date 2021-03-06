package com.gremsy.tuantran.nytime;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticleArrayAdapter extends ArrayAdapter<Article>{

    public ArticleArrayAdapter(Context context, List<Article> articles){
        super(context, android.R.layout.simple_list_item_1, articles);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get data item
        Article article = this.getItem(position);
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_article_result, parent, false);
        }

        // Find the image view
        ImageView imageView = (ImageView)convertView.findViewById(R.id.ivImage);
        // Clear out recycled image
        imageView.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        tvTitle.setText(article.getHeadline());

        // Populate thumbnail image
        String thumbnail = article.getThumbNail();
        if(!TextUtils.isEmpty(thumbnail)) {
            Picasso.with(getContext()).load(thumbnail).placeholder(R.drawable.ic_placeholder).fit().into(imageView);
        }
        return convertView;
    }
}
