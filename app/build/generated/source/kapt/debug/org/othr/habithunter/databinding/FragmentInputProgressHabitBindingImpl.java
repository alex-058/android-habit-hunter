package org.othr.habithunter.databinding;
import org.othr.habithunter.R;
import org.othr.habithunter.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentInputProgressHabitBindingImpl extends FragmentInputProgressHabitBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.progress_bar, 5);
        sViewsWithIds.put(R.id.button_progress_done, 6);
        sViewsWithIds.put(R.id.fieldHabitProgressNote, 7);
        sViewsWithIds.put(R.id.textNotesHabitProgress, 8);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentInputProgressHabitBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private FragmentInputProgressHabitBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.google.android.material.button.MaterialButton) bindings[6]
            , (com.google.android.material.textfield.TextInputLayout) bindings[7]
            , (com.google.android.material.textview.MaterialTextView) bindings[3]
            , (me.tankery.lib.circularseekbar.CircularSeekBar) bindings[5]
            , (android.widget.TextView) bindings[1]
            , (com.google.android.material.textview.MaterialTextView) bindings[2]
            , (com.google.android.material.textfield.TextInputEditText) bindings[8]
            , (com.google.android.material.textview.MaterialTextView) bindings[4]
            );
        this.inputTextGoalAmount.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.textHabitTitle.setTag(null);
        this.textIntervallGoal.setTag(null);
        this.textViewProgress.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
        if (BR.habitvm == variableId) {
            setHabitvm((org.othr.habithunter.ui.inputProgressHabit.InputProgressHabitViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHabitvm(@Nullable org.othr.habithunter.ui.inputProgressHabit.InputProgressHabitViewModel Habitvm) {
        this.mHabitvm = Habitvm;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.habitvm);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeHabitvmObservableHabit((androidx.lifecycle.LiveData<org.othr.habithunter.models.HabitModel>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeHabitvmObservableHabit(androidx.lifecycle.LiveData<org.othr.habithunter.models.HabitModel> HabitvmObservableHabit, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        java.lang.String habitvmObservableHabitHabitTitle = null;
        androidx.lifecycle.LiveData<org.othr.habithunter.models.HabitModel> habitvmObservableHabit = null;
        java.lang.String habitvmObservableHabitHabitIntervallToString = null;
        org.othr.habithunter.models.HabitIntervall habitvmObservableHabitHabitIntervall = null;
        int habitvmObservableHabitHabitGoal = 0;
        int habitvmObservableHabitHabitProgress = 0;
        org.othr.habithunter.models.HabitModel habitvmObservableHabitGetValue = null;
        org.othr.habithunter.ui.inputProgressHabit.InputProgressHabitViewModel habitvm = mHabitvm;
        java.lang.String integerToStringHabitvmObservableHabitHabitProgress = null;
        java.lang.String integerToStringHabitvmObservableHabitHabitGoal = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (habitvm != null) {
                    // read habitvm.observableHabit
                    habitvmObservableHabit = habitvm.getObservableHabit();
                }
                updateLiveDataRegistration(0, habitvmObservableHabit);


                if (habitvmObservableHabit != null) {
                    // read habitvm.observableHabit.getValue()
                    habitvmObservableHabitGetValue = habitvmObservableHabit.getValue();
                }


                if (habitvmObservableHabitGetValue != null) {
                    // read habitvm.observableHabit.getValue().habitTitle
                    habitvmObservableHabitHabitTitle = habitvmObservableHabitGetValue.getHabitTitle();
                    // read habitvm.observableHabit.getValue().habitIntervall
                    habitvmObservableHabitHabitIntervall = habitvmObservableHabitGetValue.getHabitIntervall();
                    // read habitvm.observableHabit.getValue().habitGoal
                    habitvmObservableHabitHabitGoal = habitvmObservableHabitGetValue.getHabitGoal();
                    // read habitvm.observableHabit.getValue().habitProgress
                    habitvmObservableHabitHabitProgress = habitvmObservableHabitGetValue.getHabitProgress();
                }


                if (habitvmObservableHabitHabitIntervall != null) {
                    // read habitvm.observableHabit.getValue().habitIntervall.toString()
                    habitvmObservableHabitHabitIntervallToString = habitvmObservableHabitHabitIntervall.toString();
                }
                // read Integer.toString(habitvm.observableHabit.getValue().habitGoal)
                integerToStringHabitvmObservableHabitHabitGoal = java.lang.Integer.toString(habitvmObservableHabitHabitGoal);
                // read Integer.toString(habitvm.observableHabit.getValue().habitProgress)
                integerToStringHabitvmObservableHabitHabitProgress = java.lang.Integer.toString(habitvmObservableHabitHabitProgress);
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.inputTextGoalAmount, integerToStringHabitvmObservableHabitHabitGoal);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textHabitTitle, habitvmObservableHabitHabitTitle);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textIntervallGoal, habitvmObservableHabitHabitIntervallToString);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewProgress, integerToStringHabitvmObservableHabitHabitProgress);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): habitvm.observableHabit
        flag 1 (0x2L): habitvm
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}