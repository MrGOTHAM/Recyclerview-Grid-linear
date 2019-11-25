package com.example.work11.dialogfragment;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.bumptech.glide.Glide;
import com.example.work11.R;

public class EditNameDialogFragment3 extends DialogFragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);     // 取消对话框标题
//        setCancelable(false);                                          // 对话框不可取消
        getDialog().setCanceledOnTouchOutside(false);                  // 点击非dialogFragment无效

        View view = inflater.inflate(R.layout.layout2,container,false);
        ImageView imageView  = view.findViewById(R.id.glide_image);
        Glide.with(getActivity())
                .asGif()                            //作为gif加载
                .load(R.drawable.gif123)            //图片地址
                .placeholder(R.mipmap.ic_launcher)  // 占位符
                .error(R.mipmap.ic_launcher_round)  // 错误加载图片
                .into(imageView);                   //锁定的imageView
        return view;
    }
}
