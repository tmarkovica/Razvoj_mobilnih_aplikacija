package hr.ferit.tomislavmarkovica.lv4_prep.databinding;
import hr.ferit.tomislavmarkovica.lv4_prep.R;
import hr.ferit.tomislavmarkovica.lv4_prep.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.guide_start, 3);
        sViewsWithIds.put(R.id.guide_end, 4);
        sViewsWithIds.put(R.id.guide_top, 5);
        sViewsWithIds.put(R.id.guide_bottom, 6);
        sViewsWithIds.put(R.id.guide_centre_vertical, 7);
        sViewsWithIds.put(R.id.b_dogsSeen, 8);
        sViewsWithIds.put(R.id.b_catsSeen, 9);
        sViewsWithIds.put(R.id.tv_animalsSeen, 10);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[9]
            , (android.widget.Button) bindings[8]
            , (androidx.constraintlayout.widget.Guideline) bindings[6]
            , (androidx.constraintlayout.widget.Guideline) bindings[7]
            , (androidx.constraintlayout.widget.Guideline) bindings[4]
            , (androidx.constraintlayout.widget.Guideline) bindings[3]
            , (androidx.constraintlayout.widget.Guideline) bindings[5]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvCatsSeen.setTag(null);
        this.tvDogsSeen.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.dogs == variableId) {
            setDogs((java.lang.String) variable);
        }
        else if (BR.cats == variableId) {
            setCats((java.lang.String) variable);
        }
        else if (BR.viewmodel == variableId) {
            setViewmodel((hr.ferit.tomislavmarkovica.lv4_prep.AnimalCounterViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setDogs(@Nullable java.lang.String Dogs) {
        this.mDogs = Dogs;
    }
    public void setCats(@Nullable java.lang.String Cats) {
        this.mCats = Cats;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.cats);
        super.requestRebind();
    }
    public void setViewmodel(@Nullable hr.ferit.tomislavmarkovica.lv4_prep.AnimalCounterViewModel Viewmodel) {
        this.mViewmodel = Viewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewmodel);
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
        java.lang.String cats = mCats;
        java.lang.String viewmodelGetDG = null;
        hr.ferit.tomislavmarkovica.lv4_prep.AnimalCounterViewModel viewmodel = mViewmodel;

        if ((dirtyFlags & 0xaL) != 0) {
        }
        if ((dirtyFlags & 0xcL) != 0) {



                if (viewmodel != null) {
                    // read viewmodel.getDG()
                    viewmodelGetDG = viewmodel.getDG();
                }
        }
        // batch finished
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvCatsSeen, cats);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvDogsSeen, viewmodelGetDG);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): dogs
        flag 1 (0x2L): cats
        flag 2 (0x3L): viewmodel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}