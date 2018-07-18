package com.martin.myapplication.activities


import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.martin.myapplication.R
import com.martin.myapplication.others.ToolbarActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picasso.*
import java.lang.Exception

class PicassoActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)

        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)

        buttonLoader.setOnClickListener { loadImages() }

        Picasso.get().load("https://static.pexels.com/photos/288264/pexels-photo-288264.jpeg").fetch()

    }

    fun loadImages(){
        Picasso
                .get()
                .load("https://static.pexels.com/photos/288264/pexels-photo-288264.jpeg")
                .fit() //redimensiona al tamaño de la imageview
                //.resize(300,300)  //redimensiona a la medida pasada
                //.centerInside() //en caso de hacer un resize para que quede centrado
                .into(imageViewTop)

//       Picasso
//                .get()
//                .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
//                .fit()
//                .into(imageViewBottom)

//Circular image
//       Picasso
//                .get()
//                .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
//                .fit()
//                .transform(CircleTransform()) //Renderizo como un circulo
//                .into

//Animated image
        Picasso
                .get()
                .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
                .fetch(object: Callback {
                    override fun onSuccess() {
                        imageViewBottom.alpha = 0f
                        Picasso
                                .get()
                                .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
                                .fit()
                                .into(imageViewBottom)
                        imageViewBottom.animate().setDuration(1300).alpha(1f).start()
                    }

                    override fun onError(e: Exception?) {
                    }

                })
    }
}
