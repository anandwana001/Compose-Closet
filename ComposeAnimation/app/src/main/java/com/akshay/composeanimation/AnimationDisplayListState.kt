package com.akshay.composeanimation

/**
 * Created by anandwana001 on
 * 29, October, 2022
 **/
data class AnimationDisplayListState(
    val isAnimateColorItem: Boolean = false,
    val isAnimateFloatItem: Boolean = false,
    val isAnimateDpItem: Boolean = false,
    val isAnimateIntItem: Boolean = true,
    val isAnimateRectItem: Boolean = false,
    val isAnimateSizeItem: Boolean = false
)
