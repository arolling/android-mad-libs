package com.epicodus.madlibs;

import android.os.Build;
import android.text.Layout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Guest on 4/19/16.
 */

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class MainActivityTest {
    private MainActivity activity;
    private Spinner mStorySpinner;
    private TableLayout mmmTable;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
        mStorySpinner = (Spinner) activity.findViewById(R.id.spinner);
        mmmTable = (TableLayout) activity.findViewById(R.id.tableLayout);
    }

    @Test
    public void validateTextHeader() {
        TextView appHeader = (TextView) activity.findViewById(R.id.appHeader);
        assertTrue("Fill in the Blanks!".equals(appHeader.getText().toString()));
    }

    @Test
    public void storyListViewPopulates() {
        assertNotNull(mStorySpinner.getAdapter());
        assertEquals(mStorySpinner.getAdapter().getCount(), 2);
    }

    @Test
    public void blankInputsAppearCorrectly(){
        assertNotNull(mmmTable.getChildCount());
        assertEquals(mmmTable.getChildCount(), 13);
    }
}
