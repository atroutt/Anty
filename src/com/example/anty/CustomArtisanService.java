package com.example.anty;

import com.artisan.manager.ArtisanConfigOption;
import com.artisan.manager.ArtisanConfigOption.AnalyticsEngineType;
import com.artisan.manager.ArtisanManager;
import com.artisan.services.ArtisanService;

/**
 * This is the ArtisanService, which initializes Artisan and manages its life-cycle.
 * This service is automatically started when your application starts, and automatically
 * downloads all experiments, configuration, and published changes for your app.
 * 
 * If you rename this class, you must:
 * <ul>
 * <li>Rename the class in your AndroidManifest to match the new class name</li>
 * <li>Modify the value of 'artisan_service_name' in 'res/values/artisan_ids.xml' to match the new class name</li>
 * </ul>
 */
public class CustomArtisanService extends ArtisanService {

	@Override
	public void startArtisanManager(ArtisanManager artisanManager) {
		artisanManager.start("52fbc10ce206e742a6000003", loadQA2Configuration());
	}

	@Override
	public void registerPowerhooks() {
		// register your powerhooks here
	}

	@Override
	public void registerInCodeExperiments() {
		// register your in-code experiments here
	}

	private ArtisanConfigOption loadQA2Configuration() {
		String apiAddressPortQA = "https://qa2.artisantools.com:443";
		String messageHostPortQA = "wss://messaging-qa2.artisantools.com:443";
		String messageAPIHostPortQA = "https://messaging-qa2.artisantools.com:443";

		ArtisanConfigOption.AnalyticsProperty analyticsPropQA = new ArtisanConfigOption.AnalyticsProperty();
		analyticsPropQA.setDebugEnabled(true);
		analyticsPropQA.setAnalyticsEnabled(true);
		analyticsPropQA.setAnalyticsEngineType(AnalyticsEngineType.ARTISAN_ANALYTICS_ENGINE);
		analyticsPropQA.setSampleRate(100);
		analyticsPropQA.setDispatchPeriod(30);
		analyticsPropQA.setServerURL("http://qa2.artisantools.com:8080/analytics-receiver/analytics");

		ArtisanConfigOption qaConfiguration = new ArtisanConfigOption();
		qaConfiguration.setApiHostPort(apiAddressPortQA);
		qaConfiguration.setMessageHostPort(messageHostPortQA);
		qaConfiguration.setMessageAPIHostPort(messageAPIHostPortQA);
		qaConfiguration.setDebugLogs(true);
		qaConfiguration.setAnalyticsProperty(analyticsPropQA);
		qaConfiguration.setReflectorHostPort("https://reflector-qa2.artisantools.com:443");
		// qaConfiguration.setNeverEnableArtisanGesture(true);

		return qaConfiguration;
	}
}