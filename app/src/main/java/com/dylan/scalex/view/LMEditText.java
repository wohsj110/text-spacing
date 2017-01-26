package com.dylan.scalex.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.EditText;

import com.dylan.scalex.R;
import com.dylan.scalex.util.FontCache;
import com.dylan.scalex.util.LMConstant;
import com.dylan.scalex.util.LMUtils;

public class LMEditText extends EditText {
    private static final String TAG = LMEditText.class.getSimpleName();
    private static final String XML_NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    // Original text value (before spacing)
    private CharSequence originalText = null;
    // Flag to present text in ALL CAPS
    private boolean textAllCaps = false;
    // Spacing value (dp)
    private float spacing = 0f;
    // Density (dp) scale based on 320 screen resolution
    private float dpScale = 1f;
    // Pixel scale based on 320 screen resolution
    private float pxScale = 1f;

    public LMEditText(Context context) {
        super(context);
    }

    public LMEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        checkCustomAttributes(context, attrs);
    }

    public LMEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        checkCustomAttributes(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LMEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        checkCustomAttributes(context, attrs);
    }

    private void checkCustomAttributes(Context context, AttributeSet attrs) {
        dpScale = LMUtils.scaleDensity(context);
        pxScale = LMUtils.scalePixel(context);
        // originalText = getText();
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LMText);

            // Custom Proxima Nova font style:
            // 0: regular
            // 1: semi-bold
            // 2: bold
            // 3: light
            // 4: black
            // 5: thin
            // Default is regular (0)
            int customStyle = a.getInt(R.styleable.LMText_fontStyle, 0);
            setCustomFont(getContext(), LMConstant.FONT_STYLES.get(customStyle));

            // Font size
            float fontSize = a.getFloat(R.styleable.LMText_fontSize, 0f);
            setFontSize(fontSize);

            // Hint size
            float fontSizeHint = a.getFloat(R.styleable.LMText_fontSizeHint, 0f);
            setFontSizeHint(fontSize, fontSizeHint);

            // Check if textAllCaps flag is set
            textAllCaps = attrs.getAttributeBooleanValue(XML_NAMESPACE_ANDROID, "textAllCaps", false);

            // Text spacing
            spacing = a.getFloat(R.styleable.LMText_fontSpacing, 0f);
            applyLetterSpacing();
            // Check more attributes here

            // Recycle attributes array
            a.recycle();
        }
    }

    public boolean setCustomFont(Context context, String customFont) {
        Typeface tf = FontCache.get(context, "fonts/" + customFont);
        if (tf != null) {
            setTypeface(tf);
            return true;
        } else {
            return false;
        }
    }

    public void setFontSize(float fontSize) {
        if (fontSize > 0f) {
            setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize * dpScale);
        }
    }

    public void setFontSizeHint(final float fontSize, final float fontSizeHint) {
        if (fontSize > 0f && fontSizeHint > 0f) {
            // Initial state
            if (TextUtils.isEmpty(getText())) {
                setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSizeHint * dpScale);
            } else {
                setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize * dpScale);
            }

            setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSizeHint * dpScale);
            addTextChangedListener(new TextWatcher() {

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    // do nothing
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    // Update text size if changed
                    if (TextUtils.isEmpty(getText())) {
                        setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSizeHint * dpScale);
                    } else {
                        setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize * dpScale);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                    // do nothing
                }
            });
        }
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        // originalText = text;
        applyLetterSpacing();
    }

    @Override
    public Editable getText() {
        // return !TextUtils.isEmpty(originalText) ? (Editable) originalText : super.getText();
        return super.getText();
    }

    public void setSpacing(float spacing) {
        this.spacing = spacing;
        applyLetterSpacing();
    }

    private void applyLetterSpacing() {
        if (spacing == 0f) {
            return;
        }

        // Check if current SDK version is after LOLLIPOP (21), then use letter spacing instead
        if (!isInEditMode() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setLetterSpacing(spacing * dpScale / 11); // 'EM' unit: 1 'EM' = 11 dp
            return;
        }

        if (TextUtils.isEmpty(originalText)
                || originalText.length() < 2
                || (spacing >= -1f && spacing <= 1f)) {
            return;
        }

        /*// Make ALL CAPS flag false first
        setAllCaps(false);
        // Make string separated between letters by drawing space
        SpannableString finalText;
        if (textAllCaps) {
            finalText = new SpannableString(originalText.toString().toUpperCase());
        } else {
            finalText = new SpannableString(originalText);
        }
        finalText.setSpan(
                new TrackingSpan(spacing * pxScale),
                0,
                originalText.length(),
                Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        // Set text with buffer type SPANNABLE
        super.setText(finalText, BufferType.SPANNABLE);*/
    }

    private static class TrackingSpan extends ReplacementSpan {
        private float trackingPx;

        TrackingSpan(float tracking) {
            trackingPx = tracking;
        }

        @Override
        public int getSize(@NonNull Paint paint, CharSequence text,
                           int start, int end, Paint.FontMetricsInt fm) {
            return (int) (paint.measureText(text, start, end)
                    + trackingPx * (end - start - 1));
        }

        @Override
        public void draw(@NonNull Canvas canvas, CharSequence text,
                         int start, int end, float x, int top, int y,
                         int bottom, @NonNull Paint paint) {
            float dx = x;
            for (int i = start; i < end; i++) {
                canvas.drawText(text, i, i + 1, dx, y, paint);
                dx += paint.measureText(text, i, i + 1) + trackingPx;
            }
        }
    }
}