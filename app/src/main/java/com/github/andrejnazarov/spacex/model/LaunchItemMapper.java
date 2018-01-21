package com.github.andrejnazarov.spacex.model;

import com.github.andrejnazarov.spacex.bean.Core;
import com.github.andrejnazarov.spacex.bean.FirstStage;
import com.github.andrejnazarov.spacex.bean.LaunchItem;
import com.github.andrejnazarov.spacex.bean.LaunchSite;
import com.github.andrejnazarov.spacex.bean.Links;
import com.github.andrejnazarov.spacex.bean.Payload;
import com.github.andrejnazarov.spacex.bean.Reuse;
import com.github.andrejnazarov.spacex.bean.Rocket;
import com.github.andrejnazarov.spacex.bean.SecondStage;
import com.github.andrejnazarov.spacex.bean.Telemetry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Nazarov on 21.01.18.
 */

final class LaunchItemMapper {

    LaunchItem getItem(JSONObject source) throws JSONException {
        String flightNumber = source.optString(LaunchItem.FLIGHT_NUMBER);
        String launchYear = source.optString(LaunchItem.LAUNCH_YEAR);
        String launchDateUTC = source.optString(LaunchItem.LAUNCH_DATE_UTC);
        Rocket rocket = getRocket(source.optJSONObject(LaunchItem.ROCKET));
        Reuse reuse = getReuse(source.optJSONObject(LaunchItem.REUSE));
        Telemetry telemetry = getTelemetry(source.optJSONObject(LaunchItem.TELEMETRY));
        LaunchSite launchSite = getLaunchSite(source.optJSONObject(LaunchItem.LAUNCH_SITE));
        boolean launchSuccess = source.optBoolean(LaunchItem.LAUNCH_SUCCESS);
        Links links = getLinks(source.optJSONObject(LaunchItem.LINKS));
        String details = source.optString(LaunchItem.DETAILS);

        return new LaunchItem(
                flightNumber,
                launchYear,
                launchDateUTC,
                rocket,
                reuse,
                telemetry,
                launchSite,
                launchSuccess,
                links,
                details);
    }

    private Links getLinks(JSONObject source) throws JSONException {
        List<String> links = new ArrayList<>();
        Iterator<String> keys = source.keys();
        while (keys.hasNext()) {
            String keyValue = keys.next();
            String valueString = source.getString(keyValue);
            links.add(valueString);
        }
        return new Links(links);
    }

    private LaunchSite getLaunchSite(JSONObject source) {
        String id = source.optString(LaunchSite.ID);
        String name = source.optString(LaunchSite.NAME);
        String nameLong = source.optString(LaunchSite.NAME_LONG);
        return new LaunchSite(id, name, nameLong);
    }

    private Telemetry getTelemetry(JSONObject source) {
        return new Telemetry(source.optString(Telemetry.FLIGHT_CLUB));
    }

    private Reuse getReuse(JSONObject source) {
        boolean core = source.optBoolean(Reuse.CORE);
        boolean sideCore1 = source.optBoolean(Reuse.SIDE_CORE_1);
        boolean sideCore2 = source.optBoolean(Reuse.SIDE_CORE_2);
        boolean fairings = source.optBoolean(Reuse.FAIRINGS);
        boolean capsule = source.optBoolean(Reuse.CAPSULE);
        return new Reuse(core, sideCore1, sideCore2, fairings, capsule);
    }

    private Rocket getRocket(JSONObject source) throws JSONException {
        String id = source.optString(Rocket.ID);
        String name = source.optString(Rocket.NAME);
        String type = source.optString(Rocket.TYPE);
        FirstStage firstStage = getFirstStage(source.optJSONObject(Rocket.FIRST_STAGE));
        SecondStage secondStage = getSecondStage(source.optJSONObject(Rocket.SECOND_STAGE));
        return new Rocket(id, name, type, firstStage, secondStage);
    }

    private FirstStage getFirstStage(JSONObject source) throws JSONException {
        List<Core> coresList = new ArrayList<>();
        JSONArray cores = source.getJSONArray(FirstStage.CORES);
        for (int i = 0; i < cores.length(); i++) {
            JSONObject core = cores.getJSONObject(i);

            String coreSerial = core.optString(Core.CORE_SERIAL);
            boolean reused = core.optBoolean(Core.REUSED);
            boolean landSuccess = core.optBoolean(Core.LAND_SUCCESS);
            String landingType = core.optString(Core.LANDING_TYPE);
            String landingVehicle = core.optString(Core.LANDING_VEHICLE);

            coresList.add(new Core(
                    coreSerial,
                    reused,
                    landSuccess,
                    landingType,
                    landingVehicle)
            );
        }
        return new FirstStage(coresList);
    }

    private SecondStage getSecondStage(JSONObject source) throws JSONException {
        List<Payload> payloadList = new ArrayList<>();
        JSONArray payloads = source.optJSONArray(SecondStage.PAYLOADS);
        for (int i = 0; i < payloads.length(); i++) {
            JSONObject payload = payloads.getJSONObject(i);
            String id = payload.optString(Payload.ID);
            boolean reused = payload.optBoolean(Payload.REUSED);
            List<String> customers = new ArrayList<>();
            JSONArray array = payload.optJSONArray(Payload.CUSTOMERS);
            for (int j = 0; j < array.length(); j++) {
                customers.add(array.optString(i));
            }
            String type = payload.optString(Payload.TYPE);
            String mass = payload.optString(Payload.MASS);
            String orbit = payload.optString(Payload.ORBIT);
            payloadList.add(new Payload(id, reused, customers, type, mass, orbit));
        }
        return new SecondStage(payloadList);
    }
}