package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import id.ac.polinema.idealbodyweight.fragments.AboutFragment;
import id.ac.polinema.idealbodyweight.fragments.BodyMassIndexFragment;
import id.ac.polinema.idealbodyweight.fragments.BrocaIndexFragment;
import id.ac.polinema.idealbodyweight.fragments.MenuFragment;
import id.ac.polinema.idealbodyweight.fragments.ResultFragment;
import id.ac.polinema.idealbodyweight.util.BodyMassIndex;
import id.ac.polinema.idealbodyweight.util.BrocaIndex;

public class MainActivity extends AppCompatActivity implements
		MenuFragment.OnFragmentInteractionListener,
		BrocaIndexFragment.OnFragmentInteractionListener,
		BodyMassIndexFragment.OnFragmentInteractionListener,
		ResultFragment.OnFragmentInteractionListener {

	// Deklarasikan atribut Fragment di sini
	private AboutFragment aboutFragment;
	MenuFragment menuFragment = new MenuFragment();
	private BrocaIndexFragment brocaIndexFragment;
    private BodyMassIndexFragment bodyMassIndexFragment;
	private ResultFragment resultFragment;

	private static final String ARG_BROCA = "BrocaIndex";
	private static final String ARG_BMI = "BodyMassIndex";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		brocaIndexFragment = new BrocaIndexFragment();
		bodyMassIndexFragment = new BodyMassIndexFragment();
        aboutFragment = AboutFragment.newInstance("Alan Rizky Wardana");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, menuFragment)
				.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		resultFragment = new ResultFragment();
		return  true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		if (item.getItemId() == R.id.menu_about) {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, aboutFragment)
					.addToBackStack(null)
					.commit();
		}
		// TODO: Tambahkan penanganan menu di sini
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBrocaIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, brocaIndexFragment)
				.commit();

	}

	@Override
	public void onBodyMassIndexButtonClicked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, bodyMassIndexFragment)
                .commit();

	}

	@Override
	public void onCalculateBrocaIndexClicked(float index) {
		resultFragment.setInformation(String.format("Your ideal weight is %.2f kg", index));
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, resultFragment)
				.commit();
	}

	@Override
	public void onTryAgainButtonClicked(String brocaIndex, String bodyMassIndex) {
		FragmentTransaction f = getSupportFragmentManager().beginTransaction();
		BrocaIndexFragment b = new BrocaIndexFragment();
		BodyMassIndexFragment bmi = new BodyMassIndexFragment();

		if(getSupportFragmentManager().findFragmentByTag("BrocaIndex") != null) {
//			getSupportFragmentManager().beginTransaction()
//					.replace(R.id.fragment_container, brocaIndexFragment)
//					.commit();
			f.show(b);
		}
		else {
			f.replace(R.id.fragment_container, new BrocaIndexFragment(), "BrocaIndex");
			f.commit();
		}

//		if(getSupportFragmentManager().findFragmentByTag("BodyMassIndex") == null) {
//			getSupportFragmentManager().beginTransaction()
//					.replace(R.id.fragment_container, bodyMassIndexFragment)
//					.commit();
//		}
//		getSupportFragmentManager().beginTransaction()
//				.replace(R.id.fragment_container, brocaIndexFragment)
//				.commit();

	}

	@Override
	public void onCalculateBodyMassIndexClicked(String index) {
		resultFragment.setInformation(index);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, resultFragment)
				.commit();
	}


	@Override
	public void onFragmentInteraction(Uri uri) {

	}
}
