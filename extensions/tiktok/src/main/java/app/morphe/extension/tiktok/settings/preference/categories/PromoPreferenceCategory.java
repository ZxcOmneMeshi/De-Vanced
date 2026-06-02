package app.morphe.extension.tiktok.settings.preference.categories;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.preference.Preference;
import android.preference.PreferenceScreen;

@SuppressWarnings("deprecation")
public class PromoPreferenceCategory extends ConditionalPreferenceCategory {

    private static final String TG_URL = "https://t.me/hatethisproject";

    public PromoPreferenceCategory(Context context, PreferenceScreen screen) {
        super(context, screen);
        setTitle("hate this project");
    }

    @Override
    public boolean getSettingsStatus() {
        return true;
    }

    @Override
    public void addPreferences(Context context) {
        Preference tgChannel = new Preference(context);
        tgChannel.setTitle("Telegram channel");
        tgChannel.setSummary("Updates, news, support: @hatethisproject");
        tgChannel.setOnPreferenceClickListener(pref -> {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(TG_URL)));
            return true;
        });
        addPreference(tgChannel);

        Preference support = new Preference(context);
        support.setTitle("Support the project");
        support.setSummary("Help us keep the mod alive");
        support.setOnPreferenceClickListener(pref -> {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(TG_URL)));
            return true;
        });
        addPreference(support);
    }
}
