// Generated by data binding compiler. Do not edit!
package hr.ferit.tomislavmarkovica.lv4_prep.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import hr.ferit.tomislavmarkovica.lv4_prep.AnimalCounterViewModel;
import hr.ferit.tomislavmarkovica.lv4_prep.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityMainBinding extends ViewDataBinding {
  @NonNull
  public final Button bCatsSeen;

  @NonNull
  public final Button bDogsSeen;

  @NonNull
  public final Guideline guideBottom;

  @NonNull
  public final Guideline guideCentreVertical;

  @NonNull
  public final Guideline guideEnd;

  @NonNull
  public final Guideline guideStart;

  @NonNull
  public final Guideline guideTop;

  @NonNull
  public final TextView tvAnimalsSeen;

  @NonNull
  public final TextView tvCatsSeen;

  @NonNull
  public final TextView tvDogsSeen;

  @Bindable
  protected String mDogs;

  @Bindable
  protected String mCats;

  @Bindable
  protected AnimalCounterViewModel mViewmodel;

  protected ActivityMainBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button bCatsSeen, Button bDogsSeen, Guideline guideBottom, Guideline guideCentreVertical,
      Guideline guideEnd, Guideline guideStart, Guideline guideTop, TextView tvAnimalsSeen,
      TextView tvCatsSeen, TextView tvDogsSeen) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bCatsSeen = bCatsSeen;
    this.bDogsSeen = bDogsSeen;
    this.guideBottom = guideBottom;
    this.guideCentreVertical = guideCentreVertical;
    this.guideEnd = guideEnd;
    this.guideStart = guideStart;
    this.guideTop = guideTop;
    this.tvAnimalsSeen = tvAnimalsSeen;
    this.tvCatsSeen = tvCatsSeen;
    this.tvDogsSeen = tvDogsSeen;
  }

  public abstract void setDogs(@Nullable String dogs);

  @Nullable
  public String getDogs() {
    return mDogs;
  }

  public abstract void setCats(@Nullable String cats);

  @Nullable
  public String getCats() {
    return mCats;
  }

  public abstract void setViewmodel(@Nullable AnimalCounterViewModel viewmodel);

  @Nullable
  public AnimalCounterViewModel getViewmodel() {
    return mViewmodel;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_main, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMainBinding>inflateInternal(inflater, R.layout.activity_main, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_main, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMainBinding>inflateInternal(inflater, R.layout.activity_main, null, false, component);
  }

  public static ActivityMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityMainBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityMainBinding)bind(component, view, R.layout.activity_main);
  }
}
