package com.kodego.activity.one.studentassistanceapp

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import com.google.android.material.bottomnavigation.BottomNavigationView


class CurvedBottomNavigationView : BottomNavigationView {

    private var mPath: Path?=null
    private var mPaint: Paint?=null

    //The values of tab button
    val CURVE_CIRCLE_RADIUS = 30

    //The coordinates of first curve
    var mFirstCurveStartPoint= Point()
    var mFirstCurveEndpoint= Point()
    var mFirstCurveControlPoint1= Point()
    var mFirstCurveControlPOint2= Point()

    //The coordinates of the second curve
    var mSecondCurveStartPoint= Point()
    var mSecondCurveEndpoint= Point()
    var mSecondCurveControlPoint1= Point()
    var mSecondCurveControlPOint2= Point()

    var mNavigationBarWidth: Int = 0
    var mNavigationBarHeight: Int = 0

    constructor(context: Context): super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet): super(context,attrs){
        init()
    }

    constructor(context:Context,attrs: AttributeSet,defStyleAttr:Int): super (context,attrs,defStyleAttr){
        init()
    }

    private fun init() {
        mPath = Path()
        mPaint = Paint()
        mPaint!!.style = Paint.Style.FILL_AND_STROKE
        mPaint!!.color = Color.WHITE
        setBackgroundColor(Color.TRANSPARENT)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        mNavigationBarHeight = height
        mNavigationBarWidth = width

        mFirstCurveStartPoint.set(mNavigationBarWidth / 2
            - CURVE_CIRCLE_RADIUS *2
            - CURVE_CIRCLE_RADIUS /3,
            0)

        mFirstCurveEndpoint.set (mNavigationBarWidth / 2, CURVE_CIRCLE_RADIUS + CURVE_CIRCLE_RADIUS / 4)

        mSecondCurveStartPoint = mFirstCurveEndpoint

        mSecondCurveEndpoint.set (mNavigationBarWidth / 2 + CURVE_CIRCLE_RADIUS * 2 + CURVE_CIRCLE_RADIUS/3, 0)

        mFirstCurveControlPoint1.set (mFirstCurveStartPoint.x *  CURVE_CIRCLE_RADIUS + CURVE_CIRCLE_RADIUS / 4, mFirstCurveStartPoint.y)

        mFirstCurveControlPOint2.set(mFirstCurveEndpoint.x - CURVE_CIRCLE_RADIUS *2 + CURVE_CIRCLE_RADIUS, mFirstCurveEndpoint.y)

        //second
        mSecondCurveControlPoint1.set(mSecondCurveStartPoint.x + CURVE_CIRCLE_RADIUS * 2 - CURVE_CIRCLE_RADIUS, mSecondCurveStartPoint.y)

        mSecondCurveControlPOint2.set(mSecondCurveEndpoint.x - (CURVE_CIRCLE_RADIUS + CURVE_CIRCLE_RADIUS / 4), mSecondCurveEndpoint.y)

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        mPath!!.reset()
        mPath!!.moveTo(0f, 0f)
        mPath!!.lineTo(mFirstCurveStartPoint.x.toFloat(), mFirstCurveStartPoint.y.toFloat())

        mPath!!.cubicTo(mFirstCurveControlPoint1.x.toFloat(), mFirstCurveControlPoint1.y.toFloat(), mFirstCurveControlPOint2.x.toFloat(),
            mFirstCurveControlPOint2.y.toFloat(), mFirstCurveEndpoint.x.toFloat(), mFirstCurveEndpoint.y.toFloat())

        mPath!!.cubicTo(mSecondCurveControlPoint1.x.toFloat(), mSecondCurveControlPoint1.y.toFloat(), mSecondCurveControlPOint2.x.toFloat(),
            mSecondCurveControlPOint2.y.toFloat(), mSecondCurveEndpoint.x.toFloat(), mSecondCurveEndpoint.y.toFloat())

        mPath!!.lineTo(mNavigationBarWidth.toFloat(), 0f)
        mPath!!.lineTo(mNavigationBarWidth.toFloat(), mNavigationBarHeight.toFloat())
        mPath!!.lineTo(0f, mNavigationBarHeight.toFloat())
        mPath!!.close()

        canvas.drawPath(mPath!!, mPaint!!)

    }


}