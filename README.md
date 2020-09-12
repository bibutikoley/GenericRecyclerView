
# RecyclerView Implementation for all you needs
> This Library is only for the Projects which has Databinding enabled, if you don't have databinding enabled you won't be use this library.
 

Steps -
 

 - Add jitpack to you project level build.gradle file
 ```
allprojects {  
  repositories {  
	  google()  
      jcenter()  
      maven { url 'https://jitpack.io' }  
  }
}
```
- Add below line to app level build.gradle file (use the latest version)
```
implementation 'com.github.bibutikoley:GenericRecyclerView:1.1'
```
- Setup is done.
- Create your single item xml file for RecyclerView (**Do not change the *variable* names in this file**).
```
<?xml version="1.0" encoding="utf-8"?>  
<layout xmlns:android="http://schemas.android.com/apk/res/android"  
  xmlns:app="http://schemas.android.com/apk/res-auto"  
  xmlns:tools="http://schemas.android.com/tools">  
  
	 <data>  
		 <variable  
			 name="data"  
			 type="YourModelClass" />  
		  
		 <variable
			 name="position"  
			 type="java.lang.Integer" />  
		  
		 <variable  
			 name="callback"
			 type="io.bibuti.recycleradapter.BaseAdapter.BaseInterface" />  
	  
	 </data>  
	 
	 <TextView  
	  android:layout_width="match_parent"  
	  android:layout_height="wrap_content"  
	  android:text="@{data.(Use your model class getters)}"  
	  tools:text="Text"  
	  android:onClick="@{(v) -> callback.onItemClicked(data, v, position)}"  
	  app:layout_constraintBottom_toBottomOf="parent"  
	  app:layout_constraintLeft_toLeftOf="parent"  
	  app:layout_constraintRight_toRightOf="parent"  
	  app:layout_constraintTop_toTopOf="parent" />  
  
</layout>
```
- **You must not change the *variable* names for above file.**

- Create/Open your activity/fragment.xml file.
```
<?xml version="1.0" encoding="utf-8"?>  
<layout xmlns:android="http://schemas.android.com/apk/res/android"  
  xmlns:app="http://schemas.android.com/apk/res-auto"  
  xmlns:tools="http://schemas.android.com/tools">  
  
	 <data>  
		 <variable  
			 name="data"  
			 type="java.util.List" />  
		  
		 <variable  
			 name="callback"
			 type="io.bibuti.recycleradapter.BaseAdapter.BaseInterface" />  
	  
	 </data>  
	 
	 <RelativeLayout  android:layout_width="match_parent"  
	  android:layout_height="match_parent"  
	  tools:context=".MainActivity">  
	  
		 <androidx.recyclerview.widget.RecyclerView
            android:layout_width="match_parent"  
		  android:layout_height="match_parent"  
		  app:layoutFile="@{@layout/single_item}"  
		  app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"  
		  app:listData="@{data}"  
		  app:listener="@{callback}"  
		  tools:listitem="@layout/single_item" />  
	  
	 </RelativeLayout>
</layout>
```

- Make sure you add the below params to your recycler view(**all are mandatory**).
```
app:layoutFile="@{@layout/single_item}"
app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager" 
app:listData="@{data}" 
app:listener="@{callback}"
``` 

- UI setup is done Now open you MainActivity.java/kt file and set data to your UI as shown below.
```
public class MainActivity extends AppCompatActivity {  
  
    ActivityMainBinding binding;  
  
	  @Override  
	  protected void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	  binding = DataBindingUtil.setContentView(this, R.layout.activity_main);  
	  binding.setData(new ArrayList()); //Set you list of custom model here.. 
	  
	  binding.setCallback(new BaseAdapter.BaseInterface() {  
	            @Override  
	  public void onItemClicked(Object dataType, View view, int position) {  
	  
	            }  
	        });  
	  }  
}
```
