package es.iessaladillo.pedrojoya.weatherstreams.di;

import es.iessaladillo.pedrojoya.weatherstreams.data.Database;
import es.iessaladillo.pedrojoya.weatherstreams.service.ForecastService;
import es.iessaladillo.pedrojoya.weatherstreams.service.ForecastServiceImp;
import es.iessaladillo.pedrojoya.weatherstreams.ui.MainScreen;

import java.text.Collator;
import java.util.Locale;

public class Injector {

    private Injector() {
    }

    private static Collator provideCollator() {
        Collator collator = Collator.getInstance(new Locale("es"));
        collator.setStrength(Collator.PRIMARY);
        return collator;
    }

    @SuppressWarnings("SameReturnValue")
    private static Database provideDatabase() {
        return Database.INSTANCE;
    }

    public static MainScreen provideMainScreen() {
        return new MainScreen(provideForecastService());
    }

    private static ForecastService provideForecastService() {
        return new ForecastServiceImp(provideDatabase(), provideCollator());
    }

}
