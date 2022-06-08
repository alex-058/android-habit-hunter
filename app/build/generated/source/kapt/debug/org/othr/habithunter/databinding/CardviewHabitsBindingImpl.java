package org.othr.habithunter.databinding;
import org.othr.habithunter.R;
import org.othr.habithunter.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class CardviewHabitsBindingImpl extends CardviewHabitsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.image, 3);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public CardviewHabitsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private CardviewHabitsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[0]
            , (android.widget.TextView) bindings[1]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ProgressBar) bindings[2]
            );
        this.cardView.setTag(null);
        this.habitTitle.setTag(null);
        this.progressBar.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.habit == variableId) {
            setHabit((org.othr.habithunter.models.HabitModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHabit(@Nullable org.othr.habithunter.models.HabitModel Habit) {
        this.mHabit = Habit;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.habit);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        org.othr.habithunter.models.HabitModel habit = mHabit;
        java.lang.String habitHabitTitle = null;
        int habitHabitGoal = 0;
        int habitHabitProgress = 0;

        if ((dirtyFlags & 0x3L) != 0) {



                if (habit != null) {
                    // read habit.habitTitle
                    habitHabitTitle = habit.getHabitTitle();
                    // read habit.habitGoal
                    habitHabitGoal = habit.getHabitGoal();
                    // read habit.habitProgress
                    habitHabitProgress = habit.getHabitProgress();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.habitTitle, habitHabitTitle);
            this.progressBar.setMax(habitHabitGoal);
            this.progressBar.setProgress(habitHabitProgress);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): habit
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}