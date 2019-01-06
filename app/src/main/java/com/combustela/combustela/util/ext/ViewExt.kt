package com.combustela.combustela.util.ext

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.os.Build
import android.support.annotation.ColorInt
import android.support.annotation.StringRes
import android.support.design.chip.Chip
import android.support.design.chip.ChipGroup
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.TranslateAnimation
import timber.log.Timber


var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

var View.isVisibleWithDelay: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        if (value)
            animate()
                    .alpha(1.0f)
                    .setDuration(300)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            super.onAnimationEnd(animation)
                            visibility = View.VISIBLE
                        }
                    })
        else animate()
                .alpha(0.0f)
                .setDuration(300)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                        alpha = 1.0f
                        visibility = View.GONE
                    }
                })
    }

fun Context.inflateLayout(layoutResId: Int): View {
    return inflateView(this, layoutResId, null, false)
}

fun Context.inflateLayout(layoutResId: Int, parent: ViewGroup): View {
    return inflateLayout(layoutResId, parent, true)
}

fun Context.inflateLayout(layoutResId: Int, parent: ViewGroup, attachToRoot: Boolean): View {
    return inflateView(this, layoutResId, parent, attachToRoot)
}

private fun inflateView(context: Context, layoutResId: Int, parent: ViewGroup?, attachToRoot: Boolean): View {
    return LayoutInflater.from(context).inflate(layoutResId, parent, attachToRoot)
}


fun View.showSnackbar(message: String, length: Int = Snackbar.LENGTH_LONG, f: (Snackbar.() -> Unit) = {}) {
    val snack = Snackbar.make(this, message, length)
    snack.f()
    snack.show()
}

fun View.showSnackbar(@StringRes message: Int, length: Int = Snackbar.LENGTH_LONG, f: (Snackbar.() -> Unit) = {}) {
    showSnackbar(resources.getString(message), length, f)
}

fun Snackbar.action(action: String, @ColorInt color: Int? = null, listener: (View) -> Unit) {
    setAction(action, listener)
    color?.let { setActionTextColor(color) }
}

fun View.toVisible() {
    visibility = View.VISIBLE
}

fun View.toGone() {
    visibility = View.GONE
}


fun View.convertPixelsToDp(px: Float): Float {
    val resources = context.resources
    val metrics = resources.displayMetrics
    return px / (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}

fun View.convertDpToPixel(dp: Float): Float {
    val resources = context.resources
    val metrics = resources.displayMetrics
    return dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}


fun View.isGone() = visibility == View.GONE

var View.elevationForPostLollipop: Float
    get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        elevation
    } else {
        0F
    }
    set(value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            elevation = value
        }
    }


fun View.shrink(duration: Long = 150) {
    Timber.w("Shrinking $this")
    this.pivotX = width / 2f
    this.pivotY = height / 2f

    var xScale = ObjectAnimator.ofFloat(this, View.SCALE_X, 1f, 0f)
    xScale.duration = duration
    xScale.interpolator = AccelerateDecelerateInterpolator()

    var yScale = ObjectAnimator.ofFloat(this, View.SCALE_Y, 1f, 0f)
    yScale.duration = duration
    yScale.interpolator = AccelerateDecelerateInterpolator()


    xScale.addListener(object : Animator.AnimatorListener {
        override fun onAnimationRepeat(p0: Animator?) {
        }

        override fun onAnimationEnd(p0: Animator?) {
            this@shrink.visibility = View.GONE
        }

        override fun onAnimationStart(p0: Animator?) {
        }

        override fun onAnimationCancel(p0: Animator?) {
        }

    })

    var animatorSet = AnimatorSet()
    animatorSet.playTogether(xScale, yScale)
    animatorSet.start()
}


fun View.grow(duration: Long = 150) {
    Timber.w("Growing $this")
    this.pivotX = width / 2f
    this.pivotY = height / 2f

    var xScale = ObjectAnimator.ofFloat(this, View.SCALE_X, 0f, 1f)
    xScale.duration = duration
    xScale.interpolator = AccelerateDecelerateInterpolator()

    var yScale = ObjectAnimator.ofFloat(this, View.SCALE_Y, 0f, 1f)
    yScale.duration = duration
    yScale.interpolator = AccelerateDecelerateInterpolator()



    xScale.addListener(object : Animator.AnimatorListener {
        override fun onAnimationRepeat(p0: Animator?) {
        }

        override fun onAnimationEnd(p0: Animator?) {
        }

        override fun onAnimationStart(p0: Animator?) {
            this@grow.visibility = View.VISIBLE
        }

        override fun onAnimationCancel(p0: Animator?) {
        }

    })

    var animatorSet = AnimatorSet()
    animatorSet.playTogether(xScale, yScale)
    animatorSet.start()
}


fun ViewPager.currentFragment(fragmentManager: FragmentManager): Fragment? {
    return fragmentManager.findFragmentByTag("android:switcher:${this.id}:${this.currentItem}")
}



fun View.widthByParams(width: Float) {
    val layoutParams = layoutParams
    if (layoutParams != null) {
        layoutParams.width = width.toInt()
        setLayoutParams(layoutParams)
    }
}


fun View.heightByParams(size: Float) {

    val layoutParams = layoutParams
    if (layoutParams != null) {
        layoutParams.height = size.toInt()
        setLayoutParams(layoutParams)
    }
}

fun ViewGroup.childrenList(): List<View> {
    var list = mutableListOf<View>()
    for (i in 0 until childCount) {
        list.add(getChildAt(i))
    }
    return list
}


fun ChipGroup.childChips(): List<Chip> {
    var chipList: MutableList<Chip> = mutableListOf()
    for (i in 0..childCount - 1) {
        var c = getChildAt(i)
        if (c is Chip) {
            chipList.add(c)
        }
    }
    return chipList
}


fun View.slideUp(duration: Int = 500) {
    visibility = View.VISIBLE
    val animate = TranslateAnimation(0f, 0f, this.height.toFloat(), 0f)
    animate.duration = duration.toLong()
    animate.fillAfter = true
    this.startAnimation(animate)
}

fun View.slideDown(duration: Int = 500) {
    visibility = View.VISIBLE
    val animate = TranslateAnimation(0f, 0f, 0f, this.height.toFloat())
    animate.duration = duration.toLong()
    animate.fillAfter = true
    this.startAnimation(animate)
}


fun ViewGroup.wrapContent() {
    var layoutParams = this.layoutParams
    layoutParams.height  = ViewGroup.LayoutParams.WRAP_CONTENT
    layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
    this.layoutParams = layoutParams
}


fun ViewGroup.matchParent() {
    var layoutParams = this.layoutParams
    layoutParams.height  = ViewGroup.LayoutParams.MATCH_PARENT
    layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
    this.layoutParams = layoutParams
}

fun ViewGroup.setLayoutParams(width: Int, height: Int){
    var layoutParams = this.layoutParams
    layoutParams.height  = height
    layoutParams.width = width
    this.layoutParams = layoutParams
}
