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
		//� ������ ������ �� �������� �� CrimeLab ����� ������ � ��������� ArrayList �������� Crime
		mCrimes = CrimeLab.get(this).getCrimes();
		//����� �� �������� ��������� FragmentManager ��� ����������
		FragmentManager fm = getSupportFragmentManager();
		//��������� ����������� ���������� ��������� Fragment-	StatePagerAdapter
		//�� ���������, ��� FragmentStatePagerAdapter � ��� �����, ����������� ��������������� � ViewPager.
		//������� �� ��������� ������������ ��������� � ��-
		//�������� � �������� ViewPager ���������������� ������������� ���������� ���
		//�� ����������� ����������.
		
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
		for (int i = 0; i < mCrimes.size(); i++) {
			if (mCrimes.get(i).getmId().equals(crimeId)) {
			    mViewPager.setCurrentItem(i);
			    break;
			}
		}
		//������������ ��� ����������� ��������� � ��������
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
