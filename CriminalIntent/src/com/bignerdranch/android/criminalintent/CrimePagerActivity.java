package com.bignerdranch.android.criminalintent;

import java.util.ArrayList;
import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class CrimePagerActivity extends FragmentActivity {
	private ViewPager mViewPager;
	private ArrayList<Crime> mCrimes;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mViewPager = new ViewPager(this);
		mViewPager.setId(R.id.viewPager);
		setContentView(mViewPager);
		//¬ первой строке мы получаем от CrimeLab набор данных Ч контейнер ArrayList объектов Crime
		mCrimes = CrimeLab.get(this).getCrimes();
		//«атем мы получаем экземпл€р FragmentManager дл€ активности
		FragmentManager fm = getSupportFragmentManager();
		//адаптером назначаетс€ безым€нный экземпл€р Fragment-	StatePagerAdapter
		//Ќе забывайте, что FragmentStatePagerAdapter Ч ваш агент, управл€ющий взаимодействием с ViewPager.
		//¬кратце он добавл€ет возвращаемые фрагменты в ак-
		//тивность и помогает ViewPager идентифицировать представлени€ фрагментов дл€
		//их правильного размещени€.
		
		mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
			@Override
			public int getCount() {
			   return mCrimes.size();
		    }
		    @Override
		    public Fragment getItem(int pos) {
		       Crime crime = mCrimes.get(pos);
		       return CrimeFragment.newInstance(crime.getmId());
		    }
		});
		
		UUID crimeId = (UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
		mViewPager.setCurrentItem(mCrimes.indexOf(CrimeLab.get(this).getCrime(crimeId)));
//		for (int i = 0; i < mCrimes.size(); i++) {
//			if (mCrimes.get(i).getmId().equals(crimeId)) {
//			    mViewPager.setCurrentItem(i);
//			    break;
//			}
//		}
		//используетс€ дл€ обнаружени€ изменений в странице
		mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int pos) {
				// TODO Auto-generated method stub
				Crime crime = mCrimes.get(pos);
				if (crime.getmTitle() != null) {
				   setTitle(crime.getmTitle());
				}
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
}
