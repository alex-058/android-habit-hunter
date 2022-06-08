package org.othr.habithunter.databinding;
import org.othr.habithunter.R;
import org.othr.habithunter.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentAddCustomHabitBindingImpl extends FragmentAddCustomHabitBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.fieldHabitName, 2);
        sViewsWithIds.put(R.id.textHabitName, 3);
        sViewsWithIds.put(R.id.addCustomHabitBttn, 4);
        sViewsWithIds.put(R.id.textIntervall, 5);
        sViewsWithIds.put(R.id.textGoal, 6);
        sViewsWithIds.put(R.id.textAddIcon, 7);
        sViewsWithIds.put(R.id.dividerIntervall, 8);
        sViewsWithIds.put(R.id.dividerGoal, 9);
        sViewsWithIds.put(R.id.radioButtonDaily, 10);
        sViewsWithIds.put(R.id.radioButtonWeekly, 11);
        sViewsWithIds.put(R.id.radioButtonMonthly, 12);
        sViewsWithIds.put(R.id.amountTimeRadioGroup, 13);
        sViewsWithIds.put(R.id.radioButtonAmount, 14);
        sViewsWithIds.put(R.id.radioButtonTime, 15);
        sViewsWithIds.put(R.id.profile_image, 16);
        sViewsWithIds.put(R.id.numberPickerAmount, 17);
        sViewsWithIds.put(R.id.numberPickerTime, 18);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener radioGroupIntervallandroidCheckedButtonAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.observableRadioChecked.getValue()
            //         is viewmodel.observableRadioChecked.setValue((java.lang.Integer) callbackArg_0)
            int callbackArg_0 = radioGroupIntervall.getCheckedRadioButtonId();
            // localize variables for thread safety
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.observableRadioChecked.getValue()
            java.lang.Integer viewmodelObservableRadioCheckedGetValue = null;
            // viewmodel
            org.othr.habithunter.ui.addCustomHabit.AddCustomHabitViewModel viewmodel = mViewmodel;
            // viewmodel.observableRadioChecked
            androidx.lifecycle.MutableLiveData<java.lang.Integer> viewmodelObservableRadioChecked = null;
            // viewmodel.observableRadioChecked != null
            boolean viewmodelObservableRadioCheckedJavaLangObjectNull = false;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelObservableRadioChecked = viewmodel.getObservableRadioChecked();

                viewmodelObservableRadioCheckedJavaLangObjectNull = (viewmodelObservableRadioChecked) != (null);
                if (viewmodelObservableRadioCheckedJavaLangObjectNull) {




                    viewmodelObservableRadioChecked.setValue(((java.lang.Integer) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentAddCustomHabitBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private FragmentAddCustomHabitBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.Button) bindings[4]
            , (android.widget.RadioGroup) bindings[13]
            , (android.view.View) bindings[9]
            , (android.view.View) bindings[8]
            , (com.google.android.material.textfield.TextInputLayout) bindings[2]
            , (android.widget.NumberPicker) bindings[17]
            , (android.widget.NumberPicker) bindings[18]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[16]
            , (android.widget.RadioButton) bindings[14]
            , (android.widget.RadioButton) bindings[10]
            , (android.widget.RadioButton) bindings[12]
            , (android.widget.RadioButton) bindings[15]
            , (android.widget.RadioButton) bindings[11]
            , (android.widget.RadioGroup) bindings[1]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[6]
            , (com.google.android.material.textfield.TextInputEditText) bindings[3]
            , (android.widget.TextView) bindings[5]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.radioGroupIntervall.setTag(null);
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
        if (BR.viewmodel == variableId) {
            setViewmodel((org.othr.habithunter.ui.addCustomHabit.AddCustomHabitViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewmodel(@Nullable org.othr.habithunter.ui.addCustomHabit.AddCustomHabitViewModel Viewmodel) {
        this.mViewmodel = Viewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewmodel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewmodelObservableRadioChecked((androidx.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewmodelObservableRadioChecked(androidx.lifecycle.MutableLiveData<java.lang.Integer> ViewmodelObservableRadioChecked, int fieldId) {
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
        java.lang.Integer viewmodelObservableRadioCheckedGetValue = null;
        int androidxDatabindingViewDataBindingSafeUnboxViewmodelObservableRadioCheckedGetValue = 0;
        org.othr.habithunter.ui.addCustomHabit.AddCustomHabitViewModel viewmodel = mViewmodel;
        androidx.lifecycle.MutableLiveData<java.lang.Integer> viewmodelObservableRadioChecked = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewmodel != null) {
                    // read viewmodel.observableRadioChecked
                    viewmodelObservableRadioChecked = viewmodel.getObservableRadioChecked();
                }
                updateLiveDataRegistration(0, viewmodelObservableRadioChecked);


                if (viewmodelObservableRadioChecked != null) {
                    // read viewmodel.observableRadioChecked.getValue()
                    viewmodelObservableRadioCheckedGetValue = viewmodelObservableRadioChecked.getValue();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(viewmodel.observableRadioChecked.getValue())
                androidxDatabindingViewDataBindingSafeUnboxViewmodelObservableRadioCheckedGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewmodelObservableRadioCheckedGetValue);
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.RadioGroupBindingAdapter.setCheckedButton(this.radioGroupIntervall, androidxDatabindingViewDataBindingSafeUnboxViewmodelObservableRadioCheckedGetValue);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            androidx.databinding.adapters.RadioGroupBindingAdapter.setListeners(this.radioGroupIntervall, (android.widget.RadioGroup.OnCheckedChangeListener)null, radioGroupIntervallandroidCheckedButtonAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewmodel.observableRadioChecked
        flag 1 (0x2L): viewmodel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}