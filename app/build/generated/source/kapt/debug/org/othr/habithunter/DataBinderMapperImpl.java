package org.othr.habithunter;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.othr.habithunter.databinding.CardviewHabitsBindingImpl;
import org.othr.habithunter.databinding.FragmentAddCustomHabitBindingImpl;
import org.othr.habithunter.databinding.FragmentInputProgressHabitBindingImpl;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_CARDVIEWHABITS = 1;

  private static final int LAYOUT_FRAGMENTADDCUSTOMHABIT = 2;

  private static final int LAYOUT_FRAGMENTINPUTPROGRESSHABIT = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(org.othr.habithunter.R.layout.cardview_habits, LAYOUT_CARDVIEWHABITS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(org.othr.habithunter.R.layout.fragment_add_custom_habit, LAYOUT_FRAGMENTADDCUSTOMHABIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(org.othr.habithunter.R.layout.fragment_input_progress_habit, LAYOUT_FRAGMENTINPUTPROGRESSHABIT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_CARDVIEWHABITS: {
          if ("layout/cardview_habits_0".equals(tag)) {
            return new CardviewHabitsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for cardview_habits is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTADDCUSTOMHABIT: {
          if ("layout/fragment_add_custom_habit_0".equals(tag)) {
            return new FragmentAddCustomHabitBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_add_custom_habit is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTINPUTPROGRESSHABIT: {
          if ("layout/fragment_input_progress_habit_0".equals(tag)) {
            return new FragmentInputProgressHabitBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_input_progress_habit is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "habit");
      sKeys.put(2, "habitvm");
      sKeys.put(3, "viewmodel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/cardview_habits_0", org.othr.habithunter.R.layout.cardview_habits);
      sKeys.put("layout/fragment_add_custom_habit_0", org.othr.habithunter.R.layout.fragment_add_custom_habit);
      sKeys.put("layout/fragment_input_progress_habit_0", org.othr.habithunter.R.layout.fragment_input_progress_habit);
    }
  }
}
